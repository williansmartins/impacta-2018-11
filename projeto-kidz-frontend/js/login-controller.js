app.controller('loginCtrl', function($scope, $http, LoginService, $localStorage) {



    $scope.entrar = function(){
	    // console.info($localStorage);

        LoginService.login($scope.form)
        .success(function(response){

            if(response.status=="error"){
                alert("Houve um problema ao tentar fazer o login.");
            }else{
                $scope.nome = response.user.name;
                $scope.tipo = response.user.tipo;
                // $localStorage.nome = response.user.name;
                // $localStorage.token = response.token;
                // $localStorage.tipo = response.user.tipo;
                $scope.temErro = false;
                $scope.$storage.usuarioLogado = true;
                
                var objetoGlogal = {
                	// "localstorage" : $localStorage,
                	"flagMostrarMenu" : true
                }

                $rootScope.$broadcast('topic', objetoGlogal);

                $location.path("/contas");
            }

        })
        .error(function(response){
            $scope.$storage.usuarioLogado = false;
            $scope.temErro = true;
            alert("Houve um problema ao tentar fazer o login.");
        });
    }

});