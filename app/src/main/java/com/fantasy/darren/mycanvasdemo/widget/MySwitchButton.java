package com.fantasy.darren.mycanvasdemo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by fantasy on 16/12/12.
 * 仿iOS风格的开关，可滑动
 */

public class MySwitchButton extends View {
    private String NAMESPACE = "";
    private Bitmap mBackgroundBitmap;
    private Bitmap mSlideBarBitmap;
    private int mMaxLeft;
    private int mCurrentLeft;

    public MySwitchButton(Context context) {
        super(context);
    }

    public MySwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void initView(AttributeSet attrs) {
        if (attrs != null) {
            int bgBitmapId = attrs.getAttributeResourceValue(NAMESPACE, "background", -1);
            int slideBarBitmapId = attrs.getAttributeResourceValue(NAMESPACE, "slide_bar", -1);
            mBackgroundBitmap = BitmapFactory.decodeResource(getResources(), bgBitmapId);
            mSlideBarBitmap = BitmapFactory.decodeResource(getResources(), slideBarBitmapId);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
