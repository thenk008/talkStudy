package com.wlld.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description 储存结构
 */
@ApiModel
public class Structure {
    @ApiModelProperty(value = "分类id", example = "4")
    private int id;//被改变的id
    @ApiModelProperty(value = "改变之前所处的等级", example = "2")
    private int beforeGrade;//之前所处的等级
    @ApiModelProperty(value = "现在所处的等级", example = "3")
    private int afterGrade;//此id现在的等级
    @ApiModelProperty(value = "之前父节点的id", example = "1")
    private int beforeFatherId;//之前父节点的id
    @ApiModelProperty(value = "现在父节点的id", example = "3")
    private int afterFatherId;//之后父节点的id
    @ApiModelProperty(value = "如果新增了一个3分类，那么它的描述")
    private String desc;//新增加3的描述

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBeforeGrade() {
        return beforeGrade;
    }

    public void setBeforeGrade(int beforeGrade) {
        this.beforeGrade = beforeGrade;
    }

    public int getAfterGrade() {
        return afterGrade;
    }

    public void setAfterGrade(int afterGrade) {
        this.afterGrade = afterGrade;
    }

    public int getBeforeFatherId() {
        return beforeFatherId;
    }

    public void setBeforeFatherId(int beforeFatherId) {
        this.beforeFatherId = beforeFatherId;
    }

    public int getAfterFatherId() {
        return afterFatherId;
    }

    public void setAfterFatherId(int afterFatherId) {
        this.afterFatherId = afterFatherId;
    }
}
