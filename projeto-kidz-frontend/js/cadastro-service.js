angular
.module('myApp')
.factory('CadastroService', CadastroService);

function CadastroService ($q, $window, $http) {
    var url = "/cadastrar";

    return {

        buscar : function (form) {
            return $http({
                method : "GET",
                url : backend + url,
                data: {}
            })
        },

        buscarId : function (form) {
            return $http({
                method : "GET",
                url : backend + url + "/" + form.id,
                data: {}
            })
        },

        cadastrar : function (form) {
            return $http({
                method : "POST",
                url : backend + url,
                data: {
                    "email": form.email,
                    "senha": form.senha
                }
            })
        },

    };
}