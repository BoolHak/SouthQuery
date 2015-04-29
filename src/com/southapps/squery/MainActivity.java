package com.southapps.squery;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.southapps.squery.utility.S;



public class MainActivity extends Activity {

	S sq = new S(this);
	String s;
	
	Boolean b = false;
	final String urlimage ="https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-xtp1/v/t1.0-9/11164715_926372587394219_8196576243889308510_n.png?oh=5411330818af45e18d37fe4c44542b18&oe=55E30025&__gda__=1440192275_79615beacdc4d995553c4514ae5f9706";
	final String urlimage1 ="";
	final String urlimage2 ="https://scontent-mrs.xx.fbcdn.net/hphotos-xtp1/v/t1.0-9/10923389_817927704908954_5631198503391126823_n.jpg?oh=1f8916b63d13ea32fc6b27054289a191&oe=55D1E986";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		sq.get("imgurl").image(urlimage).width(sq.sWidth()).height(sq.sWidth());
		sq.get("imgurl1").image("icon").width(sq.sWidth()).height(sq.sWidth());
		sq.get("imgurl2").image(urlimage2).width(sq.sWidth()).height(sq.sWidth());
		
		sq.get("btntest").text("test me :D").click(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				testfun();
			}
		}).on("longclick", "toweb");
		
		sq.get("btnlist").text("View list view exemples").click("tolist");
		
		sq.get("btnweb").text("Web Functions").click("toweb");
		
		sq.get("btnevent").text("Events in SQuery").click("toanother");
		
		sq.get("btnfile").text("File Managment").click("tofile");
		
		sq.get("btn1").text("Toggle text").click("toggle");
		sq.get("txt1").text("sq.get(\"txt1\").toogle();").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn2").text("Show toast").click("toast");
		sq.get("txt2").text("sq.toast(\"This is SouthQuery\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn3").text("Show alert").width(sq.sWidth()).click("alert");
		sq.get("txt3").text("sq.alert(\"ic_launcher\",\"Danger!!\",\"This is SouthQuery\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn4").text("Change text, color, background").click("change");
		sq.get("txt4").text("sq.get(\"txt4\").text(\"Text changed !!!\").color(\"#e74c3c\").bg(\"#34495e\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn5").text("Go to an other activity").click("toanother");
		sq.get("txt5").text("sq.to(\"OtherActivity\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn6").text("Get a float from TextView").click("getfloat");
		sq.get("txt6").text("float f = sq.get(\"txt6_1\").toFloat()/7;\nsq.alert(\" \"+f);").color(Color.BLACK).bg(Color.WHITE);
		sq.get("txt6_1").text("12546.6");
		
		sq.get("btn7").text("Show Progress").click("progress");
		sq.get("txt7").text("sq.progress(true,\"Loading...\").delay(2000, \"cancelProgress\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn8").text("Get String from string xml").click("getString");
		sq.get("txt8").text("sq.alert(sq.getS(\"app_name\"));").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn9").text("Notification").click("notif");
		sq.get("txt9").text("sq.notify(\"ic_launcher\",\"title\",\"subject\",\"body\");").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn10_1").text("bluetooth On").click("bon").width(sq.sWidth()/2);
		sq.get("btn10_2").text("bluetooth Off").click("boff").width(sq.sWidth()/2);
		sq.get("txt10").text("sq.bluetooth(true);//sq.bluetooth(false);").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn11_1").text("wifi On").click("won").width(sq.sWidth()/2);
		sq.get("btn11_2").text("wifi Off").click("woff").width(sq.sWidth()/2);
		sq.get("txt11").text("sq.wifi(true);//sq.wifi(false);").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn12_1").text("take pic").click("cami").width(sq.sWidth()/3);
		sq.get("btn12_2").text("take video").click("camv").width(sq.sWidth()/3);
		sq.get("btn12_3").text("Gallery").click("gal").width(sq.sWidth()/3);
		sq.get("txt12").text("sq.camImg(1);//sq.camVid(2);//sq.gallery(3);").color(Color.BLACK).bg(Color.WHITE);
		
		sq.get("btn13_1").text("Call").click("call").width(sq.sWidth()/3);
		sq.get("btn13_2").text("SMS").click("sms").width(sq.sWidth()/3);
		sq.get("btn13_3").text("Mail").click("mail").width(sq.sWidth()/3);
		sq.get("txt13").text("sq.call(\"123456\");\nsq.sms(sq.getPhoneNumber(),\"Hello!\");\nsq.mail(\"boolhak@gmail.com\", \"Hello\", \"Hello southapps\");").color(Color.BLACK).bg(Color.WHITE);
		
		
	}
	
	public void testfun(){
		
		sq.get("TextView").color(Color.CYAN);
		sq.get("txt1*").color(Color.RED);
		
	}
	
	public void testfun2(){
		

	}
	
	public void call(){
		sq.call("123456");
	}
	public void sms(){
		sq.sms(sq.getPhoneNumber(),"Hello!");
	}
	public void mail(){
		sq.mail("boolhak@gmail.com", "Hello", "Hello southapps");
	}
	
	public void cami(){
		sq.camImg(1);
	}
	public void camv(){
		sq.camVid(2);
	}
	public void gal(){
		sq.gallery(3);
	}
	
	
	public void won(){
		sq.wifi(true);
	}
	
	public void woff(){
		sq.wifi(false);
	}
	
	public void bon(){
		sq.bluetooth(true);
	}
	
	public void boff(){
		sq.bluetooth(false);
	}
	
	public void notif(){
		sq.notify("ic_launcher","title","subject","body");
	}
	public void getString(){
		sq.alert(sq.getS("app_name"));
	}
	
	public void toggle(){
		sq.get("txt1").toogle();
	}
	
	public void toast(){
		sq.toast("This is SouthQuery");
	}
	
	public void alert(){
		sq.alert("ic_launcher","Danger!!","This is SouthQuery");
		
	}
	
	public void change(){
		
		if(!b){
		sq.get("txt4").text("Text changed !!!").color("#e74c3c").bg("#34495e");
		b=true;
		}else{
			b=false;
			sq.get("txt4").text("sq.get(\"txt4\").text(\"Text changed !!!\").color(\"#e74c3c\").bg(\"#34495e\");").color(Color.BLACK).bg(Color.WHITE);
		}
		
	}
	
	public void toanother(){
		sq.to("OtherActivity");
	}
	
	public void toweb(){
		sq.to("WebUitl");
	}
	
	public void tolist(){
		sq.to("ListExample");
	}
	
	public void tofile(){
		
		sq.selectFile(null);
	}
	
	public void getfloat(){
		float f = sq.get("txt6_1").toFloat()/7;
		sq.alert(" "+f);
	}
	
	public void progress(){
		sq.progress(true,"Loading...").delay(2000, "cancelProgress");
	}
	
	public void cancelProgress(){
		sq.progress(false);
	}
	
	
	

}
