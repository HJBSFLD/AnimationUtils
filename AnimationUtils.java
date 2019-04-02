package com.ad.show.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.widget.ImageView;

/**
 * author  Li Peng on 2019/4/2.
 * Phone 18974450920
 * Mail lipeng03@skyworth.com
 */
public class AnimationUtils {
    /**
     * 强调
     */
    public static void doEmphasizeAnimate(ImageView v) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(v, "scaleX", 1f, 0.7f);
        animator1.setDuration(100);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(v, "scaleY", 1f, 0.7f);
        animator2.setDuration(100);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(v, "scaleX", 0.7f, 1.3f);
        animator3.setDuration(100);
        animator3.setStartDelay(100);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(v, "scaleY", 0.7f, 1.3f);
        animator4.setDuration(100);
        animator4.setStartDelay(100);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(v, "rotation", 0, -5, 0, 5, 0, -5, 0, 5, 0, -5, 0, 5, 0);
        animator5.setDuration(1000);
        animator5.setStartDelay(200);
        ObjectAnimator animator6 = ObjectAnimator.ofFloat(v, "scaleX", 1.3f, 1f);
        animator6.setDuration(100);
        animator6.setStartDelay(1200);
        ObjectAnimator animator7 = ObjectAnimator.ofFloat(v, "scaleY", 1.3f, 1f);
        animator7.setDuration(100);
        animator7.setStartDelay(1200);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator1, animator2, animator3, animator4, animator5, animator6, animator7);
        set.start();
    }

    /**
     * 抖动
     */
    public static void doShakeAnimate(ImageView v) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "translationX", 0, -30, 0, 30, 0, -30, 0, 30, 0, -30, 0, 30, 0, -30, 0);
        animatorX.setDuration(1000);
        animatorX.start();
    }

    /**
     * 摇摆
     */
    public static void doRockAnimate(final ImageView v) {
        final float pX = v.getPivotX();
        final float pY = v.getPivotY();
        v.setPivotX(v.getWidth() / 2);
        v.setPivotY((float) (v.getHeight() + v.getWidth() * Math.sin(Math.PI / 3)));
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "rotation", 0, -5, 0, 5, 0, -5, 0, 5, 0);
        animatorX.setDuration(1000);
        animatorX.start();
        animatorX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                v.setPivotX(pX);
                v.setPivotY(pY);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    /**
     * 滚入
     */
    public static void doRollInAnimate(final ImageView v) {
        final float pX = v.getPivotX();
        final float pY = v.getPivotY();
        v.setPivotX(0);
        v.setPivotY(v.getHeight());
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "rotation", -60, 0);
        animatorX.setDuration(1000);
        animatorX.start();
        animatorX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                v.setPivotX(pX);
                v.setPivotY(pY);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    /**
     * 向下飞入
     */
    public static void doEnterTopAnimate(ImageView v) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "translationY", -v.getHeight(), 0);
        animatorX.setDuration(1000);
        animatorX.start();
    }

    /**
     * 向上飞入
     */
    public static void doEnterBottomAnimate(ImageView v) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "translationY", v.getWidth(), 0);
        animatorX.setDuration(1000);
        animatorX.start();
    }

    /**
     * 向左飞入
     */
    public static void doEnterLeftAnimate(ImageView v) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "translationX", v.getWidth(), 0);
        animatorX.setDuration(1000);
        animatorX.start();
    }

    /**
     * 向右飞入
     */
    public static void doEnterRightAnimate(ImageView v) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "translationX", -v.getWidth(), 0);
        animatorX.setDuration(1000);
        animatorX.start();
    }

    /**
     * 光速进入
     */
    public static void doEnterFastAnimate(ImageView v, int pageWidth) {
        final SpringAnimation animX = new SpringAnimation(v, SpringAnimation.TRANSLATION_X, 0);
        animX.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        animX.getSpring().setStiffness(1000f);
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "translationX", (pageWidth - v.getLeft()), -50);
        animatorX.setDuration(200);
        animatorX.start();
        animatorX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animX.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    /**
     * 放大动画
     */
    public static void doZoomInAnimate(ImageView v) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "scaleX", 0f, 1f, 1f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(v, "scaleY", 0f, 1f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorX, animatorY);
        set.setDuration(1000);
        set.start();
    }

    /**
     * 橡皮筋动画
     */
    public static void doRubberAnimate(ImageView v) {
        final SpringAnimation animX = new SpringAnimation(v, SpringAnimation.SCALE_X, 1f);
        final SpringAnimation animY = new SpringAnimation(v, SpringAnimation.SCALE_Y, 1f);
        animX.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        animY.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        animX.getSpring().setStiffness(1000f);
        animY.getSpring().setStiffness(1000f);
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(v, "scaleX", 1f, 1.3f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(v, "scaleY", 1f, 0.7f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorX, animatorY);
        set.setDuration(200);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animX.start();
                animY.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
