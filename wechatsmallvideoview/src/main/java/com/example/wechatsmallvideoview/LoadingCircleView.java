package com.example.wechatsmallvideoview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 *
 * <p>
 * My GitHub : https://github.com/af913337456/
 * <p>
 * My Blog   : http://www.cnblogs.com/linguanh/
 * <p>
 * second time edited by LinGuanHong on 2017/4/26.
 */

public class LoadingCircleView extends View {


    private Paint paintBgCircle;


    private Paint paintCircle;

    private Paint paintProgressCircle;


    private float startAngle = -90f;//开始角度

    private float sweepAngle = 0;//结束

    private int progressCirclePadding = 0;//进度圆与背景圆的间距


    private boolean fillIn = false;//进度圆是否填充

    private int animDuration = 2000;


    private LodingCircleViewAnim mLodingCircleViewAnim;//动画效果


    public LoadingCircleView(Context context) {
        super(context);
        init();
    }

    public LoadingCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    private void init() {

        mLodingCircleViewAnim = new LodingCircleViewAnim();
        mLodingCircleViewAnim.setDuration(animDuration);
        progressCirclePadding = dip2px(getContext(), 3);

        paintBgCircle = new Paint();
        paintBgCircle.setAntiAlias(true);
        paintBgCircle.setStyle(Paint.Style.FILL);
        paintBgCircle.setColor(Color.WHITE);


        paintCircle = new Paint();
        paintCircle.setAntiAlias(true);
        paintCircle.setStyle(Paint.Style.FILL);
        paintCircle.setColor(Color.GRAY);


        paintProgressCircle = new Paint();
        paintProgressCircle.setAntiAlias(true);
        paintProgressCircle.setStyle(Paint.Style.FILL);
        paintProgressCircle.setColor(Color.WHITE);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredWidth() / 2, getMeasuredWidth() / 2, paintBgCircle);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredWidth() / 2, getMeasuredWidth() / 2 - progressCirclePadding / 2, paintCircle);
        RectF f = new RectF(progressCirclePadding, progressCirclePadding, getMeasuredWidth() - progressCirclePadding, getMeasuredWidth() - progressCirclePadding);
        canvas.drawArc(f, startAngle, sweepAngle, true, paintProgressCircle);
        if (!fillIn)
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredWidth() / 2, getMeasuredWidth() / 2 - progressCirclePadding * 2, paintCircle);


    }


    public void startAnimAutomatic(boolean fillIn) {
        this.fillIn = fillIn;
        if (mLodingCircleViewAnim != null)
            clearAnimation();
        startAnimation(mLodingCircleViewAnim);
    }

    public void stopAnimAutomatic() {
        if (mLodingCircleViewAnim != null)
            clearAnimation();
    }


    public void setProgerss(int progerss, boolean fillIn) {
        this.fillIn = fillIn;
        sweepAngle = (float) (360 / 100.0 * progerss);
        invalidate();
    }


    private class LodingCircleViewAnim extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f) {
                sweepAngle = 360 * interpolatedTime;
                invalidate();
            } else {
                startAnimAutomatic(fillIn);
            }

        }
    }
}