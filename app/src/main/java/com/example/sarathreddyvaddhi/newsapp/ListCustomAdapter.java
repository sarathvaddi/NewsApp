package com.example.sarathreddyvaddhi.newsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sarathreddyvaddhi on 8/24/15.
 */
public class ListCustomAdapter extends BaseAdapter {

    public Context actx;
    public ArrayList<GetResultsSet> afeed;
    TextView Title;
    TextView Abst;

    public ListCustomAdapter(Context ctx,ArrayList<GetResultsSet> feed) {
        this.afeed = feed;
        this.actx = ctx;
        Log.i("TAG","Adapter");
    }



    @Override
    public int getCount() {
        return afeed.size();
    }

    @Override
    public Object getItem(int position) {

        return afeed.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("TAG","Entered into getview in adapter");
        View v ;

        if (convertView == null) {

            v= new View(actx);
        }
        else
            v=(View)convertView;

            LayoutInflater inflater = (LayoutInflater) actx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             v = inflater.inflate(R.layout.custom_row, parent,false);
             Title = (TextView)v.findViewById(R.id.title);
             Abst=(TextView)v.findViewById(R.id.abst);


        Title.setText(afeed.get(position).getTitle().toString());
        Abst.setText(afeed.get(position).getSection().toString());

        Log.i("title :", afeed.get(position).getTitle());
        Log.i("Section: ",afeed.get(position).getSection());
        return v;
    }


}
