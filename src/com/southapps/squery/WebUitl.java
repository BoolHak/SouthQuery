package com.southapps.squery;

import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.southapps.squery.utility.S;

public class WebUitl extends Activity {

	S sq = new S(this);
	String s;
	final String url = "http://api.androidhive.info/contacts/";
	final String downloadUrl ="http://speedtest.reliableservers.com/10MBtest.bin";
	HttpResponse response;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		
		sq.get("btn1").click("fun1");
		sq.get("txt1").text("sq.browser(\"google.com\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn2").click("fun2");
		sq.get("txt2").text("sq.thread(\"after\", \"background\");\n"
				+ "public void background(){s = sq.httpGet(url);}\n"
				+ "public void after(){ sq.alert(s);}").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn3").click("fun3");
		sq.get("txt3").text("response = sq.post(url,l);").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn4").click("fun4");
		sq.get("txt4").text("sq.download(downloadUrl);").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn5").click("fun5");
		sq.get("txt5").text("sq.downloadNative(downloadUrl);").color(Color.BLACK).bg(Color.WHITE);
		
	}
	
	public void fun1(){
		sq.browser("google.com");
	}
	
	public void fun2(){
		sq.thread("after", "background");
	}
	
	public void fun3(){
		
		sq.thread("after1", "background1");
		
	}
	
	public void fun4(){
		
		sq.download(downloadUrl);
		
	}
	
	public void fun5(){
		
		sq.downloadNative(downloadUrl);
		
	}
	
	public void background1(){
		
		List<NameValuePair> l = new LinkedList<NameValuePair>();
		l.add(new BasicNameValuePair("id", "12345"));
		response = sq.post(url,l);
		
	}
	
	public void after1(){
		
		sq.alert("response code: " + response.getStatusLine().getStatusCode());
	}
	
	public void background(){
		
		s = sq.httpGet(url);
		
	}
	
	public void after(){
		sq.alert(s);
	}

	
}