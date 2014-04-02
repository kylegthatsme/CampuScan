package com.example.demo;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;




//This is the ASYNCTASK to be implemented in the activity
class GetPoints extends AsyncTask<Void, Void, Void>{
	
	private static String pt_url="http://people.clemson.edu/~myankou/php/EyeApp/points.php";
	private static final String TAG_NAME = "Name";
	//add tags for latitude and longitude and campus ID
	ArrayList<String> PList;
	//I guess use separate lists for each set of variables since the one implemented here only retreives names
	
	
	@Override
    protected void onPreExecute() {
        super.onPreExecute();
       //ProgressDialog pDialog = new ProgressDialog();
        //pDialog.setMessage("Retreiving points...");
        //pDialog.setCancelable(false);
        //pDialog.show();

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
                ArrayList<String> PList = new ArrayList<String>();
                PList.add("");
                
				//add 3 more for loops for each set of variables
                for (int i = 0; i < jsonObj.length(); i++) {
                    JSONObject c = jsonObj.getJSONObject(i);
                    // RNOVAK EDIT: changed "FList" to "PList"
            		PList.add(c.getString(TAG_NAME));
                }
                
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
   
		//if (pDialog.isShowing())
        //    pDialog.dismiss();
        
		for(String entry: PList){
		Log.i("GETPOINTS", entry);	
		}
		
		
		/**
         * Updating parsed JSON data into ListView
         * */

		/* Adapters are updated here, so change this to fit whatever we use in UI
		stAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, FList);
    	festAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		inputFest.setAdapter(festAdapter);
		*/
    	
	}
}