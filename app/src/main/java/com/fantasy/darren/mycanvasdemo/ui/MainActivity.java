package com.fantasy.darren.mycanvasdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.fantasy.darren.mycanvasdemo.R;
import com.fantasy.darren.mycanvasdemo.adapter.MainActAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.main_list_view);
        String[] itemNames ={"Animation Button","MyCanvas"};
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList,itemNames);
        MainActAdapter mainActAdapter = new MainActAdapter(stringArrayList);
        listView.setAdapter(mainActAdapter);
    }
}
