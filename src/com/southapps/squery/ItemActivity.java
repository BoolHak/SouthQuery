package com.southapps.squery;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.southapps.squery.testmodels.Test;
import com.southapps.squery.utility.S;

public class ItemActivity extends Activity {

	S sq = new S(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item);
		sq.setUpViews();
		Test model = (Test) sq.model;
		sq.get("txt1").text("sq.setUpViews();").bg(Color.WHITE).color(Color.BLACK);
	}
}