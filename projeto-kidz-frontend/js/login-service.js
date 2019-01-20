angular
.module('myApp')
.factory('LoginService', LoginService);

function LoginService ($q, $window, $http) {
    return {

        login : function (form) {
            return $http({
                method : "POST",
                url : backend + "/auth",
                data: {
                    "username": form.username,
                    "password": form.password
                }
            })
        },

    };
}