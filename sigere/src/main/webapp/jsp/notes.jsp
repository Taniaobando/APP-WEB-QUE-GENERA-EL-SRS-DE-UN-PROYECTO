<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
  Project:Sigere
  Developer:Verónica Tofiño
  Contact email:veronicatofino@gmail.com
  Creation date: 15/05/2019
  Last modification: 18/05/2019
  -->
 <!doctype html>
<html>
	<head>
	    <title>Tus notas</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
		<style>
/*----------------------------------------------------- General ---------------------------------------------------------*/
			body {
		      font-family: Arial, sans-serif;
		      font-family: Calibri, sans-serif;
			  font-family: 'Roboto Condensed', sans-serif;
		      background-color:#f1f1f1;
		    }
		    * {box-sizing: border-box}
			
		      
			html,body,header,h1,a,p {
				padding:0;
				margin:0;
			}
			
		    .mainTitle{
				padding:30px 0px 0px 130px;
        	}
/*----------------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------- Navegation Bar -------------------------------------------------------*/
			.lupa{
				color:white;
			}
			#navbar {
			  overflow: hidden;
			  background-color: #333;
			  height:150%;
			}		
			#navbar a {
			  float: left;
			  display: block;
			  color: #333;
			  text-align: center;
			  padding: 8px 15px;
			  text-decoration: none;
			  font-size: 17px;
			}
				
			.MainTitle{
		      font-family:Arial,bold;
			  padding:40px 0px;
		    }
		        
			h2 { 
			  display: inline;
			  text-align:left;  
			  color:black; 
			  font-family:Arial,bold;
			  padding:40px 0px;
			}
		
			      
			*{
			  box-sizing: border-box;
			}
					
			.search-container {
			  float: right;
			}
				
			.log-out {
			  float: right;
			}
				
			input[type=text] {
			  padding: 6px;
			  margin-top: 8px;
			  font-size: 17px;
			  border: none;
			}
				
			.search-container button {
			  float: right;
			  padding: 6px 10px;
			  margin-top: 8px;
			  margin-right: 16px;
			  background:#990000;
			  font-size: 17px;
			  border: none;
			  cursor: pointer;
			}
				
			.search-container button:hover {
			  background: #800000;
			}
				
			.content {
			  background-color: white;
			  padding: 10px;
			  margin:auto;
			 }
			        
					
			.dropbtn {
			  background-color: #333;
			  color: white;
			  padding: 16px;
			  font-size: 16px;
			  border: none;
			  cursor: pointer;
			  float:right;
			}
					
			.dropdown {
			  float:right;
			}
					
			.dropdown-content {
			  display: none;
			  position:relative;
			  background-color: #595959;
			  min-width: 160px;
			  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
			  z-index: 1;
			}
					
			.dropdown-content a {
			  color: white;
			  padding: 12px 16px;
			  text-decoration: none;
			  display: block;
			  background-color: #595959;
			}
					
			.dropdown-content a:hover 
				{background-color: #595959;}
			
			.dropdown:hover .dropdown-content {
			  display: block;
			}
					
			.dropdown:hover .dropbtn {
			  background-color: #333;
			}
			
			.button,.button:hover,.button:focus {
			  background-color:#333;
			  border: none;
			  color: white;
			  padding: 15px 32px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 16px;
			  cursor: pointer;
			  float: right;
			}
			.SendNewNote{
			  float: right;
			  overflow: hidden;
			  color:white;
			}
					
			.btn, .btn:hover {
			  background-color:#333;
			  border: none;
			  color: white;
			  font-size: 20px;
			  cursor: pointer;
			  float: bottom;
			}
			:focus {
			  outline: none;
			}
				
			.row {
			  margin-right: 0;
			  margin-left: 0;
			}		
/*---------------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------- Notes ------------------------------------------------------------------*/
			
			
			ul li h2{
			  font-size:140%;
			  font-weight:bold;
			  padding-bottom:10px;
			}
			ul li p{
			  font-family:"Reenie Beanie",arial,sans-serif;
			  font-size:100%;
			}
			ul,li{
			  list-style:none;
			}
			h3{
				padding:10px 0px 0px 40px ;
				font-size:180%;
			}
			ul {
			  overflow:hidden;
			  padding:3em;
			}
			ul li{
			  text-decoration:none;
			  color:#000;
			  background:#ffc;
			  display:block;
			  height:15em;
			  width:15em;
			  padding:1em;
			}
			ul li{
			  margin:1em;
			  float:left;
			}
/*------------------------------------------------------------------------------------------------------------------------*/
		</style>
	</head>
	<body>
	  	<div id="navbar" class="my-header">
	  	 	<img src="https://i.ibb.co/YZsKKwR/gato-Blanco.png" width="170" height="60">
	  	 	<div class="dropdown">
	  			<button class="dropbtn">Bienvenido,${firstname}  <i class="fa fa-caret-down"></i></button>
	  			<div class="dropdown-content">
	    			<div class="Profile">
						<form action="perfil">
					   		<button class="button">Perfil del Usuario</button>
					   	</form>
					</div>
	                <div class="Log-out">
	                      <form action="salir" method="get">
	                          <button class="button">Cerrar Sesión</button>
	                      </form>
	               </div>
	    		</div>
			</div>
			<div class="SendNewNote">
	            <a href="enviarnota?id=${id}"><button class="btn"><i class="fa fa-paper-plane"></i></button></a>
			</div>
		</div>
		<div class="title">
		<h3>Tus notas: </h3>
		</div>
	  	<ul>
	  		${notes}
	    </ul>
	</body>
</html>
	