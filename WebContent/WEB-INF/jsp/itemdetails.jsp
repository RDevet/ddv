<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Items</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="Rational Software Architect">

	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.css" />
	<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.js"></script>

	
</head>
<body>	
<div data-role="page">
	 <div data-role="header"  data-theme="a">
        <h1>RedAllure</h1>
    </div>
    
    <div data-role="content" data-theme="d">
     	<ul data-role="listview" data-inset="true" data-theme="d">
     		 <li>Category: <c:out value="${deptName}" /></li>
     	</ul> 
	    <ul data-role="listview" data-inset="true" data-theme="d" data-dividertheme="b">
	        <li data-role="list-divider"><c:out value="${item.title}" /></li>
	        <li>Price: <c:out value="${item.price}" /></li>
	        <li>Store: <c:out value="${storeId}" /></li>
	    </ul>
	 	<img src="<c:out value="${item.imageURL}"/>" />
	 </div>
	 
    <div data-role="footer" data-theme="d" align="center">
    © 2012 Target Corporation
    </div>
</div>    
</body>
</html>
