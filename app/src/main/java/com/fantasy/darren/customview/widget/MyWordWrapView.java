package com.fantasy.darren.customview.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fantasy on 17/1/13.
 */

public class MyWordWrapView extends ViewGroup {
    private int Margin = 10;
    private int padding = 10;

    public MyWordWrapView(Context context) {
        super(context);
    }

    public MyWordWrapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int actuallyWidth = width - Margin * 2;
        int actuallyHeight = 0;
        int row = 1;
        int cHeight = 0;
        int addWidth = 0;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            child.setPadding(padding, padding, padding, padding);
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            int cWidth = child.getMeasuredWidth();
            cHeight = child.getMeasuredHeight();
            addWidth += cWidth + padding;
            if (addWidth > actuallyWidth) {
                row++;
                addWidth = cWidth;
            }
        }
        actuallyHeight = (cHeight + Margin) * row;
        setMeasuredDimension(actuallyWidth, actuallyHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int actuallyWidth = r - l;
        int x = Margin;
        int y;
        int row = 1;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            child.setBackgroundColor(Color.GRAY);
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();
            x += width + padding;
            if (x > actuallyWidth) {
                x = width + padding;
                row++;
            }
            y = row * (height + Margin);
            if (i == 0)
                child.layout(x - width - padding, y - height, x - padding, y);
            else
                child.layout(x - width, y - height, x, y);
        }
    }
}
