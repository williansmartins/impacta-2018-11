app.controller('loginCtrl', function($scope, $http, LoginService, $localStorage) {

    $scope.form = {
        username : "admin",
        password : "admin"
    }

    $scope.entrar = function(){
	    // console.info($localStorage);

        LoginService.login($scope.form)
        .then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
            console.info("sucesso:");
            console.info(response);
            $localStorage.token = response.data.token;

            window.location = "home.html";

          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            alert("Erro ao tentar fazer login.");
            console.info("error:");
            console.info(response);
        });


        // .then(
        //     function(response){
        //     debugger;

        //     if(response.status=="error"){
        //         alert("Houve um problema ao tentar fazer o login.");
        //     }else{
        //         $localStorage.token = response.token;
        //         $scope.temErro = false;
        //         $scope.$storage.usuarioLogado = true;
                
        //         var objetoGlogal = {
        //         	// "localstorage" : $localStorage,
        //         	"flagMostrarMenu" : true
        //         }

        //         $rootScope.$broadcast('topic', objetoGlogal);

        //         $location.path("/contas");
        //     }

        // },
        //   function(response){
        //     $scope.$storage.usuarioLogado = false;
        //     $scope.temErro = true;
        //     alert("Houve um problema ao tentar fazer o login.");
        // });
    }

    var init = function(){
        LoginService.getCriancas()
        .then(function(response){
            console.info(response.data);
        })
    }

    init();

});