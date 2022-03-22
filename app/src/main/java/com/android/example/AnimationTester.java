package com.android.example;

import android.animation.Animator;
import android.animation.ValueAnimator;

public class AnimationTester {

    private static Animator createVideoViewAlphaAnimator(boolean testBool) {
        ValueAnimator alphaAnimator = testBool
                ? ValueAnimator.ofFloat(0.0f, 0.5f)
                : ValueAnimator.ofFloat(0.1f, 1.0f);
        return alphaAnimator;
    }

    public static void doAnims() {
        createVideoViewAlphaAnimator(true).start();
    }
}
