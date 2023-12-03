<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page import="com.spring.mugpet.domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>MugPet</title>
<style>
	#top {
		border-bottom: 1px solid black;
	}
	
	#inline {
		display: flex;
	}
	
	#title {
		text-align: center;
		font-size: 40px;
		font-weight: bold;
		width: 50%;
		display: inline-block;
		margin: 1% 20% 0 35%;
	}
	
	#logoImg {
		width: 50px;
		height: 50px;
	}
	
	#menu {
		text-align: right;
		font-size: 15px;
		width: 15%;
		display: inline-block;
		float: right;
		margin: 10px;
	}
	
	#search {
		text-align: right;
		padding: 0 10px 5px 0;
		width: 400px;
		margin-left: auto;
	}
	
	#searchBtn {
		height: 35px;
		width: 75px;
		background-color: #FFE593;
		border-color: #FFE593;
		color: white;
		font-weight: bold;
	}
	
	#body {
		display: flex;
	}
	
	#category {
		display: inline-block;
		position: fixed;
		width: 200px;
		height:628px;
		text-align: center;
		padding: 10px 0;
		float: left;
	}
	
	#categoryBtn {
		background-color: #FFD1FF; 
		border-color: #FFD1FF; 
		font-weight: bold; 
		margin-top: 20px;
	}
	
	#category_name {
		posigion: flex;
		width: 200px;
		line-height: 300%;
		font-weight: bold;
	}
	
	#subBody {
		display: inline-block;
		margin-left:200px;
		border-left:1px solid black;
	}
	
	#banner {
		display: flex;
		background-color: #FDFCE4;
		height: 275px;
		border-bottom: 1px solid black;
	}
	
	#comment {
		width: 400px;
		font-size: 18px;
		line-height: 230%;
		display: inline-block;
		padding: 70px 0 0 60px;
	}
	
	#comment_big {
		font-size: 30px;
		font-weight: bold;
	}
	
	#walk {
		width:250px;
		height:250px;
		margin: 10px 120px 0 auto;
	}
	
	#orderBy {
		text-align:right;
		padding:4px 28px 0 0;
	}
	
	#orderBtn {
		background-color:white;
		border-color:white;
		color:black;
	}
	
	#itemList {
		padding:0 45px;
		display:flex;	
	}
	
	#itemCard {
		display:inline-block;
		width:200px; 
		height:350px;
		margin:20px;
	}
	
	#itemImg {
		width:198px;
		height:198px;
	}
	
	#itemName {
		font-weight: bold;
		font-size: 15px;
	}
	
	#brand {
		font-size: 10px;
	}
	
	#price {
		font-size: 13px;
	}
	
	a {
		text-decoration: none;
		color: inherit;
	}
	/* link, visited, hover, active 순서대로 맞춰 쓸 것 */
	a:visited, a:hover, a:active {
		color: black;
	}
	
	* {
	  box-sizing: border-box;
	  margin: 0;
	  padding: 0;
	}
	:root {
	  --padding: 60px;
	}
	.box {
	  position: relative;
	  margin: 50px auto;
	  width: 400px;
	  display: flex;
	  flex-direction: column;
	  justify-content: center;
	  padding: var(--padding);
	  background-color: #c4dfff;
	  border-radius: 7px;
	}
	
	.box input,
	.box button {
	  padding: 15px;
	  font-size: 1.2em;
	  border: none;
	}
	.box input {
	  margin-bottom: 25px;
	}
	.box button {
	  background-color: #ffe4c4;
	  color: #547fb2;
	  border-radius: 4px;
	}
	
	.sign-up-box {
	  position: absolute;
	  width: 70px;
	  height: 70px;
	  border-radius: 50%;
	  background-color: #86acd9;
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  top: var(--padding);
	  right: -35px;
	  cursor: pointer;
	  transition: all 500ms ease-in-out;
	}
	.sign-up-box i {
	  font-size: 1.9em;
	  color: #fff;
	}
	
	/*.active*/
	
	.sign-up-box.active {
	  top: 0;
	  bottom: 0;
	  right: 0;
	  width: 100%;
	  height: 100%;
	  display: flex;
	  flex-direction: column;
	  justify-content: center;
	  align-items: stretch;
	  padding: 30px;
	  cursor: default;
	  border-radius: 7px;
	}
	
	.sign-up-box.active input,
	.sign-up-box.active button {
	  padding: 15px;
	  font-size: 1.2em;
	  border: none;
	  margin: 0;
	}
	.sign-up-box.active input {
	  margin-bottom: 10px;
	}
	
	.sign-up-box.active > span {
	  position: absolute;
	  width: 30px;
	  height: 30px;
	  background-color: #fff;
	  border-radius: 50%;
	  top: 5px;
	  right: 30px;
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  color: #547fb2;
	  font-weight: 700;
	  cursor: pointer;
	}

    .input-form {
      max-width: 680px;

      margin-top: 40px;
      margin-bottom: 40px;
        display: flex;
 	 	flex-direction: column;
  		justify-content: center;
      padding: 32px;
      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
      
	}
   
	a {
		text-decoration: none;
		color: inherit;
	}
	
	button {
 	 margin: 20px;
 	 outline: none;
	}
	.custom-btn {
	  width: 130px;
	  height: 40px;
	  padding: 10px 25px;
	  border: 2px solid #f9c6cf;
	  font-family: 'Lato', sans-serif;
	  font-weight: 500;
	  background: transparent;
	  cursor: pointer;
	  transition: all 0.3s ease;
	  position: relative;
	  display: inline-block;
	}
	
	.btn-1 {
 	 transition: all 0.3s ease;
	}
	.btn-1:hover {
	   box-shadow:
	   -7px -7px 20px 0px #fff9,
	   -4px -4px 5px 0px #fff9,
	   7px 7px 20px 0px #0002,
	   4px 4px 5px 0px #0001;
	}
	
	.frame {
  	width: 90%;
  	margin-top: 40px;
     margin-bottom: 40px;
  	text-align: center;
	}
   .profileplace{
    	display: flex;
     	justify-content: center;
		height:200px; 
		margin:0; 
		padding:0;
	}

}
</style>
</head>
<body>

	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="body"/>
	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>