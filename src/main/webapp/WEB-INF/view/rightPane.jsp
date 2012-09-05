<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/css/style.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/static/css/jqcloud.css'/>">
<script src="<c:url value='/static/javascript/jqcloud-1.0.1.js'/>"></script>
<script src="<c:url value='/static/javascript/jqcloud-1.0.1.min.js'/>"></script>
<script src="<c:url value='/static/javascript/tagcloud.js'/>"></script>

<div id="rightPane" align="center">
            <div id="wordcloud">
             Tag Cloud
            </div>
            <div id="advertisement">ADVERTISEMENT</div>
            <div id='fb-root'>
                <p id='msg'></p>
                <p>
                <a onclick='postToFeed(); return false;'><img style="cursor: pointer; cursor: hand"
                src="<c:url value='static/images/facebook.png'/>" alt="Facebook" class="Facebook Icon"></a>
                <a href="https://twitter.com/share" data-url="http://10.10.5.107:8080/forum/"
                data-text="Need info on Bangalore?" data-size="large" data-count="none" target="_blank">
                <img src="<c:url value='static/images/twitter.png'/>" alt="Twitter" style="border-style: none"></a>
                </p>
            </div>
</div>

