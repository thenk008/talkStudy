package com.wlld.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description
 */
@ApiModel
public class MyTree {
    @ApiModelProperty(value = "分类id", example = "1")
    private int id;//主键
    @ApiModelProperty(value = "分类描述")
    private String describe;//描述
    @ApiModelProperty(value = "所处级别", example = "2")
    private int grade;//级别
    @ApiModelProperty(value = "父级id", example = "2")
    private int father_id;//父级的id
    @ApiModelProperty(value = "是否封禁，1是正常，0是封禁", example = "1")
    private int is_active;//是否封禁,1是正常0是封禁

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getFather_id() {
        return father_id;
    }

    public void setFather_id(int father_id) {
        this.father_id = father_id;
    }
}
