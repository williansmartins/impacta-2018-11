var app = angular.module('myApp', []);

app.controller('criancaCtrl', function($scope, $http) {

	// $scope.email;

   	$scope.entrar = function(){
   		$http.get("http://172.16.18.38:8081/cadastro")
	   	.then(function (response) {
	   		console.info(response);
	   	});
   	}

   	$scope.cadastrar = function(){
	   	$http.get("http://172.16.18.38:8081/cadastro/" + $scope.senha)
	   	.then(function (response) {
	   		console.info(response.data.senha);
	   	});
   	}

});