<link rel="stylesheet" type="text/css" href="<c:url value='/static/css/style.css'/>">
<script src="<c:url value="/static/javascript/shareToSocialMedia.js"/>"></script>
<script src='http://connect.facebook.net/en_US/all.js'></script>
<div id="rightPane" align="center">
            <div id="tagCloud">
                TAG CLOUD
            </div>
            <div id="advertisement">ADVERTISEMENT</div>
            <div id='fb-root'>
                <p id='msg'></p>
                    <a onclick='postToFeed(); return false;'><img style="cursor: pointer; cursor: hand" src="<c:url value='/static/images/facebook.png'/>" alt="Facebook" class="Facebook Icon"></a>
                    <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://10.10.5.107:8080/forum" data-count="none" target="_blank"><img src="<c:url value='/static/images/twitter.png'/>"  alt="Twitter"></a>
            </div>
</div>