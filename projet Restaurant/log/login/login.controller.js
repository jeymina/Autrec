(function() {
    'use strict';

    angular
        .module('monAppli')
        .controller('LoginController', LoginController)
        .config(function($httpProvider) {
            delete $httpProvider.defaults.header;
        });


    LoginController.$inject = ['$scope', '$http', '$location'];


    function LoginController($scope, $http, $location) {
        var vm = this;
        var oui;

        vm.login = function() {
            console.log("pute");
            $http({
                url: "http://25.66.6.53:8080/restokevina/connexion.htm",
                method: "POST",
                data: {
                    id: vm.username,
                    pass: vm.password
                },
                withCredentials: true,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function(data) {
                console.log(data);
                if (data.data.response.retour === "success") {
                    console.log("et c'est connecté :D");

                    $http({
                        url: "http://25.66.6.53:8080/restokevina/getSession.htm",
                        method: "GET",
                        withCredentials: true,
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(function(data) {
                        $location.path('/home');
                    }).catch(function(data) {
                        console.log("nike bien toutes tes mères");
                    });



                } else {
                    console.log("pas connecté");
                }
            }).catch(function(error) {
                console.log(error);
            });
        }
    };

})();