package com.fantasy.darren.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by fantasy on 17/2/6.
 */

public class MyProgressBar extends View {
    private Paint mOutPaint;
    private Paint mInsidePaint;

    private float mWidth;
    private float mPadding;
    private float mStartAngle = 0f;

    private RectF mRectF = new RectF();

    public MyProgressBar(Context context) {
        this(context, null);
    }

    public MyProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mOutPaint = new Paint();
        mOutPaint.setAntiAlias(true);
        mOutPaint.setStyle(Paint.Style.STROKE);
        mOutPaint.setColor(Color.WHITE);
        mOutPaint.setStrokeWidth(8);

        mInsidePaint = new Paint();
        mInsidePaint.setAntiAlias(true);
        mInsidePaint.setStyle(Paint.Style.STROKE);
        mInsidePaint.setColor(Color.GRAY);
        mInsidePaint.setStrokeWidth(8);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth / 2 - mPadding, mOutPaint);
        canvas.drawArc(mRectF, mStartAngle, 100, false, mInsidePaint);
        playAnimation();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredWidth() > getMeasuredHeight())
            mWidth = getMeasuredHeight();
        else
            mWidth = getMeasuredWidth();
        mPadding = 10;
        Log.i("darren","onMeasure");
        mRectF = new RectF(mPadding, mPadding, mWidth - mPadding, mWidth - mPadding);
    }

    private void playAnimation() {
//        Log.i("darren", "startAnimation:" + mStartAngle);
        mStartAngle = (mStartAngle + 10) % 360;
        invalidate();
    }
}
