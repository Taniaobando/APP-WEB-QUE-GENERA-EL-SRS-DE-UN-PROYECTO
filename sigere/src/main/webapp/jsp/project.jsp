<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
  Project:Sigere
  Developer:Tania Obando, Verónica Tofiño
  Contact email:taniaobando1998@gmail.com,veronicatofino@gmail.com
  Creation date: 29/04/2019
  Last modification: 05/06/2019
  -->
<!doctype html>
<html>
	<head>
	    <title>Proyecto: ${name}</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
		<style>
		.lupa{
			color:white;
		}
		
/* --------------------------------------- Calendar --------------------------------------------------------------------------*/
		 .btn2{
	        color: black;
	        font-size: 20px;
	        cursor: pointer;
	        float:right;
		 	margin-right:160px;
		 }
		 .cld-main{
		   width: 660px;
		  }
		  .cld-main a{
			color: #7B00FF;
		  }
		  
		  .cld-datetime{
		    position: relative;
		    width: 66%;
		    min-width: 100px;
		    max-width: 300px;
		    margin: auto;
		    overflow: hidden;
		  }
		  .cld-datetime .today{
			    position: relative;
			    float: left;
			    width: calc(100% - 40px);
			    margin: auto;
			    text-align: center;
		  }
		  .cld-nav{
			    position: relative;
			    width: 20px;
			    height: 20px;
			    margin-top: 2px;
		  }
		  .cld-nav:hover{
			    cursor: pointer;
		  }
		  .cld-nav:hover svg{
			      fill: #666;
		  }
		  .cld-rwd{
			    float: left;
		  }
		  .cld-fwd{
			    float: right;
		  }
		  .cld-nav svg:hover{
		   }
		  .cld-labels, .cld-days{
			  padding-left: 0;
		  }
		  .cld-label, .cld-day{
		    box-sizing: border-box;
		    display: inline-block;
		    width: 14.28%;
		    text-align: center;
		 }
		 .cld-day{
		    display: block;
		    float: left;
		    position: relative;
		    margin: 0;
		    padding: 5px;
		    height: 66px;
		    border: 1px solid #ddd;
		    overflow-y: auto;
		 }
		 .cld-day.clickable:hover{
		    cursor: pointer;
		 }
		 .cld-day.today{
		    border: 1px solid #7B00FF;
		 }
		 .cld-day.disableDay{
		    opacity: 0.5;
		 }
		 .cld-day.nextMonth, .cld-day.prevMonth{
		    opacity: 0.33;
		 }
		 .cld-number{
		    margin: 0;
		    text-align: left;
		 }
		 .cld-title{
		    font-size: 10px;
		    display: block;
		    margin: 0;
		    font-weight: normal;
		 }
		 .cld-day:hover{
		    background: #eee;
		 }
		 .cld-number.eventday{
		    font-weight: bold;
		 }
		 .cld-number.eventday:hover{
		   background: #eee;
		 }
		  .today .cld-number.eventday:hover{
		 }
