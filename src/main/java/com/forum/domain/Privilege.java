package com.forum.domain;

public enum Privilege {
    ADMIN, USER;

    public static Privilege getPrivilege(int value){
        switch(value){
            case 1: return ADMIN;
            default:return USER;
        }
    }
}
