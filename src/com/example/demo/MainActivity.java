package com.example.demo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
//import android.graphics.Color;
//import android.location.Location;
//import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
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

public class MainActivity extends Activity {
	//LocationManager lm;
	//Location location;
	double x;
	double y;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button b = new Button(this);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ArActivity.startWithSetup(MainActivity.this, new DefaultARSetup(){
					
					//JsonHandler handler = new JsonHandler();

					@Override
					public void addObjectsTo(GL1Renderer renderer, World world,
							GLFactory objectFactory) {
												
								ArrayList<Location> locationList = new ArrayList<Location>();
							    
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}