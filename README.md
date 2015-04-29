# SouthQuery
This is a jQuery-like library fo android  to help write android apps faster.
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
* On:<br>
`sq.get("btn1").on("touchdown","functionName");`<br>
`sq.get("btn1").on("touchup","functionName");`<br>
`sq.get("btn1").on("move","functionName");`<br>
`sq.get("btn1").on("click","functionName");`<br>
`sq.get("btn1").on("longclick","functionName");`<br>

