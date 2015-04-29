package com.southapps.squery.utility;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sq {
	
	TextView tv = null;
	EditText et = null;
	Button bt =null;
	Activity activity = null;
	
	public Sq(Activity activity){
		this.activity = activity;
	}
	
	public Sq get(int id){
		View v = (TextView) activity.findViewById(id);
		
		if(v instanceof TextView)
		tv = (TextView) v;
		if(v instanceof EditText)
		et = (EditText) v;
		if(v instanceof Button)
		bt = (Button) v;
		return this;
	}
	
	public Sq text(String text){
		if(tv != null)
		tv.setText(text);
		if(et != null)
		et.setText(text);
		if(bt != null)
		bt.setText(text);
		return this;
	}
	
	public Sq color(int color){
		if(tv != null)
		tv.setTextColor(color);
		if(et != null)
		et.setTextColor(color);
		if(bt != null)
		bt.setTextColor(color);
		return this;
	}
	
	public Sq bg(int color){
		if(tv != null)
		tv.setBackgroundColor(color);
		if(et != null)
		et.setBackgroundColor(color);
		if(bt != null)
		bt.setBackgroundColor(color);
		return this;
	}
	
	public Sq click(View.OnClickListener listener){
		tv.setOnClickListener(listener);
		return this;
	}
	
	public Sq click(Sq s){	
		return s;
	}
	
	public Sq toast(String text){
		Toast t = Toast.makeText(activity, text, Toast.LENGTH_SHORT);
		t.show();
		return this;
	}

	public void click(Function function) {
		
		
	}
	
	
	
	

}
