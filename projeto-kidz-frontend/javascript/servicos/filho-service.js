angular
.module('principal')
.factory('FilhoService', FilhoService);

function FilhoService ($q, $window, $http) {
    return {

        buscarFilhos : function (id) {
            return $http({
                method : "GET",
                url : barramento + "/generic/filho/"+id+"&transform=1",
            })
        },

        buscarFilhosDoPai : function (id_pai) {
            return $http({
                method : "GET",
                url : barramento + "/generic/filho?filter=id_pai,eq,"+id_pai+"&transform=1",
            })
        },

        inserir : function (objeto) {
            return $http({
                method : "POST",
                url : barramento + "/generic/filho",
                data: objeto
            })
        },

        atualizar : function (objeto) {
            return $http({
                method : "PUT",
                url : barramento + "/generic/filho/"+ objeto.id,
                data: objeto
            })
        },

        excluir : function (id) {
            return $http({
                method : "DELETE",
                url : barramento + "/generic/filho/"+id,
            })
        },

    };
}