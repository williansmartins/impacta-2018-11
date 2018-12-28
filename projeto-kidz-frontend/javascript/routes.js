angular.module('principal') 
.config(function($routeProvider) {
	
	$routeProvider.when('/', {
		templateUrl : "views/login.html",
		controller: 'LoginController'
	})
	.when('/login', {
		templateUrl : "views/login.html",
		controller: 'LoginController'
	})
	.when('/home', {
		templateUrl : "views/home.html",
		controller: 'HomeController'
	})
	.when('/filhos', {
		templateUrl : "views/filhos.html",
		controller: 'FilhosController'
	})
	.when('/404', {
		templateUrl : "views/404.html",
		controller: 'GraficoController'
	})
	.otherwise( {
		redirectTo: 'views/404.html'
	});

});