package com.yulei.demo.model.enumClass;

/**
 * Created by 余磊 on 2016/5/28.
 */
public enum NewsType {
    MAJOR_INTRO("专业介绍", 1), SUMMARY("整体概括", 2), STRUCTURE("组织架构", 3), RULE("规章制度", 4),
    COLLEGE_NEWS("", 4), PRESENCE("师生风采", 5),RESEARCH("科研动态",6),TRENDS("教学动态",7);
    private String string;
    private int i;

    NewsType(String string, int i) {
        this.string = string;
        this.i = i;
    }

    public String getString() {
        return string;
    }

    public int getI() {
        return i;
    }
}
