package com.example.demo;


import java.util.ArrayList;

import geo.GeoObj;
import gl.GL1Renderer;
import gl.GLFactory;
import gl.Color;

import system.ArActivity;
import system.DefaultARSetup;
import util.Vec;
import worldData.Obj;
import worldData.World;
import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity {

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
						
							//RadioButton selectRadio = (RadioButton) findViewById(dbselectmain.getCheckedRadioButtonId());
								
								Location l = new Location("");
							    l.setLatitude(34.40394);
							    l.setLongitude(-82.50102);
							    Obj o = new GeoObj(l);
							    o.setComp(objectFactory.newCube());
							    world.add(o);
							    
							    ArrayList<Location> locationList = new ArrayList<Location>();
							        
							    //mcadams
							    l.setLatitude(34.6755916);
							    l.setLongitude(-82.8346138);
							    Obj mcadms = new GeoObj(l);
							    mcadms.setComp(objectFactory.newTextObject("McAdams", new Vec(0,0,0), getApplicationContext() , camera));
							    world.add(mcadms);
							   
							    
							    Obj x = new GeoObj();
							    for(Location i: locationList){
							    	x = new GeoObj(i);
							    	x.setComp(objectFactory.newCube(Color.red()));
							    	
							    	world.add(x);
							    }
							    
							    
							    
							   
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