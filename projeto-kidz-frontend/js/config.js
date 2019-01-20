angular.module('myApp')
.config(function($httpProvider, $provide) {

})
.run(function($rootScope, $location, $window, $localStorage, $http) {

	// $httpProvider.defaults.common['Authorization'] = 'Bearer ' + token;
	var token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU0ODU5NDQ1NiwiaWF0IjoxNTQ3OTg5NjU2fQ.ykl42eC3JhQYic43lYOZ9BmuH7b5ub6R5qf4RGvfRNWYJkgjhPe_BSb6ibBnTol0N_4RVq_vW544Xdmo-AUj6w";
	$http.defaults.headers.common.Authorization = 'Bearer ' + token;


	$rootScope.$on( "$routeChangeStart", function(event, next, current) {
		
		var ignorar = false;
		if(!isEmpytNullOrUndefined(next)){
			// console.info("trocando de rota");
			//var ignorar = next.$$route.originalPath == "/painel-de-servicos";
		}else{
			// console.info("trocando de rota - sem next");
		}

		var usuarioLogado = $localStorage.usuarioLogado;
		if (!ignorar && isEmpytNullOrUndefined(usuarioLogado)) { 
			//$location.path("/login");
		}
	});
});
