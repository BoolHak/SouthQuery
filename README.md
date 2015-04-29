# SouthQuery
This is a jQuery-like library fo android  to help write android apps faster.
With SQ,  Android Development becomes a piece of cake !  
<br>
<h1>SouthQuery Tutorial</h1>
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
* Select TextView That starts with txt<br>
`sq.get("txt*");`
