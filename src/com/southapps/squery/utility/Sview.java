package com.southapps.squery.utility;

import android.view.View;

public class Sview {
	
	public String name;
	public int id;
	public Class type;
	public View v;
	
	public Sview(String name, int id) {
		this.name = name;
		this.id = id;
		
	}
	
	public Sview(View v, Class type) {
		this.v = v;
		this.type = type;	
	}
	

	public String toString(){
		return "name:" + name + ", id:"+ id;
	}
	
	public String toString2(){
		return "type:" + type.getSimpleName();
	}
}
