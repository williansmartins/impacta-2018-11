angular
.module('myApp')
.factory('CriancaService', CriancaService);

function CriancaService ($q, $window, $http) {
    return {

        buscarTodos : function (form) {
            return $http({
                method : "GET",
                url : backend + "/crianca",
            })
        },


        buscar : function (form) {
            return $http({
                method : "GET",
                url : backend + "/crianca/" + form.id,
                data: {
                    "id" : form.id
                }
            })
        },


        atualizar : function (form) {
            return $http({
                method : "PUT",
                url : backend + "/crianca/" + form.id,
                data: {
                    "id" : form.id,
                    "user_id": form.user_id,
                    "nome": form.nome,
                    "nascimento" : form.nascimento,
                    "sexo" : form.sexo

                }
            })
        },

        deletar : function (form) {
            return $http({
                method : "DELETE",
                url : backend + "/crianca/" +form.id,
                data: {
                    "id" : form.id
                }
            })
        },

    };
}