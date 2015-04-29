package com.southapps.squery;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.southapps.squery.utility.S;

public class OtherActivity extends Activity{

	S sq = new S(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		
		sq.get("txt0").text("Events in SQuery").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn1").on("touchdown","fun1");
		sq.get("txt1").text("sq.get(\"btn1\").on(\"touchdown\",\"fun1\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn2").on("touchup","fun2");
		sq.get("txt2").text("sq.get(\"btn2\").on(\"touchup\",\"fun2\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn3").text("Move").on("move","fun3");
		sq.get("txt3").text("sq.get(\"btn3\").on(\"move\",\"fun3\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn4").on("longclick","fun4");
		sq.get("txt4").text("sq.get(\"btn4\").on(\"longclick\",\"fun4\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn5").on("click","fun5");
		sq.get("txt5").text("sq.get(\"btn5\").on(\"click\",\"fun5\");").color(Color.BLACK).bg(Color.WHITE);
		
	}
	
	public void fun1(){
		sq.toast("touch down");
	}
	
	public void fun2(){
		sq.toast("touch up");
	}
	
	public void fun3(){
		sq.toast("moving");
	}
	
	public void fun4(){
		sq.toast("longclick");
	}
	
	public void fun5(){
		sq.toast("click");
	}

	
}
