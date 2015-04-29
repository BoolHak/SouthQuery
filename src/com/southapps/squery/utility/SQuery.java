package com.southapps.squery.utility;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SQuery {
	
	private static Activity activity;
	
	public SQuery(Activity activity){
		
		this.activity = activity;
		
	}
	
	public static <T> T  get(int id){
		
		return (T) activity.findViewById(id);
		
	}
	
	public static <T> T click(T t,String text){
		View v = (View) t;
		final String txt = text;
		v.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {			
				Toast toast = Toast.makeText(activity.getApplicationContext(), txt, Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		return (T) v;
		
	}
	
	


}
