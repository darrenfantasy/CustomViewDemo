package com.fantasy.darren.mycanvasdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fantasy.darren.mycanvasdemo.R;
import com.fantasy.darren.mycanvasdemo.widget.MyPickerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fantasy on 17/1/12.
 */

public class MyPickerViewActivity extends Activity {
    MyPickerView minute_pv;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_pickerview_activity);
        minute_pv = (MyPickerView) findViewById(R.id.minute_pv);
        textView = (TextView) findViewById(R.id.sure);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("darren", "isShow:" + minute_pv.isShown());
                if (minute_pv.isShown()) {
                    Log.i("darren", "gone");
                    minute_pv.setVisibility(View.GONE);
                } else {
                    Log.i("darren", "visible");
                    minute_pv.setVisibility(View.VISIBLE);
                }

            }
        });
        List<String> data = new ArrayList<String>();
        List<String> seconds = new ArrayList<String>();
        String[] jobs = {"学生", "创业公司成员", "外企从业者", "国企从业者", "私企从业者", "公务员", "IT从业者"};
        for (int i = 0; i < jobs.length; i++) {
            data.add(jobs[i]);
        }
        for (int i = 0; i < 60; i++) {
            seconds.add(i < 10 ? "0" + i : "" + i);
        }
        minute_pv.setData(data);
        minute_pv.setOnSelectListener(new MyPickerView.onSelectListener() {

            @Override
            public void onSelect(String text) {
                Toast.makeText(MyPickerViewActivity.this, "选择了 " + text,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
