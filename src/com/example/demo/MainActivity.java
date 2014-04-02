package com.example.demo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import geo.GeoObj;
import gl.GL1Renderer;
import gl.GLFactory;
import gl.Color;
import gl.GLText;
import gl.scenegraph.Shape;
import system.ArActivity;
import system.DefaultARSetup;
import util.Vec;
import worldData.Obj;
import worldData.World;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.location.Location;
import android.os.AsyncTask;
//import android.graphics.Color;
//import android.location.Location;
//import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Config;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings.TextSize;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	//LocationManager lm;
	//Location location;
	double x;
	double y;
	
	ArrayList<Double> LatList, LonList;
	private ProgressDialog pDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button b = new Button(this);
		
		//JsonHandler handler = new JsonHandler();
		//String result = handler.readPoints();
		
		//Log.i("JSON STUFF", result);
		
		LonList = new ArrayList<Double>();
		LatList = new ArrayList<Double>();
		
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//new GetPoints().execute();
				
				//Log.i("POINTS",LonList.get(0).toString());
				
				
				// Could break if JSON not formatted
				for(Double entry: LonList){
					Log.i("POINTS", "POINTFLAG" + entry.toString());
				}
				
				ArActivity.startWithSetup(MainActivity.this, new DefaultARSetup(){
					
					
					

					@Override
					public void addObjectsTo(GL1Renderer renderer, World world,
							GLFactory objectFactory) {
												
								//GetPoints JSONRetriever = new GetPoints();
						
								
						
						
						
								ArrayList<Location> locationList = new ArrayList<Location>();
							    
								/*
							    // Locations near Robin's House
							    locationList.add(newLoc(34.725244, -82.909956));
							    locationList.add(newLoc(34.725116, -82.909876));
							    locationList.add(newLoc(34.724948, -82.909795));
							    locationList.add(newLoc(34.724997, -82.909607));
							    locationList.add(newLoc(34.72559, -82.907668));
							    
							    // McAdams
							    locationList.add(newLoc(34.6755916, -82.8346138));
							    
							    // Campus Buildings
							    
							    //Hendrix Center
							    locationList.add(newLoc(34.6760527, -82.8318250));
							    
							    //JSONObject asdf;
							    //asdf.get
							    
							    //Red Fern
							    locationList.add(newLoc(34.6757500, -82.8335805));
							    
							    // McAdams Hall
							    locationList.add(newLoc(34.6755916, -82.8346138));
							    
							    // Edwards Hall
							    locationList.add(newLoc(34.6768166, -82.8337916));
							    
							    // Vicory Hall
							    locationList.add(newLoc(34.6773750, -82.8337972));
							    
							    // Daniel Hall
							    locationList.add(newLoc(34.6771472, -82.8351611));
							    
							    // Kinard Hall
							    locationList.add(newLoc(34.6775249, -82.8351500));
							    
							    // Martin Hall
							    locationList.add(newLoc(34.6780583, -82.8355305));
							    */
							    
								Toast toast = Toast.makeText(getApplicationContext(), "LatList.size(): " + Integer.toString(LatList.size()), 10000);
						    	toast.show();
								
								for(int i = 0; i < LatList.size(); i++){
									locationList.add(newLoc(LatList.get(i), LonList.get(i)));
								}
								
							    
							    Obj x;
							    for(Location i: locationList){
							    	x = new GeoObj(i);
							    	//x.setComp(objectFactory.newCube(Color.red()));
							    	//x.setComp(objectFactory.newTextured2dShape(textAsBitmap("TEST", (float)18.0, Color.red().toIntRGB()), "TESTBITMAP"));
							    	
							    	String text = "Hello world!";
							    	Bitmap b = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
							    	Canvas c = new Canvas(b);
							    	c.drawBitmap(b, 0, 0, null);
							    	c.drawColor(Color.white().toIntRGB());
							    	
							    	TextPaint textPaint = new TextPaint();
							    	textPaint.setAntiAlias(true);
							    	textPaint.setTextSize(128.0F);
							    	StaticLayout sl= new StaticLayout(text, textPaint, b.getWidth()-8, Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
							    	c.translate(6, 40);
							    	sl.draw(c);
							    	
							    	
							    	x.setComp(objectFactory.newTexturedSquare("HelloBitMap", b, 10));
							    	
							    	world.add(x);
							    }
							    
							   
					}

					Location newLoc(double one, double two){
						Location newLocation = new Location("addLoc()");
						newLocation.setLatitude(one);
						newLocation.setLongitude(two);
						return newLocation;
						
					}
					
					public Bitmap textAsBitmap(String text, float textSize, int textColor) {
					    Paint paint = new Paint();
					    //paint.setTextSize
					    paint.setTextSize(textSize);
					    paint.setColor(textColor);
					    paint.setTextAlign(Paint.Align.LEFT);
					    int width = (int) (paint.measureText(text) + 0.5f); // round
					    float baseline = (int) (-paint.ascent() + 0.5f); // ascent() is negative
					    int height = (int) (baseline + paint.descent() + 0.5f);
					    Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
					    Canvas canvas = new Canvas(image);
					    canvas.drawText(text, 0, baseline, paint);
					    return image;
					}
					
					
				});
				
			}
			
		});
		setContentView(b);
		
		new GetPoints().execute();
		for(Double entry: LonList){
			Log.i("POINTS", "POINTFLAG" + entry.toString());
		}
	}
	
	
	//JSON **MIGHT NOT WORK**
	private static String pt_url="http://people.clemson.edu/~myankou/php/EyeApp/points.php";
	private static final String TAG_NAME = "Name";
	//add tags for latitude and longitude and campus ID
	ArrayList<String> PList;
	//ArrayList<Double> LatList, LonList;
	//I guess use separate lists for each set of variables since the one implemented here only retreives names

	//This is the ASYNCTASK to be implemented in the activity
				private class GetPoints extends AsyncTask<Void, Void, Void>{
					//ProgressDialog pDialog;
					@Override
			        protected void onPreExecute() {
			            super.onPreExecute();
			            pDialog = new ProgressDialog(getApplicationContext());
			            pDialog.setMessage("Retreiving points...");
			            pDialog.setCancelable(false);
			            pDialog.show();
			 
			        }
					
					@Override
					protected Void doInBackground(Void... arg0){
						ServiceHandler sh = new ServiceHandler();
						 
			            // Making a request to url and getting response
			            String ptStr = sh.makeServiceCall(pt_url, ServiceHandler.GET);
			 
			            Log.d("Response: ", "> " + ptStr);
			 
			            if (ptStr != null) {
			                try {
			                    JSONArray jsonObj = new JSONArray(ptStr);
			                    PList = new ArrayList<String>();
			                    PList.add("");
			                    
			                    LatList = new ArrayList<Double>();
			                    LonList = new ArrayList<Double>();
			                    
								//add 3 more for loops for each set of variables
			                    for (int i = 0; i < jsonObj.length(); i++) {
			                        JSONObject c = jsonObj.getJSONObject(i);
			                		PList.add(c.getString(TAG_NAME));
			                		LatList.add(c.getDouble("gps_lat"));
			                		LonList.add(c.getDouble("gps_lon"));
			                    }
			                   // for (int i = 0; i < json)
			                    
			                } catch (JSONException e) {
			                    e.printStackTrace();
			                }
			            } else {
			                Log.e("ServiceHandler", "Couldn't get any data from the url");
			            }
			 
			            return null;
					}
					
					@Override
					protected void onPostExecute(Void result){
						super.onPostExecute(result);
			            // Dismiss the progress dialog
			            if (pDialog.isShowing())
			                pDialog.dismiss();
			            /**
			             * Updating parsed JSON data into ListView
			             * */

						//for(String entry: PList){
						//	Log.i("GETPOINTS", entry);	
						//	}
						
						/* Adapters are updated here, so change this to fit whatever we use in UI
						stAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, FList);
			        	festAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						inputFest.setAdapter(festAdapter);
						*/
			        	
					}
				}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}