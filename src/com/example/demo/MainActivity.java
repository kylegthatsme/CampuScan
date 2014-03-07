package com.example.demo;


import gl.GL1Renderer;
import gl.GLFactory;
import system.ArActivity;
import system.DefaultARSetup;
import util.Vec;
import worldData.World;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	LocationManager lm;
	Location location;
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
								//location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
								//x = location.getLatitude();
								//y = location.getLongitude();
								//GeoObj o = new GeoObj(x,y);
								//o.setComp(objectFactory.newArrow());
								world.add(objectFactory.newSolarSystem(new Vec(-10,0,10)));
								//world.add(o);
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
