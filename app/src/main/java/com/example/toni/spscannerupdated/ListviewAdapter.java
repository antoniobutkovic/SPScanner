package com.example.toni.spscannerupdated;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ListviewAdapter extends CursorAdapter {

    public ListviewAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_listview, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView num = (TextView) view.findViewById(R.id.num);
        TextView value = (TextView) view.findViewById(R.id.value);
        TextView timestamp = (TextView) view.findViewById(R.id.timestamp);
        num.setText(cursor.getString(1));
        value.setText(cursor.getString(2));
        timestamp.setText(cursor.getString(3));
    }
}
