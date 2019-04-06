<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enterprise</title>
<%@ page import="org.apache.http.HttpHeaders" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.1.3/toastr.min.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/react-bootstrap-table/4.3.1/react-bootstrap-table-all.min.css"/>
<link href="https://unpkg.com/react-tabs@3/style/react-tabs.css" rel="stylesheet">
<link rel="stylesheet" href="luminate.css">

<script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>


<script crossorigin src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
<script crossorigin src="https://unpkg.com/react@16/umd/react.development.js"></script>
<script crossorigin src="https://unpkg.com/react-dom@16/umd/react-dom.development.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/react-bootstrap-table/4.3.1/react-bootstrap-table.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react-bootstrap-table/4.3.1/react-bootstrap-table.js.map"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/react-bootstrap-table/4.3.1/react-bootstrap-table.min.js"></script>
<script src="https://unpkg.com/react-tabs@3/dist/react-tabs.development.js"></script>
<script crossorigin src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
<script  src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.15.3/axios.js"></script>	
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css">
<script type="text/babel" src="enterprise.js">
</script>
</head>

<body class="home-page">
<h2 class="security-header">&nbsp;&nbsp;<%out.println("Response From: "+request.getHeader(HttpHeaders.HOST));%></h2>
<div id="gridData" class="container"></div>
</body>

</html>