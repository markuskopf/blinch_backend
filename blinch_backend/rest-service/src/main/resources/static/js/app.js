

var app = angular.module('app', [
    'ngRoute' ,
    'appControllers' ,
    'ngMessages' ,
    'ngMaterial'
]);

app.config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'home.html',
		controller : 'home',
		controllerAs: 'controller'
	}).when('/login', {
		templateUrl : 'login.html',
		controller : 'navigation',
		controllerAs: 'controller'
	}).when('/register', {
	    templateUrl : 'register.html',
	    controller : 'register',
	    controllerAs: 'register'
	}).when('/signup', {
      	templateUrl : 'signup.html',
      	controller : 'signup',
      	controllerAs: 'signup'
     }).otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

});