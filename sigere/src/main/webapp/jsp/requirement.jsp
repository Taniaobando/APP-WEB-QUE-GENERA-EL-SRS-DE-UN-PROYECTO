<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
  Project:Sigere
  Developer:Verónica Tofiño
  Contact email: veronicatofino@gmail.com
  Creation date: 3/05/2019
  Last modification: 15/05/2019
  -->
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta charset="utf-8">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">	
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<title>Requerimiento: ${idFromUser }</title>
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
				padding:30px 0px 0px 100px;
        	}
/*-------------------------------------------------------------------------------------------------------------------------*/

/*------------------------------------------------- Navegation Bar -------------------------------------------------------*/
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
			  padding:40px 0px 20px 0px;
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
			.CreateSpecification{
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
/*------------------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------ Slideshow -------------------------------------------------------*/
			body {font-family: Verdana, sans-serif; margin:0}
			
			/* Slideshow container */
			.slideshow-container {
			  height: auto;
			  width:auto;
              position: relative;
              left:80px;
              
			}
			
			.mySlides {
              height: auto;
  			  width: auto;
			}
			
			.mySlides2 {
              height: auto;
  			  width: auto;
			}
			/* Next & previous buttons */
			.prev, .next {
			  cursor: pointer;
			  position: absolute;
			  width:2%;
			  top: 15%;
			  margin-top: -30px;
			  padding: 16px;
			  color: #888;
			  font-weight: bold;
			  font-size: 20px;
			  border-radius: 0 3px 3px 0;
			  user-select: none;
			  left:-50px;
			}
			
			/* Position the "next button" to the right */
			.next {
			  position: absolute;
  			  left: 450px;
  			  right: 0;
			  border-radius: 3px 0 0 3px;
			}
			
			/* On hover, add a black background color with a little bit see-through */
			.prev:hover, .next:hover {
			  background-color: rgba(0,0,0,0.8);
			  color: white;
			}
			table, th, td {
			  border: 1.5px solid black;
			  border-collapse: collapse;
			  background-color: rgba(255, 255, 255, 0.16);
			}
			th, td {
			  padding: 5px;
			  text-align: center;    
			}
			.btn3{
		        color: black;
		        font-size: 15px;
		        cursor: pointer;
				padding:0px 5px;    
				float: right;
				margin-right:100px;    
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
		</div>
		<div class="mainTitle" style="clear: both">
			<h2>Historial del requerimiento ${idFromUser }</h2>
			<h2 style="margin-left:200px">Especificación asociada</h2>
			<a id="spc" href="crearespecificacion?id=${id}"><button id="myBtn" class="btn3" onclick="disabled()">Agregar Esp.</button></a>
		</div>
		<hr />​
		<div class="slideshow-container">
			${requirements }
			${specifications }
			<a class="prev" onclick="plusSlides(-1)">❮</a>
			<a class="next" onclick="plusSlides(1)">❯</a>
			
		</div>
		
		
		<script>
			var slideIndex = 1;
			var tmp = 0
			var varNull = ${varNull};
			if (varNull.localeCompare("Null") == 0){
				tmp = 0;
			}else{
				tmp = 1;
			}	
		
			showSlides(slideIndex);
			
			function plusSlides(n) {
			  showSlides(slideIndex += n);
			}
			
			function currentSlide(n) {
			  showSlides(slideIndex = n);
			}
			
			function showSlides(n) {
			  var i;
			  var slides = document.getElementsByClassName("mySlides");
			  var slides2 = document.getElementsByClassName("mySlides2");
			  if (n > slides.length) {slideIndex = 1}    
			  if (n < 1) {slideIndex = slides.length}
			  for (i = 0; i < slides.length; i++) {
			      slides[i].style.display = "none";  
			      if (tmp == 1){
			    	slides2[i].style.display="none"; 
			      }
			      
			  }
			  slides[slideIndex-1].style.display = "block";  
			  if (tmp == 1){
			  	slides2[slideIndex-1].style.display="block";
			  }
			  
			}
		</script>
		<script>
			
			var varNull = ${varNull};
			var roleUser = ${roleUser};
			var type = ${type};
			if (varNull.localeCompare("notNull")==0){
				document.getElementById("myBtn").innerText="Editar Esp.";
				document.getElementById("spc").href="editarespecificacion?id="+${specificationId};
			}
			if (roleUser.localeCompare("observador")==0 || (type.localeCompare("RNF")==0)){
				document.getElementById('myBtn').disabled=true;
			}
		
		</script>
		
	</body>
</html> 
