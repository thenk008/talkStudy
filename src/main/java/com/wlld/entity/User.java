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
public class User {
    @ApiModelProperty(value = "用户id", example = "1")
    private int id;
    @ApiModelProperty(value = "用户账户")
    private String user;//账号
    @ApiModelProperty(value = "密码")
    private String passWord;//密码
    @ApiModelProperty(value = "权限")
    private String power;//权限
    @ApiModelProperty(value = "姓名")
    private String name;//姓名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
