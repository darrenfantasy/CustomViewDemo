package com.fantasy.darren.mycanvasdemo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.fantasy.darren.mycanvasdemo.R;

/**
 * Created by fantasy on 16/12/12.
 * 仿iOS风格简单的开关
 */

public class MySimpleSwitchButton extends View {

    private Bitmap mButtonOn;
    private Bitmap mButtonOff;
    private Bitmap mButtonCurrent;
    private boolean isOn;
    public MySimpleSwitchButton(Context context) {
        super(context);
    }

    public MySimpleSwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView(){
        mButtonOn = BitmapFactory.decodeResource(getResources(), R.mipmap.toggle_btn_checked);
        mButtonOff = BitmapFactory.decodeResource(getResources(),R.mipmap.toggle_btn_unchecked);
        setStatus(true);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOn){
                    mButtonCurrent = mButtonOff;
                    isOn = false;
                }else {
                    mButtonCurrent = mButtonOn;
                    isOn = true;
                }
                invalidate();
            }
        });
        mButtonCurrent = mButtonOff;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mButtonOn.getWidth(),mButtonOn.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mButtonCurrent,0,0,null);
    }

    public void setStatus(boolean b){
        isOn = b;
    }

}
