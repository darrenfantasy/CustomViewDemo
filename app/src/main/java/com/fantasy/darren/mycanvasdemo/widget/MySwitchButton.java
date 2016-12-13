package com.fantasy.darren.mycanvasdemo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by fantasy on 16/12/12.
 * 仿iOS风格的开关，可滑动
 */

public class MySwitchButton extends View {
    private String NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private Bitmap mBackgroundBitmap;
    private Bitmap mSlideBarBitmap;
    private int mMaxLeft;
    private int mCurrentLeft;
    private int startX, moveX;
    private boolean mIsOpen;

    public MySwitchButton(Context context) {
        super(context);
        initView(null);
    }

    public MySwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        if (attrs != null) {
            int bgBitmapId = attrs.getAttributeResourceValue(NAMESPACE, "background", -1);
            int slideBarBitmapId = attrs.getAttributeResourceValue(NAMESPACE, "slide_bar", -1);
            mBackgroundBitmap = BitmapFactory.decodeResource(getResources(), bgBitmapId);
            mSlideBarBitmap = BitmapFactory.decodeResource(getResources(), slideBarBitmapId);
            if (mBackgroundBitmap == null || mSlideBarBitmap == null) {
                throw new NullPointerException("资源图片不能为空");
            }
        }
        //最大可滑动距离
        mMaxLeft = mBackgroundBitmap.getWidth() - mSlideBarBitmap.getWidth();
        initStatus(attrs);
    }

    private void initStatus(AttributeSet attrs) {
        if (attrs != null) {
            boolean isOpen = attrs.getAttributeBooleanValue(NAMESPACE, "is_open", false);
            mIsOpen = isOpen;
            setStatus(mIsOpen);
        }
    }

    public void setStatus(boolean on) {
        mIsOpen = on;
        if (on) {
            mCurrentLeft = mMaxLeft;
        } else {
            mCurrentLeft = 0;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                int distance = (int) event.getX() - startX;
                mCurrentLeft += distance;
                moveX += Math.abs(distance);
                startX = (int) event.getX();
                break;
            case MotionEvent.ACTION_UP:
                if (moveX < 5) {//本意应该是点击
                    setStatus(!mIsOpen);
                } else {
                    if (mCurrentLeft < mMaxLeft / 2)
                        setStatus(false);
                    else
                        setStatus(true);
                }
                moveX = 0;
                break;
        }
        //边界判断
        if (mCurrentLeft < 0)
            mCurrentLeft = 0;
        if (mCurrentLeft > mMaxLeft)
            mCurrentLeft = mMaxLeft;
        invalidate();
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mBackgroundBitmap.getWidth(), mBackgroundBitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBackgroundBitmap, 0, 0, null);
        Log.i("darren", "mCurrentLeft:" + mCurrentLeft);
        canvas.drawBitmap(mSlideBarBitmap, mCurrentLeft, 0, null);
    }

}
