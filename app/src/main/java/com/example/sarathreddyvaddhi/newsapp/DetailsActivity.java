package com.example.sarathreddyvaddhi.newsapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sarathreddyvaddhi on 10/8/15.
 */
public class DetailsActivity extends ActionBarActivity {

    TextView title,abst;
    int position;
     ArrayList<GetResultsSet> feeds= new ArrayList<GetResultsSet>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_news);
        title=(TextView)findViewById(R.id.title);
        abst=(TextView)findViewById(R.id.abst);

        Bundle b = getIntent().getExtras();
        feeds = (ArrayList<GetResultsSet>)b.getSerializable("News");
        position=b.getInt("position");

        title.setText(feeds.get(position).getTitle().toString());
        abst.setText(feeds.get(position).getAbst().toString());


    }
}
