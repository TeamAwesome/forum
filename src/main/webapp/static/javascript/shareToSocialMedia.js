FB.init({appId: "126401650838612", status: true, cookie: true});

function postToFeed() {

    // calling the API ...
    var obj = {
      method: 'feed',
      link: window.location.href,
      picture: 'http://fbrell.com/f8.jpg',
      name: 'The Forum',
      caption: 'Info on Bangalore',
      description: 'Seek and share answers about Bangalore.'
    };

    function callback(response) {
     if (response && response.post_id) {
           alert('Post was published.');
         } else {
           alert('Post was not published.');
         }
    }
    FB.ui(obj, callback);
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