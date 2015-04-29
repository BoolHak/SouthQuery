package com.southapps.squery.testmodels;

import java.io.Serializable;

public class Test implements Serializable{
	
	public String name;
	public String value;
	public String image;
	public String Description;
	
	public Test(String name,String value,String image,String Description){
		
		this.name =name;
		this.value =value;
		this.image =image;
		this.Description = Description;
		
	}
}
