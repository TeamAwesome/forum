<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<html>
<head>
    <title>Welcome</title>
    <meta property="og:title" content="The Forum" />
    <meta property="og:type" content="city" />
    <meta property="og:url" content="http://localhost:8080/app/" />
    <meta property="og:image" content="" />
    <meta property="og:site_name" content="The Forum" />
    <meta property="fb:app_id" content="126401650838612" />

</head>
<body class="home">
<div class="title">
    <span>Welcome Home</span>
</div>

<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_GB/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<script>
    !function(d,s,id){
        var js,fjs=d.getElementsByTagName(s)[0];
        if(!d.getElementById(id)){
            js=d.createElement(s);
            js.id=id;
            js.src="//platform.twitter.com/widgets.js";
            fjs.parentNode.insertBefore(js,fjs);
            }
        }
    (document,"script","twitter-wjs");
</script>


<p><a href="https://twitter.com/share" class="twitter-share-button" data-text="Visit the forum for info on Bangalore -&gt; http://localhost:8080/app" data-size="large" data-count="none">Tweet</a></p>

<p><div class="fb-like" data-href="http://localhost:8080/app" data-send="false" data-width="450" data-show-faces="true" data-action="recommend"></div></p>

</body>


</html>
