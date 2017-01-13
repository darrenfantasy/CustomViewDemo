package com.fantasy.darren.mycanvasdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.fantasy.darren.mycanvasdemo.R;
import com.fantasy.darren.mycanvasdemo.widget.MyWordWrapView;

/**
 * Created by fantasy on 17/1/13.
 */

public class MyWordWrapActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_wordwrap_activity);
        MyWordWrapView myWordWrapView = (MyWordWrapView) findViewById(R.id.word_wrap_view);
        String[] strings = new String[]{"haha", "hello", "darren", "周杰伦周杰伦周杰伦","hi", "fantasy", "darrenfanasty", "jay", "kobe bryant", "steven curry","本来几天高高兴兴"};
        for (int i = 0; i < strings.length; i++) {
            TextView textView = new TextView(this);
            textView.setText(strings[i]);
            myWordWrapView.addView(textView);
        }
    }
}
