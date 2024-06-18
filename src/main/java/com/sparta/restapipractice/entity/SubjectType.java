package com.sparta.restapipractice.entity;

public enum SubjectType {
    JPA(Type.JPA),  // 사용자 권한
    DB(Type.DB);  // 관리자 권한

    private final String type;

    SubjectType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public static class Type {
        public static final String JPA = "JPA";
        public static final String DB = "DB";
    }
}
