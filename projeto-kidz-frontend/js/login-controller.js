app.controller('loginCtrl', function($scope, $http, LoginService, $localStorage, CriancaService) {

    $scope.form = {
        username : "admin",
        password : "admin",
        user_id: 123, 
        nome : "Luis Felipe", 
        dataNasc : "", 
        sexo : "Masculino"
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


    }

    $scope.cadastrarCrianca = function(){
        // console.info($localStorage);

        CriancaService.cadastrar($scope.form)
        .then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
            console.info("sucesso:");
            console.info(response);

          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            alert("Erro ao tentar fazer o cadastro.");
            console.info("error:");
            console.info(response);
        });

    }


    var init = function(){
        // LoginService.getCriancas()
        // .then(function(response){
        //     console.info(response.data);
        // })
    }

    init();

});