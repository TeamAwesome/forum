package com.forum.util;


public class TestHelper {
    public int getLikeCountValue(String likeCountText) {
        int result = Integer.MIN_VALUE;

        int openIndex = likeCountText.indexOf("(");
        int closeIndex = likeCountText.indexOf(")");

        if (openIndex != -1 && closeIndex > openIndex) {
            result = Integer.valueOf(
                    likeCountText.substring(openIndex + 1, closeIndex)
            );
        }

        return result;
    }

}
