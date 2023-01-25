package com.eterces.bauetattendance;

public class ClassItem {
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    String className;

    public ClassItem(String className, String subjectName) {
        this.className = className;
        this.subjectName = subjectName;
    }

    String subjectName;
}
