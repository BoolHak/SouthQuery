package com.southapps.squery;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.southapps.squery.testmodels.Test;
import com.southapps.squery.utility.S;

public class ListExample extends Activity {

	S sq = new S(this);

	final String urlimg ="https://scontent-mrs.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/11178258_1581030745488776_4057396672364221359_n.jpg?oh=3cde07b797a38a0a1fbac39e4823f98e&oe=55CCED90";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		sq.get("txt1").text("Generic List view\n sq.get(\"lv1\").list(\"row_layout\",listObj,\"ItemActivity\");").bg(Color.WHITE).color(Color.BLACK);
		
		LinkedList<Test> listObj = new LinkedList<Test>();
		for (int i = 1; i < 501; i++) {	
			listObj.add(new Test("name "+i,"value "+i,"icon","balaballalaallablalallalabalalalalabala"));
		}
		
		sq.get("lv1").list("row_layout",listObj,"ItemActivity");
		
		
	}
	

}