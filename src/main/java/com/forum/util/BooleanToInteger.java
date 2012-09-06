package com.forum.util;

/**
 * Created with IntelliJ IDEA.
 * User: nitinku
 * Date: 31/8/12
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class BooleanToInteger {
    public Boolean toBoolean(int anInteger)throws IllegalArgumentException {
        if(anInteger > 1 || anInteger < 0)
            throw new IllegalArgumentException(
                    "integer to convert must be 0 or 1, actual value is " + anInteger
            );
        if(anInteger==1)
            return  true;
        return false;
    }

    public Integer toInteger(boolean aBoolean) {
        if(aBoolean) return 1;
        return 0;
    }

}
