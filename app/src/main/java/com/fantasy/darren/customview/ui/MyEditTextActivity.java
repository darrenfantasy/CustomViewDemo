package com.fantasy.darren.customview.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.fantasy.darren.customview.R;
import com.fantasy.darren.customview.widget.MyEditText;

/**
 * Created by fantasy on 17/3/1.
 */

public class MyEditTextActivity extends Activity{
    private MyEditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_edittext_activity);
        myEditText = (MyEditText)findViewById(R.id.editview);
        setEditTextLeftDrawable();
    }


    private void setEditTextLeftDrawable() {
        float density = getResources().getDisplayMetrics().density;
        int defSize = (int) (18 * density + 0.5f);
        Drawable drawable = getResources().getDrawable(R.mipmap.search_icon);
        drawable.setBounds(0, 0, defSize, defSize);
        myEditText.setCompoundDrawables(drawable, null, null, null);
    }
}
