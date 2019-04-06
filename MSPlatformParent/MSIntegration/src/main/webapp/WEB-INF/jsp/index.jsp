<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Spring Zuul</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-resource.min.js"></script>
<script>
	/*<![CDATA[*/
	var app = angular.module('myApp', [ "ngResource" ]);
	app.controller('mainCtrl', function($scope, $resource, $http) {
		$scope.customers = $resource("/nonrest/api/customers/:customerId", {
			customerId : '@id'
		});

		$scope.getCustomer = function() {
			$scope.customer = $scope.customers.get({
				customerId : $scope.customer.id
			});
		}		
		$scope.getApp = function(appUrl) {
			$scope.url = appUrl;
		}
	});
	/*]]>*/
</script>
</head>
<body ng-app="myApp" ng-controller="mainCtrl">

	<div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" th:href="@{/}">Spring Zuul</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#" id="customer_href_id"
						ng-click="getApp('/api/customers/')">Customer</a></li>
					<li><a href="#" id="catalog_href_id"
						ng-click="getApp('/api/catalog/')">Catalog</a></li>
					<li><a href="#" id="order_href_id"
						ng-click="getApp('/api/orders/')">Order</a></li>
					<li><a href="#" id="order_href_id"
						ng-click="getApp('/ui/')">New Customer</a></li>	
				</ul>
				<form class="navbar-form navbar-left" action="#">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</nav>

	</div>
	<div class="container" id="body_panel">
		<h1 class="col-sm-12">Customer Details</h1>
		<!-- <div class="row" id="customer_test_id">
			<div class="col-sm-12">
				<label class="col-sm-3">ID:</label> <span>{{customer.id}}</span>
			</div>

			<div class="col-sm-12">
				<label class="col-sm-3">Name:</label> <span>{{customer.name}}</span>
			</div>

			<div class="col-sm-12">
				Customer Id: <input type="text" id="id" ng-model="customer.id"
					ng-change="getCustomer()" /> <a class="btn btn-default" href="#"
					ng-click="getCustomer()">Details</a>
			</div>
		</div>	 -->
		<iframe id="iframeContent" ng-src="{{url}}" style="width: 100%; height: 400px; border: 0"></iframe>	
	</div>
	
</body>
</html>