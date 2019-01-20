app.controller('produtoController', function($scope, $http, LoginService, $localStorage, ProdutoService) {

   

    $scope.criancas = null;

      $scope.cadastrar = function(){
        // console.info($localStorage);

        ProdutoService.inserir($scope.form)
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

    // $scope.buscarCriancas = function(){
    //     CriancaService.buscarTodos()
    //     .then(function successCallback(response) {
    //         // this callback will be called asynchronously
    //         // when the response is available
    //         console.info("sucesso:");
    //         console.info(response);
    //         $scope.criancas = response.data;

    //       }, function errorCallback(response) {
    //         // called asynchronously if an error occurs
    //         // or server returns response with an error status.
    //         alert("Erro ao tentar fazer o cadastro.");
    //         console.info("error:");
    //         console.info(response);
    //     });
    // }

    // $scope.excluirCrianca = function(id){
    //     CriancaService.deletar(id)
    //     .then(function successCallback(response) {
    //         $scope.buscarCriancas();

    //       }, function errorCallback(response) {
    //         // called asynchronously if an error occurs
    //         // or server returns response with an error status.
    //         console.info("Erro ao tentar excluir o cadastro.");
    //         console.info("error:");
    //         console.info(response);
    //     });
    // }

    // var init = function(){
    //     $scope.buscarCriancas();
    // }

    // //init();

});