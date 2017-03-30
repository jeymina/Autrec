    var monApp = angular.module('monAppli', ['ngRoute', 'ngAnimate', 'ngCookies']);

    monApp.controller('appCtrl', ['$scope', '$animate', '$rootScope', '$http', '$location', function($scope, $animate, $rootScope, $http, $location) {
        var vm = this;
        console.log("coucou");
        console.log();

        $scope.init = function() {
            $scope.checkIfConnected();
            $scope.getListePlats();
        }

        $scope.redirect = function() {
            $location.path('/login');
        }

        $scope.redirectPanier = function(){
            $location.path('/monPanier');
        }

        $scope.ajouterAuPanier = function(id) {
            console.log("ajouterAuPanier" + id);
            $http({
                url: "http://25.66.6.53:8080/restokevina/ajoutepanier.htm",
                method: "POST",
                withCredentials: true,
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    platId: id,
                    userId: $scope.connected.data.response.session.utilActif.id,
                    qte: 1
                }
            }).then(function(data) {
                if (data.data.response.retour === "success") {}
            }).catch(function(data) {
                console.log("ajout pas fait");
            });
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
                //[].forEach.call(document.querySelectorAll('.navbar'), function (el) {
                  //  el.style.visibility = 'hidden';
               // });          
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
                    console.log("je met $scope.connected à null (index)");
                    $scope.connected = null;
                    //[].forEach.call(document.querySelectorAll('.navbar'), function (el) {
                    //  el.style.visibility = 'hidden';
                    // });          
                }
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


    $scope.getListePlats = function() {
        console.log("entrée dans le getListePlats");
        $http({
            url: "http://25.66.6.53:8080/restokevina/lesplatstrie.htm",
            method: "GET",
            withCredentials: true,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function(data) {
            if (data.data.response.retour === "success") {
                console.log(data.data);
                $scope.listeEntrees = data.data.response.listeEntree;
                $scope.listePlats = data.data.response.listePlatPrinc;
                $scope.listeDesserts = data.data.response.listeDessert;
            }
        }).catch(function(data) {
            console.log("GetSession de l'index n'est pas passé");
        });
      }

        $scope.getPanier = function() {
            console.log("entrée dans le getPanier");
            $http({
                url: "http://25.66.6.53:8080/restokevina/getpanier.htm",
                method: "POST",
                withCredentials: true,
                data: {
                    id: $scope.connected.data.response.session.utilActif.id
                },
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function(data) {
                if (data.data.response.retour === "success") {
                    console.log(data.data);
                    $scope.monPanier = data;
                } else {
                    console.log("pas de panier :c")
                }

            }).catch(function(data) {
                console.log("GetSession de l'index n'est pas passé");
            });
        }

        $scope.calculPrixPlat = function(plat) {
            var prix = 0;
            var ling = plat.listIngPlat;
            for (ing in ling) {
                prix += ling[ing].montant;
            }
            return prix;
        }

        $scope.getListePlats = function() {
            console.log("entrée dans le getListePlats");
            $http({
                url: "http://25.66.6.53:8080/restokevina/lesplatstrie.htm",
                method: "GET",
                withCredentials: true,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function(data) {
                if (data.data.response.retour === "success") {
                    console.log(data.data);
                    $scope.listeEntrees = data.data.response.listeEntree;
                    $scope.listePlats = data.data.response.listePlatPrinc;
                    $scope.listeDesserts = data.data.response.listeDessert;
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
            }).when('/monPanier', {
                    controller: 'LoginController',
                    templateUrl: 'panier.html'
            }).when('/tmp', {
                    controller: 'LoginController',
                    templateUrl: 'tmp.html'
            }).otherwise({
                redirectTo: '/home'
            });
    }]);
