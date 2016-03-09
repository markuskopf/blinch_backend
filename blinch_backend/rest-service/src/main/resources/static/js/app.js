

/* App Module */

var blinchApp = angular.module('blinchApp', [
  'ngRoute',
  'blinchAppControllers'
]);

blinchApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/index', {
        templateUrl: 'partials/landing-login.html',
        controller: 'blinchAppCtrl'
      }).
      when('/dashboard', {
        templateUrl: 'partials/landing-dashboard.html',
      }).
      otherwise({
        redirectTo: '/index'
      });
  }]);
