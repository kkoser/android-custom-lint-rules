package com.android.example;

import androidx.annotation.Dimension;

public class AnimationTester {

    public static @Dimension(unit = Dimension.SP) int SP_VAL;

    private static void createVideoViewAlphaAnimator(boolean testBool) {
        useSpValue(SP_VAL);
    }

    public static void useSpValue(@Dimension(unit = Dimension.SP) int val) {
        TextOverlay overlay = new TextOverlay(val);
    }

}
