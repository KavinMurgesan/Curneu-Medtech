package com.example.kavin.curneu;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class stationList extends ArrayAdapter<ticket> {


    private Activity context;
    private List<ticket> stationlist;

    public stationList(Activity context,List<ticket> stationlist){
        super(context,R.layout.listlayout,stationlist);
        this.context=context;
        this.stationlist=stationlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listviewitem=inflater.inflate(R.layout.listlayout,null,true);
        TextView textviewname = (TextView)listviewitem.findViewById(R.id.textView5);
        ticket ticket=stationlist.get(position);
        textviewname.setText(ticket.getStaName());
        return textviewname;
    }
}
