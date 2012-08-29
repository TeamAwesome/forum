package com.forum.domain;

public enum Topic {
    FOOD(1),TRAVEL(2),RELIGIOUS_SITES(3),FASHION(4), ARTS(5), MUSIC(6);
    private int id;

    Topic(int id){
        this.id = id;
    }

}
