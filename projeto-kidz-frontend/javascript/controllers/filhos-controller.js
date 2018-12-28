angular.module('principal')
.controller('FilhosController', ['$scope', '$compile', '$uibModal', '$log', '$document', '$location', '$window', '$filter', '$localStorage', 'FilhoService', '$anchorScroll', '$filter', '$rootScope',
	function ($scope, $compile, $uibModal, $log, $document, $location, $window, $filter, $localStorage, FilhoService, $anchorScroll, $filter, $rootScope) {

    $scope.filhos = null;
    $scope.entidadeSelecionada = null;
    $scope.formats = ['yyyy-MM-dd', 'dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate', 'yyyy-MM'];
    $scope.format = $scope.formats[0];
    $scope.popup1 = { opened: false };

    var buscarFilhos = function(){
    	FilhoService.buscarFilhosDoPai(0).then(
    		function(response){
                if(response.data.filho){
                    $scope.filhos = response.data.filho;
                    tratarFilhos($scope.filhos);
                }else{
                    alert("erro ao buscar");
                }
    		},function(response){
    			console.info(response);
    		}
    	);
    }

    var tratarFilhos = function(filhos){
        filhos.forEach(function(item){
            var nascimento = new Date(item.nascimento); 
            item.idade = calcularIdade(nascimento.getFullYear(), nascimento.getMonth(), nascimento.getDate());
        });
    }

    $scope.open1 = function() {
        $scope.popup1.opened = true;
    };

    init = function() {
        buscarFilhos();
    };
    
	init();
}]);