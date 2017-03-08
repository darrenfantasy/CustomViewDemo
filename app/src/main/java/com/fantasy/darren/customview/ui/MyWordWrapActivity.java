package com.fantasy.darren.customview.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.fantasy.darren.customview.R;
import com.fantasy.darren.customview.widget.MyWordWrapView;

/**
 * Created by fantasy on 17/1/13.
 */

public class MyWordWrapActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_wordwrap_activity);
        MyWordWrapView myWordWrapView = (MyWordWrapView) findViewById(R.id.word_wrap_view);
        String[] strings = new String[]{"haha", "hello", "darren", "周杰伦周杰伦周杰伦","hi", "fantasy", "darrenfanasty", "jay", "kobe bryant", "steven curry","stay hungry ,stay foolish"};
        for (int i = 0; i < strings.length; i++) {
            TextView textView = new TextView(this);
            textView.setText(strings[i]);
            myWordWrapView.addView(textView);
        }
    }
}
