package com.yulei.demo.model.enumClass;

/**
 * Created by 余磊 on 2016/5/28.
 */
public enum NewsType {
    MAJOR_INTRO("专业介绍", 1), SUMMARY("整体概括", 2), STRUCTURE("组织架构", 3), RULE("规章制度", 4),
    COLLEGE_NEWS("学院新闻", 5), PRESENCE("师生风采", 6),RESEARCH("科研动态",7),TRENDS("教学动态",8),MAJOR_CONSTRUCTION("专业建设",9),
    CLASS_CONSTRUCTION("课程建设",10),TEACH_MANAGE("教学管理",11),GRADUATE_PROFILE("研究生概况",12),
    GRADUATE_TRADE("培养方案",13),GRADUATE_MANAGE("研究生管理",14),RESEARCH_PROFILE("科研概况",15),
    RESEARCH_MANAGE("科研管理",16),ACADEMIC_EXCHANGE("学术交流",17),PROJECT_ACHIEVEMENT("项目与成果",18),
    ACTIVITY("学生活动",19),DAILY_MANAGE("日常管理",20),AWARD("评奖评优",21),NOTICE("通知公告",22),
    ENROLLMENT_INFO("招生信息",23),CAREER_PROSPECTS("就业前景",24),EMPLOYMENT_STATUS("就业情况",25);

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
