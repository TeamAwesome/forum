<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body class="home">
<div class="title">
    <span>Welcome Home</span>
</div>

<a href="https://twitter.com/share" class="twitter-share-button" data-text="Visit the forum for info on Bangalore -&gt; http://localhost:8080/app" data-size="large" data-count="none">Tweet</a>
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

</body>


</html>
