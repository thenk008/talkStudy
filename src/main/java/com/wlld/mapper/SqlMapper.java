package com.wlld.mapper;

import com.wlld.entity.MyTree;
import com.wlld.entity.Sentence;
import com.wlld.entity.SentenceSql;
import com.wlld.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface SqlMapper {
    //展示分类的所有结构关系
    @Select("select * from mytree")
    List<MyTree> getTree();

    //根据分类id将某个分类的结构关系拿出来
    @Select("select * from mytree where id=#{id}")
    MyTree getNode(int id);

    //获取当前库里全部模板
    @Select("select * from sentence")
    List<Sentence> getModel();

    //获取当前用户账号
    @Select("select * from admin where user=#{user}")
    User getUser(User user);

    //修改一个分类的结构关系
    @Update("update mytree set grade=#{grade},father_id=#{father_id} where id=#{id}")
    void updateTree(MyTree myTree);

    //插入一个新的分类,并返回它的主键id
    @Insert("insert into mytree (des,grade,father_id,is_active)values" +
            "(#{des},#{grade},#{father_id},#{is_active})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveTree(MyTree myTree);

    //插入一条新的语句
    @Insert("insert into sentence (word,first,second,third) values (#{word},#{first},#{second},#{third})")
    void saveSentence(SentenceSql sentenceSql);

    //模版内语句id及级别调整
    @Update("<script>update sentence " +
            "<set> " +
            "<if test=\"first>0\">first=#{first},</if>" +
            "<if test=\"second>0\">second=#{second},</if>" +
            "<if test=\"third>0\">third=#{third},</if>" +
            "</set>" +
            "where" +
            "<choose>" +
            "<when test=\"beforeFirst>0\">first=#{beforeFirst}</when>" +
            "<when test=\"beforeSecond>0\">second=#{beforeSecond}</when>" +
            "<when test=\"beforeThird>0\">third=#{beforeThird}</when>" +
            "</choose>" +
            "</script>")
    void updateSentence(SentenceSql sentenceSql);
}
