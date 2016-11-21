package com.fantasy.darren.mycanvasdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by fantasy on 16/11/18.
 */

public class MyLayout extends LinearLayout {
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("darren","MyLayout--dispatchTouchEvent-Action Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("darren","MyLayout-dispatchTouchEvent--Action Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("darren","MyLayout-dispatchTouchEvent--Action Up");
                break;

        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("darren","MyLayout--onInterceptTouchEvent-Action Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("darren","MyLayout-onInterceptTouchEvent--Action Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("darren","MyLayout-onInterceptTouchEvent--Action Up");
                break;

        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("darren","MyLayout--onTouchEvent-Action Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("darren","MyLayout-onTouchEvent--Action Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("darren","MyLayout-onTouchEvent--Action Up");
                break;
        }
        return super.onTouchEvent(event);
    }
}