/* ------------------------------------------------------------------------------------------------------------------------- */
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
		
		/*The close button for other stuff*/
		.closepop {
		    position: absolute;
		    right: 25px;
		    top: 0;
		    color: #000;
		    font-size: 35px;
		    font-weight: bold;
		}
		.closepop:hover,.close:focus {
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
		
		
/*-----------------------------------------------------------------------------------------------------------------------*/
/*-------------------------------------- General ------------------------------------------------------------------------*/	
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

/*-----------------------------------------------------------------------------------------------------------------------*/
/*-------------------------------------- Navegation Bar -----------------------------------------------------------------*/	
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
		
		#navbar  #popup a {
			float:none;
		}
		
		.my-header h1 { 
		    display: inline;
		    text-align:left; 
		    font-size:280%; 
		    color:rgb(171,0,15); 
		    font-family:Arial
		}
		.my-header span { 
	    	float: right;
			padding: 0px 10px;
		 }
		 .notesForm{
		  	float: right;
	       	overflow: hidden;
	      	color:white;
		 }
		 .membersForm{
	        	float: right;
	          	overflow: hidden;
	          	color:white;
	      }
	      
	      .pdfForm{
	        	float: right;
	          	overflow: hidden;
	          	
	      }
	      
	      .pdfF{
	          	color:white;
	          	background-color:#990000;
	          	float:bottom;
	          	margin-top:12px;
	          	
	      }
	      
		* {
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
	        
			.main {
			  max-width: 960px;
			  margin:0px 100px;
			}
			
	        
	        .CreateRequeriment{
	        	float: right;
	          	overflow: hidden;
	          	color:white;
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
	
			.button {
			   
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
			
			.btn, .btn:hover, .btn:active, .btn:focus {
	          background-color:#333;
	          border: none;
	          color: white;
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
			
/*--------------------------------------------------------- List of Options -------------------------------------------------------------------*/	
			.btn3{
		        color: black;
		        font-size: 15px;
		        cursor: pointer;
				margin-left:265px;		        
			 }
			
			.absolute-wrapper{
			    position: fixed;
			    width: 300px;
			    height: 100%;
			    background-color: #f8f8f8;
			    border-right: 1px solid #e7e7e7;
			}
			
			.side-menu {
			  position: absolute;
			  width: 300px;
			  height: 100%;
			  background-color: #f8f8f8;
			  border-right: 1px solid #e7e7e7;
			}
			.side-menu .navbar {
			  border: none;
			}
			.side-menu .navbar-header {
			  width: 100%;
			  border-bottom: 1px solid #e7e7e7;
			}
			.side-menu .navbar-nav .active a {
			  background-color: transparent;
			  margin-right: -1px;
			  border-right: 5px solid #e7e7e7;
			}
			
			.side-menu .navbar-nav li {
			  display: block;
			  width: 100%;
			  border-bottom: 1px solid #e7e7e7;
			  color:red;
			}
			.side-menu .navbar-nav li a {
			  padding: 15px;
			}
			.side-menu .navbar-nav li a .glyphicon {
			  padding-right: 10px;
			}
			.side-menu #dropdown {
			  border: 0;
			  margin-bottom: 0;
			  border-radius: 0;
			  background-color: transparent;
			  box-shadow: none;
			}
			.side-menu #dropdown .caret {
			  float: right;
			  margin: 9px 5px 0;
			}
			.side-menu #dropdown .indicator {
			  float: right;
			}
			.side-menu #dropdown > a {
			  border-bottom: 1px solid #e7e7e7;
			}
			.side-menu #dropdown .panel-body {
			  padding: 0;
			  background-color: #f3f3f3;
			}
			.side-menu #dropdown .panel-body .navbar-nav {
			  width: 100%;
			}
			.side-menu #dropdown .panel-body .navbar-nav li {
			  padding-left: 15px;
			  border-bottom: 1px solid #e7e7e7;
			}
			.side-menu #dropdown .panel-body .navbar-nav li:last-child {
			  border-bottom: none;
			}
			.side-menu #dropdown .panel-body .panel > a {
			  margin-left: -20px;
			  padding-left: 35px;
			}
			.side-menu #dropdown .panel-body .panel-body {
			  margin-left: -15px;
			}
			.side-menu #dropdown .panel-body .panel-body li {
			  padding-left: 30px;
			}
			.side-menu #dropdown .panel-body .panel-body li:last-child {
			  border-bottom: 1px solid #e7e7e7;
			}
			.side-menu #search-trigger {
			  background-color: #f3f3f3;
			  border: 0;
			  border-radius: 0;
			  position: absolute;
			  top: 0;
			  right: 0;
			  padding: 15px 18px;
			}
			.side-menu .brand-name-wrapper {
			  min-height: 50px;
			}
			.side-menu .brand-name-wrapper .navbar-brand {
			  display: block;
			}
			.side-menu #search {
			  position: relative;
			  z-index: 1000;
			}
			.side-menu #search .panel-body {
			  padding: 0;
			}
			.side-menu #search .panel-body .navbar-form {
			  padding: 0;
			  padding-right: 50px;
			  width: 100%;
			  margin: 0;
			  position: relative;
			  border-top: 1px solid #e7e7e7;
			}
			.side-menu #search .panel-body .navbar-form .form-group {
			  width: 100%;
			  position: relative;
			}
			.side-menu #search .panel-body .navbar-form input {
			  border: 0;
			  border-radius: 0;
			  box-shadow: none;
			  width: 100%;
			  height: 50px;
			}
			.side-menu #search .panel-body .navbar-form .btn {
			  position: absolute;
			  right: 0;
			  top: 0;
			  border: 0;
			  border-radius: 0;
			  background-color: #f3f3f3;
			  padding: 15px 18px;
			}
			/* Main body section */
			.side-body {
			  margin-left: 310px;
			}
			/* small screen */
			@media (max-width: 768px) {
			  .side-menu {
			    position: relative;
			    width: 100%;
			    height: 0;
			    border-right: 0;
			    border-bottom: 1px solid #e7e7e7;
			  }
			  .side-menu .brand-name-wrapper .navbar-brand {
			    display: inline-block;
			  }
			  /* Slide in animation */
			  @-moz-keyframes slidein {
			    0% {
			      left: -300px;
			    }
			    100% {
			      left: 10px;
			    }
			  }
			  @-webkit-keyframes slidein {
			    0% {
			      left: -300px;
			    }
			    100% {
			      left: 10px;
			    }
			  }
			  @keyframes slidein {
			    0% {
			      left: -300px;
			    }
			    100% {
			      left: 10px;
			    }
			  }
			  @-moz-keyframes slideout {
			    0% {
			      left: 0;
			    }
			    100% {
			      left: -300px;
			    }
			  }
			  @-webkit-keyframes slideout {
			    0% {
			      left: 0;
			    }
			    100% {
			      left: -300px;
			    }
			  }
			  @keyframes slideout {
			    0% {
			      left: 0;
			    }
			    100% {
			      left: -300px;
			    }
			  }
			  /* Slide side menu*/
			  /* Add .absolute-wrapper.slide-in for scrollable menu -> see top comment */
			  .side-menu-container > .navbar-nav.slide-in {
			    -moz-animation: slidein 300ms forwards;
			    -o-animation: slidein 300ms forwards;
			    -webkit-animation: slidein 300ms forwards;
			    animation: slidein 300ms forwards;
			    -webkit-transform-style: preserve-3d;
			    transform-style: preserve-3d;
			  }
			  .side-menu-container > .navbar-nav {
			    /* Add position:absolute for scrollable menu -> see top comment */
			    position: fixed;
			    left: -300px;
			    width: 300px;
			    top: 43px;
			    height: 100%;
			    border-right: 1px solid #e7e7e7;
			    background-color: #f8f8f8;
			    -moz-animation: slideout 300ms forwards;
			    -o-animation: slideout 300ms forwards;
			    -webkit-animation: slideout 300ms forwards;
			    animation: slideout 300ms forwards;
			    -webkit-transform-style: preserve-3d;
			    transform-style: preserve-3d;
			  }
			  @-moz-keyframes bodyslidein {
			    0% {
			      left: 0;
			    }
			    100% {
			      left: 300px;
			    }
			  }
			  @-webkit-keyframes bodyslidein {
			    0% {
			      left: 0;
			    }
			    100% {
			      left: 300px;
			    }
			  }
			  @keyframes bodyslidein {
			    0% {
			      left: 0;
			    }
			    100% {
			      left: 300px;
			    }
			  }
			  @-moz-keyframes bodyslideout {
			    0% {
			      left: 300px;
			    }
			    100% {
			      left: 0;
			    }
			  }
			  @-webkit-keyframes bodyslideout {
			    0% {
			      left: 300px;
			    }
			    100% {
			      left: 0;
			    }
			  }
			  @keyframes bodyslideout {
			    0% {
			      left: 300px;
			    }
			    100% {
			      left: 0;
			    }
			  }
			  /* Slide side body*/
			  .side-body {
			    margin-left: 5px;
			    margin-top: 70px;
			    position: relative;
			    -moz-animation: bodyslideout 300ms forwards;
			    -o-animation: bodyslideout 300ms forwards;
			    -webkit-animation: bodyslideout 300ms forwards;
			    animation: bodyslideout 300ms forwards;
			    -webkit-transform-style: preserve-3d;
			    transform-style: preserve-3d;
			  }
			  .body-slide-in {
			    -moz-animation: bodyslidein 300ms forwards;
			    -o-animation: bodyslidein 300ms forwards;
			    -webkit-animation: bodyslidein 300ms forwards;
			    animation: bodyslidein 300ms forwards;
			    -webkit-transform-style: preserve-3d;
			    transform-style: preserve-3d;
			  }
			  /* Hamburger */
			  .navbar-toggle {
			    border: 0;
			    float: left;
			    padding: 18px;
			    margin: 0;
			    border-radius: 0;
			    background-color: #f3f3f3;
			  }
			  /* Search */
			  #search .panel-body .navbar-form {
			    border-bottom: 0;
			  }
			  #search .panel-body .navbar-form .form-group {
			    margin: 0;
			  }
			  .navbar-header {
			    /* this is probably redundant */
			    position: fixed;
			    z-index: 3;
			    background-color: #f8f8f8;
			  }
			  /* Dropdown tweek */
			  #dropdown .panel-body .navbar-nav {
			    margin: 0;
			  }
			}
