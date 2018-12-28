angular.module('principal')
.controller('LoginController', ['$scope', '$uibModal', '$log', '$document', '$location', '$window', '$filter', 'LoginService', '$rootScope', '$localStorage','$rootScope', 
	function ($scope, $uibModal, $log, $document, $location, $window, $filter, LoginService, $rootScope, $localStorage, $rootScope) {

    $scope.temErro = false;
    $scope.mensagem = "";
    $scope.form = {
    	"name": "",
    	"email": "",
    	"password": ""
    };
    $scope.$storage = $localStorage;
    $scope.flagMostrarLogin = true;

    // $scope.solicitar = function(){
    // 	console.info("solicitando para:");
    // 	console.info($scope.form);

    // 	LoginService.validarDisponibilidade($scope.form)
    //     .success(function(response, status){
    //         if(status == 406){
    //     		apresentarMensagem("Usuário não disponível");
    //     	}else{
    //     		cadastrar();
    //     	}
    //     })
    //     .error(function(response){
        	
    //     	console.info(response);
    //         apresentarMensagem("Usuário indisponível:");
    //     });
    // }

    $scope.cadastrar = function(){

    	//todo: validar email

    	//validar usuario
    	LoginService.cadastrar($scope.form)
        .success(function(response, status){
            if(status == 200 && response != null){
        		apresentarMensagem("Cadastro efetuado com sucesso, a partir de agora você pode entrar com seu usuário e senha.");
        		$scope.flagMostrarLogin = true;
            }else{
                //TODO: tratar erro 409(quando usuario ja esta cadastrado)
                apresentarMensagem("Erro ao solicitar cadastro");
            }
        })
        .error(function(response){
            apresentarMensagem("Erro ao solicitar cadastro");
        });
    }

    $scope.login = function(){
        LoginService.login($scope.form)
        .success(function(data, status, headers, config){

            debugger;
            // //TODO: nao era pra ser assim, erro de login tinha que cair em error...
            // if(response.status=="error"){
            //     apresentarMensagem("Houve um problema ao tentar fazer o login.");
            // }else{
            //     $scope.nome = response.user.name;
            //     $scope.tipo = response.user.tipo;
            //     $localStorage.nome = response.user.name;
            //     $localStorage.token = response.token;
            //     $localStorage.tipo = response.user.tipo;
            //     $scope.temErro = false;
            //     $scope.$storage.usuarioLogado = true;
                
            //     var objetoGlogal = {
            //     	"localstorage" : $localStorage,
            //         "flagMostrarMenu" : true,
            //     	"flagMostrarRodape" : false
            //     }

            //     $rootScope.$broadcast('topic', objetoGlogal);

            //     $location.path("/home");
            // }

        })
        .error(function(response){
            $scope.$storage.usuarioLogado = false;
            $scope.temErro = true;
            apresentarMensagem("Houve um problema ao tentar fazer o login.");
        });
    }

    var limparDadosDeLogin = function(){

     	var objetoGlogal = {
        	"localstorage" : null,
        	"flagMostrarMenu" : null,
            "flagMostrarRodape" : true
        }

        $rootScope.$broadcast('topic', objetoGlogal);
    }

    init = function() {
        limparDadosDeLogin();
    };

	init();
}]);