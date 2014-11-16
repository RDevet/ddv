<!DOCTYPE html>
<html>
	<head>
	<title>RedAllure</title>

	<meta name="viewport" content="width=device-width, initial-scale=1"> 

	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
	<script src=" http://connect.facebook.net/en_US/all.js"></script>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>

<script type="text/javascript">

</script>

<body>

<div id="fb-root"></div>

<div data-role="page">

	<div data-role="header">
		<h1>RedAllure</h1>
	</div><!-- /header -->

	<div data-role="content">	
		<p>Pick your friend to get gift recommendations</p>		
	</div><!-- /content -->


     <div data-role="content" align="center" data-theme="d">
       <ul data-role="listview" data-inset="true" data-theme="b">
               <li>Friends</li>
       </ul>
       <ul data-role="listview">
       <div id="friends"></div>     
       <script type="text/javascript">
        //var arr = [ {"id": "123", "Name":"John"}, {"id":"11", "Name": "Keith"}];

        function getUserFriends() {
            FB.api('/me/friends&fields=name,id,picture', function(response) {
              console.log('Got friends: ', response);
              
              if (!response.error) {
                var markup = '';
                console.log('data', response.data);
                
/*                var friends = response.data;
                
                for (var i=0; i < friends.length && i < 25; i++) {
                  var friend = friends[i];
                  
                  markup += '<li><p><img src="' + friend.picture + '"></img>' + friend.name + '</li><br>';
                }
                document.write(markup);
*/
                friendCount = response.data.length;

                for( i=0; i<response.data.length; i++) {

                  friendId = response.data[i].id;

                  markup += '<li><p><img src="' + response.data[i].picture + '"></img>' + response.data[i].name + '</li><br>';


                } //end_for
                console.log('markup', markup);
                document.getElementById("friends").innerHTML = markup;

              }
            });
          }
        
       
	      getUserFriends();
	      
	      console.log(getUserFriends());
		</script>         
		</ul>           
 	</div>
    <div data-role="footer" data-theme="d" align="center">
    © 2012 Target Corporation
    </div>
</div>   
</body>

</html><body>

</body>
</html>