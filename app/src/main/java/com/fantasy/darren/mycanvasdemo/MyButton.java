package com.fantasy.darren.mycanvasdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by fantasy on 16/11/18.
 */

public class MyButton extends Button {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("darren","myButton--dispatchTouchEvent-Action Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("darren","myButton-dispatchTouchEvent--Action Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("darren","myButton-dispatchTouchEvent--Action Up");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("darren","myButton--onTouchEvent-Action Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("darren","myButton-onTouchEvent--Action Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("darren","myButton-onTouchEvent--Action Up");
                break;
        }
        return super.onTouchEvent(event);
    }
}
