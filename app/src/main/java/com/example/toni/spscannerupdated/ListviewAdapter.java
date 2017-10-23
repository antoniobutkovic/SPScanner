package com.example.toni.spscannerupdated;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListviewAdapter extends CursorAdapter {

    @BindView(R.id.num) TextView num;
    @BindView(R.id.value) TextView value;
    @BindView(R.id.timestamp) TextView timestamp;

    public ListviewAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_listview, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        num.setText(cursor.getString(1));
        value.setText(cursor.getString(2));
        timestamp.setText(cursor.getString(3));
    }
}
