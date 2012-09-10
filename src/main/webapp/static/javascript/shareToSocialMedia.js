FB.init({appId: "384033571663513", status: true, cookie: true});

function postToFeed() {

    // calling the API ...
    var obj = {
      method: 'feed',
      link: window.location.href,
      picture: '<c:url value="/static/images/facebook.png"/>',
      name: 'The Forum',
      caption: 'Info on Bangalore',
      description: 'Seek and share answers about Bangalore.'
    };

    FB.ui(obj);
}

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





