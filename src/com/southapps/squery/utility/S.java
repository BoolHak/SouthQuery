package com.southapps.squery.utility;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.impl.client.DefaultHttpClient;











import com.southapps.squery.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.os.Vibrator;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class S<T> {

	public T t;
	Activity activity;
	private ProgressDialog pDialog;
	private ProgressDialog mProgressDialog;
	public static final String PREFS_NAME = "MyPrefsFile";
	int w,h;
	LinkedList<Sview> l,lv;
	public Object model;
	
	public enum Method {POST,GET};
	
	
	  /**
	   * Contractor:  Setting up the SouthQuerry class
	   * 
	   * @param the current activity 
	   */
	public S(Activity activity){
		this.activity = activity;
		
	}
	
	
	

	  /**
	   * Gets the view by its id 
	   * 
	   * @param Id of the view
	   * @return S<T>
	   */
	@SuppressWarnings("unchecked")
	public S<T> get(String id){
		id =id.trim();
		
		if(id.contains("*")){
			if(l==null)
			l = (LinkedList<Sview>) getTableId();
			
			String sufix = getSufix(id);
			LinkedList<View> lv = new LinkedList<View>();
			for (Sview v : l) {
				if(v.name.startsWith(sufix)){
					View vi = activity.findViewById(v.id);
					if(vi!=null)
					lv.add(vi);
				}
			}
			
			if(lv.size()!=0){
				t = (T) lv;
			}
			
			return this;
		}
		if(id.equals("TextView")){		
			getViewByType("TextView");
			return this;
		}
		
		if(id.equals("Button")){
			getViewByType("Button");
			return this;
		}
		if(id.equals("ImageView")){
			getViewByType("ImageView");
			return this;
		}
		if(id.equals("EditText")){
			getViewByType("EditText");
			return this;
		}
		if(id.equals("CheckBox)")){
			getViewByType("CheckBox");
			return this;
		}
		if(id.equals("ImageButton)")){
			getViewByType("ImageButton");
			return this;
		}
		
		if(id.equals("RadioButton)")){
			getViewByType("RadioButton");
			return this;
		}
		
		
			t = (T) activity.findViewById(getId(id));

		return this;
	}
	
	  /**
	   * Gets the view by its id 
	   * 
	   * @param Id of the view (R.id.id)
	   * @return S<T>
	   */
	@SuppressWarnings("unchecked")
	public S<T> get(int id){
		t = (T) activity.findViewById(id);
		return this;
	}
	
	  /**
	   * Gets the view by its id from a View 
	   * 
	   * @param Id of the view
	   * @param Id of the view
	   * @return S<T>
	   */
	@SuppressWarnings("unchecked")
	public  S<T> get(View view,String id) {
		id =id.trim();
		t = (T) view.findViewById(getId(id));
		return this;
	}

	  /**
	   * Gets the view by its id from a View 
	   * 
	   * @param Id of the view
	   * @param  the view
	   * @return S<T>
	   */
	@SuppressWarnings("unchecked")
	public  S<T> get(View view,int id) {
		
		t = (T) view.findViewById(id);
		return this;
	}
	  /**
	   *  Gets the view by its id from a View 
	   * 
	   * @param Id of the view
	   * @return View
	   */
	@SuppressWarnings("unchecked")
	public  View getView(String id) {
		id =id.trim();
		t = (T) activity.findViewById(getId(id));
		return (View)t;
	}
	/**
	 * Gets the id as an int by its id from a View
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public  View getView(int id) {
		
		t = (T) activity.findViewById(id);
		return (View)t;
	}
	
	  /**
	   * Gets the id as an int by its id from a View 
	   * 
	   * @param Id of the view
	   * @return int
	   */
	public int getId(String id){
		Resources res = activity.getResources();
		int theid = res.getIdentifier(id, "id", activity.getPackageName());
		return theid;
	}
	
	public int getIdD(String id){
		int theid =  activity.getResources().getIdentifier(
				id, "drawable", activity.getApplicationContext().getPackageName());
		return theid;
	}
	
	  /**
	   * Sets the image to an ImageView or ImageButton from the drawable
	   * 
	   * @param  name of the drawable
	   * @return S<T>
	   */
	public S<T> image(String name){
		name = name.trim();
		Boolean b = false;
		
		int theid =  activity.getResources().getIdentifier(
				name, "drawable", activity.getApplicationContext().getPackageName());
		
		try {
			if(t instanceof ImageView)
			{
				java.net.URL url = new URL(name);

	        }
			
		} catch (MalformedURLException  e) {
			b = true;
		}
		
		if(b){
			

			
			if(t instanceof ImageView){
				((ImageView)t).setImageResource(theid);
			}
			if(t instanceof ImageButton){
				((ImageButton)t).setImageResource(theid);
			}
			if(t instanceof LinkedList){
				LinkedList<View> auxl = (LinkedList<View>)t;
				for (View v : auxl) {
					t= (T) v;
					image(name);
				}
				
				t= (T) auxl;
			}
		}else{
	         
	        // Imageview to show
	         int loader = R.drawable.ic_launcher;
	        // ImageLoader class instance
	        ImageLoader imgLoader = new ImageLoader(activity.getApplicationContext(),loader);
	        // whenever you want to load an image from url
	        // call DisplayImage function
	        // url - image url to load
	        // loader - loader image, will be displayed before getting image
	        // image - ImageView 
	        imgLoader.DisplayImage(name, loader, (ImageView)t);
		}
		return this;
	}
	
	  /**
	   * Sets the background color of a view
	   * 
	   * @param  Color
	   * @return S<T>
	   */
	public S<T> bg(int color){
		
		
		if(t instanceof TextView){
			((TextView)t).setBackgroundColor(color);return this;
		}
		if(t instanceof Button){
			((Button)t).setBackgroundColor(color);return this;
		}	
		if(t instanceof EditText){
			((EditText)t).setBackgroundColor(color);return this;
		}
		if(t instanceof CheckBox)
		{
			((CheckBox)t).setBackgroundColor(color);return this;
		}
		if(t instanceof RadioButton)
		{
			((RadioButton)t).setBackgroundColor(color);return this;
		}
		if(t instanceof View)
		{
			((View)t).setBackgroundColor(color);
		}
		if(t instanceof LinkedList){
			LinkedList<View> auxl = (LinkedList<View>)t;
			for (View v : auxl) {
				t= (T) v;
				bg(color);
			}
			
			t= (T) auxl;
		}
		return this;
	}
	
	  /**
	   * Sets the background color of a view
	   * 
	   * @param  Color as a String example #ff0000
	   * @return S<T>
	   */
	
	public S<T> bg(String color){
		
		try{
			int c = Color.parseColor(color);
			bg(c);
		}catch(IllegalArgumentException ex){
			ex.printStackTrace();
		}
		
		return this;
	}
	
	  /**
	   * Sets the text 
	   * 
	   * @param  text
	   * @return S<T>
	   */
	@SuppressWarnings("unchecked")
	public S<T> text(String text){
		
		
		if(t instanceof TextView){
			((TextView)t).setText(text);
		}
		if(t instanceof Button){
			((Button)t).setText(text);
		}	
		if(t instanceof EditText){
			((EditText)t).setText(text);
		}
		if(t instanceof CheckBox)
		{
			((CheckBox)t).setText(text);
		}
		if(t instanceof RadioButton)
		{
			((RadioButton)t).setText(text);
		}
		
		if(t instanceof LinkedList){
			LinkedList<View> auxl = (LinkedList<View>)t;
			for (View v : auxl) {
				t= (T) v;
				text(text);
			}
			
			t= (T) auxl;
		}
		return this;
	}
	
	
	  /**
	   * Sets the font of the text 
	   * 
	   * @param  the file name of the font have to be in the assets folder 
	   * @return S<T>
	   */
	public S<T> font(String fileName){
		
		Typeface font = Typeface.createFromAsset(activity.getAssets(), fileName);
		
		if(t instanceof TextView){
			((TextView)t).setTypeface(font);
		}
		if(t instanceof Button){
			((Button)t).setTypeface(font);
		}	
		if(t instanceof EditText){
			((EditText)t).setTypeface(font);
		}
		if(t instanceof CheckBox)
		{
			((CheckBox)t).setTypeface(font);
		}
		if(t instanceof RadioButton)
		{
			((RadioButton)t).setTypeface(font);
		}
		if(t instanceof LinkedList){
			LinkedList<View> auxl = (LinkedList<View>)t;
			for (View v : auxl) {
				t= (T) v;
				font(fileName);
			}
			
			t= (T) auxl;
		}
		
		
		return this;
	}
	
	  /**
	   * Sets the text color 
	   * 
	   * @param  Color
	   * @return S<T>
	   */
	
	public S<T> color(int color){
		
		if(t instanceof TextView){
			((TextView)t).setTextColor(color);
		}
		if(t instanceof Button){
			((Button)t).setTextColor(color);
		}
		if(t instanceof EditText){
			((EditText)t).setTextColor(color);
		}
		if(t instanceof RadioButton)
		{
			((RadioButton)t).setTextColor(color);
		}
		if(t instanceof CheckBox)
		{
			((CheckBox)t).setTextColor(color);
		}
		if(t instanceof LinkedList){
			LinkedList<View> auxl = (LinkedList<View>)t;
			for (View v : auxl) {
				t= (T) v;
				color(color);
			}
			
			t= (T) auxl;
		}
		return this;
	}
	
	  /**
	   * Sets the text color 
	   * 
	   * @param  Color like #ff0000
	   * @return S<T>
	   */
	public S<T> color(String color){
		
		try{
			int c = Color.parseColor(color);
			color(c);
		}catch(IllegalArgumentException ex){
			ex.printStackTrace();
		}
		
		return this;
	}
	
	  /**
	   * Sets the items of a simple list item  
	   * 
	   * @param  data array of strings
	   * @return S<T>
	   */
	
	public S<T> list(String[] data){
		if(t instanceof ListView){
			
			((ListView) t).setAdapter(new ArrayAdapter<String>(activity,
		              android.R.layout.simple_list_item_1, android.R.id.text1, data));
		}
		return this;
	}
	  /**
	   * Sets the items of a simple list item  
	   * 
	   * @param  data list of strings
	   * @return S<T>
	   */
	public S<T> list(List<String> data){
		list(data.toArray(new String[data.size()]));
		return this;
	}
	  /**
	   * Sets the items of a costume list view 
	   * The ids in the view have to have the same names as the 
	   * attributes of the list of objects	
	   * 
	   * @param  id of the row view
	   * @param  list of objects the will populate the list
	   * @return S<T>
	   */
	public S<T> list(String idView,List<Object> objects){
		
		idView =idView.intern();
		T aux = t;
		int resID = activity.getResources().getIdentifier(idView, "layout", activity.getPackageName());
		ListView list = (ListView) t;
		SAdapter a = new SAdapter(resID,objects);
		list.setAdapter(a);
		
		t = aux;
		return this;
	}
	
	public S<T> list(String idView,List<Object> objects,String toActivity){
		
		final String name = toActivity;
		final List<Object> obj =objects;
		idView =idView.intern();
		T aux = t;
		int resID = activity.getResources().getIdentifier(idView, "layout", activity.getPackageName());
		ListView list = (ListView) t;
		SAdapter a = new SAdapter(resID,objects);
		list.setAdapter(a);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent i = new Intent();
				String pkg = activity.getApplicationContext().getPackageName();
				i.setComponent(new ComponentName(pkg,pkg+"."+name));
				i.putExtra("Southappsobject",(Serializable) obj.get(position) );
				activity.startActivity(i);
			}
		});
		
		t = aux;
		return this;
	}
	
	public S<T> setUpViews(){
		
		Object model = (Object) activity.getIntent().getSerializableExtra("Southappsobject");
		for(Field f : model.getClass().getFields()) {
			   try {
				   
				   get(f.getName());
				   
				   //TODO: add other things like button links
					   if(t instanceof TextView)
					   text((String) f.get(model));
					   if(t instanceof ImageView)
					   image((String) f.get(model));
			
			   } catch (IllegalAccessException e) {
				e.printStackTrace();
			   } catch (IllegalArgumentException e) {
				e.printStackTrace();
			   }
		}
		
		this.model = model;
		return this;
	}
	
	  /**
	   * Go to an other activity (have  to be in the same package)
	   * 
	   * @param  name of the activity  
	   * @return S<T>
	   */
	public S<T> to(String name){
		name = name.trim();
		Intent i = new Intent();
		String pkg = activity.getApplicationContext().getPackageName();
		i.setComponent(new ComponentName(pkg,pkg+"."+name));
		activity.startActivity(i);
		return this;
	}
	

	  /**
	   * On view Click
	   * 
	   * @param  View.OnClickListener  
	   * @return S<T>
	   */
	
	public S<T> click(View.OnClickListener listener){
		
		((View)t).setOnClickListener(listener);
		
		return this;
	}
	
	  /**
	   * On view Click
	   * 
	   * @param  function have to be a public function in the activity  
	   * @return S<T>
	   */
	
	public S<T> click(String function){
		
		final String fun = function;
		((View)t).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {			
				callFun(fun);				
			}
		});

		return this;
	}
	
	  /**
	   * On List view item Click
	   * 
	   * @param  OnItemClickListener
	   * @return S<T>
	   */
	public S<T> itemClick(OnItemClickListener listener){
		if(t instanceof ListView){
			((ListView) t).setOnItemClickListener(listener);
		}
		return this;
	}
	
	  /**
	   * Gets the int from the view (edittext, button,..)
	   * 
	   *
	   * @return int
	   */
	
	public int toInt(){
		String s = txt().trim();
		int i;
		try{
			i = Integer.parseInt(s);
		}catch(NumberFormatException exp){
			exp.printStackTrace();
			return 0;
		}
		return i;	
	}
	
	  /**
	   * Gets the float from the view (edittext, button,..)
	   * 
	   *
	   * @return float
	   */
	public float toFloat(){
		String s = txt().trim();
		float i;
		try{
			i = Float.parseFloat(s);
		}catch(NumberFormatException exp){
			exp.printStackTrace();
			return 0f;
			
		}
		return i;	
	}
	
	  /**
	   * Gets the boolean from the view (edittext, button,..)
	   * 
	   *
	   * @return boolean
	   */
	public Boolean toBool(){
		String s = txt().trim();
		Boolean i;
		try{
			i = Boolean.parseBoolean(s);
		}catch(NumberFormatException exp){
			exp.printStackTrace();
			return false;
		}
		return i;	
	}
	
	  /**
	   * Show the view
	   * 
	   *
	   * @return S<T>
	   */
	public S<T> show(){
		((View)t).setVisibility(View.VISIBLE);
		return this;
	}
	
	  /**
	   * Hide the view
	   * 
	   *
	   * @return S<T>
	   */
	public S<T> hide(){
		((View)t).setVisibility(View.INVISIBLE);
		return this;
	}
	
	  /**
	   * Hide the view (Gone)
	   * 
	   *
	   * @return S<T>
	   */
	public S<T> gone(){
		((View)t).setVisibility(View.GONE);
		return this;
	}
	

	  /**
	   * toogle the view
	   * 
	   *
	   * @return S<T>
	   */
	public S<T> toogle(){
		if (((View)t).getVisibility() == View.VISIBLE) {
			((View)t).setVisibility(View.INVISIBLE);
		} else {
			((View)t).setVisibility(View.VISIBLE);
		}
		return this;
	}
	
	  /**
	   * sets the width of the view in dp
	   * 
	   *@param width
	   * @return S<T>
	   */
	public S<T> widthDp(int width){
		((View)t).getLayoutParams().width = (int) pxToDp(width);
		return this;
	}
	
	  /**
	   * sets the height of the view in dp
	   * 
	   *@param height
	   * @return S<T>
	   */
	public S<T> heightDp(int height){
		((View)t).getLayoutParams().height = (int) pxToDp(height);
		return this;
	}
	
	  /**
	   * sets the x of the view in dp
	   * 
	   *@param x
	   * @return S<T>
	   */
	@SuppressLint("NewApi")
	public S<T> XDp(int x){
		((View)t).setX((int) pxToDp(x));
		return this;
	}
	  /**
	   * sets the y of the view in dp
	   * 
	   *@param y
	   * @return S<T>
	   */
	@SuppressLint("NewApi")
	public S<T> YDp(int y){
		((View)t).setY((int) pxToDp(y));
		return this;
	}
	
	  /**
	   * sets the width of the view in px
	   * 
	   *@param width
	   * @return S<T>
	   */
	public S<T> width(int width){
		((View)t).getLayoutParams().width = width;
		return this;
	}
	  /**
	   * sets the height of the view in px
	   * 
	   *@param height
	   * @return S<T>
	   */
	public S<T> height(int height){
		((View)t).getLayoutParams().height = height;
		return this;
	}
	  /**
	   * sets the x of the view in px
	   * 
	   *@param x
	   * @return S<T>
	   */
	@SuppressLint("NewApi")
	public S<T> X(int x){
		((View)t).setX(x);
		return this;
	}
	  /**
	   * sets the y of the view in px
	   * 
	   *@param y
	   * @return S<T>
	   */
	@SuppressLint("NewApi")
	public S<T> Y(int y){
		((View)t).setY(y);
		return this;
	}
	  /**
	   * gets the screen width
	   * 
	   * @return int
	   */
	public int sWidth(){
		
		int Measuredwidth = 0;   
		Point size = new Point();
		WindowManager w = activity.getWindowManager();
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)    {
		    w.getDefaultDisplay().getSize(size);
		    Measuredwidth = size.x;   
		}else{
		    Display d = w.getDefaultDisplay(); 
		    Measuredwidth = d.getWidth();    
		}
		return Measuredwidth;
	}
	  /**
	   * gets the screen height
	   * 
	   * @return int
	   */
	public int sHeight(){
		
		int Measuredheight = 0;  
		Point size = new Point();
		WindowManager w = activity.getWindowManager();

		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)    {
		    w.getDefaultDisplay().getSize(size);
		    Measuredheight = size.y; 
		}else{
		    Display d = w.getDefaultDisplay(); 
		    Measuredheight = d.getHeight(); 
		}
		
		return Measuredheight;
	}
	
	  /**
	   * Makes a short Toast
	   * @param text of the Toast
	   * @return S<T>
	   */
	public S<T> toast(String text){
		Toast t = Toast.makeText(activity, text, Toast.LENGTH_SHORT);
		t.show();
		return this;
	}

	  /**
	   * Makes a Long Toast
	   * @param text of the Toast
	   * @return S<T>
	   */
	
	public S<T> Ltoast(String text){
		Toast t = Toast.makeText(activity, text, Toast.LENGTH_LONG);
		t.show();
		return this;
	}
	

	  /**
	   * Makes an alert dialog
	   * @param Title of the alert
	   * @param Text of the alert
	   * @return S<T>
	   */
	public S<T> alert(String title,String text){
		
		AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(text);
		alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
		    new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) {
		            dialog.dismiss();
		        }
		    });
		alertDialog.show();
		return this;
	}
	  /**
	   * Makes an alert dialog
	   * @param icon of the alert
	   * @param Title of the alert
	   * @param Text of the alert
	   * @return S<T>
	   */
	public S<T> alert(String icon,String title,String text){
		
		AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(text);
		alertDialog.setIcon(getIdD(icon));
		alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
		    new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) {
		            dialog.dismiss();
		        }
		    });
		alertDialog.show();
		return this;
	}
	
	  /**
	   * Makes an alert dialog
	   * @param Text of the alert
	   * @return S<T>
	   */
	public S<T> alert(String text){
		
		AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
		alertDialog.setTitle("Alert");
		alertDialog.setMessage(text);
		alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
		    new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) {
		            dialog.dismiss();
		        }
		    });
		alertDialog.show();
		return this;
	}
	
	  /**
	   * Makes an progress dialog
	   * @param show or hide the dialog
	   * @param Text of the alert
	   * @return S<T>
	   */
	public S<T> progress(Boolean active,String text){
		
		if(pDialog==null){
			
			 pDialog = new ProgressDialog(activity);
		     pDialog.setMessage(text);
		     pDialog.setCancelable(false);
		}
		
		if(active){
			if (!pDialog.isShowing())
	            pDialog.show();
		}else{
			if (pDialog.isShowing())
	            pDialog.dismiss();
		}
		
		return this;
	}
	  /**
	   * Makes an progress dialog
	   * @param show or hide the dialog
	   * @return S<T>
	   */
	public S<T> progress(Boolean active){
		
		if(pDialog==null){
			
			 pDialog = new ProgressDialog(activity);
		     pDialog.setMessage("Please wait...");
		     pDialog.setCancelable(false);
		}
		
		if(active){
			if (!pDialog.isShowing())
	            pDialog.show();
		}else{
			if (pDialog.isShowing())
	            pDialog.dismiss();;
		}
		
		return this;
	}
	  /**
	   * Gets the text of a view
	   * @return String
	   */
	public String txt(){
		String s ="";
		String aux ="";
		if(t instanceof TextView){	
			aux =( (TextView) t).getText().toString();
		}
		if(t instanceof Button){
			aux =( (Button) t).getText().toString();
		}
		if(t instanceof EditText){
			aux =( (EditText) t).getText().toString();
		}
		if(t instanceof CheckBox){
			aux =( (CheckBox) t).getText().toString();
		}
		if(t instanceof RadioButton){
			aux =( (RadioButton) t).getText().toString();
		}
		
		
		if(!aux.isEmpty()){
			s=aux;
		}
		
		return s;
	}
	
	class SAdapter extends BaseAdapter{

	    private LayoutInflater inflater;
	    private List<Object> Items;
	    private int idView;
	    
	    
	    public SAdapter(int idView, List<Object> Items){
	    	this.Items = Items;
	    	this.idView = idView;
	    }
	    
		@Override
		public int getCount() {
			return Items.size();
		}

		@Override
		public Object getItem(int position) {
			return Items.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			 if (inflater == null)
		            inflater = (LayoutInflater) activity
		                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 if (convertView == null)
		            convertView = inflater.inflate(idView, null);
			 
				Object obj = Items.get(position);
				
				for(Field f : obj.getClass().getFields()) {
					   try {
						   
						   get(convertView,f.getName());
						   
							   if(t instanceof TextView)
							   text((String) f.get(obj));
							   if(t instanceof ImageView)
							   image((String) f.get(obj));
					
					   } catch (IllegalAccessException e) {
						e.printStackTrace();
					   } catch (IllegalArgumentException e) {
						e.printStackTrace();
					   }
				}
			 
			 
			 
			return convertView;
		}
		
	}
	

	  /**
	   * Creates a thread
	   * @param handler after the thread is done
	   * @param name of the function to execute inside the thread
	   * @return S<T>
	   */
	public S<T> thread(final Handler handler,String function){
		final String name = function;
		
		
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {

				try{
					callFun(name);
					handler.sendEmptyMessage(0);
					
				}catch(Throwable exp){
					
				}
			}
		});
		
		
		thread.start();
		
		progress(false);
		
		return this;
	}
	  /**
	   * Creates a thread
	   * @param name of the function to execute after the thread is done
	   * @param name of the function to execute inside the thread
	   * @return S<T>
	   */
	@SuppressLint("HandlerLeak")
	public S<T> thread(String After,String background){
		final String nameb = background;
		final String namea = After;
		
		final Handler handler = new Handler(){
			 @Override
		        public void handleMessage(Message inputMessage) {
		            
				 	callFun(namea);
				 	
		        }
		};
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {

				try{
					callFun(nameb);
					handler.sendEmptyMessage(0);
					
				}catch(Throwable exp){
					
				}
			}
		});
		
		
		thread.start();
		
		progress(false);
		
		return this;
	}
	
	  /**
	   * Http get 
	   * @param url
	   * @return String
	   */
	public String httpGet(String url){
		 ServiceHandler sh = new ServiceHandler();
         return sh.makeServiceCall(url, ServiceHandler.GET);
	}
	  /**
	   * Http post 
	   * @param url
	   * @return String
	   */
	public String httpPost(String url){
		 ServiceHandler sh = new ServiceHandler();
        return sh.makeServiceCall(url, ServiceHandler.POST);
	}
	
	  /**
	   * Post data to the server 
	   * @param url
	   * @param list of NameValuePair to send
	   * @return HttpResponse
	   */
	public HttpResponse post(String url,List<NameValuePair> nameValuePairs) {
	    
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(url);

	    try {
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        HttpResponse response = httpclient.execute(httppost);
	        return response;

	    } catch (ClientProtocolException e) {
	    } catch (IOException e) {
	    }
	    return null;
	}
	
	
	  /**
	   * Sets the activity as a splash screen
	   * @param time in milliseconds
	   * @param name of the next activity
	   * @return S<T>
	   */
	public S<T> splash(int time,final String nextActivity){
        new Handler().postDelayed(new Runnable() {
           @Override
            public void run() {
                to(nextActivity);
                activity.finish();
            }
        }, time);
        
		return this;
	}
	
	  /**
	   * Save a string in the Shared Preferences
	   * @param value
	   * @param key
	   * @return S<T>
	   */
	public S<T> setPref(String value, String key) {
	    SharedPreferences settings = activity.getSharedPreferences(PREFS_NAME, 0);
	    settings = activity.getSharedPreferences(PREFS_NAME, 0);
	    SharedPreferences.Editor editor = settings.edit();
	    editor.putString(key, value);
	    editor.commit();
	    return this;
	}

	  /**
	   * Gets a string in the Shared Preferences
	   * @param key
	   * @return String
	   */
	public String getPref(String key) {
	    SharedPreferences settings = activity.getSharedPreferences(PREFS_NAME, 0);
	    settings = activity.getSharedPreferences(PREFS_NAME, 0);
	    String value = settings.getString(key, "");
	    return value;
	}
	
	  /**
	   * Calls a public function inside the activity
	   * @param name of the function to call
	   * @return S<T>
	   */
	public S<T> callFun(String name){
		
		Class<? extends Activity>  aClass = activity.getClass();
		try {
			java.lang.reflect.Method method = aClass.getMethod(name, new Class[]{});
			method.invoke(activity,new Object[] {});
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
	  /**
	   * gets a value from string file
	   * @param name of the string
	   * @return String
	   */
	public String getS(String name){	
		
		String packageName = activity.getPackageName();
		int resId = activity.getResources().getIdentifier(name, "string", packageName);
		return activity.getString(resId);
		    
	}
	
	  /**
	   * gets a Drawable from Drawable folder
	   * @param name of the string
	   * @return Drawable
	   */
	public Drawable getD(String name) { 
		
	    int resourceId = activity.getResources().getIdentifier(name, "drawable", activity.getPackageName());
	    return activity.getResources().getDrawable(resourceId);
	}
	
	  /**
	   * gets a Drawable from Drawable folder
	   * @param name of the string
	   * @return Bitmap
	   */
	
	public Bitmap getB(String name){
		return BitmapFactory.decodeResource(activity.getResources(),
				activity.getResources().getIdentifier(name, "drawable", activity.getPackageName()));
		
	}

	  /**
	   * Open the camera to take a picture 
	   * @permission uses-permission android:name="android.permission.CAMERA"
	   * @param code
	   * @return S<T>
	   */
		public S<T> camImg(int code){
	      Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	      activity.startActivityForResult(intent, code);
	      return this;
	   }
	  
	//<uses-permission android:name="android.permission.CAMERA" />
		  /**
		   * Open the camera to take a video 
		   * @permission uses-permission android:name="android.permission.CAMERA"
		   * @param code
		   * @return S<T>
		   */
	  public S<T> camVid(int code){
	      Intent intent = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
	      activity.startActivityForResult(intent, code);
	      return this;
	   }
	  
	  /**
	   * Open the gallery 
	   * @param code
	   * @return S<T>
	   */
	  public S<T> gallery(int code){
		  
          Intent intent = new Intent();
          intent.setType("image/*");
          intent.setAction(Intent.ACTION_GET_CONTENT);
          activity.startActivityForResult(Intent.createChooser(intent, ""), code);
		 
          return this;
		  
	  }
	  
	  /**
	   * Open the browser 
	   * @param url to go to
	   * @return S<T>
	   */
	  public S<T> browser(String url){
		  url = url.trim();
		  if (!url.startsWith("http://") && !url.startsWith("https://"))
			   url = "http://" + url;
		  Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		  activity.startActivity(browserIntent);
		  return this;
	  }
	  
	  /*
	   * <uses-permission android:name="android.permission.BLUETOOTH"/>
	   * <uses-permission android:name="android.permission.BLUETOOTH_ADMIN"/>
	   */
	  /**
	   * Open and close bluetooth 
	   * @permission  uses-permission android:name="android.permission.BLUETOOTH"
	   * @permission  uses-permission android:name="android.permission.BLUETOOTH_ADMIN"
	   * @param enable 
	   * @return S<T>
	   */
	  public S<T> bluetooth(Boolean enable){
		  	  
			    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
			    boolean isEnabled = bluetoothAdapter.isEnabled();
			    if (enable && !isEnabled) {
			        bluetoothAdapter.enable(); 
			    }
			    else if(!enable && isEnabled) {
			        bluetoothAdapter.disable();
			    }

		  return this;
	  }
	  /*
	   * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />  
		<uses-permission android:name="android.permission.INTERNET" />  
		<uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/> 
	   */
	  
	  /**
	   * Open and close wifi 
	   * @permission  uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
	   * @permission  uses-permission android:name="android.permission.INTERNET"
	   * * @permission  uses-permission android:name="android.permission.CHANGE_WIFI_STATE"
	   * @param enable 
	   * @return S<T>
	   */
	  public S<T> wifi(Boolean enable){
	  	  
		  	WifiManager wifi = (WifiManager) activity.getSystemService(Context.WIFI_SERVICE);
		    boolean isEnabled = wifi.isWifiEnabled();
		    
		    if (enable && !isEnabled) {
		    	wifi.setWifiEnabled(true);  
		    }
		    else if(!enable && isEnabled) {
		    	wifi.setWifiEnabled(false);  
		    }

	  return this;
	  } 
	  
	  /**
	   * This method converts dp unit to equivalent pixels, depending on device density. 
	   * 
	   * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
	   * @param context Context to get resources and device specific display metrics
	   * @return A float value to represent px equivalent to dp depending on device density
	   */
	  public float dpToPx(float dp){
	      Resources resources = activity.getResources();
	      DisplayMetrics metrics = resources.getDisplayMetrics();
	      float px = dp * (metrics.densityDpi / 160f);
	      return px;
	  }

	  /**
	   * This method converts device specific pixels to density independent pixels.
	   * 
	   * @param px A value in px (pixels) unit. Which we need to convert into db
	   * @param context Context to get resources and device specific display metrics
	   * @return A float value to represent dp equivalent to px value
	   */
	  public float pxToDp(float px){
	      Resources resources = activity.getResources();
	      DisplayMetrics metrics = resources.getDisplayMetrics();
	      float dp = px / (metrics.densityDpi / 160f);
	      return dp;
	  }
	  
	  /**
	   * Makes a notification
	   * 
	   * @param title
	   * @param subject 
	   * @param body
	   * @return S<T>
	   */
	   @SuppressWarnings("deprecation")
	   public S<T> notify(String title,String subject,String body ){
		  NotificationManager NM=(NotificationManager)activity.getSystemService(Context.NOTIFICATION_SERVICE);
	      Notification notify=new Notification(android.R.drawable.
	      stat_notify_more,title,System.currentTimeMillis());
	      PendingIntent pending=PendingIntent.getActivity(
	      activity.getApplicationContext(),0, new Intent(),0);
	      notify.setLatestEventInfo(activity.getApplicationContext(),subject,body,pending);
	      NM.notify(0, notify);
	      
	      return this;
	   }
	   /**
		   * Makes a notification
		   * 
		   * @param id of the icon
		   * @param title
		   * @param subject 
		   * @param body
		   * @return S<T>
		   */ 
	   @SuppressWarnings("deprecation")
	   public S<T> notify(String icon,String title,String subject,String body ){
		  NotificationManager NM=(NotificationManager)activity.getSystemService(Context.NOTIFICATION_SERVICE);
		  int theid =  activity.getResources().getIdentifier(
					icon, "drawable", activity.getApplicationContext().getPackageName());
	      Notification notify=new Notification(theid,title,System.currentTimeMillis());
	      PendingIntent pending=PendingIntent.getActivity(
	      activity.getApplicationContext(),0, new Intent(),0);
	      notify.setLatestEventInfo(activity.getApplicationContext(),subject,body,pending);
	      NM.notify(0, notify);
	      
	      return this;
	   }
	   
	   /**
		   * Send an email
		   * 
		   * @param destination 
		   * @param subject 
		   * @param body
		   * @return S<T>
		   */
	   public S<T> mail(String to,String subject,String body){
		   
		   Intent i = new Intent(Intent.ACTION_SEND);
		   i.setType("message/rfc822");
		   i.putExtra(Intent.EXTRA_EMAIL  , new String[]{to});
		   i.putExtra(Intent.EXTRA_SUBJECT, subject);
		   i.putExtra(Intent.EXTRA_TEXT   , body);
		   try {
		       activity.startActivity(Intent.createChooser(i, "Send mail..."));
		   } catch (android.content.ActivityNotFoundException ex) {
		       toast("There are no email clients installed.");
		   }
		   
		   return this;
	   }
	   /**
		   * Send an email
		   * 
		   * @param array of destinations 
		   * @param subject 
		   * @param body
		   * @return S<T>
		   */
	   public S<T> mail(String[] to,String subject,String body){
		   
		   Intent i = new Intent(Intent.ACTION_SEND);
		   i.setType("message/rfc822");
		   i.putExtra(Intent.EXTRA_EMAIL  , to);
		   i.putExtra(Intent.EXTRA_SUBJECT, subject);
		   i.putExtra(Intent.EXTRA_TEXT   , body);
		   try {
		       activity.startActivity(Intent.createChooser(i, "Send mail..."));
		   } catch (android.content.ActivityNotFoundException ex) {
		       toast("There are no email clients installed.");
		   }
		   
		   return this;
	   }
	   
	   /**
		   * delays the execution of a function
		   * 
		   * @param time in milliseconds
		   * @param name of the function
		   * @return S<T>
		   */
	   public S<T> delay(int time, String function){
		   
		   final String s =function;
		   final Handler handler = new Handler();
		   handler.postDelayed(new Runnable() {
		     @Override
		     public void run() {
		       callFun(s);
		     }
		   }, time);
		   return this;
		   
	   }
	   /**
		   * Get the android version

		   * @return String
		   */
	   public String androidVersion() {
		   
		    String release = Build.VERSION.RELEASE;
		    int sdkVersion = Build.VERSION.SDK_INT;
		    return "Android SDK: " + sdkVersion + " (" + release +")";
		    
		}
	   /**
		   * Reloads the activity
		   * @return S<T>
		   */
	   public S<T> reload(){
		   if (Build.VERSION.SDK_INT >= 11) {
			    activity.recreate();
			} else {
			    Intent intent = activity.getIntent();
			    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			    activity.finish();
			    activity.overridePendingTransition(0, 0);

			    activity.startActivity(intent);
			    activity.overridePendingTransition(0, 0);
			}
		   return this;
	   }

	   //<uses-permission android:name="android.permission.READ_PHONE_STATE"/> 
	   /**
		   * Get the device phone number

		   * @return String
		   */
	   public String getPhoneNumber(){
		   
		    TelephonyManager mTelephonyMgr;
		    mTelephonyMgr = (TelephonyManager)
		        activity.getSystemService(Context.TELEPHONY_SERVICE); 
		    return mTelephonyMgr.getLine1Number();
		    
		}
	   
	   /**
		   * Get the device name

		   * @return String
		   */
	   public String deviceName() {
		    String manufacturer = Build.MANUFACTURER;
		    String model = Build.MODEL;
		    if (model.startsWith(manufacturer)) {
		        return capitalize(model);
		    } else {
		        return capitalize(manufacturer) + " " + model;
		    }
		}


		private String capitalize(String s) {
		    if (s == null || s.length() == 0) {
		        return "";
		    }
		    char first = s.charAt(0);
		    if (Character.isUpperCase(first)) {
		        return s;
		    } else {
		        return Character.toUpperCase(first) + s.substring(1);
		    }
		}
		
		public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
		          "[a-zA-Z0-9+._%-+]{1,256}" +
		          "@" +
		          "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
		          "(" +
		          "." +
		          "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
		          ")+"
		      );
		   /**
			   * check if it is an email 

			   * @return boolean
			   */
		public boolean checkEmail(String email) {
		    return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
		}
		
	    /**
	     * Convert byte array to hex string
	     * @param bytes
	     * @return
	     */
	    public  String bytesToHex(byte[] bytes) {
	        StringBuilder sbuf = new StringBuilder();
	        for(int idx=0; idx < bytes.length; idx++) {
	            int intVal = bytes[idx] & 0xff;
	            if (intVal < 0x10) sbuf.append("0");
	            sbuf.append(Integer.toHexString(intVal).toUpperCase());
	        }
	        return sbuf.toString();
	    }

	    /**
	     * Get utf8 byte array.
	     * @param str
	     * @return  array of NULL if error was found
	     */
	    public  byte[] getUTF8Bytes(String str) {
	        try { return str.getBytes("UTF-8"); } catch (Exception ex) { return null; }
	    }

	    /**
	     * Load UTF8withBOM or any ansi text file.
	     * @param filename
	     * @return  
	     * @throws java.io.IOException
	     */
	    public  String loadFileAsString(String filename) throws java.io.IOException {
	        final int BUFLEN=1024;
	        BufferedInputStream is = new BufferedInputStream(new FileInputStream(filename), BUFLEN);
	        try {
	            ByteArrayOutputStream baos = new ByteArrayOutputStream(BUFLEN);
	            byte[] bytes = new byte[BUFLEN];
	            boolean isUTF8=false;
	            int read,count=0;           
	            while((read=is.read(bytes)) != -1) {
	                if (count==0 && bytes[0]==(byte)0xEF && bytes[1]==(byte)0xBB && bytes[2]==(byte)0xBF ) {
	                    isUTF8=true;
	                    baos.write(bytes, 3, read-3); // drop UTF8 bom marker
	                } else {
	                    baos.write(bytes, 0, read);
	                }
	                count+=read;
	            }
	            return isUTF8 ? new String(baos.toByteArray(), "UTF-8") : new String(baos.toByteArray());
	        } finally {
	            try{ is.close(); } catch(Exception ex){} 
	        }
	    }

	    //<uses-permission android:name="android.permission.INTERNET" />
	    //<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	    /**
	     * Returns MAC address of the given interface name.
	     * @param interfaceName eth0, wlan0 or NULL=use first interface 
	     * @return  mac address or empty string
	     */
	    public static String macAddress(String interfaceName) {
	        try {
	            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
	            for (NetworkInterface intf : interfaces) {
	                if (interfaceName != null) {
	                    if (!intf.getName().equalsIgnoreCase(interfaceName)) continue;
	                }
	                byte[] mac = intf.getHardwareAddress();
	                if (mac==null) return "";
	                StringBuilder buf = new StringBuilder();
	                for (int idx=0; idx<mac.length; idx++)
	                    buf.append(String.format("%02X:", mac[idx]));       
	                if (buf.length()>0) buf.deleteCharAt(buf.length()-1);
	                return buf.toString();
	            }
	        } catch (Exception ex) { } // for now eat exceptions
	        return "";
	        /*try {
	            // this is so Linux hack
	            return loadFileAsString("/sys/class/net/" +interfaceName + "/address").toUpperCase().trim();
	        } catch (IOException ex) {
	            return null;
	        }*/
	    }

	    //<uses-permission android:name="android.permission.INTERNET" />
	    //<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	    /**
	     * Get IP address from first non-localhost interface
	     * @param ipv4  true=return ipv4, false=return ipv6
	     * @return  address or empty string
	     */
	    public static String ip(boolean useIPv4) {
	        try {
	            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
	            for (NetworkInterface intf : interfaces) {
	                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
	                for (InetAddress addr : addrs) {
	                    if (!addr.isLoopbackAddress()) {
	                        String sAddr = addr.getHostAddress().toUpperCase();
	                        boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr); 
	                        if (useIPv4) {
	                            if (isIPv4) 
	                                return sAddr;
	                        } else {
	                            if (!isIPv4) {
	                                int delim = sAddr.indexOf('%'); // drop ip6 port suffix
	                                return delim<0 ? sAddr : sAddr.substring(0, delim);
	                            }
	                        }
	                    }
	                }
	            }
	        } catch (Exception ex) { } // for now eat exceptions
	        return "";
	    }
		
		//<uses-permission android:name="android.permission.READ_PHONE_STATE"/> 
		   /**
			   * gets the imei of the device 

			   * @return String
			   */
		public String imei() {
		    TelephonyManager telephonyManager = (TelephonyManager) activity
		            .getSystemService(Context.TELEPHONY_SERVICE);
		    return telephonyManager.getDeviceId();
		}
		
		//<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
		   /**
			   * gets the uuid of the device 

			   * @return String
			   */
		public String uuid(){
		    String device_unique_id = Secure.getString(activity.getContentResolver(),
		            Secure.ANDROID_ID);
		    return device_unique_id;
		}
		
		
	 //<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
	   GPSTracker gps;
	   /**
		   * gets the device current location 

		   * @return S<T>
		   */
	   public S<T> gps(){
		   gps = new GPSTracker(activity);

           // Check if GPS enabled
           if(gps.canGetLocation()) {

               double latitude = gps.getLatitude();
               double longitude = gps.getLongitude();

               // \n is for new line
               Toast.makeText(activity, "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
           } else {
               // Can't get location.
               // GPS or network is not enabled.
               // Ask user to enable GPS/network in settings.
               gps.showSettingsAlert();
           }
		   
           return this;
      }
	   
	   
		//<uses-permission android:name="android.permission.CALL_PHONE" />
	   /**
		   * calls a phone number 
		   * @param the number to call
		   * @return S<T>
		   */
		public S<T> call(String number){
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:"+number));
			activity.startActivity(callIntent);
			return this;
		}
		
		//<uses-permission android:name="android.permission.SEND_SMS"/>
		
		   /**
			   * send an sms 
			   * @param the number
			   * @param the message
			   * @return S<T>
			   */
		public S<T> sms(String number,String message){
			sendSMS(number, message);   
			return this;
		}
		//<uses-permission android:name="android.permission.VIBRATE"/>
		/**
		 * make the device vibrate
		 * @param duration
		 * @return S<T>
		 */
		public S<T> vibrate(int duration)
		 {
		    Vibrator vibs = (Vibrator) activity.getSystemService(Context.VIBRATOR_SERVICE);
		    vibs.vibrate(duration); 
		    return this;
		 }
		
		 private void sendSMS(String phoneNumber,String message) {
		        SmsManager smsManager = SmsManager.getDefault();


		         String SENT = "SMS_SENT";
		            String DELIVERED = "SMS_DELIVERED";

		            SmsManager sms = SmsManager.getDefault();
		            ArrayList<String> parts = sms.divideMessage(message);
		            int messageCount = parts.size();

		            

		            ArrayList<PendingIntent> deliveryIntents = new ArrayList<PendingIntent>();
		            ArrayList<PendingIntent> sentIntents = new ArrayList<PendingIntent>();

		            PendingIntent sentPI = PendingIntent.getBroadcast(activity, 0, new Intent(SENT), 0);
		            PendingIntent deliveredPI = PendingIntent.getBroadcast(activity, 0, new Intent(DELIVERED), 0);

		            for (int j = 0; j < messageCount; j++) {
		                sentIntents.add(sentPI);
		                deliveryIntents.add(deliveredPI);
		            }

		            // ---when the SMS has been sent---
		            activity.registerReceiver(new BroadcastReceiver() {
		                @Override
		                public void onReceive(Context arg0, Intent arg1) {
		                    switch (getResultCode()) {
		                    case Activity.RESULT_OK:
		                        toast("SMS sent");
		                        break;
		                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
		                    	toast("Generic failure");
		                        break;
		                    case SmsManager.RESULT_ERROR_NO_SERVICE:
		                    	toast("No service");
		                        break;
		                    case SmsManager.RESULT_ERROR_NULL_PDU:
		                    	toast("Null PDU");
		                        break;
		                    case SmsManager.RESULT_ERROR_RADIO_OFF:
		                    	toast("Radio off");
		                        break;
		                    }
		                }
		            }, new IntentFilter(SENT));

		            // ---when the SMS has been delivered---
		            activity.registerReceiver(new BroadcastReceiver() {
		                @Override
		                public void onReceive(Context arg0, Intent arg1) {
		                    switch (getResultCode()) {

		                    case Activity.RESULT_OK:
		                    	toast("SMS delivered");
		                        break;
		                    case Activity.RESULT_CANCELED:
		                    	toast("SMS not delivered");
		                        break;
		                    }
		                }
		            }, new IntentFilter(DELIVERED));
		  smsManager.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
		           /* sms.sendMultipartTextMessage(phoneNumber, null, parts, sentIntents, deliveryIntents); */
		    }
		 
		 
		 
		 //<service android:name="com.southapps.squery.utility.DownloadService"/>
		 //<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
		 //<uses-permission android:name="android.permission.INTERNET"></uses-permission>
		 //<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
		 //<uses-permission android:name="android.permission.READ_PHONE_STATE"></uses-permission>
		 
		 /** Download a file 
		  * 
		  * have to add service in the manifest             
		  * service android:name="com.southapps.squery.utility.DownloadService"
		  * @param url link of download
		  */
		@SuppressLint("NewApi")
		public S<T> download(String url){
		   
		// declare the dialog as a member field of your activity
			 String fileName = url.substring( url.lastIndexOf('/')+1, url.length() );

			 
		   
		   //if(!service){
			   // instantiate it within the onCreate method
			   mProgressDialog = new ProgressDialog(activity);
			   mProgressDialog.setMessage("Downloading ...");
			   mProgressDialog.setIndeterminate(true);
			   mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			   mProgressDialog.setCancelable(true);
			   
			   mProgressDialog.show();  
			   Intent intent = new Intent(activity, DownloadService.class);
			   intent.putExtra("url", url);
			   intent.putExtra("filename", fileName);
			   intent.putExtra("receiver", new DownloadReceiver(new Handler()));
			   activity.startService(intent);
			   
		   return this;
	   }
		
		public S<T> downloadNative(String url){
			
				String fileName = url.substring( url.lastIndexOf('/')+1, url.length() );
			   if(isDownloadManagerAvailable(activity))
			   {
				   DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
			   request.setDescription("Some descrition");
			   request.setTitle("Some title");
			   // in order for this if to run, you must use the android 3.2 to compile your app
			   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			       request.allowScanningByMediaScanner();
			       request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
			   }
			   
			   request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);

			   // get download service and enqueue file
			   DownloadManager manager = (DownloadManager) activity.getSystemService(Context.DOWNLOAD_SERVICE);
			   manager.enqueue(request);
			   }
			
			return this;
		}
	   
	   class DownloadReceiver extends ResultReceiver{
		    public DownloadReceiver(Handler handler) {
		        super(handler);
		    }

		    @Override
		    protected void onReceiveResult(int resultCode, Bundle resultData) {
		        super.onReceiveResult(resultCode, resultData);
		        if (resultCode == DownloadService.UPDATE_PROGRESS) {
		            int progress = resultData.getInt("progress");
		            mProgressDialog.setProgress(progress);
		            if (progress == 100) {
		                mProgressDialog.dismiss();
		            }
		        }
		    }
		}
	   
	   private boolean isDownloadManagerAvailable(Context context) {
		    try {
		        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
		            return false;
		        }
		        Intent intent = new Intent(Intent.ACTION_MAIN);
		        intent.addCategory(Intent.CATEGORY_LAUNCHER);
		        intent.setClassName("com.android.providers.downloads.ui", "com.android.providers.downloads.ui.DownloadList");
		        List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent,
		                PackageManager.MATCH_DEFAULT_ONLY);
		        return list.size() > 0;
		    } catch (Exception e) {
		        return false;
		    }
		}
	   /**
	    * File browser dialog
	    * @param ext null if you want to show all files
	    * @return FileDialog
	    */
	   public FileDialog selectFile(String ext){
		   
           File mPath = new File(Environment.getExternalStorageDirectory() + "//DIR//");
           FileDialog fileDialog = new FileDialog(activity, mPath);
           fileDialog.setFileEndsWith(ext);
           fileDialog.showDialog();
		   
		   return fileDialog;
	   }
	   
	   /**
	    * Directory browser dialog
	    * @return FileDialog
	    */
	   
	   public FileDialog selectDir(){
		   
           File mPath = new File(Environment.getExternalStorageDirectory() + "//DIR//");
           FileDialog fileDialog = new FileDialog(activity, mPath);

           fileDialog.setSelectDirectoryOption(true);
           
           fileDialog.showDialog();
		   
		   return fileDialog;
	   }
	  
	   
	    @SuppressWarnings("deprecation")
	    /**
	     * Encrypt a text
	     * @param value text to encrypt
	     * @param password
	     * @return
	     */
		protected String encrypt( String value,String password ) {

	    	password = password.trim();
	    	char[] pass = password.toCharArray();
	        try {
	            final byte[] bytes = value!=null ? value.getBytes("utf-8") : new byte[0];
	            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
	            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(pass));
	            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
	            pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(Settings.Secure.getString(activity.getContentResolver(),Settings.System.ANDROID_ID).getBytes("utf-8"), 20));
	            return new String(Base64.encode(pbeCipher.doFinal(bytes), Base64.NO_WRAP),"utf-8");

	        } catch( Exception e ) {
	            throw new RuntimeException(e);
	        }

	    }

	    @SuppressWarnings("deprecation")
	    /**
	     * Decrypt a text
	     * @param value text to decrypt
	     * @param password
	     * @return
	     */
		protected String decrypt(String value,String password){
	    	password = password.trim();
	    	char[] pass = password.toCharArray();
	        try {
	            final byte[] bytes = value!=null ? Base64.decode(value,Base64.DEFAULT) : new byte[0];
	            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
	            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(pass));
	            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
	            pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(Settings.Secure.getString(activity.getContentResolver(),Settings.System.ANDROID_ID).getBytes("utf-8"), 20));
	            return new String(pbeCipher.doFinal(bytes),"utf-8");

	        } catch( Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
		/**
		 * To find out if it's a tablet of a phone 
		 * @return true if it's a tablet
		 */
	    public boolean isTablet() { 
	    	TelephonyManager telephony = (TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE); 
	    	int type = telephony.getPhoneType();
	    	if (type == TelephonyManager.PHONE_TYPE_NONE) { return true;} 
	    	 return false; 
	    }
	   
	    public S<T> hideKeyborad(){
	    	InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
	    	imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
	    	return this;
	    }
	    
	    public Boolean isChecked(){
	    	
	    	if(t instanceof CheckBox){
	    		return ((CheckBox)t).isChecked();
	    	}
	    	return null;
	    }
	    
	    /**
	     * list of events: click,touchdown,touchup,back,move,longclick
	     * @param event
	     * @param function
	     * @return
	     */
	    @SuppressLint("DefaultLocale")
		public S<T> on(String event,String function){
	    	event = event.trim();
	    	event = event.toLowerCase();
	    	final String fun = function;
	    	if(event.equals("click")){
	    		click(function);
	    	}
	    	if(event.equals("touchdown")){
	    		((View)t).setOnTouchListener(new OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						
						if (event.getAction() == MotionEvent.ACTION_DOWN ) {
		                    callFun(fun);
		                    return true;
		                }

		                return false;
					}
				});
	    	}
	    	if(event.equals("touchup")){
	    		((View)t).setOnTouchListener(new OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						
						if (event.getAction() == MotionEvent.ACTION_UP ) {
		                    callFun(fun);
		                    return true;
		                }

		                return false;
					}
				});
	    		}
	    	
		    if(event.equals("move")){
		    		((View)t).setOnTouchListener(new OnTouchListener() {
						
						@Override
						public boolean onTouch(View v, MotionEvent event) {
							
							if (event.getAction() == MotionEvent.ACTION_MOVE ) {
			                    callFun(fun);
			                    return true;
			                }

			                return false;
						}
					});
		    		
	    	}
		    if(event.equals("longclick")){
	    		((View)t).setOnLongClickListener(new View.OnLongClickListener() {
					
					@Override
					public boolean onLongClick(View v) {
						callFun(fun);
						return true;
					}
				});
	    		
    	}
	    	
	    	return this;
	    }
	    /**
	     * Sets on touch listener to a view
	     *  
	     * @param listener OnTouchListener
	     * @return
	     */
	    public S<T> touch(OnTouchListener listener){
	    	
	    	((View)t).setOnTouchListener(listener);
	    	
	    	return this;
	    }
	    
	    //TODO: Fix Them
	    
	    public S<T> margin(int left,int top,int right,int bottom) {
	        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ((View) t).getLayoutParams();
	        lp.setMargins(left, top, right, bottom);
	        ((View) t).setLayoutParams(lp);
	        return this;
	    }
	    
	    public S<T> margin(int margin) {
	        LayoutParams lp = new LayoutParams(getWidth(),getHeight());
	        ((MarginLayoutParams) lp).setMargins(margin,margin,margin,margin);
	        ((View) t).setLayoutParams(lp);
	        return this;
	    }
	    
	    public S<T> padding(int left,int top,int right,int bottom) {
	    	((View) t).setPadding(left, top, right, bottom);
	        return this;
	    }
	    
	    public S<T> padding(int padding) {
	    	((View) t).setPadding(padding, padding, padding, padding);
	        return this;
	    }
	    
	    public int getWidth(){
	    	w = 0;
	    	((View) t).post(new Runnable() {
	            @Override
	            public void run() {
	                int width = ((View) t).getMeasuredWidth();
	                w = width;

	            }
	    	});
	    	
	    	return w;
	    }
	    
	    public int getHeight(){
	    	w = 0;
	    	((View) t).post(new Runnable() {
	            @Override
	            public void run() {
	                int height = ((View) t).getMeasuredHeight();
	                w = height;
	            }
	    	});
	    	
	    	return w;
	    }
	    
	    private String getSufix(String id){
			id=id.trim();
			if(!id.isEmpty())
			if('*' == id.charAt(id.length() - 1))
			{
				id = id.substring(0, id.length() - 1);
				return id;
			}
			return null;
			
		}
		
		public List<Sview> getTableId(){
			
			Class aClass;
			LinkedList<Sview> list =new LinkedList<Sview>();
			try {
				aClass = Class.forName(activity.getPackageName()+".R$id");		
				Field[] ID_Fields = aClass.getFields();
				int[] resArray = new int[ID_Fields.length];
				for(int i = 0; i < ID_Fields.length; i++) {
			    
			        try {
						resArray[i] = ID_Fields[i].getInt(null);
						list.add(new Sview(ID_Fields[i].getName(),resArray[i]));
						
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				}
				return list;
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
			
			return null;
		}
		
		public List<Sview> getTableView(){
			
			LinkedList<Sview> list = new LinkedList<Sview>();
			ViewGroup myLayout = (ViewGroup) activity.getWindow().getDecorView().findViewById(android.R.id.content);
				
			addToTabView(list, myLayout);
			    
			
			return list;
		}
		
		private void addToTabView(List<Sview> list,ViewGroup myLayout){
			
			for( int i = 0; i < ((ViewGroup) myLayout).getChildCount(); i++ ){
				list.add(new Sview(myLayout.getChildAt(i),myLayout.getChildAt(i).getClass()));
				if(myLayout.getChildAt(i) instanceof ViewGroup)
					addToTabView(list,(ViewGroup) myLayout.getChildAt(i));
			}
			
		}
		
		private void getViewByType(String type){
			if(lv==null)
			lv = (LinkedList<Sview>) getTableView();
			LinkedList<View> li = new LinkedList<View>();
			for (Sview v : lv) {				
					if(v.type.getSimpleName().equals("TextView")){
						li.add(v.v);
					}	
			}
			
			if(li.size()!=0)
			t = (T) li;
		}
		
}
