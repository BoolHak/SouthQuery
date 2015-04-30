# SouthQuery
This is a jQuery-like library for android  to help write android apps faster.
With SQ,  Android Development becomes a piece of cake !  
<br>
<h1>SouthQuery Tutorial</h1>
<a href="https://drive.google.com/file/d/0B1SvoJJn6KDNY2NUUC1ER3JIdTA/view?usp=sharing">DownLoad JAR</a>
## Constructor:
`S sq = S(this);`
## Selector:
(you can use it on TextView,Button,ImageView,EditText,ImageButton,RadioButton,CheckBox,View)
* Select a TextView:<br>
`sq.get("txt1");`<br>
`sq.get(R.id.txt1);`
<br>
* Select all TextViews:<br>
`sq.get("TextView");`<br>
* Select TextView from a view<br>
`sq.get(view,"txt1");`<br>
`sq.get("idView","txt1");`<br>
* Select TextView That starts with txt<br>
`sq.get("txt*");`
<br><br>(More selectors will be added soon)

## Text:
* Set text:<br>
`sq.get("btn1").text("Click me!!");`<br>
* Get Value:<br>
`String s = sq.get("txt1").txt();`<br>
`float f = sq.get("txt1").toFloat();`<br>
`int i = sq.get("txt1").toInt();`<br>
`Boolean b = sq.get("txt1").toBool();`<br>
* Change text color:<br>
`sq.get("txt1").color(Color.WHITE);`<br>
`sq.get("txt1").color("#ffffff");`<br>

## Image:
* Set background color:<br>
`sq.get("btn1").bg(Color.WHITE);`<br>
`sq.get("btn1").bg("#ffffff");`<br>
* Set Image:<br>
`sq.get("imageView1").image("image");`<br>
`sq.get("imageView1").image("http:\\");`<br>

## Size and position:
* Screen width and height:<br>
`int w = sq.sWidth();`<br>
`int h = sq.sHeight();`<br>
* Set width, height and position:<br>
`sq.get("btn1").width(sq.sWidth()).height(500).X(15).Y(10);`<br>

## Web functions:
* Http get/post:<br>
`String s = sq.httpGet(url);`<br>
`String s = sq.httpPost(url);`<br>
* Post data to the server:<br>
`List<NameValuePair> l = new LinkedList<NameValuePair>();`<br>
`l.add(new BasicNameValuePair("id", "12345"));`<br>
`HttpResponse response = sq.post(url,l);`<br><br>
* Download file:<br>
`sq.downloadNative(downloadUrl);`<br>
(using a service)<br>
`sq.download(downloadUrl);`<br>
* Open browser: <br>
`sq.browser("google.com");`<br>

## Events:
* Click:<br>
`sq.get("btn1").click("functionName")`<br>
(functionName is the name of the function that will be called on click should be public in the activity class)<br>
`sq.get("btn1").click(listener)`<br>
* Touch:<br>
`sq.get("btn1").touch(listener)`<br>
* On:<br>
`sq.get("btn1").on("touchdown","functionName");`<br>
`sq.get("btn1").on("touchup","functionName");`<br>
`sq.get("btn1").on("move","functionName");`<br>
`sq.get("btn1").on("click","functionName");`<br>
`sq.get("btn1").on("longclick","functionName");`<br>

## File:
* Load File:<br>
`String s = sq.loadFileAsString("filename");`<br>
* Select a File:<br>
`sq.selectFile("txt");`<br>
* Select a Directory:<br>
`sq.selectDir();`<br>

## Threads:
* Thread:<br>
`sq.thread("after", "background");`<br>
`sq.thread(Handler, "background");`<br>
* Delay:<br>
`sq.delay(2000, "after");`<br>

## Navigation:
* Go to an other activity:<br>
`sq.to("nameActivity");`<br>
* Splash activity:<br>
`sq.splash(time, "nextActivity")` <br>

## Visibility:
* Show:<br>
`sq.get("txt1").show();`<br>
* Hide:<br>
`sq.get("txt1").hide();`<br>
* Toggle:<br>
`sq.get("txt1").toggle();`<br>

## Toast,Alert,Progress,Notification:
* Toast:<br>
`sq.toast("short toast");`<br>
`sq.Ltoast("long toast");`<br>
* Alert:<br>
`sq.alert("This is an alert!!");`<br>
`sq.alert("Title","This is an alert!!");`<br>
`sq.alert("ic_launcher","Title","This is an alert!!");`<br>
* Progress:<br>
`sq.progress(true);`<br>
`sq.progress(true,"Loading");`<br>
`sq.progress(false);`<br>
* Notification:<br>
`sq.notify("ic_launcher","title","subject","body");`,<br>

## Other functions:
* Bluetooth:<br>
`sq.bluetooth(true);`<br>
`sq.bluetooth(false);`<br>
* Wifi:<br>
`sq.wifi(true);`<br>
`sq.wifi(false);`<br>
* Call:<br>
`sq.call("123456");`<br>
* Sms:<br>
`sq.sms(sq.getPhoneNumber(),"Hello!");`<br>
* Mail:<br>
`sq.mail("boolhak@gmail.com", "Hello", "Hello southapps !!");`<br>
* Camera:<br>
`sq.camImg(code);`<br>
`sq.camVid(code);`<br>
* Gallery:<br>
`sq.gallery(code);`<br>
* Mac Address:<br>
`sq.macAddress("interfaceName");`<br>
* IP Address:<br>
`sq.ip(true);// IPv4`<br>
`sq.ip(false);// IPv6`<br>
* IMEI, UUID:<br>
`sq.imei();`<br>
`sq.uuid();`<br>
* Vibrate:<br>
`sq.vibrate(200);`<br>
* Is a Tablet<br>
`sq.isTablet();`<br>
* Hide keyborad<br>
`sq.hideKeyborad();`<br>
* Is Checked<br>
`Boolean b = sq.get("checkbox1").isChecked();`<br>
* Check Email:<br>
`Boolean b = sq.checkEmail("boolhak@gmail.com");`<br>
* device Name:<br>
`String s = sq.deviceName();`<br>
* Reload Activity:<br>
`sq.reload();`<br>



