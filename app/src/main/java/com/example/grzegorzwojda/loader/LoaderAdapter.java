package com.example.grzegorzwojda.loader;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Grzegorz Wojda on 2016-01-08.
 */
public class LoaderAdapter extends CursorAdapter {

    Context context;
    private static LayoutInflater inflater = null;

    public LoaderAdapter(Context context, Cursor c){
        super(context, c);
        this.context = context;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view=inflater.inflate(R.layout.list_row,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        View vi = view;

        if (vi == null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView number = (TextView) vi.findViewById(R.id.number);
        TextView body = (TextView) vi.findViewById(R.id.body);
        TextView date = (TextView) vi.findViewById(R.id.data);
        TextView read = (TextView) vi.findViewById(R.id.read);

        number.setText(cursor.getString(cursor.getColumnIndexOrThrow("address")));
        body.setText(cursor.getString(cursor.getColumnIndexOrThrow("body")));

        Date dat = new Date(cursor.getLong(4));
        String formattedDate = new SimpleDateFormat("MM/dd/yyyy").format(dat);
        date.setText(formattedDate);

        String r = cursor.getString(cursor.getColumnIndexOrThrow("read"));
        if(r.equals("1"))
            read.setText("Odczytane");
        else read.setText("Nieodczytane");
    }
}
