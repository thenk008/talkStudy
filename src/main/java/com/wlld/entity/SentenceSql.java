package com.wlld.entity;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description
 */
public class SentenceSql {
    private int id;
    private String word;//语句
    private int first;//最高类别属于哪一个
    private int second;//二级类别属于哪一个
    private int third;//三级类别属于哪一个
    private int beforeFirst;//之前
    private int beforeSecond;
    private int beforeThird;

    public int getBeforeFirst() {
        return beforeFirst;
    }

    public void setBeforeFirst(int beforeFirst) {
        this.beforeFirst = beforeFirst;
    }

    public int getBeforeSecond() {
        return beforeSecond;
    }

    public void setBeforeSecond(int beforeSecond) {
        this.beforeSecond = beforeSecond;
    }

    public int getBeforeThird() {
        return beforeThird;
    }

    public void setBeforeThird(int beforeThird) {
        this.beforeThird = beforeThird;
    }

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
