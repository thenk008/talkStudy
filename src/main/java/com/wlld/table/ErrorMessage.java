package com.wlld.table;

public enum ErrorMessage {
    OK(0, "正常"),
    Mismatch(1, "与该分类原本父子关系不匹配"),
    NotActive(2, "该分类id已经被封禁，不可以再使用"),
    LackFollow(3, "缺少下级分类"),
    MessageNotEnough(4, "分类插入信息不足"),
    SentenceNotEnough(5, "分类语句数量过少"),
    UserMessageNotEnough(6, "登陆用户信息不足");
    private int code;
    private String message;

    ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
