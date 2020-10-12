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
<head>
	<title>Nueva especificación</title>
	
	<meta charset="UTF-8">
	<!-- Bootstrap CSS -->
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	    
	<style>
		#navbar {
			  overflow: hidden;
			  background-color: #990000;
			  height:150%;
		}		
		* {
		  box-sizing: border-box;
		}
		
		.catOk{
		 	position:relative;
		 	left:320px;
		}
		
		body {
		  padding: 1rem;
		}
		
		.contain {
		  max-width: 1170px;
		  margin-left: auto;
		  margin-right: auto;
		  padding: 1em;
		}
		@media (min-width: 600px) {
		  .contain {
		    padding: 0;
		  }
		}
		
		h3,
		ul {
		  margin: 0;
		}
		
		h3 {
		  margin-bottom: 1rem;
		}
		
		input:focus,
		textarea:focus {
		  outline: 3px solid gold;
		}
		
		input,
		textarea,
		button {
		  width: 100%;
		  border: 1px solid #000;
		}
		
		.wrapper {
		  float:middle;
		  box-shadow: 0 0 10px 0 rgb(0, 0, 5);
		  width:800px;
		  position:relative;
		  top:20px;
		  padding-top:5px;
		  left: 190px;
		}
		.wrapper > * {
		  padding: 1em;
		}
		
		
		
		ul {
		  list-style: none;
		  padding: 0;
		}
		
		.contacts {
		  background: #4b5195;
		  color: #fff;
		}
		
		.form {
		  background: #fff;
		}
		
		form {
		  display: grid;
		  grid-template-columns: 1fr 1fr;
		  grid-gap: 20px 80px;
		}
		form label {
		  display: block;
		}
		form p {
		  margin: 0;
		}
		
		.full-width {
		  grid-column: 1 / 3;
		}
		
		button,
		input,
		textarea {
		  padding: 1em;
		}
		
		.btn {
		  background: black;
		  width: 50%;
		  border: 0;
		}
		.btn:hover, .btn:focus {
		  background: black;
		  outline: 0;
		}
		
		.btn1{
			float:right;
		}
		
		textarea {
		   resize: none;
		}
	</style>
</head>
<body>
	<div class="contain">
	
	  <div class="wrapper">
		<div id="navbar" class="my-header">
	  	 	<img src="https://i.ibb.co/6rdz9XG/Gato-Sigere.png" width="190" height="70" padding-left="5px" >  	
		</div>
    	<br>
    	<div class="NewSpc">
    		<p><B>Nueva especificación del Requerimiento: RF ${idReq} / version ${versionReq}</B></p>
    	</div>
    	<div id="second" class="catOk">
	    	<img src="https://i.ibb.co/5sVGfWr/especificacion.png" width="160" height="150" >
		</div>
		
	      
		<div class="form">
	      <form:form id="regSpc" modelAttribute="object" action="crearespecificacion" method="post">
	      <div class="form group">
	        <p>
	          <label for="">Código</label>
	          <input type="text" placeholder="El código deber ser RF-id. Ej: RF-003" name="code" class="form-control"  required>
	        </p>
	       </div>
	        <p>
	          <label for="">Nombre</label>
	          <input type="text" placeholder="Escriba el nombre de la especificación..." name="name" class="form-control" required>
	        </p>
	        <!-- <p>
	          <label for="">Fecha</label>
	          <input type="text" name="date" class="form-control" required>
	        </p> -->
	        <p>
	          <label for="">Grado de necesidadd</label>
	          <select name="gradeOfNeed" class="form-control" required>
				<option value= "1" >1</option>
			  	<option value= "2" >2</option>
			  	<option value= "3" >3</option>
			  	<option value= "4" >4</option>
			  	<option value= "5" >5</option>
		      </select> 
	        </p>
	        <p>
	          <label for="">Descripción</label>
	          <textarea name="description" placeholder="Escriba la descripción" cols="20" rows="4" class="form-control" required></textarea>
	        </p>
	        
	        <p>
	          <label for="">Entradas</label>
			  <textarea name="entry" placeholder="Escriba las entradas" cols="10" rows="4" class="form-control" required></textarea>
	        </p>
	        <p>
	          <label for="">Fuente</label>
			  <textarea name="font" placeholder="Escriba la fuente" cols="10" rows="4" class="form-control" required></textarea>
	        </p>
	        <p>
	          <label for="">Salidas</label>
			  <textarea name="outt" placeholder="Escriba las salidas" cols="10" rows="2" class="form-control" required></textarea>
	        </p>
	        
	        <p>
	          <label for="">Destino</label>
			  <textarea name="destiny" placeholder="Escriba el destino" cols="10" rows="2" class="form-control" required></textarea>
	        </p>
	         
	        <p>
	          <label for="">Restricciones</label>
			  <textarea name="restriction" placeholder="Escriba las restricciones" cols="10" rows="3" class="form-control" required></textarea>
	        </p>
	        
	        <p>
	          <label for="">Proceso</label>
			  <textarea name="process" placeholder="Escriba el proceso" cols="10" rows="3" class="form-control" required></textarea>
	        </p>
	        
	        <p>
	          <label for="">Efectos colaterales</label>
			  <textarea name="colateralEffect" placeholder="Escriba los efectos colaterales" cols="10" rows="2" class="form-control" required></textarea>
	        </p>
	        <p>
	        <label for="">Versión de la Especificación</label>
	        <input type="hidden" id="reqId" name="requirementId" class="form-control">
	        <input type="text" id="version" name="version" class="form-control" value=${version } disabled>
	        <input type="hidden" id="version" name="version" class="form-control" value=${version }>
	        </p>
	        <p>
	        	<button type="submit" class="btn btn-lg btn-info btn1">Aceptar</button>
	        </p>
	        <p>
	        	<button type="button" id="idForm" class="btn btn-lg btn-info btn2">Cancelar</button>
	       </p>
	       
	       <input type="hidden" id="idd" name="id">
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
			   	document.getElementById("idd").value = getQueryVariable();
				document.getElementById("reqId").value=getQueryVariable();
				document.getElementById("idForm").onclick= function(){
				location.href="http://localhost:8080/sigere/requerimiento?id="+ getQueryVariable();
				}
			</script>
			</form:form>
	    </div>
	   
	  </div>
	</div>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>