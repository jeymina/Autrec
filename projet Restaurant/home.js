var monApp = angular.module('monAppli', ['ngRoute', 'ngAnimate', 'ngCookies']);


monApp.controller('appCtrl', ['$scope', '$animate', '$rootScope', '$http', '$location', function($scope, $animate, $rootScope, $http, $location) {

    var vm = this;
    var isConnected;

    console.log("coucou");
    console.log();

    $scope.init = function() {
        $scope.checkIfConnected();
    }

    $scope.redirect = function() {
        $location.path('/login');
    }

    $scope.$on("myEvent", function(event, args) {
        console.log("MyEvent");
        $scope.checkIfConnected();
    });



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
            }
        }).catch(function(data) {
            console.log("déconnexion pas effectuée");
        });
    }

    $scope.checkIfConnected = function() {
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
                    $scope.connected = data;
                    console.log("data" + data.data);
                    console.log("Je suis connecté :" + data.data.response.session.utilActif.nom);
                    console.log($scope.connected.data.response.session.utilActif.nom);
                    console.log($scope.connected);
                } else {
                    $scope.connected = null;
                }
            }
        }).catch(function(data) {
            console.log("GetSession de l'index n'est pas passé");
        });

    }

    $scope.$on('$viewContentLoaded', function() {
        $('#navbar').load('navbar.html');
    });

    prent = window.parent;
    // will work as normal, if globaly disabled
    $animate.enabled(true);
    $scope.slides = [{
        image: 'http://lorempixel.com/400/200/',
        text: 'blah1'
    }, {
        image: 'http://lorempixel.com/400/200/nature',
        text: 'blah2'
    }, {
        image: 'http://lorempixel.com/400/200/food',
        text: 'blah3'
    }, ];

    $scope.isActive = function(i) {
        return $scope.index - 1 == i;
    }
    $scope.index = 0;
    $scope.currentImage = $scope.slides[$scope.index];
}]);



monApp.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
    $routeProvider
        .when("/home", {
            templateUrl: "index.html",
            controller: "appCtrl"
        })
        .when("/Desserts", {
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
