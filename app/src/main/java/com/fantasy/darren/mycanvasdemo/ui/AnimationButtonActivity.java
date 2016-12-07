package com.fantasy.darren.mycanvasdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.fantasy.darren.mycanvasdemo.R;
import com.fantasy.darren.mycanvasdemo.widget.MyAnimationButton;

/**
 * Created by fantasy on 16/12/7.
 */

public class AnimationButtonActivity extends Activity{
    private  MyAnimationButton myAnimationButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_button_activity);
        myAnimationButton = (MyAnimationButton) findViewById(R.id.my_animation_btn);
        myAnimationButton.setMyText("点我");
        myAnimationButton.setMyTextSize(40);
        myAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAnimationButton.refresh();
            }
        });
    }
}
