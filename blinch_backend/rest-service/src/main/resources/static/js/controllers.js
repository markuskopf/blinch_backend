

var appControllers = angular.module('appControllers', []);


appControllers.controller('navigation',

		function($rootScope, $scope, $http, $location, $route, sharedProperties, headerStyle) {

            sharedProperties.setAnimation(false);
		    headerStyle.whiteHeader();

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
				}).error(function(response) {
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

                        sharedProperties.setAnimation(false);
                        headerStyle.whiteHeader();

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

				    headerStyle.coloredHeader();
				});
			}
});


appControllers.controller('home',

    function($rootScope, $scope, $http, $window, sharedProperties, headerStyle) {

            if($rootScope.authenticated == false) {
                sharedProperties.setAnimation(true);
                headerStyle.coloredHeader();
            } else {
                sharedProperties.setAnimation(false);
                headerStyle.whiteHeader();
            }

            angular.element($window).bind("scroll", function() {
                    if (sharedProperties.getAnimation()) {
                        if ($window.pageYOffset > 0) {
                            headerStyle.whiteHeader();
                        } else {
                            headerStyle.coloredHeader();
                        }
                    }
        });

	$http.get('/resource/').success(function(data) {
		$scope.greeting = data;
	})
});

appControllers.controller('register',

        function($scope, $http, $location, $route, sharedProperties, headerStyle) {

            sharedProperties.setAnimation(false);
            headerStyle.whiteHeader();

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

appControllers.controller('signup',

        function($scope, $document, sharedProperties, headerStyle) {
                sharedProperties.setAnimation(false);
                headerStyle.whiteHeader();
        }
);

appControllers.factory('sharedProperties', function() {
        var animation = true;

        return {
            getAnimation: function () {
                return animation;
            },
            setAnimation: function(value) {
                animation = value;
            }
        };
});

appControllers.factory('headerStyle',
    function($document) {

        return {
             whiteHeader : function() {
                var bgId = angular.element('#bg_id');
                bgId.addClass('show');

                var loginAnchor = angular.element('#loginAnchor');
                loginAnchor.addClass('navshow');

                var logoutAnchor = angular.element('#logoutAnchor');
                logoutAnchor.addClass('navshow');

                var signupAnchor = angular.element('#signupAnchor');
                signupAnchor.addClass('navshow');

                var registerAnchor = angular.element('#registerAnchor');
                registerAnchor.addClass('navshow');

                var element = angular.element('#logo');
                element.removeClass('logoWhite');
             },

             coloredHeader : function() {
                var bar = angular.element('#bg_id');
                bar.removeClass('show');

                var loginAnchor = angular.element('#loginAnchor');
                loginAnchor.removeClass('navshow');

                var logoutAnchor = angular.element('#logoutAnchor');
                logoutAnchor.removeClass('navshow');

                var signupAnchor = angular.element('#signupAnchor');
                signupAnchor.removeClass('navshow');

                var registerAnchor = angular.element('#registerAnchor');
                registerAnchor.removeClass('navshow');

                var element = angular.element('#logo');
                element.addClass('logoWhite');
             }
        }
});