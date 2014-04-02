package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

public class JsonHandler extends Activity {
  

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	  
	    StrictMode.ThreadPolicy policy = new StrictMode.
	    ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy); 
	    
	    
	    setContentView(R.layout.mainmenu);
	    String readPoints = readPoints();
	    try {
	    	
		    JSONArray jsonArray = new JSONArray(readPoints);
		    Log.i(JsonHandler.class.getName(), "Number of entries " + jsonArray.length());
		    for (int i = 0; i < jsonArray.length(); i++) {
			    JSONObject jsonObject = jsonArray.getJSONObject(i);
			    Log.i(JsonHandler.class.getName(), jsonObject.getString("text"));
		    }
		    
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
    }

    public String readPoints() {
	    StringBuilder builder = new StringBuilder();
	    HttpClient client = new DefaultHttpClient();
	    HttpGet httpGet = new HttpGet("http://people.clemson.edu/~myankou/php/EyeApp/points.php");
	    try {
	    	
		    HttpResponse response = client.execute(httpGet);
		    StatusLine statusLine = response.getStatusLine();
		    int statusCode = statusLine.getStatusCode();
		    if (statusCode == 200) {
			    HttpEntity entity = response.getEntity();
			    InputStream content = entity.getContent();
			    BufferedReader reader = new BufferedReader(new InputStreamReader(content));
			    String line;
			    while ((line = reader.readLine()) != null) {
			    	builder.append(line);
			    }
			    
		    } else {
		    	Log.e(JsonHandler.class.toString(), "Failed to download file");
		    }
	    } catch (ClientProtocolException e) {
	    e.printStackTrace();
	    } catch (IOException e) {
	    e.printStackTrace();
	    }
	    Log.i("Json","Json retrieved from site:"+builder.toString());
	    return builder.toString();
    }
    
    
}