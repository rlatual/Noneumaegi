package com.nonu.noneumaegi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nonu.noneumaegi.R;
import com.nonu.noneumaegi.VO.Tradetime;

import java.util.ArrayList;

public class TradetimeAdapter extends BaseAdapter {
    ArrayList<Tradetime> tradetimes = new ArrayList<>();

    @Override
    public int getCount() {
        return tradetimes.size();
    }

    @Override
    public Object getItem(int position) {
        return tradetimes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.time_listview_item, parent, false);
        }

        TextView isweek = convertView.findViewById(R.id.tv_isweek);
        TextView time1 = convertView.findViewById(R.id.tv_time1);
        TextView time2 = convertView.findViewById(R.id.tv_time2);

        if (tradetimes.get(pos).isWeek()) {
            isweek.setText("평");
        } else {
            isweek.setText("주");
        }

        time1.setText(tradetimes.get(pos).getStartTime());
        time2.setText(tradetimes.get(pos).getEndTime());

        return convertView;
    }

    public void addItem(boolean isWeek, String time1, String time2) {
        Tradetime tradetime = new Tradetime();

        tradetime.setWeek(isWeek);
        tradetime.setStartTime(time1);
        tradetime.setEndTime(time2);

        tradetimes.add(tradetime);
    }
}
