package com.wlld.controller;

import com.wlld.entity.MyTree;
import com.wlld.entity.Response;
import com.wlld.entity.Structure;
import com.wlld.entity.User;
import com.wlld.service.TalkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description
 */
@RestController
@RequestMapping("/ai")
@Api(tags = "修改分类树结构相关接口")
public class MyTalk {
    @Autowired
    private TalkService talk;

    @RequestMapping(value = "/getTree", method = RequestMethod.POST)//获取树结构
    @ApiOperation("获取树结构")
    public List<MyTree> getTree() {
        return talk.getForest();
    }

    @RequestMapping(value = "/updateTree", method = RequestMethod.POST)//修改当前树结构
    @ApiOperation("修改当前树结构")
    public Response updateTree(Structure structure) {
        return talk.updateForest(structure);
    }

    @RequestMapping(value = "/insertTree", method = RequestMethod.POST)//新增一个树结构
    @ApiOperation("新增一个树结构")
    public Response insertTree(MyTree myTree) {
        return talk.insertTree(myTree);
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)//启动模型
    @ApiOperation("启动模型")
    public Response start(User user) throws Exception {
        return talk.startRF(user);
    }
}
