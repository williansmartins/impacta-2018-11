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

        getCriancas : function (form) {
            return $http({
                method : "GET",
                url : backend + "/persons/",
                headers: [  
                    {
                        'Content-Type': 'application/json',
                        'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU0ODU5NDQ1NiwiaWF0IjoxNTQ3OTg5NjU2fQ.ykl42eC3JhQYic43lYOZ9BmuH7b5ub6R5qf4RGvfRNWYJkgjhPe_BSb6ibBnTol0N_4RVq_vW544Xdmo-AUj6w'
                    }
                ]
            })
        },



    };
}