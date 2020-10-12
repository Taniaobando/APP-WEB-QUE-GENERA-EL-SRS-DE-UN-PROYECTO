<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
  Project:Sigere
  Developer:Verónica Tofiño
  Contact email: veronicatofino@gmail.com
  Creation date: 12/05/2019
  Last modification: 15/05/2019
  -->

<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">	
	    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<title>Miembros</title>
	<style>
		.w3-bar{
			background-color:white;
		}
		
		.centerThis{
  			float:center;
  			padding:0px 200px;
		}
		
		.AddMember{
			float:right;
			padding: 0px 200px;
			font-size:200%;
		}
	/*----------------------------------------------------- General ---------------------------------------------------------*/
		body {
	      font-family: Arial, sans-serif;
	      font-family: Calibri, sans-serif;
		  font-family: 'Roboto Condensed', sans-serif;
	      background-color:#f1f1f1;
	    }
	      
		html,body,header,h1,a,p {
			padding:0;
			margin:0;
		}
		
		a:link,
        a:visited{
	        color:Black;
	        font:Arial,bold;
	    	text-decoration:none;
	        	
	    }
	/*----------------------------------------------------------------------------------------------------------------------*/
	
	/*----------------------------------------------------- Navegation Bar --------------------------------------------------*/
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
			
		.btn, .btn:hover {
	       background-color:#333;
	       border: none;
	       color: white;
	       font-size: 20px;
	       cursor: pointer;
	       float:bottom;
	    }
	    
	    .bttn, .bttn:hover {
	       background-color:red;
	       border: none;
	       color: black;
	       font-size: 20px;
	       cursor: pointer;
	       float:bottom;
	    }
	        
	    :focus {
	  	   outline: none;
		}
		
		.row {
			margin-right: 0;
			margin-left: 0;
		}
			
	/*-----------------------------------------------------------------------------------------------------------------------*/
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
	  	 	<img src="https://i.ibb.co/YZsKKwR/gato-Blanco.png"" width="170" height="60">
	  	 	<div class="dropdown">
	  			<button class="dropbtn">Bienvenido,${firstnameAct}  <i class="fa fa-caret-down"></i></button>
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
		
			<div class="w3-container">
	        	<div class="row">
		        	<div class="MainTitle">
				  		<h2>Miembros del proyecto</h2>
				  	
				  	<div class="AddMember">
				  		<i id="myBtn" class="fa fa-plus-square" aria-hidden="true"></i>
				  	</div>
				  	</div>
				  
			  	</div>
			  	
				<div class="centerThis">	  
				  <ul class="w3-ul w3-card-4">
				    ${members}
				  </ul>
			     </div>
				
			</div>
			<!-- The Modal -->
			<div id="myModal" class="modal">
			<form:form id="getMember" action="añadirmiembro" method="post">
			  <!-- Modal content -->
			  <div class="modal-content">
			    <div class="modal-header">
			      <span class="close">&times;</span>
			      <h2>Agregar Miembro</h2>
			      
			    </div>
			    <div class="modal-body" style="text-align:center">
			    	<div class="row">
   	 					<label for="email"><b>Email</b></label>
    					<input type="text" placeholder="Escriba el email..." name="email" class="form-control" required>
								
    				</div>
    				<div class="row">
    					<label for="role"><b>Rol</b></label>
    				</div>
    				<div class="row">
    					<select name="role" class="form-control">
			                    <option value="participante">Participante</option>
			                    <option value="observador">Observador</option>
	                    </select>
					</div>
					<input type="hidden" id="projId" name="projectId">
			    </div>
			    <div class="modal-footer">
			      <button type="submit" class="btn ">Agregar</button>
			      <button type="button" class="btn cancel" onclick="closeForm()">Cancelar</button>
			    </div>
			    <p>${message}</p>			    
			  </div>
			  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
			  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
			  <script>
			  	function getQueryVariable(){
					var query = window.location.search.substring(1);
					var vars = query.split("&");
					for (var i=0;i<vars.length;i++) {
						var pair = vars[i].split("=");
					    if(pair[0] == "id")
					    	var id=pair[1];
						   	{return id}
						}
						return(false);
				}
			  	document.getElementById("projId").value=getQueryVariable();
			  </script>
			</form:form>
			</div>
		<script>
		//All the code related whit the Pop Up or modal was taked from= https://www.w3schools.com/howto/howto_css_modals.asp
			// Get the modal
			var modal = document.getElementById('myModal');
			var rolUser= ${rolUser};
			// Get the button that opens the modal
			var btn = document.getElementById("myBtn");
			
			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];
			
			// When the user clicks the button, open the modal 
			btn.onclick = function() {
				if (rolUser.localeCompare("admin") == 0){
				  modal.style.display = "block"; 
			  	}else{
			  		alert("¡Accesso denegado!\n Sólo el administrador puede agregar miembros al proyecto.");
			  	}  
			}
			
			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
				modal.style.display = "none"; 
			}
			
			
		</script>
		<script>
			
			function closeForm() {
			  document.getElementById("myModal").style.display = "none";
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
		if (isEmpty(mssg)){
			document.getElementById("myModal").style.display = "none";
		}else{
			document.getElementById("myModal").style.display = "block";
		}
		</script>
	</body>
</html>