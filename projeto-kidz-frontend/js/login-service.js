angular
.module('myApp')
.factory('LoginService', LoginService);

function LoginService ($q, $window, $http) {
    return {

        login : function (form) {
            return $http({
                method : "POST",
                url : backend + "/auth",
                headers: [{'Content-Type': 'application/json'}], 
                data: {
                    "username": form.username,
                    "password": form.password
                }
            })
        },

    };
}