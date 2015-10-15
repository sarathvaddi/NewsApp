package com.example.sarathreddyvaddhi.newsapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sarathreddyvaddhi on 8/19/15.
 */
public class  JParser {
    private static final String TAG_results = "results";
    private static final String TAG_section = "section";
    private static final String TAG_subsection = "subsection";
    private static final String TAG_title = "title";
    private static final String TAG_abst = "abstract";
    private static final String TAG_url = "url";
    ArrayList<GetResultsSet> feeds = new ArrayList<GetResultsSet>();
    GetResultsSet resultObject;


    public ArrayList JsonParser(String response) throws JSONException {

        Log.i("TAG","Entered into parser");


        JSONArray results;
        JSONObject res = new JSONObject(response);

        results = res.getJSONArray(TAG_results);

        try {
            for (int i = 0; i <= results.length(); i++)
            {
                JSONObject r = results.getJSONObject(i);

                String section = r.getString(TAG_section);
                String subsection = r.getString(TAG_subsection);
                String title = r.getString(TAG_title);
                String abst = r.getString(TAG_abst).toString();
                String url = r.getString(TAG_url);


                Log.i("TAG",""+section+""+subsection+""+title+""+r.getString(TAG_section));
                resultObject = new GetResultsSet();
                resultObject.setSection(section);
                resultObject.setSubsection(subsection);
                resultObject.setTitle(title);
                resultObject.setUrl(url);
                resultObject.setAbst(abst);


                Log.i("TAG", " " + resultObject.getTitle().toString() + "& " + resultObject.getSection().toString());

// try {
                    feeds.add(resultObject);


//
//                } catch (Exception e) {
//
//                }


            }
            Log.i("TAG",""+feeds.size());
        }
        catch (Exception e){

        }
        return feeds;
    }


}
