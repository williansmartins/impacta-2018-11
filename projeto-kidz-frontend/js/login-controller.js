var app = angular.module('myApp', []);

app.controller('criancaCtrl', function($scope, $http) {
 
	// $scope.email;

   	$scope.entrar = function(){
   		Jquery.post( "http://172.16.18.38:8080/auth", {
            'username': $scope.email,
            'password': $scope.senha
        } );


   		// $http({
     //        method : "POST",
     //        url : "http://172.16.18.38:8080/auth",
     //        data: {
     //            'username': $scope.email,
     //            'password': $scope.senha
     //        }
     //    })
   	}

   	$scope.cadastrar = function(){
	   	$http.get("http://172.16.18.38:8080/cadastro/" + $scope.senha)
	   	.then(function (response) {
	   		console.info(response.data.senha);
	   	});
   	}

});