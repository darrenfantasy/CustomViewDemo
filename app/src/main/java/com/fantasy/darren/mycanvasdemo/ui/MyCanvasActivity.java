package com.fantasy.darren.mycanvasdemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fantasy.darren.mycanvasdemo.R;
import com.fantasy.darren.mycanvasdemo.widget.MyCanvas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by fantasy on 16/12/7.
 */

public class MyCanvasActivity extends Activity {
    private MyCanvas myCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_canvas_activity);
        myCanvas = (MyCanvas) findViewById(R.id.my_canvas);
        Button saveBtn = (Button) findViewById(R.id.save);
        LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.m_layout);
        saveBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("darren","myButton--onTouch-Action Down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i("darren","myButton-onTouch--Action Move");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("darren","myButton-onTouch--Action Up");
                        break;
                }
                return false;
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // savePhoto();
                Log.i("darren","myButton-onClick--");
                myCanvas.cleanBitmap();
            }
        });
        mLinearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("darren","mLinearLayout--onTouch-Action Down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i("darren","mLinearLayout-onTouch--Action Move");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("darren","mLinearLayout-onTouch--Action Up");
                        break;
                }
                return false;
            }
        });
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("darren","myLayout-onClick--");
                myCanvas.cleanBitmap();
            }
        });
    }
    private void savePhoto(){
        try {
            File file = new File(Environment.getExternalStorageDirectory(),System.currentTimeMillis()+".png");
            OutputStream outputStream = new FileOutputStream(file);
            myCanvas.saveBitmap(outputStream);
            outputStream.close();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
            intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
            sendBroadcast(intent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("darren","activity--onTouchEvent-Action Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("darren","activity-onTouchEvent--Action Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("darren","activity-onTouchEvent--Action Up");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("darren","activity--dispatchTouchEvent-Action Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("darren","activity-dispatchTouchEvent--Action Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("darren","activity-dispatchTouchEvent--Action Up");
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
