package com.wlld.table;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description
 */
public class PowerTable {//用户权限表
    public final static int Start = 1;//启动权限 最高危权限 每次都要输入账号密码
    public final static int UpdateTree = 1 << 1;//修改结构权限，高危权限
    public final static int Check = 1 << 2;//核对权限
    public final static int UpdateSentence = 1 << 3;//纠错权限
}
