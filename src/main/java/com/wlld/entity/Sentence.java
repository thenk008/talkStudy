package com.wlld.entity;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description
 */
public class Sentence {
    private int id;
    private String word;//语句
    private int first;//最高类别属于哪一个
    private int second;//二级类别属于哪一个
    private int third;//三级类别属于哪一个

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }
}
