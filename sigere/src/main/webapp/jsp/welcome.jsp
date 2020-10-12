<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
  Project:Sigere
  Developer:Verónica Tofiño
  Contact email: veronicatofino@gmail.com
  Creation date: 29/04/2019
  Last modification: 15/05/2019
  -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">	
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    
 
	
	<title>Bienvenido</title>
	<style>
		
/*--------------------------------------------- General ------------------------------------------------------------------*/	
		body {
          font-family: Arial, sans-serif;
          background-color:#f1f1f1;
          
        }
        
		html,body,header,h1,a,p {
			padding:0;
			margin:0;
		}
		.btn3{
		    color: black;
		    font-size: 15px;
		    cursor: pointer;
			margin-left: 650px;		        
		}
/*-------------------------------------------------------------------------------------------------------------------------*/
/*---------------------------------------------- Navegation Bar -----------------------------------------------------------*/
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
			.CreateProject{
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
/*-------------------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------- Main content ----------------------------------------------------------*/
		.row {
          margin: 10px -16px;
        }
        
        
        /* Add padding BETWEEN each column */
        .row,
        .row > .column {
          padding: 8px;
        }
        /* Create four equal columns that floats next to each other */
        .column {
          float: left;
          width: 25%; 
        }
        a:link,
        a:visited{
        	color:Black;
        	font:Arial,bold;
        	text-decoration:none;
        	font-size:110%;
        }

        /* Clear floats after rows */ 
        .row:after {
          content: "";
          display: table;
          clear: both;
        }
        /* Content */
        .content {
          background-color: white;
          padding: 10px;
          margin:auto;
        }
        
		.main {
		  max-width: 960px;
		  margin:0px 100px;
		}
/*------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------- Pop up ------------------------------------------------------------------*/
	/* The Modal (background) */
		/* The Modal (background) */
		.modal {
			display:none;
		    position: fixed;
		    z-index: 1;
		    left: 0;
		    top: 0;
		    width: 100%;
		    height: 100%;
		    overflow: auto;
		    background-color: rgba(0,0,0,0.4);
		}
		#navbar  #popup a {
			float:none;
		}
		
		/* Modal Content */
		.modal-content {
		    background-color: #fefefe;
		    margin: 4% auto 15% auto;
		    border: 1px solid #888;
		    width: 40%; 
			padding-bottom: 30px;
		}
		
		/* The Close Button (x) */
		.close {
		    position: absolute;
		    right: 25px;
		    top: 0;
		    color: #000;
		    font-size: 35px;
		    font-weight: bold;
		}
		.close:hover,.close:focus {
		    color: red;
		    cursor: pointer;
		}
		
		/* Add Zoom Animation */
		.animate {
		    animation: zoom 0.6s
		}
		@keyframes zoom {
		    from {transform: scale(0)} 
		    to {transform: scale(1)}
		}
		
		p{
			color:red;
			padding:0px 5px;
		}
		
	/*-----------------------------------------------------------------------------------------------------------------------*/
		</style>
	</head>
<body>
  	<div id="navbar" class="my-header">
  	 	<img src="https://i.ibb.co/YZsKKwR/gato-Blanco.png" width="170" height="60">
  	 	<div class="dropdown">
	  		<button class="dropbtn">Bienvenido,${firstname}  <i class="fa fa-caret-down"></i></button>
	  		<div class="dropdown-content">
	        <!--   <div class="Profile">
	             <button class="button">Perfil del Usuario</button>
	          </div> -->
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
  	 	<div class="search-container">
			<form:form id="find" action="buscarproyecto" method ="get">
			<input id="searched" type="text" placeholder="Buscar" name="search" onkeyup="success()">

			<!--  <input id ="searched" type="text" placeholder="Buscar" name="search">-->
			<button id= "buttonGlass" type="submit" disabled><i class="fa fa-search lupa"></i></button>
			<div id="myModal" class="modal">
				      <!-- Modal content -->
				  <div class="modal-content">
				    <div class="modal-header">
				    	<span class="close">&times;</span>
				        
				      <h2>Resultados</h2>
				      
				    </div>
				    <div id= "popup" class="modal-body" style="text-align:center">
				    	<ul style="list-style-type:none;">
				    		${results}
				    	</ul>
				    </div>
				  </div>
				  
				
	    	</div>
	    	</form:form>
		</div>
	</div>
	<div class="main">
		<div class="Zone">
			<p style="font-size:150%; color:rgb(0,0,0); padding-top:30px;display: inline-block"> Tus proyectos:</p>
			<a href="crearproyecto?"><button class="btn3">Agregar Proyecto</button></a>
						 	
		</div>
		
		
		 <div class="row">
			 ${projects}
	         
	  	</div>
	 </div>

	 <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	 <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script>
			var modal = document.getElementById('myModal');

			var span = document.getElementsByClassName("close")[0];

			span.onclick = function() {
				modal.style.display = "none"; 
			}
	 	
	 	</script>
	 	
	 	<script>
	 	function success() {
	 		 if(document.getElementById("searched").value==="") { 
	 	            document.getElementById('buttonGlass').disabled = true; 
	 	        } else { 
	 	            document.getElementById('buttonGlass').disabled = false;
	 	        }
	 	    }

	 	</script>
	 	
	 	<script>
		function isEmpty(obj) {
		    for(var key in obj) {
		        if(obj.hasOwnProperty(key))
		            return false;
		    }
		    return true;
		}
		var mssg = ${message};
		if (mssg == 'null'){
			document.getElementById("myModal").style.display = "none";
		}else{
			document.getElementById("myModal").style.display = "block";
		}
		</script>	 
	 
		
</body>
</html>