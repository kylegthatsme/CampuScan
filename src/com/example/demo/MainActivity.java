package com.example.demo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
import android.location.Location;
//import android.graphics.Color;
//import android.location.Location;
//import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
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
							    
							    
							    
							    Obj x;
							    for(Location i: locationList){
							    	x = new GeoObj(i);
							    	x.setComp(objectFactory.newCube(Color.red()));
							    	world.add(x);
							    }
							    
							   
					}

					Location newLoc(double one, double two){
						Location newLocation = new Location("addLoc()");
						newLocation.setLatitude(one);
						newLocation.setLongitude(two);
						return newLocation;
						
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