/*------------------------------------------------------------------------------------------------------------------------------------*/		
			a:link,
        	a:visited{
	        	color:Black;
	        	font:Arial,bold;
	        	text-decoration:none;
	        	
	        }
/*---------------------------------------------------------------------------------------------------------------------------*/
/*---------------------------------------------------------- SRS -----------------------------------------------------------*/

			
			.setup-content{
				width: 70%;
			    position: relative;	
			}
			.stepwizard-step p {
			    margin-top: 10px;
			}
			
			.stepwizard-row {
			    display: table-row;
			}
			
			.stepwizard {
			    display: table;
			    width: 70%;
			    position: relative;
			}
			
			.stepwizard-step button[disabled] {
			    opacity: 1 !important;
			    filter: alpha(opacity=100) !important;
			}
			
			.stepwizard-row:before {
			    top: 14px;
			    bottom: 0;
			    position: absolute;
			    content: " ";
			    width: 100%;
			    height: 1px;
			    background-color: #ccc;
			    z-order: 0;
			
			}
			
			.stepwizard-step {
			    display: table-cell;
			    text-align: center;
			    position: relative;
			}
			
			.btn-circle, .btn-circle:hover {
			  width: 40px;
			  height: 40px;
			  text-align: center;
			  padding: 6px 0;
			  font-size: 20px;
			  color:white;
			  line-height: 1.428571429;
			  border-radius: 20px;
			}
			.btn4{
		        color: black;
		        font-size: 15px;
		        cursor: pointer;
				margin-left:670px;		        
			 }
			 
			 .modal-body a{
			 	padding:0px;
			 }
/*-----------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------- Diagrams --------------------------------------------------------------------*/
			div.gallery {
			  margin: 5px;
			  border: 1px solid #ccc;
			  float: left;
			  width: 180px;
			}
			
			div.gallery:hover {
			  border: 1px solid #777;
			}
			
			div.gallery img {
			  width: 100%;
			  height: auto;
			}
			
			div.desc {
			  padding: 15px;
			  text-align: center;
			}
