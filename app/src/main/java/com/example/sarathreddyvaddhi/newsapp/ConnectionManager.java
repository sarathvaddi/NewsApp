package com.example.sarathreddyvaddhi.newsapp;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by sarathreddyvaddhi on 8/19/15.
 */
public class ConnectionManager  {

    DefaultHttpClient dhc = new DefaultHttpClient();
    HttpGet hg;


    public String GetValues() throws IOException {

        Log.i("TAG","Entered Connection Manager");

        hg = new HttpGet("http://api.nytimes.com/svc/topstories/v1/home.json?api-key=15629235341919a7b4b8b6e9344f9bca:6:72095783");
        HttpResponse response = dhc.execute(hg);
        HttpEntity entity= response.getEntity();
        InputStream is= entity.getContent();
        String resp = byteResponse(is);
//        String respfinal = convertStandardJSONString(resp);
        return resp;
    }

    private String ConvertToString(InputStream is){

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();

    }

    private String byteResponse(InputStream is) {
//        String byteString = "";
//        byte[] b = new byte[1024];
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try {
//            while ( is.read(b) != -1)
//            baos.write(b);
//            byteString = new String(baos.toByteArray());
//
//            return byteString;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return byteString;


        // json is UTF-8 by default
        InputStream inputStream = is;
        String result = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            result = sb.toString();
            return result;
        } catch (Exception e) {
            // handling
        } finally

        {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception exc) {
            }

        }
        return result;
    }

//    public String convertStandardJSONString(String data_json){
//        data_json = data_json.replace("\\", "");
//        data_json = data_json.replace("\"{", "{");
//        data_json = data_json.replace("}\",", "},");
//        data_json = data_json.replace("}\"", "}");
//        return data_json;
//    }
}
