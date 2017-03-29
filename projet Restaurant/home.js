var monApp = angular.module('monAppli', ['ngRoute', 'ngAnimate', 'ngCookies']);

monApp.controller('appCtrl', ['$scope', '$animate', '$rootScope', '$http', '$location', function($scope, $animate, $rootScope, $http, $location) {
    var vm = this;

    console.log("coucou");
    console.log();

    $scope.init = function() {
        $scope.checkIfConnected();
        $scope.getListeEntrees();
    }

    $scope.redirect = function() {
        $location.path('/login');
    }


    $scope.logout = function() {
        $http({
            url: "http://25.66.6.53:8080/restokevina/deconnexion.htm",
            method: "POST",
            withCredentials: true,
            headers: {
                'Content-Type': 'application/json'
            },
            data: {}
        }).then(function(data) {
            if (data.data.response.retour === "success") {
                console.log("déconnexion effectuée")
                $scope.connected = null;
                [].forEach.call(document.querySelectorAll('.navbar'), function (el) {
                    el.style.visibility = 'hidden';
                });          
            }
        }).catch(function(data) {
            console.log("déconnexion pas effectuée");
        });
    }

    $scope.checkIfConnected = function() {
        console.log("entrée dans le checkIfConnected");
        $http({
            url: "http://25.66.6.53:8080/restokevina/getsession.htm",
            method: "GET",
            withCredentials: true,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(data) {
            if (data.data.response.retour === "success") {
                console.log(data.data);
                if (data.data.response.session.utilActif !== null) {
                    $scope.connected = data;
                    console.log("data" + data.data);
                    console.log("Je suis connecté :" + data.data.response.session.utilActif.nom);
                    console.log($scope.connected.data.response.session.utilActif.nom);
                    console.log($scope.connected);
                } else {
                    console.log("je met $scope.connected à null (index)")
                    $scope.connected = null;
                }
            }
        }).catch(function(data) {
            console.log("GetSession de l'index n'est pas passé");
        });

    }

    $scope.getListeEntrees = function() {
        console.log("entrée dans le getListeEntrees");
        $http({
            url: "http://25.66.6.53:8080/restokevina/lesentrees.htm",
            method: "GET",
            withCredentials: true,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(data) {
            if (data.data.response.retour === "success") {
                console.log(data.data);
                $scope.listeEntrees = data.data.response.listeEntree;
            }
        }).catch(function(data) {
            console.log("GetSession de l'index n'est pas passé");
        });

    }

    $scope.$on("myEvent", function(event, args) {
        console.log("MyEvent");
        $scope.checkIfConnected();
    });


    $scope.$on('$viewContentLoaded', function() {
        $http({
            url: "http://25.66.6.53:8080/restokevina/getsession.htm",
            method: "GET",
            withCredentials: true,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(data) {
            if (data.data.response.retour === "success") {
                if (data.data.response.session.utilActif !== null) {
                    console.log("chargement barre menu");
                    $('#navbar').load('navbar.html');
                    
                }
            }
        });
    });


}]);


monApp.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    $routeProvider
        .when("/home", {
            templateUrl: "index.html",
            controller: "appCtrl"
        })
        .when("/desserts", {
            templateUrl: "desserts.html",
            controller: "appCtrl"
        })
        .when("/entrees", {
            templateUrl: "entrees.html",
            controller: "appCtrl"
        })
        .when("/plats", {
            templateUrl: "plats.html",
            controller: "appCtrl"
        }).when('/login', {
            controller: 'LoginController',
            templateUrl: 'log/login/login.view.html',
            controllerAs: 'vm'
        }).when('/register', {
            controller: 'RegisterController',
            templateUrl: 'log/register/register.view.html',
            controllerAs: 'vm'
        }).otherwise({
            redirectTo: '/home'
        });
}]);