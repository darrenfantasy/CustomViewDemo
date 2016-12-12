package com.fantasy.darren.mycanvasdemo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fantasy on 16/12/12.
 * 仿iOS风格简单的开关
 */

public class MySimpleSwitchButton extends View {

    private String NAMESPACE = "http://schemas.android.com/apk/res/com.fantasy.darren.mycanvasdemo";
    private Bitmap mButtonOn;
    private Bitmap mButtonOff;
    private Bitmap mButtonCurrent;
    private boolean isOn;

    public MySimpleSwitchButton(Context context) {
        super(context);
        initView(null);
    }

    public MySimpleSwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        if (attrs != null) {
            int mButtonOnId = attrs.getAttributeResourceValue(NAMESPACE, "switch_on", -1);
            int mButtonOffId = attrs.getAttributeResourceValue(NAMESPACE, "switch_off", -1);
            mButtonOn = BitmapFactory.decodeResource(getResources(), mButtonOnId);
            mButtonOff = BitmapFactory.decodeResource(getResources(), mButtonOffId);
            if (mButtonOn == null || mButtonOff == null) {
                throw new NullPointerException("资源图片不能为空");
            }
        }

        setStatus(true);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn) {
                    mButtonCurrent = mButtonOff;
                    isOn = false;
                } else {
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
        setMeasuredDimension(mButtonOn.getWidth(), mButtonOn.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mButtonCurrent, 0, 0, null);
    }

    public void setStatus(boolean b) {
        isOn = b;
    }

}
