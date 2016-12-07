package com.fantasy.darren.mycanvasdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * button中的字体可变色并且"一直播放"
 * Created by fantasy on 16/12/7.
 */

public class MyAnimationButton extends Button {

    private Paint mPaint;
    private String mText;
    private float mTextSize;
    private int mTextColor = Color.RED;
    private int mTextCoverColor = Color.GREEN;
    private int mProgress;
    public MyAnimationButton(Context context) {
        super(context);
    }

    public MyAnimationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    public MyAnimationButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        mPaint.setTextSize(mTextSize);
        final float y = canvas.getHeight() / 2 - (mPaint.descent() / 2 + mPaint.ascent() / 2);
        float textWidth = mPaint.measureText(mText);

        float coverLength = getMeasuredWidth()/100*mProgress;
        mProgress++;
        Log.i("darren","mProgress:"+mProgress);
        if(mProgress == 100)
            mProgress = 0;
        // 文字变色部分的距离
        float coverTextLength = textWidth / 2 - getMeasuredWidth() / 2 + coverLength;

        float textProgress = coverTextLength / textWidth;

        LinearGradient linearGradient = new LinearGradient((getMeasuredWidth() - textWidth) / 2, 0, (getMeasuredWidth() + textWidth) / 2, 0,
                new int[]{mTextColor, mTextCoverColor}, new float[]{textProgress,textProgress+0.001f}, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient);
        mPaint.setColor(mTextColor);
        canvas.drawText(mText, (getMeasuredWidth() - textWidth) / 2, y, mPaint);
        invalidate();
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
}
