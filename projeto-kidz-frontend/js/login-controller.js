app.controller('loginCtrl', function($scope, $http, LoginService, $localStorage, CriancaService) {

    $scope.form = {
        username : "admin",
        password : "admin",
        user_id: 123, 
        nome : "Luis Felipe", 
        dataNasc : "", 
        sexo : "Masculino"
    }

    $scope.criancas = null;

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

    $scope.preencherCrianca = function(crianca){
        $scope.form = {
            username : crianca.username,
            password : crianca.password,
            user_id: crianca.user_id, 
            nome : crianca.nome, 
            dataNasc : crianca.dataNasc, 
            sexo : crianca.sexo
        }
    }

    $scope.cadastrarCrianca = function(){
        // console.info($localStorage);

        CriancaService.cadastrar($scope.form)
        .then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
            console.info("sucesso:");
            console.info(response);
            $scope.buscarCriancas();

          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            alert("Erro ao tentar fazer o cadastro.");
            console.info("error:");
            console.info(response);
        });

    }

    $scope.buscarCriancas = function(){
        CriancaService.buscarTodos()
        .then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
            console.info("sucesso:");
            console.info(response);
            $scope.criancas = response.data;

          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            alert("Erro ao tentar fazer o cadastro.");
            console.info("error:");
            console.info(response);
        });
    }

    $scope.excluirCrianca = function(id){
        CriancaService.deletar(id)
        .then(function successCallback(response) {
            $scope.buscarCriancas();

          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            console.info("Erro ao tentar excluir o cadastro.");
            console.info("error:");
            console.info(response);
        });
    }

    var init = function(){
        $scope.buscarCriancas();
    }

    init();

});