/*---------------------------------------------------------------------------------------------------------------------------*/
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
	  	 	<div class="search-container">
	  	 		<form:form id="find" action="buscarrequerimiento" method ="post">
				<input id="searched" type="text" placeholder="Buscar" name="search" onkeyup="success()">
				<input type="hidden" name="projectId" value=${id}>
				<button id= "buttonGlass" type="submit" disabled><i class="fa fa-search lupa"></i></button>
				<div id="searchModal" class="modal">
					      <!-- Modal content -->
					  <div class="modal-content">
					    <div class="modal-header">
					    	<span id = "closebutton" class="closepop">&times;</span>
					        
					      <h2>Resultados</h2>
					      
					    </div>
					    <div class="modal-body" style="text-align:center">
					    ${results}
					    </div>
					  </div>
					  
					
		    	</div>
	    		</form:form>
			    
		    </div>
			<!-- <button class="button">Notas</button> -->
		    <div class="notesForm">
		    	<a href="notas?id=${id}"><button class="btn"><i class="fa fa-sticky-note" ></i></button></a>
		    </div>
			<!--<button class="button">Miembros</button>-->
			<div class="membersForm">
				<a href="miembros?id=${id}"><button class="btn"><i class="fa fa-users"></i></button></a>
				<!--<form id="MembersForm" action="members">
	      			<input type="submit" value="Miembros" />
	    		</form>-->
	    	</div>
	    	<div class="pdfForm">
	    		<form id="PdfForm" action="generarSRS" method="post">
	    			<input type="hidden" name="id" value=${id }>
	    			<input type="submit" class="pdfF" value="Generar SRS"/>
	    		</form>
	    	</div>
		</div>
		<div class="main">
			<div class="Zone">
				<br></br>
				<h3 style="font:Arial,bold; color:rgb(0,0,0); padding:0px 0px"> ${name}</h3>
				
				
			</div>
		 </div>
		
		<div class= "row"  style="padding-left: 100px"> 
		    <div class="absolute-wrapper"> </div>
		    <!-- Menu -->
			    <div class="side-menu">
					<nav class="navbar navbar-default" role="navigation">
					    <!-- Main Menu -->
					    <div class="side-menu-container">
					        <ul class="nav navbar-nav">
					            <li id="Reqs"><a><span class="glyphicon glyphicon-list-alt"></span> Requerimientos</a></li>
					            <li id="Diags"><a><span class="glyphicon glyphicon-camera"></span> Diagramas</a></li>
					            <li id="Cal"><a><span class="glyphicon glyphicon-calendar"></span> Calendario</a></li>
					            <li id="SRS"><a><span class="glyphicon glyphicon-file"></span>Otros campos SRS</a></li>
							</ul>
					    </div>
					</nav>
			    </div>
		    <!-- Main Content -->
		    <div class="container-fluid">
		        <div class="side-body">
		           <div class="tab-content" id="nav-tabContent">
					    <div class="Requeriments" id="Requirements">
					   	 	<i>Haga clic en los encabezados para ordenar la tabla.</i>
				        	<a href="crearrequerimiento?id=${id}"><button id ="createR" class="btn3">Agregar Requerimiento</button></a>
						 	<table id = "myTable2" class="table" style="width:100%">
  								<thead align="center">
    								<tr>
    									<th onclick="sortTable(0)" scope="col">Tipo</th>
    									<th onclick="sortTable(1)" scope="col">Estado</th>
		                        		<th onclick="sortTable(2)" scope="col">ID</th>
		                        		<th onclick="sortTable(3)" scope="col">Nombre</th>
		                        		<th onclick="sortTable(4)" scope="col">Versión</th>
		                        		<th scope="col"><em class="fa fa-cog"></em></th>
	                    			</tr> 
	                  			</thead>
		                    	<tbody>
		                    		${requirements}
		                 		</tbody>
             		 		</table>	
 						</div>
					    <div class="Diagrams" id="Diagrams" style="display:none">
						    <h3>Diagramas</h3>
						    ${diagrams }
						</div>
						<div class="Calendar" id="Calendar" style="display:none">
							<button id="myBtn" class="btn2"><i class="fa fa-calendar-plus-o"></i></button><br>
						    <div id="caleandar">
   							</div>
					    </div>
						<div class="SRSS" id="SRSS" style="display:none">
							<div class="container">
							<form:form id="getSRS" action="editarIntroSRS" method="post">	
								<div class="stepwizard">
								    <div class="stepwizard-row setup-panel">
								        <div class="stepwizard-step">
								            <a href="#step-1" type="button" class="btn btn-primary btn-circle"><span class="glyphicon glyphicon-pencil"></span></a>
								            <p>Introducción</p>
								        </div>
								        <div class="stepwizard-step">
								            <a href="#step-2" type="button" class="btn btn-default btn-circle"><span class="glyphicon glyphicon-globe"></span></a>
								            <p>Descripción Global</p>
								        </div>
								        <div class="stepwizard-step">
								            <a href="#step-3" type="button" class="btn btn-default btn-circle"><span class="glyphicon glyphicon-th-list"></span></a>
								            <p>Otros Requerimientos</p>
								        </div>
								    </div>
								</div>
							    <div class="row setup-content" id="step-1">
							        <div class="col-xs-12">
							            <div class="col-md-12">
							                <h3 style="display: inline-block"> Introducción</h3>
							                <button type="button" id="myBtn4" class="btn4">Editar</button>
							                <div class="form-group">
							                    <label class="control-label">Próposito del sistema</label>
							                    <textarea  id="systemProspect" name="systemProspect" class="form-control" cols="20" rows="4" disabled>${systemProspect }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Alcance</label>
							                    <textarea  id="scope" name="scope" class="form-control" cols="20" rows="4" disabled>${scope }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Objetivos y restricciones de diseño</label>
							                    <textarea  id="objectives" name="objectives" class="form-control" cols="20" rows="4" disabled>${objectives }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Definiciones, acrónimos y abreviaturas</label>
							                    <textarea id="definitions" name="definitions" class="form-control" cols="20" rows="4" disabled>${definitions }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Referencias</label>
							                    <textarea id="references" name="references" class="form-control" cols="20" rows="4" disabled>${referencs }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Apreciación global</label>
							                    <textarea id="globalAppraisal" name="globalAppraisal" class="form-control" cols="20" rows="4" disabled>${globalAppraisal }</textarea>
							                </div>
							                <input type="hidden" id="projId" name="projectId" value=${id }>                                                                 
							                <button type="submit" class="btn" style="float:right">Aceptar</button>
							                <div class="row col-sm-3 form-group" style="float:right; text-align:right; font-size:18%">
							                	<input type="text" id="vrs1" name="version" class="form-control" placeholder="Versión SRS" disabled>
							                </div>
							            </div>
							        </div>
							    </div>
							</form:form>
							<form:form id="getSRSDescr" action="editarDescrSRS" method="post">
							    <div class="row setup-content" id="step-2">
							        <div class="col-xs-12">
							            <div class="col-md-12">
							                <h3 style="display: inline-block"> Descripción global</h3>
							                <button type="button" id="myBtn5" class="btn4">Editar</button>
							                <div class="form-group">
							                    <label class="control-label">Perspectiva del producto</label>
							                    <textarea id="productPerspective" name="productPerspective" class="form-control" cols="20" rows="4" disabled>${productPerspective }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Caracterísitcas del usuario</label>
							                    <textarea id="userCharacteristics" name="userCharacteristics" class="form-control" cols="20" rows="4" disabled>${userCharacteristics }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Funciones del producto</label>
							                    <textarea id="productFunctions" name="productFunctions" class="form-control" cols="20" rows="4" disabled>${productFunctions }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Modelo del dominio</label>
							                    <textarea id="domailModel" name="domailModel" class="form-control" cols="20" rows="4" disabled>${domainModel }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Restricciones</label>
							                    <textarea id="restrictions" name="restrictions" class="form-control" cols="20" rows="4" disabled>${restrictions }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Suposicines y dependencias</label>
							                    <textarea id="suppositions" name="suppositions" class="form-control" cols="20" rows="4" disabled>${suppositions }</textarea>
							                </div>
							                <input type="hidden" id="projId" name="projectId" value=${id }>
							                <button type="submit" class="btn" style="float:right">Aceptar</button>
							                <div class="row col-sm-3 form-group" style="float:right; text-align:right; font-size:18%">
							                	<input type="text" id="vrs2" name="version" class="form-control" placeholder="Versión SRS" disabled>
							                </div>
							            </div>
							        </div>
							    </div>
							</form:form>
							<form:form id="getSRSReqs" action="editarReqsSRS" method="post">
							    <div class="row setup-content" id="step-3">
							        <div class="col-xs-12">
							            <div class="col-md-12">
							                <h3 style="display: inline-block"> Otros Requerimientos</h3>
							                <button type="button" id="myBtn6" class="btn4">Editar</button>
							                <div class="form-group">
							                    <label class="control-label">Requerimientos de la Base de datos</label>
							                    <textarea id="dbRequirements" name="dbRequirements" class="form-control" cols="20" rows="4" disabled>${dbRequirements }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Restricciones del Diseño</label>
							                    <textarea id="designRestrictions" name="designRestrictions" class="form-control" cols="20" rows="4" disabled>${designRestrictions }</textarea>
							                </div>
							                <div class="form-group">
							                    <label class="control-label">Aceptación de las normas</label>
							                    <textarea id="ruleAcceptance" name="ruleAcceptance" class="form-control" cols="20" rows="4" disabled>${ruleAcceptance }</textarea>
							                </div>
							                <input type="hidden" id="projId" name="projectId" value=${id }>
							                <button type="submit" class="btn" style="float:right">Aceptar</button>
							                <div class="row col-sm-3 form-group" style="float:right; text-align:right; font-size:18%">
							                	<input type="text" id="vrs3" name="version" class="form-control" placeholder="Versión SRS" disabled>
							                </div>
							            </div>
							        </div>
							    </div>
							</form:form>
							</div>
						 </div>
						
						</div>
						<!-- The Modal -->
						<div id="myModal" class="modal">
						 <form:form id="getEvent" action="agregarevento" method="post">
						  <!-- Modal content -->
						  <div class="modal-content">
						    <div class="modal-header">
						      <span class="close">&times;</span>
						      <h2 style="text-align:center">Agregar evento al calendario</h2>
						    </div>
						    <div class="modal-body" style="text-align:center">
						    	<div class="row">
			   	 					<label style="font-size:120%" for="email"><b>Fecha del evento</b></label>
			    					<div class="row">
										<div class="col-sm-4 form-group">
										<label>Año</label>
										<input style="text-align:center" name="year" placeholder="XXXX" class="form-control" required>
										</div>
										<div class="col-sm-4 form-group">
										<label>Mes</label>
										<input style="text-align:center" name="month" placeholder="XX" class="form-control" required>
										</div>
										<div class="col-sm-4 form-group">
										<label>Día</label>
										<input style="text-align:center" name="day" placeholder="XX" class="form-control" required>
										</div>
									</div>	
								</div>		
			    				<div class="row">
			    					<label for="title"><b>Título</b></label>
			    				</div>
			    				<div class="row">
			    					<input style="text-align:center" name="title" placeholder="Título del evento" class="form-control" required>
								</div>
								<div class="row">
			    					<label for="description"><b>Descripción</b></label>
			    				</div>
			    				<div class="row">
			    					<textarea style="text-align:center" name="description"  rows= 5 placeholder="Descripción del evento" class="form-control" required></textarea>
								</div>
								<input type="hidden" id="projId" name="projectId" value=${id }>
						    </div>
						    <div class="modal-footer">
						      <button type="submit" class="btn ">Agregar</button>
						      <button type="button" class="btn cancel" onclick="closeForm()">Cancelar</button>
						   </div>
						  </div>
						 </form:form>
						</div>
					</div>
				</div>
			</div>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	  	<script>
	  		var btn4= document.getElementById("myBtn4");
	  		btn4.onclick = function(){
	  			document.getElementById("systemProspect").disabled=false;
	  			document.getElementById("scope").disabled=false;
	  			document.getElementById("objectives").disabled=false;
	  			document.getElementById("definitions").disabled=false;
	  			document.getElementById("references").disabled=false;
	  			document.getElementById("globalAppraisal").disabled=false;
	  			document.getElementById("vrs1").disabled=false;
	  			document.getElementById("vrs1").required=true;
	  		}	  		
	  	</script>
	  	<script>
		  	var btn5= document.getElementById("myBtn5");
	  		btn5.onclick = function(){
	  			document.getElementById("productPerspective").disabled=false;
	  			document.getElementById("userCharacteristics").disabled=false;
	  			document.getElementById("productFunctions").disabled=false;
	  			document.getElementById("domailModel").disabled=false;
	  			document.getElementById("restrictions").disabled=false;
	  			document.getElementById("suppositions").disabled=false;
	  			document.getElementById("vrs2").disabled=false;
	  			document.getElementById("vrs2").required=true;

	  		}
	  	</script>
	  	<script>
		  	var btn6= document.getElementById("myBtn6");
	  		btn6.onclick = function(){
	  			document.getElementById("dbRequirements").disabled=false;
	  			document.getElementById("designRestrictions").disabled=false;
	  			document.getElementById("ruleAcceptance").disabled=false;
	  			document.getElementById("vrs3").disabled=false;
	  			document.getElementById("vrs3").required=true;

	  		}
	  	</script>
	  	<script>
	  	$(document).ready(function () {

	  	    var navListItems = $('div.setup-panel div a'),
	  	            allWells = $('.setup-content'),
	  	            allNextBtn = $('.nextBtn');

	  	    allWells.hide();

	  	    navListItems.click(function (e) {
	  	        e.preventDefault();
	  	        var $target = $($(this).attr('href')),
	  	                $item = $(this);

	  	        if (!$item.hasClass('disabled')) {
	  	            navListItems.removeClass('btn-primary').addClass('btn-default');
	  	            $item.addClass('btn-primary');
	  	            allWells.hide();
	  	            $target.show();
	  	            $target.find('input:eq(0)').focus();
	  	        }
	  	    });

	  	    allNextBtn.click(function(){
	  	        var curStep = $(this).closest(".setup-content"),
	  	            curStepBtn = curStep.attr("id"),
	  	            nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
	  	            curInputs = curStep.find("input[type='text'],input[type='url']"),
	  	            isValid = true;

	  	        $(".form-group").removeClass("has-error");
	  	        for(var i=0; i<curInputs.length; i++){
	  	            if (!curInputs[i].validity.valid){
	  	                isValid = false;
	  	                $(curInputs[i]).closest(".form-group").addClass("has-error");
	  	            }
	  	        }

	  	        if (isValid)
	  	            nextStepWizard.removeAttr('disabled').trigger('click');
	  	    });

	  	    $('div.setup-panel div a.btn-primary').trigger('click');
	  	});
	  	
	  	
	  	
	  	</script>
	  	<script>
		var modalPop = document.getElementById('searchModal');

		var span= document.getElementsByClassName("closepop")[0];
		
		span.onclick = function() {
			modalPop.style.display = "none"; 
		}
 	
	 	
	 	</script>
	 	
	 	<script>
	 	//Checks if the field is empty, if it is, gets disabled. Extracted from https://stackoverflow.com
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
			document.getElementById("searchModal").style.display = "none";
		}else{
			document.getElementById("searchModal").style.display = "block";
		}
		</script>
	  	
	  	<script>
		/*All the code related whit the Pop Up or modal was taked from= https://www.w3schools.com/howto/howto_css_modals.asp*/
			// Get the modal
			var modal = document.getElementById('myModal');
			
			// Get the button that opens the modal
			var btn = document.getElementById("myBtn");
			
			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];
			
			// When the user clicks the button, open the modal 
			var roleUser=${roleUser};
			btn.onclick = function() {
				//If the user is a observer it denies the access. 
				if (roleUser.localeCompare("observador")==0){
					alert("¡Accesso denegado!\n Los observadores no pueden agregar eventos al calendario.");
				}else{
					modal.style.display = "block";
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
			var roleUser=${roleUser};
			var btn1 = document.getElementById("myBtn1");
			btn1.onclick = function(){
				if (roleUser.localeCompare("observador")==0){
					return false;
				}
			}
		</script>
		<script>
			var roleUser=${roleUser};
			var btn2=document.getElementById("myBtn2");
			btn2.onclick = function(){
				if (roleUser.localeCompare("admin")==0){
				}else{
					return false;
				}	
			}
		</script>
		<script>
			var roleUser=${roleUser};
			if (roleUser.localeCompare("observador")==0){
				document.getElementById('createR').disabled = true;
			}else{
				document.getElementById('createR').disabled=false;
			}	
		</script>
	  	<script>
			$(function () {
			    $('.navbar-toggle').click(function () {
			        $('.navbar-nav').toggleClass('slide-in');
			        $('.side-body').toggleClass('body-slide-in');
			        $('#search').removeClass('in').addClass('collapse').slideUp(200);
		
			        /// uncomment code for absolute positioning tweek see top comment in css
			        //$('.absolute-wrapper').toggleClass('slide-in');
			        
			    });
			   
			   // Remove menu for searching
			   $('#search-trigger').click(function () {
			        $('.navbar-nav').removeClass('slide-in');
			        $('.side-body').removeClass('body-slide-in');
		
			        /// uncomment code for absolute positioning tweek see top comment in css
			        //$('.absolute-wrapper').removeClass('slide-in');
		
			    });
			});	
		</script>
		<script>
			$("#Reqs").on('click',function(){
				$("#Requirements").show();
				$("#Diagrams,#Calendar,#Intro,#GlobalDescr,#SRSS").hide();
				$("#Reqs").active();
			});
		</script>
		<script>
			$("#Diags").on('click',function(){
				$("#Diagrams").show();
				$("#Requirements,#Calendar,#Intro,#GlobalDescr,#SRSS").hide();
				$("#Diags").active();
			});
		</script>
		<script>
			$("#Cal").on('click',function(){
				$("#Calendar").show();
				$("#Diagrams,#Intro,#Requirements,#GlobalDescr,#SRSS").hide();
				$("#Cal").active();
			});
		</script>
		<script>
			$("#Intr").on('click',function(){
				$("#Intro").show();
				$("#Diagrams,#Calendar,#GlobalDescr,#Requirements,#SRSS").hide();
				$("#Intr").active();
			});
		</script>
		<script>
			$("#Descr").on('click',function(){
				$("#GlobalDescr").show();
				$("#Diagrams,#Calendar,#Intro,#Requirements,#SRSS").hide();
				$("#Descr").active();
			});
		</script>
		<script>
			$("#SRS").on('click',function(){
				$("#SRSS").show();
				$("#Diagrams,#Calendar,#Intro,#Requirements,#GlobalDescr").hide();
				$("#SRSS").active();
			});
		</script>
		<script>
		//All related whit the calendar was extracted from = https://www.cssscript.com/create-simple-event-calendar-javascript-caleandar-js/
			var Calendar = function(model, options, date){
			  // Default Values
			  this.Options = {
			    Color: '',
			    LinkColor: '',
			    NavShow: true,
			    NavVertical: false,
			    NavLocation: '',
			    DateTimeShow: true,
			    DateTimeFormat: 'mmm, yyyy',
			    DatetimeLocation: '',
			    EventClick: '',
			    EventTargetWholeDay: false,
			    DisabledDays: [],
			    ModelChange: model
			  };
			  // Overwriting default values
			  for(var key in options){
			    this.Options[key] = typeof options[key]=='string'?options[key].toLowerCase():options[key];
			  }
			
			  model?this.Model=model:this.Model={};
			  this.Today = new Date();
			
			  this.Selected = this.Today
			  this.Today.Month = this.Today.getMonth();
			  this.Today.Year = this.Today.getFullYear();
			  if(date){this.Selected = date}
			  this.Selected.Month = this.Selected.getMonth();
			  this.Selected.Year = this.Selected.getFullYear();
			
			  this.Selected.Days = new Date(this.Selected.Year, (this.Selected.Month + 1), 0).getDate();
			  this.Selected.FirstDay = new Date(this.Selected.Year, (this.Selected.Month), 1).getDay();
			  this.Selected.LastDay = new Date(this.Selected.Year, (this.Selected.Month + 1), 0).getDay();
			
			  this.Prev = new Date(this.Selected.Year, (this.Selected.Month - 1), 1);
			  if(this.Selected.Month==0){this.Prev = new Date(this.Selected.Year-1, 11, 1);}
			  this.Prev.Days = new Date(this.Prev.getFullYear(), (this.Prev.getMonth() + 1), 0).getDate();
			};
			
			function createCalendar(calendar, element, adjuster){
			  if(typeof adjuster !== 'undefined'){
			    var newDate = new Date(calendar.Selected.Year, calendar.Selected.Month + adjuster, 1);
			    calendar = new Calendar(calendar.Model, calendar.Options, newDate);
			    element.innerHTML = '';
			  }else{
			    for(var key in calendar.Options){
			      typeof calendar.Options[key] != 'function' && typeof calendar.Options[key] != 'object' && calendar.Options[key]?element.className += " " + key + "-" + calendar.Options[key]:0;
			    }
			  }
			  var months = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
			
			  function AddSidebar(){
			    var sidebar = document.createElement('div');
			    sidebar.className += 'cld-sidebar';
			
			    var monthList = document.createElement('ul');
			    monthList.className += 'cld-monthList';
			
			    for(var i = 0; i < months.length - 3; i++){
			      var x = document.createElement('li');
			      x.className += 'cld-month';
			      var n = i - (4 - calendar.Selected.Month);
			      // Account for overflowing month values
			      if(n<0){n+=12;}
			      else if(n>11){n-=12;}
			      // Add Appropriate Class
			      if(i==0){
			        x.className += ' cld-rwd cld-nav';
			        x.addEventListener('click', function(){
			          typeof calendar.Options.ModelChange == 'function'?calendar.Model = calendar.Options.ModelChange():calendar.Model = calendar.Options.ModelChange;
			          createCalendar(calendar, element, -1);});
			        x.innerHTML += '<svg height="15" width="15" viewBox="0 0 100 75" fill="rgba(255,255,255,0.5)"><polyline points="0,75 100,75 50,0"></polyline></svg>';
			      }
			      else if(i==months.length - 4){
			        x.className += ' cld-fwd cld-nav';
			        x.addEventListener('click', function(){
			          typeof calendar.Options.ModelChange == 'function'?calendar.Model = calendar.Options.ModelChange():calendar.Model = calendar.Options.ModelChange;
			          createCalendar(calendar, element, 1);} );
			        x.innerHTML += '<svg height="15" width="15" viewBox="0 0 100 75" fill="rgba(255,255,255,0.5)"><polyline points="0,0 100,0 50,75"></polyline></svg>';
			      }
			      else{
			        if(i < 4){x.className += ' cld-pre';}
			        else if(i > 4){x.className += ' cld-post';}
			        else{x.className += ' cld-curr';}
			
			        //prevent losing var adj value (for whatever reason that is happening)
			        (function () {
			          var adj = (i-4);
			          //x.addEventListener('click', function(){createCalendar(calendar, element, adj);console.log('kk', adj);} );
			          x.addEventListener('click', function(){
			            typeof calendar.Options.ModelChange == 'function'?calendar.Model = calendar.Options.ModelChange():calendar.Model = calendar.Options.ModelChange;
			            createCalendar(calendar, element, adj);} );
			          x.setAttribute('style', 'opacity:' + (1 - Math.abs(adj)/4));
			          x.innerHTML += months[n].substr(0,3);
			        }()); // immediate invocation
			
			        if(n==0){
			          var y = document.createElement('li');
			          y.className += 'cld-year';
			          if(i<5){
			            y.innerHTML += calendar.Selected.Year;
			          }else{
			            y.innerHTML += calendar.Selected.Year + 1;
			          }
			          monthList.appendChild(y);
			        }
			      }
			      monthList.appendChild(x);
			    }
			    sidebar.appendChild(monthList);
			    if(calendar.Options.NavLocation){
			      document.getElementById(calendar.Options.NavLocation).innerHTML = "";
			      document.getElementById(calendar.Options.NavLocation).appendChild(sidebar);
			    }
			    else{element.appendChild(sidebar);}
			  }
			
			  var mainSection = document.createElement('div');
			  mainSection.className += "cld-main";
			
			  function AddDateTime(){
			      var datetime = document.createElement('div');
			      datetime.className += "cld-datetime";
			      if(calendar.Options.NavShow && !calendar.Options.NavVertical){
			        var rwd = document.createElement('div');
			        rwd.className += " cld-rwd cld-nav";
			        rwd.addEventListener('click', function(){createCalendar(calendar, element, -1);} );
			        rwd.innerHTML = '<svg height="15" width="15" viewBox="0 0 75 100" fill="rgba(0,0,0,0.5)"><polyline points="0,50 75,0 75,100"></polyline></svg>';
			        datetime.appendChild(rwd);
			      }
			      var today = document.createElement('div');
			      today.className += ' today';
			      today.innerHTML = months[calendar.Selected.Month] + ", " + calendar.Selected.Year;
			      datetime.appendChild(today);
			      if(calendar.Options.NavShow && !calendar.Options.NavVertical){
			        var fwd = document.createElement('div');
			        fwd.className += " cld-fwd cld-nav";
			        fwd.addEventListener('click', function(){createCalendar(calendar, element, 1);} );
			        fwd.innerHTML = '<svg height="15" width="15" viewBox="0 0 75 100" fill="rgba(0,0,0,0.5)"><polyline points="0,0 75,50 0,100"></polyline></svg>';
			        datetime.appendChild(fwd);
			      }
			      if(calendar.Options.DatetimeLocation){
			        document.getElementById(calendar.Options.DatetimeLocation).innerHTML = "";
			        document.getElementById(calendar.Options.DatetimeLocation).appendChild(datetime);
			      }
			      else{mainSection.appendChild(datetime);}
			  }
			
			  function AddLabels(){
			    var labels = document.createElement('ul');
			    labels.className = 'cld-labels';
			    var labelsList = ["Dom", "Lun", "Mar", "Mier", "Jue", "Vier", "Sab"];
			    for(var i = 0; i < labelsList.length; i++){
			      var label = document.createElement('li');
			      label.className += "cld-label";
			      label.innerHTML = labelsList[i];
			      labels.appendChild(label);
			    }
			    mainSection.appendChild(labels);
			  }
			  function AddDays(){
			    // Create Number Element
			    function DayNumber(n){
			      var number = document.createElement('p');
			      number.className += "cld-number";
			      number.innerHTML += n;
			      return number;
			    }
			    var days = document.createElement('ul');
			    days.className += "cld-days";
			    // Previous Month's Days
			    for(var i = 0; i < (calendar.Selected.FirstDay); i++){
			      var day = document.createElement('li');
			      day.className += "cld-day prevMonth";
			      //Disabled Days
			      var d = i%7;
			      for(var q = 0; q < calendar.Options.DisabledDays.length; q++){
			        if(d==calendar.Options.DisabledDays[q]){
			          day.className += " disableDay";
			        }
			      }
			
			      var number = DayNumber((calendar.Prev.Days - calendar.Selected.FirstDay) + (i+1));
			      day.appendChild(number);
			
			      days.appendChild(day);
			    }
			    // Current Month's Days
			    for(var i = 0; i < calendar.Selected.Days; i++){
			      var day = document.createElement('li');
			      day.className += "cld-day currMonth";
			      //Disabled Days
			      var d = (i + calendar.Selected.FirstDay)%7;
			      for(var q = 0; q < calendar.Options.DisabledDays.length; q++){
			        if(d==calendar.Options.DisabledDays[q]){
			          day.className += " disableDay";
			        }
			      }
			      var number = DayNumber(i+1);
			      // Check Date against Event Dates
			      for(var n = 0; n < calendar.Model.length; n++){
			        var evDate = calendar.Model[n].Date;
			        var toDate = new Date(calendar.Selected.Year, calendar.Selected.Month, (i+1));
			        if(evDate.getTime() == toDate.getTime()){
			          number.className += " eventday";
			          var title = document.createElement('span');
			          title.className += "cld-title";
			          if(typeof calendar.Model[n].Link == 'function' || calendar.Options.EventClick){
			            var a = document.createElement('a');
			            a.setAttribute('href', '#');
			            a.innerHTML += calendar.Model[n].Title;
			            if(calendar.Options.EventClick){
			              var z = calendar.Model[n].Link;
			              if(typeof calendar.Model[n].Link != 'string'){
			                  a.addEventListener('click', calendar.Options.EventClick.bind.apply(calendar.Options.EventClick, [null].concat(z)) );
			                  if(calendar.Options.EventTargetWholeDay){
			                    day.className += " clickable";
			                    day.addEventListener('click', calendar.Options.EventClick.bind.apply(calendar.Options.EventClick, [null].concat(z)) );
			                  }
			              }else{
			                a.addEventListener('click', calendar.Options.EventClick.bind(null, z) );
			                if(calendar.Options.EventTargetWholeDay){
			                  day.className += " clickable";
			                  day.addEventListener('click', calendar.Options.EventClick.bind(null, z) );
			                }
			              }
			            }else{
			              a.addEventListener('click', calendar.Model[n].Link);
			              if(calendar.Options.EventTargetWholeDay){
			                day.className += " clickable";
			                day.addEventListener('click', calendar.Model[n].Link);
			              }
			            }
			            title.appendChild(a);
			          }else{
			            title.innerHTML += '<a href="' + calendar.Model[n].Link + '">' + calendar.Model[n].Title + '</a>';
			          }
			          number.appendChild(title);
			        }
			      }
			      day.appendChild(number);
			      // If Today..
			      if((i+1) == calendar.Today.getDate() && calendar.Selected.Month == calendar.Today.Month && calendar.Selected.Year == calendar.Today.Year){
			        day.className += " today";
			      }
			      days.appendChild(day);
			    }
			    // Next Month's Days
			    // Always same amount of days in calander
			    var extraDays = 13;
			    if(days.children.length>35){extraDays = 6;}
			    else if(days.children.length<29){extraDays = 20;}
			
			    for(var i = 0; i < (extraDays - calendar.Selected.LastDay); i++){
			      var day = document.createElement('li');
			      day.className += "cld-day nextMonth";
			      //Disabled Days
			      var d = (i + calendar.Selected.LastDay + 1)%7;
			      for(var q = 0; q < calendar.Options.DisabledDays.length; q++){
			        if(d==calendar.Options.DisabledDays[q]){
			          day.className += " disableDay";
			        }
			      }
			
			      var number = DayNumber(i+1);
			      day.appendChild(number);
			
			      days.appendChild(day);
			    }
			    mainSection.appendChild(days);
			  }
			  if(calendar.Options.Color){
			    mainSection.innerHTML += '<style>.cld-main{color:' + calendar.Options.Color + ';}</style>';
			  }
			  if(calendar.Options.LinkColor){
			    mainSection.innerHTML += '<style>.cld-title a{color:' + calendar.Options.LinkColor + ';}</style>';
			  }
			  element.appendChild(mainSection);
			
			  if(calendar.Options.NavShow && calendar.Options.NavVertical){
			    AddSidebar();
			  }
			  if(calendar.Options.DateTimeShow){
			    AddDateTime();
			  }
			  AddLabels();
			  AddDays();
			}
			
			function caleandar(el, data, settings){
			  var obj = new Calendar(data, settings);
			  createCalendar(obj, el);
			}
		</script>
		<script>
			var events = [
			 ${events}];	
			var settings = {};
			var element = document.getElementById('caleandar');
			caleandar(element, events, settings);
		</script>
		<script>
			//Function take from = https://www.w3schools.com/howto/howto_js_sort_table.asp
			function sortTable(n) {
			  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
			  table = document.getElementById("myTable2");
			  switching = true;
			  // Set the sorting direction to ascending:
			  dir = "asc"; 
			  /* Make a loop that will continue until
			  no switching has been done: */
			  while (switching) {
			    // Start by saying: no switching is done:
			    switching = false;
			    rows = table.rows;
			    /* Loop through all table rows (except the
			    first, which contains table headers): */
			    for (i = 1; i < (rows.length - 1); i++) {
			      // Start by saying there should be no switching:
			      shouldSwitch = false;
			      /* Get the two elements you want to compare,
			      one from current row and one from the next: */
			      x = rows[i].getElementsByTagName("TD")[n];
			      y = rows[i + 1].getElementsByTagName("TD")[n];
			      /* Check if the two rows should switch place,
			      based on the direction, asc or desc: */
			      if (dir == "asc") {
			        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
			          // If so, mark as a switch and break the loop:
			          shouldSwitch = true;
			          break;
			        }
			      } else if (dir == "desc") {
			        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
			          // If so, mark as a switch and break the loop:
			          shouldSwitch = true;
			          break;
			        }
			      }
			    }
			    if (shouldSwitch) {
			      /* If a switch has been marked, make the switch
			      and mark that a switch has been done: */
			      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
			      switching = true;
			      /* Each time a switch is done, increase this count by 1:*/
			      switchcount ++; 
			    } else {
			      /* If no switching has been done AND the direction is asc,
			      set the direction to "desc" and run the while loop again. */
			      if (switchcount== 0 && dir == "asc") {
			        dir = "desc";
			        switching = true;
			      }
			    }
			  }
			}
		</script>
	</body>
</html>
