package com.example.demo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		
		Button b_start = (Button)this.findViewById(R.id.main_menu_start);
		// change
		b_start.setOnClickListener(l_start);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	private OnClickListener l_start = new OnClickListener() {
	    public void onClick(View v) {
	      // do something when the button is clicked
	    	
	    	Intent myIntent = new Intent(v.getContext(), MainActivity.class);
	    	startActivity(myIntent);
	    	
	    	//Intent JSONIntent = new Intent(v.getContext(), JsonHandler.class);
	    	//startActivity(JSONIntent);
	    	
	    	
	    }
	


	};
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    Context context = getApplicationContext();
	    int duration = Toast.LENGTH_LONG;
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.internal:
	            if (checked){
	            	//internal radio button selected
			    	CharSequence text = "You selected the internal DB";
			    	Toast toast = Toast.makeText(context, text, duration);
			    	toast.show();
			    	
	            }
	        case R.id.external:
	            if (checked){
	            	//external radio button selected
	            	CharSequence text = "You selected the internal DB";
			    	Toast toast = Toast.makeText(context, text, duration);
			    	toast.show();
	            }
	    }
	}

}
