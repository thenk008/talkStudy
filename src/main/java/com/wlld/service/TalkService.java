package com.wlld.service;

import com.wlld.bean.BeanManger;
import com.wlld.bean.BeanMangerOnly;
import com.wlld.entity.*;
import com.wlld.mapper.SqlMapper;
import com.wlld.table.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description
 */
@Service
public class TalkService {
    @Autowired
    private SqlMapper sql;
    @Autowired
    private BeanManger bean;
    @Autowired
    private BeanMangerOnly beanOnly;

    //查看当前树结构
    public List<MyTree> getForest() {
        return sql.getTree();
    }

    //插入一个新的分类
    @Transactional
    public Response insertTree(MyTree myTree) {
        Response response = bean.response();
        String desc = myTree.getDes();//描述
        int grade = myTree.getGrade();//当前等级
        if (desc != null && grade > 0) {
            myTree.setIs_active((byte) 1);
            sql.saveTree(myTree);
            response.setError(ErrorMessage.OK.getCode());
            response.setErrorMessage(ErrorMessage.OK.getMessage());
        } else {
            response.setError(ErrorMessage.MessageNotEnough.getCode());
            response.setErrorMessage(ErrorMessage.MessageNotEnough.getMessage());
        }
        return response;
    }

    public Response startRF(User user) throws Exception {//启动rf
        Response response = bean.response();
        if (user.getPassWord() != null && user.getUser() != null) {
            List<Sentence> sentences = sql.getModel();//当前库里所有的模板
            Map<Integer, List<String>> model = new HashMap<>();
            if (sentences.size() > 1) {
                for (Sentence sentence : sentences) {
                    int type = sentence.getSecond();
                    String word = sentence.getWord();
                    if (model.containsKey(type)) {
                        model.get(type).add(word);
                    } else {
                        List<String> words = new ArrayList<>();
                        words.add(word);
                        model.put(type, words);
                    }
                }
                beanOnly.tokenizer().start(model);//模版进行初始化
                response.setError(ErrorMessage.OK.getCode());
                response.setErrorMessage(ErrorMessage.OK.getMessage());
            } else {
                response.setError(ErrorMessage.SentenceNotEnough.getCode());
                response.setErrorMessage(ErrorMessage.SentenceNotEnough.getMessage());
            }
        } else {
            response.setError(ErrorMessage.UserMessageNotEnough.getCode());
            response.setErrorMessage(ErrorMessage.UserMessageNotEnough.getMessage());
        }
        return response;
    }

    //更新树结构
    @Transactional
    public Response updateForest(Structure structure) {
        Response response = bean.response();
        int id = structure.getId();
        int beforeGrade = structure.getBeforeGrade();
        int afterGrade = structure.getAfterGrade();
        int beforeFatherId = structure.getBeforeFatherId();
        int afterFatherId = structure.getAfterFatherId();
        MyTree myTree = sql.getNode(id);
        if (myTree.getFather_id() == beforeFatherId && myTree.getGrade() == beforeGrade) {
            if (myTree.getIs_active() > 0) {
                response.setError(ErrorMessage.OK.getCode());
                response.setErrorMessage(ErrorMessage.OK.getMessage());
                SentenceSql sentenceSql = bean.sentenceSql();
                myTree.setGrade(afterGrade);
                myTree.setFather_id(afterFatherId);
                sql.updateTree(myTree);//更新树结构
                if (beforeGrade == 3 && afterGrade == 2) {//从三级换到二级
                    String des = structure.getDesc();//描述
                    if (des != null) {//增加新的三级
                        MyTree myTreeThree = bean.myTree();
                        myTreeThree.setIs_active((byte) 1);
                        myTreeThree.setDes(des);
                        myTreeThree.setFather_id(id);
                        myTreeThree.setGrade(3);//新的三级
                        int thirdKey = sql.saveTree(myTreeThree);
                        sentenceSql.setSecond(id);
                        sentenceSql.setThird(thirdKey);
                        sentenceSql.setBeforeThird(id);
                        sql.updateSentence(sentenceSql);//修改语句级别
                    } else {
                        response.setError(ErrorMessage.LackFollow.getCode());
                        response.setErrorMessage(ErrorMessage.LackFollow.getMessage());
                    }
                } else {//从二级到三级，或者平级调动
                    switch (afterGrade) {//需要修改的
                        case 2:
                            sentenceSql.setFirst(afterFatherId);
                            break;
                        case 3:
                            sentenceSql.setSecond(afterFatherId);
                            break;
                    }
                    switch (beforeGrade) {//需要查找的
                        case 2:
                            sentenceSql.setBeforeSecond(id);
                            break;
                        case 3:
                            sentenceSql.setBeforeThird(id);
                            break;
                    }
                    sql.updateSentence(sentenceSql);//更新语句
                }
            } else {
                response.setError(ErrorMessage.NotActive.getCode());
                response.setErrorMessage(ErrorMessage.NotActive.getMessage());
            }
        } else {
            response.setError(ErrorMessage.Mismatch.getCode());
            response.setErrorMessage(ErrorMessage.Mismatch.getMessage());
        }
        return response;
    }

}
