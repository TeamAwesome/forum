package com.forum.domain;


public enum AgeRange {

    RANGE_0_25(1), RANGE_25_35(2), RANGE_35_50(3), RANGE_50_70(4), RANGE_70_PLUS(5);

    private int code;

    AgeRange(int code){
       this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AgeRange getAgeRange(int code){
        switch(code){
            case 1:
                return RANGE_0_25;
            case 2:
                return RANGE_25_35;
            case 3:
                return RANGE_35_50;
            case 4:
                return RANGE_50_70;
            case 5:
                return RANGE_70_PLUS;
            default:
                throw new IllegalArgumentException("Wrong code for ageRange of user.");
        }
    }
}
