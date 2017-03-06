package com.fantasy.darren.customview.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.fantasy.darren.customview.R;
import com.fantasy.darren.customview.widget.MyProgressBar;

/**
 * Created by fantasy on 17/2/6.
 */

public class MyProgressBarActivity extends Activity {
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_progressbar_activity);
        mGridView = (GridView) findViewById(R.id.gridview);
        mGridView.setNumColumns(4);
        MyAdapter myAdapter = new MyAdapter();
        mGridView.setAdapter(myAdapter);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.i("darren","getView");
            MyProgressBar myProgressBar = new MyProgressBar(parent.getContext());
            myProgressBar.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
            return myProgressBar;
        }
    }
}
