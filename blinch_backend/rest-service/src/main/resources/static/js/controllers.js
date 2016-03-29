

var appControllers = angular.module('appControllers', []);


appControllers.controller('navigation',

		function($rootScope, $scope, $http, $location, $route) {

			var self = this;

			self.tab = function(route) {
				return $route.current && route === $route.current.controller;
			};

			var authenticate = function(credentials, callback) {

				var headers = credentials ? {
					authorization : "Basic "
							+ btoa(credentials.username + ":"
									+ credentials.password)
				} : {};

				$http.get('user', {
					headers : headers
				}).success(function(data) {
					if (data.name) {
						$rootScope.authenticated = true;
					} else {
						$rootScope.authenticated = false;
					}

					callback && callback($rootScope.authenticated);
				}).error(function() {
					$rootScope.authenticated = false;
					callback && callback(false);
				});

			}

			authenticate();

			self.credentials = {};
			self.login = function() {
				authenticate(self.credentials, function(authenticated) {
					if (authenticated) {
						console.log("Login succeeded")
						$location.path("/");
						self.error = false;
						$rootScope.authenticated = true;
					} else {
						console.log("Login failed")
						$location.path("/login");
						self.error = true;
						$rootScope.authenticated = false;
					}
				})
			};

			$scope.logout = function() {
				$http.post('logout', {}).success(function() {
					$rootScope.authenticated = false;
					$location.path("/");
				}).error(function(data) {
				    $rootScope.authenticated = false;
				});
			}
});


appControllers.controller('home', function($scope, $http) {
	$http.get('/resource/').success(function(data) {
		$scope.greeting = data;
	})

});

appControllers.controller('register',

        function($scope, $http, $location, $route) {

            var self = this;

            var sendRegistrationData = function(registrationData) {

            				$http.post('/api/v1/users', registrationData).then(function(response) {
                                                                                            console.log("Registration successful")
                                                                                            $location.path("/");
                                                                                        }, function(response) {
                                                                                            console.log("Registration failed")
                                                                                            $location.path("/register");
                                                                                        });

            }


            self.registrationData = {};

            self.registration = function() {

                    sendRegistrationData(self.registrationData);

           }
});

appControllers.controller('datePicker',

        function($scope) {
            $scope.myDate = new Date();
              $scope.minDate = new Date(
                  $scope.myDate.getFullYear(),
                  $scope.myDate.getMonth() - 2,
                  $scope.myDate.getDate());
              $scope.maxDate = new Date(
                  $scope.myDate.getFullYear(),
                  $scope.myDate.getMonth() + 2,
                  $scope.myDate.getDate());
              $scope.onlyWeekendsPredicate = function(date) {
                    var day = date.getDay();
                    return day === 0 || day === 6;
                }
        }
);