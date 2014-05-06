package com.example.demo;
//
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import com.example.demo.MainActivity.GetPoints;
import com.example.demo.SimpleGestureFilter.SimpleGestureListener;

import android.os.AsyncTask;
import android.os.Bundle;
//import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;
import android.support.v4.app.NavUtils;

public class TakeMeThere extends Activity implements SimpleGestureListener {

	ViewAnimator viewAnimator;
	
	
	Animation inAnimPast;// = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
    Animation outAnimPast;// = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
	
    Animation inAnimFuture;// = AnimationUtils.loadAnimation(this,(R.anim.slide_in_right));
    Animation outAnimFuture;// = AnimationUtils.loadAnimation(this,(R.anim.slide_out_left));
	
	
	/*
	WebView webview;
	WebView webview_next = ;
	*/
	
	//WebView webview = (WebView) findViewById(R.id.webview);	
	//WebView webview_next = (WebView) findViewById(R.id.webview_next);
	
	String TAG_URL = "url";
	String TAG_PRES = "p_flag";
	
	boolean on_wv_1;
	
	ArrayList<String> AfList;
	int presentIndex, currentUrlIndex, poiId;
	ProgressDialog pDialog;
	String af_url = "http://miyanki.com/EyeApp/php/artifacts.php?poi=";
	
	//ArrayList<String> URLS;
	String URLS[] = {"www.google.com","www.wikipedia.org","www.clemson.edu"};
	
