package com.fantasy.darren.mycanvasdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.OutputStream;

/**
 * Created by fantasy on 16/10/25.
 */
public class MyCanvas extends View {
    private static final String tag = "MyCanvas";
    private Canvas mCanvas;
    private Paint mPaint;
    private Bitmap mBitmap;

    public MyCanvas(Context context) {
        super(context);
    }

    public MyCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitmap = Bitmap.createBitmap(2000, 2000, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.GRAY);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);
    }

    public MyCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private float startX, startY, stopX, stopY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "ACTION_DOWN");
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "ACTION_MOVE");
                stopX = event.getX();
                stopY = event.getY();
                mCanvas.drawLine(startX, startY, stopX, stopY, mPaint);
                startX = event.getX();
                startY = event.getY();
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCanvas != null) {
            Log.i(tag, "onDraw");
            canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        }
    }

    public void saveBitmap(OutputStream outputStream) {
        if (mBitmap != null)
            mBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
    }

    public void cleanBitmap(){
//        Paint paint = new Paint();
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        paint.setColor(Color.GRAY);
//        mCanvas.drawPaint(paint);
        mCanvas.drawColor(Color.GRAY);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        invalidate();
    }
}
