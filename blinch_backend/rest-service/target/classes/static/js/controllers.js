
'use strict';

/* Controllers */

var blinchAppControllers = angular.module('blinchAppControllers', []);

blinchAppControllers.controller('blinchAppCtrl', ['$scope', '$http',
   function($scope, $http) {
     $http.get('/resource/').success(function(data) {
                $scope.greeting = data;
            })
   }]);

blinchAppControllers.controller('blinchAppCtrl', ['$scope', '$routeParams',
   function($scope, $routeParams) {
     $scope.phoneId = $routeParams.phoneId;
   }]);
