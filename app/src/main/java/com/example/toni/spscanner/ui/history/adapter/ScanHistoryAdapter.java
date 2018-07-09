package com.example.toni.spscanner.ui.history.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.toni.spscanner.R;
import com.example.toni.spscanner.model.Scan;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ScanHistoryAdapter extends BaseAdapter {

    private List<Scan> scans;

    public ScanHistoryAdapter() {
        scans = new ArrayList<>();
    }

    public void updateScanResultsList(List<Scan> scan){
        scans.clear();
        scans.addAll(scan);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return scans.size();
    }

    @Override
    public Object getItem(int position) {
        return scans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TaskViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scan, parent,false);
            holder = new TaskViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (TaskViewHolder) convertView.getTag();
        }
        Scan scan = scans.get(position);

        holder.scannedValueTv.setText(scan.getScannedValue());
        holder.resultTv.setText(scan.getResult());
        holder.timestampTv.setText(scan.getTime());

        return convertView;
    }

    static class TaskViewHolder{
        @BindView(R.id.num)
        TextView scannedValueTv;
        @BindView(R.id.value)
        TextView resultTv;
        @BindView(R.id.timestamp)
        TextView timestampTv;

        public TaskViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
