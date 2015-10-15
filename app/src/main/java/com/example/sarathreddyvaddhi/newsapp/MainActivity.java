package com.example.sarathreddyvaddhi.newsapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    ListView lv;
    ArrayList<GetResultsSet> feedsFinal;
    ListCustomAdapter lvAdapter;
    Button btn;
    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       lvAdapter = new ListCustomAdapter();

        mcontext = this;
        lv = (ListView)findViewById(R.id.listView);
        btn=(Button)findViewById(R.id.refresh);

        GetResults g = new GetResults();
        g.execute();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetResults gd = new GetResults();
                gd.execute();

            }
        });

    }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                    return true;
                }

                return super.onOptionsItemSelected(item);
            }

            protected class GetResults extends AsyncTask<Void, Void, ArrayList<GetResultsSet>> {

                @Override
                protected ArrayList<GetResultsSet> doInBackground(Void... params) {

                    Log.i("TAG","Entered into background");
                    String response = null;
                    ArrayList<GetResultsSet> feeds = null;
                    ConnectionManager CM = new ConnectionManager();
                    try {
                        response = CM.GetValues();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JParser jp = new JParser();
                    try {
                        feeds = jp.JsonParser(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return feeds;
                }

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(ArrayList<GetResultsSet> getResultsSets) {
                    Log.i("TAG","Into Post execute");
                    super.onPostExecute(getResultsSets);
                    feedsFinal = getResultsSets;
                    lvAdapter = new ListCustomAdapter(mcontext, feedsFinal);
                    lv.setAdapter(lvAdapter);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                            Bundle b = new Bundle();
                            b.putSerializable("News", feedsFinal);
                            b.putInt("position", position);
                            i.putExtras(b);
                            startActivity(i);
                        }
                    });

                }
            }
        }