	private SimpleGestureFilter detector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_me_there);
		presentIndex = 0;
		//URLS = new ArrayList<String>();
		//URLS.add("www.google.com");
		//URLS.add("www.wikipedia.org");
		//URLS.add("www.clemson.edu");
		on_wv_1 = true;
		
		//String[] URLS = {"www.google.com","www.wikipedia.org","www.clemson.edu"};
		
		viewAnimator = (ViewAnimator) findViewById(R.id.viewAnimator);
		
		
		inAnimPast = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
	    outAnimPast = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
		
	    inAnimFuture = AnimationUtils.loadAnimation(this,(R.anim.slide_in_right));
	    outAnimFuture = AnimationUtils.loadAnimation(this,(R.anim.slide_out_left));
		
	    
	    viewAnimator.setInAnimation(inAnimPast);
	    viewAnimator.setOutAnimation(outAnimPast);
	      
	     viewAnimator.setOnClickListener(new View.OnClickListener() {
	      public void onClick(View v) {
	       viewAnimator.showNext();
	      }
	     });
	    
		detector = new SimpleGestureFilter(this,this);
		
		// Show the Up button in the action bar.
		Intent intent = getIntent();
		//String name = intent.getStringExtra("SENT_NAME");
		poiId = intent.getIntExtra("SENT_ID", 999);
		
		//TextView textView = new TextView(this);
		//textView.setTextSize(40);
		//textView.setText(name);
		//setContentView(textView);
		
		//WebView webview = new WebView(this);
		
		
		
		try {
			new GetUrls().execute().get((long)10.0, TimeUnit.SECONDS);
			//wait(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String entry: AfList){
			Log.d("URLS", "URL: " + entry);
		}
		
		
		
		currentUrlIndex = presentIndex;
		
		WebView webview_1 = (WebView) findViewById(R.id.webview);
		webview_1.loadUrl(AfList.get(currentUrlIndex));
		
		WebView webview_2 = (WebView) findViewById(R.id.webview_next);
		webview_2.loadUrl("www.google.com");
		
		Toast.makeText(this, "Swipe left or right to view past and future information", Toast.LENGTH_LONG).show();
		
		
		//webview.loadUrl(name);
		//webview_next.loadUrl(name);
		//webview.setLayoutParams(LayoutParams);
		//webview.zoomOut();
		//webview.zoomOut();
		
		//setContentView(webview);
		
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.take_me_there, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public boolean dispatchTouchEvent(MotionEvent me){
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}
	int arrayindex = 1;
	@Override
	public void onSwipe(int direction) {
		
		WebView webview_1 = (WebView) findViewById(R.id.webview);
		//webview.loadUrl(name);
		
		WebView webview_2 = (WebView) findViewById(R.id.webview_next);
		//webview_next.loadUrl(name);
		
		
		
		String str = "";
		
		switch (direction){
		// MOVE BACK IN TIME
		case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
			// If there are more 'past' artifacts
			if(currentUrlIndex > 0){
				currentUrlIndex --;
				if(on_wv_1){
					webview_2.loadUrl(AfList.get(currentUrlIndex));
					on_wv_1 = false;
				}
				else{
					webview_1.loadUrl(AfList.get(currentUrlIndex));
					on_wv_1 = true;
				}
				viewAnimator.setInAnimation(inAnimPast);
				viewAnimator.setOutAnimation(outAnimPast);
				viewAnimator.showPrevious();
			}
			else {Toast.makeText(this, "You have reached the beginning of time.", Toast.LENGTH_SHORT).show();}
        	break;
        
        // MOVE FORWARD IN TIME
		case SimpleGestureFilter.SWIPE_LEFT :  str = "Swipe Left";
			
			// If there are more 'future' artifacts
			if(currentUrlIndex < AfList.size() - 1){
				currentUrlIndex ++;
				
				if(on_wv_1){
					webview_2.loadUrl(AfList.get(currentUrlIndex));
					on_wv_1 = false;
				}
				else{
					webview_1.loadUrl(AfList.get(currentUrlIndex));
					on_wv_1 = true;
				}
				viewAnimator.setInAnimation(inAnimFuture);
			    viewAnimator.setOutAnimation(outAnimFuture);
			      
				viewAnimator.showPrevious();
			}
			else{Toast.makeText(this, "You have reached the end of time.", Toast.LENGTH_SHORT).show();}
		//
            break;
		case SimpleGestureFilter.SWIPE_DOWN :  str = "Swipe Down";
            break;
		case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
            break;
		}
		
		//webview_next.loadUrl("www.google.com");
		
		//viewAnimator.showPrevious();
		
	//TextView theText = (TextView)findViewById(R.id.takemetext);
	//theText.setText(str);
	//Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDoubleTap() {
		//Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
	}

	
	private class GetUrls extends AsyncTask<Void, Void, Void>{
		//ProgressDialog pDialog;
		@Override
        protected void onPreExecute() {
            super.onPreExecute();
            //pDialog = new ProgressDialog(MainActivity.this);
            pDialog = new ProgressDialog(TakeMeThere.this);
            
            pDialog.setMessage("Retreiving points...");
            pDialog.setCancelable(false);
            pDialog.show();
 
        }
		
		@Override
		protected Void doInBackground(Void... arg0){
			//ServiceHandler sh = new ServiceHandler(MainActivity.this);
			ServiceHandler sh = new ServiceHandler(TakeMeThere.this);
				 
            // Making a request to url and getting response
            //String ptStr = sh.makeServiceCall(pt_url, ServiceHandler.GET);
            String afStr = sh.makeServiceCall(af_url + Integer.toString(poiId), ServiceHandler.GET);
            Log.d("URLcalled ", af_url + Integer.toString(poiId));
            Log.d("Response: ", "> " + afStr);
 
            if (afStr != null) {
                try {
                	JSONArray afJsonObj = new JSONArray(afStr);
                    //JSONArray jsonObj = new JSONArray(ptStr);
                    //PList = new ArrayList<String>();
                    //PList.add("TEST");
                    AfList = new ArrayList<String>();
                    
                    //LatList = new ArrayList<Double>();
                    //LonList = new ArrayList<Double>();
                  
                    Log.d("jsonObj.length()", Integer.toString(afJsonObj.length()));
                    
                    String urlToAdd = "";
                    
                    for(int i = 0; i < afJsonObj.length(); i++){
                    	JSONObject c = afJsonObj.getJSONObject(i);
                    	urlToAdd = c.getString(TAG_URL);
                    	//find ispresent
                    	if(c.getString(TAG_PRES).equals("1")){
                    		presentIndex = i;
                    	}
                    	AfList.add(urlToAdd);
                    }
					
					
                    //String strToAdd = "";
					//add 3 more for loops for each set of variables
                    //for (int i = 0; i < jsonObj.length(); i++) {
                        //JSONObject c = jsonObj.getJSONObject(i);
                        //strToAdd = c.getString(TAG_NAME);
                        //Log.d("strToAdd", "JSONSTRING: " + strToAdd);
                		//PList.add(strToAdd);
                		//LatList.add(c.getDouble("gps_lat"));
                		//LonList.add(c.getDouble("gps_lon"));
                    //}
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
 
            return null;
		}
		
		protected void onPostExecute(Void result){
			super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();   	
		}
	}
}
