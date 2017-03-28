(function() {
    'use strict';

    angular
        .module('monAppli')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['$scope', '$http', '$location'];

    function RegisterController($scope, $http, $location) {

    	var vm = this;

    	vm.register = function() {
            console.log("pute");
            $http({
                url: "http://25.66.6.53:8080/restokevina/signin.htm",
                method: "POST",
                data: {
                    nom: vm.user.firstName,
                    prenom: vm.user.lastName,
                    pass: vm.user.password,
                    tel: vm.user.tel,
                    mail: vm.user.mail, 
                    voirie: vm.user.voirie,
                    cp: vm.user.cp, 
                    ville: vm.user.ville
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
                        url: "http://25.66.6.53:8080/restokevina/getsession.htm",
                        method: "GET",
                        withCredentials: true,
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(function(data) {
                        $location.path('/login');
                    }).catch(function(data) {
                        console.log("nike bien toutes tes mères");
                    });



                } else {
                    console.log("échec register");
                    $scope.error = data.data.response.message;
                }
            }).catch(function(error) {
                console.log(error);
            });
        }



    }



})();
