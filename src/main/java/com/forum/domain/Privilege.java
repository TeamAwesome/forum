package com.forum.domain;

public enum Privilege {
    ADMIN(), MODERATOR(), EXPERT(), USER(), BLOCKED_USER();

    public static Privilege getPrivilege(int value){
        switch(value){
            case 1: return ADMIN;
            default:return USER;
        }
    }
}
