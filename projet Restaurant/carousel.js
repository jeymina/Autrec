/*(function() {
  'use strict';


  angular.module('app', ['ui.bootstrap','ui.bootstrap.tpls', 'ngAnimate'])
    .controller('carousel', carousel);
  function carousel($scope,$animate){
    $animate.enabled(true);
    $scope.myInterval = 3000;
    $scope.noWrapSlides = false;
    $scope.activeSlide = 0;
    $scope.slides = [

    {
      image: 'http://lorempixel.com/400/200/'
    },
    {
      image: 'http://lorempixel.com/400/200/food'
    },
    {
      image: 'http://lorempixel.com/400/200/sports'
    },
    {
      image: 'http://lorempixel.com/400/200/people'
    }
    ];
  }
})();
*/
var monAppli= {};
var app = angular.module('monAppli', ['ui.bootstrap', 'ngAnimate']) 

app.controller('carousel',['$scope', '$animate', function ($scope, $animate) {
    
    // will work as normal, if globaly disabled
    $animate.enabled(true); 
    
    $scope.slides = [
        { image: 'http://lorempixel.com/400/200/', text: 'blah' },    
        { image: 'http://lorempixel.com/400/200/', text: 'blah' },
        { image: 'http://lorempixel.com/400/200/', text: 'blah' }, 
    ]
        
}]);
