package com.example.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import commands.Command;

public class CommandTakeMeNow extends Command {

	//private String myTextToDisplay;
	private Context myContext;
	private String myName;

	private LinearLayout myLinLayout;
	private EditText myEditText;

	public CommandTakeMeNow(Context c , String n) {
		//myTextToDisplay = textToDisplay;
		myContext = c;
		myName = n;
	}

	@Override
	public boolean execute() {

		Intent intent = new Intent(myContext, TakeMeThere.class );
		//String message = "TEST MESSAGE";
		intent.putExtra("SENT_NAME", myName);
		//myContext.startActivity(intent);
		myContext.startActivity(intent);
		/*
		new Handler(Looper.getMainLooper()).post(new Runnable() {
			@Override
			public void run() {
				//Toast.makeText(myContext  , myTextToDisplay, Toast.LENGTH_LONG)
				//		.show();
			}
		});
		*/
		return true;
	}

	@Override
	public boolean execute(Object transfairObject) {

		if (transfairObject == myLinLayout) {
		//	final String s = myEditText.getText().toString();

			new Handler(Looper.getMainLooper()).post(new Runnable() {
				@Override
				public void run() {
	//				Toast.makeText(myLinLayout.getContext(), s,
	//						Toast.LENGTH_LONG).show();
				}
			});
			return true;
		}

		return execute();
	}

	@Override
	public View getMyListItemView(View viewToUseIfNotNull, ViewGroup parentView) {
		myLinLayout = new LinearLayout(parentView.getContext());
		myLinLayout.setFocusable(false);
		myLinLayout.setOrientation(LinearLayout.VERTICAL);

		TextView t = new TextView(parentView.getContext());
		t.setText("Show Toast:");
		t.setTextSize(25);
		t.setFocusable(false);
		myLinLayout.addView(t);

		myEditText = new EditText(parentView.getContext());
		myLinLayout.addView(myEditText);

		final Button b = new Button(parentView.getContext());
		b.setText("Lock Input");
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				myEditText.setFocusable(!myEditText.isFocusable());
				b.setFocusable(false);
				b.setVisibility(View.GONE);
				myEditText.setEnabled(false);
			}
		});

		myLinLayout.addView(b);

		return myLinLayout;
	}

	/**
	 * Only a wrapper method to make life easier ;)
	 * 
	 * @param myTargetActivity
	 * @param text
	 */
	public static void show(Activity myTargetActivity, String text) {
		//new CommandShowToast(myTargetActivity, text).execute();
	}
}

