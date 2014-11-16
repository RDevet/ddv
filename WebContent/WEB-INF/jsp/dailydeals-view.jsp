<!DOCTYPE html>
<html>
	<head>
	<title>RedAllure</title>

	<meta name="viewport" content="width=device-width, initial-scale=1"> 

	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>

<script type="text/javascript">
var tcinList;
</script>

<body>

<div data-role="page">

	<div data-role="header">
		<h1>daily deals</h1>
	</div><!-- /header -->

	<div data-role="content" align="center">	
		<p>Vote for 30% off.</p>		
	</div><!-- /content -->

     <div data-role="content" align="center" data-theme="d">
              <ul data-role="listview" data-theme="c">
                     <c:forEach items="${itemList}" var="item">
                      <li>
                      <a href="recommend.do?deptId=<c:out value="${deptId}" />&storeId=<c:out value="${storeId}" />&deptName=<c:out value="${deptName}" />&itemId=<c:out value="${item.listingid}" />&action=getItemDetails"><c:out value="${item.productdescription}" />
                            <img src="<c:out value="${item.imageURL}" />" />
                            <p><c:out value="${item.price}" /></p>
                      </a>
                      <a href="vote.do">Vote!</a>
                      </li>
                  </c:forEach>
           </ul> 
        </div>   
 
    <div data-role="footer" data-theme="d" align="center">
    © 2013 Target Corporation
    </div>
</div>   
</body>

</html>