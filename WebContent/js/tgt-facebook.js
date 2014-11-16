	function loginUser0() {
		document.getElementById("placeholder").innerHTML = "RedAllure is ready!";
	}


  window.fbAsyncInit = function() {
//    FB.init({ appId: '356391317759947', // localhost:8080
    FB.init({ appId: '237763859667425', // ral.target.cloudbees.net
    status: true, 
    cookie: true,
    xfbml: true,
    oauth: true});

    FB.Event.subscribe('auth.statusChange', handleStatusChange);	
  };

  function handleStatusChange(response) {
   document.body.className = response.authResponse ? 'connected' : 'not_connected';
  
   if (response.authResponse) {
     console.log(response);
     updateUserInfo(response);
     updateInterests();
   }
 }


  function uninstallApp() {
    FB.api({method: 'auth.revokeAuthorization'},
      function(response) {
        window.location.reload();
      });
  }

  
// Below 10:30 am code merge  
    function loginUser() {    
      FB.login(function(response) { }, {scope:'email,user_interests,user_likes,friends_interests,friends_likes'});  	
    }

    function updateUserInfo(response) {
      FB.api('/me', function(response) {
        document.getElementById('placeholder').innerHTML = '<img src="https://graph.facebook.com/' + response.id + '/picture">' + " " + response.name;
      });
    }


    function updateInterests() {
    FB.api('/me&fields=name,picture,interests', function(response) {
      console.log('Got interests: ', response);
      
      if (!response.error) {
        var markup = '';
        
        var interests = response.interests.data;
        
        for (var i=0; i < interests.length && i < 25; i++) {
          var interest = interests[i];
          
          markup += interest.name + '<br>';
        }
        
        document.getElementById('interests').innerHTML += markup;
      }
    });
  }
    
    
    function getUserFriends() {
        FB.api('/me/friends&fields=name,id,picture', function(response) {
          console.log('Got friends: ', response);
          
          if (!response.error) {
            var markup = '';
            
            var friends = response.data;
            
            for (var i=0; i < friends.length && i < 25; i++) {
              var friend = friends[i];
              
              markup += '<img src="' + friend.picture + '"> ' + friend.name + '<br>';
            }
            
            document.getElementById('user-friends').innerHTML = markup;
          }
        });
      }
