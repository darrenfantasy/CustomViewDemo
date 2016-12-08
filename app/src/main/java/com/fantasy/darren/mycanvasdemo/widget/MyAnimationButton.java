package com.fantasy.darren.mycanvasdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * 具有动画效果的自定义button
 * Created by fantasy on 16/12/7.
 */

public class MyAnimationButton extends Button {
    // 背景画笔
    private Paint mBackgroundPaint;
    private Paint mPaint;
    private String mText;
    private float mTextSize;
    private int mTextColor = Color.RED;
    private int mTextCoverColor = Color.GREEN;
    private int mProgress;
    private RectF mBackgroundBounds;
    // 背景颜色
    private int mBackgroundColor = 0x00000000;
    private int mBackgroundSecondColor =  Color.RED;
    private int mBackgroundFirstColor = Color.GREEN;
    private int mStockColor = 0xffbcbcbc;
    public MyAnimationButton(Context context) {
        super(context);
    }

    public MyAnimationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(mBackgroundColor);
        mPaint = new Paint();
        mBackgroundPaint = new Paint();
    }

    public MyAnimationButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawText(canvas);
        drawBackgroud(canvas);
    }

    private void drawText(Canvas canvas) {
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);
        final float y = canvas.getHeight() / 2 - (mPaint.descent() / 2 + mPaint.ascent() / 2);
        float textWidth = mPaint.measureText(mText);

        float coverLength = getMeasuredWidth()/100*mProgress;
        mProgress++;
        Log.i("darren","mProgress:"+mProgress);
        if(mProgress <= 100){
            // 文字变色部分的距离
            float coverTextLength = textWidth / 2 - getMeasuredWidth() / 2 + coverLength;

            float textProgress = coverTextLength / textWidth;

            LinearGradient linearGradient = new LinearGradient((getMeasuredWidth() - textWidth) / 2, 0, (getMeasuredWidth() + textWidth) / 2, 0,
                    new int[]{mTextColor, mTextCoverColor}, new float[]{textProgress,textProgress+0.001f}, Shader.TileMode.CLAMP);
            mPaint.setShader(linearGradient);
        }else {
            setMyText("点我");
        }
        canvas.drawText(mText, (getMeasuredWidth() - textWidth) / 2, y, mPaint);
        invalidate();
    }

    private void drawBackgroud(Canvas canvas){
        mBackgroundPaint.setColor(mBackgroundFirstColor);
        mBackgroundBounds = new RectF();
        float mProgressPercent = mProgress / (100 + 0f);
        Log.i("darren","mProgressPercent:"+mProgressPercent);
        LinearGradient mProgressBgGradient = new LinearGradient(0, 0, getMeasuredWidth(), 0, new int[] { mBackgroundFirstColor, mBackgroundSecondColor },
                new float[] {mProgressPercent, mProgressPercent + 0.001f }, Shader.TileMode.CLAMP);
        mBackgroundPaint.setColor(mBackgroundFirstColor);
        mBackgroundPaint.setShader(mProgressBgGradient);
        drawstock(canvas, mStockColor);
        canvas.drawRoundRect(mBackgroundBounds, 5, 5, mBackgroundPaint);
    }

    private void drawstock(Canvas canvas, int color) {
        // 画边框
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0, 0, this.getWidth(), this.getHeight());
        canvas.drawRoundRect(rectF, 5, 5, paint);

    }
    public void setMyText(String text) {
        mText = text;
    }

    public void setMyTextSize(float textSize) {
        mTextSize = textSize;
    }

    public void setProgress(int i){
        mProgress = i;
    }

    public void refresh(){
        setProgress(0);
        setMyText("ahhhhhhhh");
        invalidate();
    }
}
