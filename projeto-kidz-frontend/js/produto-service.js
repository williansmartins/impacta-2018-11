angular
.module('myApp')
.factory('ProdutoService', ProdutoService);

function ProdutoService ($q, $window, $http) {
    return {

        inserir : function (form) {
            return $http({
                method : "POST",
                url : backend + "/produto",
                data: {
                    "titulo": form.titulo,
                    "descricao": form.descricao,
                    "sexo":form.sexo,
                    "cor":form.cor,
                    "tamanho":form.tamanho,
                    "status":form.status,
                    "categoria":form.categoria,
                    "user_id":user_id
                }
            })         
        },

        buscarTodos : function (form) {
            return $http({
                method : "GET",
                url : backend + "/produto",
                
            })         
        },
        buscar: function (form) {
            return $http({
                method : "GET",
                url : backend + "/produto" + form.id
                
            })         
        },

    deletar : function (form) {
            return $http({
                method : "DELETE",
                url : backend + "/produto" + form.id
                
            })         
        },


    atualizar : function (form) {
            return $http({
                method : "PUT",
                url : backend + "/produto" + form.id,
                data: {
                    "id":form.id,
                    "titulo": form.titulo,
                    "descricao": form.descricao,
                    "sexo":form.sexo,
                    "cor":form.cor,
                    "tamanho":form.tamanho,
                    "status":form.status,
                    "categoria":form.categoria,
                    "user_id":user_id
                }
            })         
        },


    };
}