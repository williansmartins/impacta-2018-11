angular.module('principal')
.controller('HomeController', ['$scope', '$compile', '$uibModal', '$log', '$document', '$location', '$window', '$filter', '$localStorage', 'FilhoService', '$anchorScroll', '$filter', '$rootScope',
	function ($scope, $compile, $uibModal, $log, $document, $location, $window, $filter, $localStorage, FilhoService, $anchorScroll, $filter, $rootScope) {

    init = function() {
    	FilhoService.buscarFilhosDoPai(0).then(
    		function(response){
    			console.info(response);
    			alert(response);
    		},function(response){
    			console.info(response);
    		}
    	);
    };
    
	//init();
}]);