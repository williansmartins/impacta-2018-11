angular
.module('principal')
.factory('LoginService', LoginService);

function LoginService ($q, $window, $http) {
    return {

        getToken : function () {
            return $window.sessionStorage.getItem("token");
        },

        setToken: function (token) {
            $window.sessionStorage.setItem("token", token);
        },

        login : function (form) {
            return $http({
                method : "POST",
                url : barramento + "/login",
                data: {
                    'username': form.email,
                    'password': form.password
                }
            })
        },

        cadastrar : function (form) {
            return $http({
                method : "POST",
                url : barramento + "/user",
                data: {
                    "name" : form.name,
                    "lastName" : form.name,
                    "email" : form.email,
                    "password" : form.password
                }
            })
        },

        // validarDisponibilidade : function (form) {
        //     return $http({
        //         method : "POST",
        //         url : barramento + "/validarDisponibilidade",
        //         params: {
        //             'email': form.email
        //         }
        //     })
        // },

        logout : function (data) {
            $window.sessionStorage.setItem("token", "");
            $q.when();
        }
    };
}