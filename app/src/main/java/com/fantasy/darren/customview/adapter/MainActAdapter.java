package com.fantasy.darren.customview.adapter;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fantasy.darren.customview.R;
import com.fantasy.darren.customview.ui.AnimationButtonActivity;
import com.fantasy.darren.customview.ui.MyCanvasActivity;
import com.fantasy.darren.customview.ui.MyEditTextActivity;
import com.fantasy.darren.customview.ui.MyPickerViewActivity;
import com.fantasy.darren.customview.ui.MyProgressBarActivity;
import com.fantasy.darren.customview.ui.MySwitchButtonActivity;
import com.fantasy.darren.customview.ui.MyWordWrapActivity;

import java.util.List;

/**
 * Created by fantasy on 16/12/7.
 */

public class MainActAdapter extends BaseAdapter {
    private List<String> mListNames;

    public MainActAdapter(List<String> names) {
        mListNames = names;
    }

    @Override
    public int getCount() {
        return mListNames.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        String name = mListNames.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.main_adapter_item, null);
            viewHolder.relativeLayout = (RelativeLayout) convertView.findViewById(R.id.item_rl);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.item_tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(name);
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent intent = new Intent(parent.getContext(), AnimationButtonActivity.class);
                    parent.getContext().startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(parent.getContext(), MyCanvasActivity.class);
                    parent.getContext().startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(parent.getContext(), MySwitchButtonActivity.class);
                    parent.getContext().startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(parent.getContext(), MyPickerViewActivity.class);
                    parent.getContext().startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(parent.getContext(), MyWordWrapActivity.class);
                    parent.getContext().startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(parent.getContext(), MyProgressBarActivity.class);
                    parent.getContext().startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(parent.getContext(), MyEditTextActivity.class);
                    parent.getContext().startActivity(intent);
                }
            }
        });

        return convertView;
    }

    class ViewHolder {
        TextView textView;
        RelativeLayout relativeLayout;
    }
}
