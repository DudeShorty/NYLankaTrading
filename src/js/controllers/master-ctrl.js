/**
 * Master Controller
 */

angular.module('RDash')
    .controller('MasterCtrl', ['$scope', '$cookieStore', 'UserService', '$location', MasterCtrl]);

function MasterCtrl($scope, $cookieStore, UserService, $location) {

    var authenticate = function (credentials, callback) {
        if (credentials.username == null || credentials.password == null) {
            return;
        }
        UserService.login(credentials)
            .success(function (data) {
                if (credentials.username == data.username) {
                    $scope.authenticated = true;
                    $cookieStore.put('authenticated', true);
                } else {
                    $location.path("/login");
                    $scope.authenticated = false;
                    $cookieStore.put('authenticated', false);
                }
                $scope.credentials = {
                    "username": null,
                    "password": null
                };
                callback && callback();
            })
            .error(function (error) {
                $location.path("/login");
                $scope.authenticated = false;
                $cookieStore.put('authenticated', false);
                callback && callback();
            });
        };

        $scope.credentials = {
            "username": null,
            "password": null
        };

        $scope.login = login;
        function login() {
            $scope.authenticated = $cookieStore.get('authenticated');
            if ($scope.authenticated) {
                $scope.error = false;
                $scope.authenticated = true;
                $cookieStore.put('authenticated', true);
            } else {
                authenticate($scope.credentials, function () {
                    if ($scope.authenticated) {
                        $location.path("/item-category");
                        $scope.error = false;
                    } else {
                        $location.path("/login");
                        $scope.error = true;
                    }
                });
            }
        }

        login();

        $scope.logout = logout;
        function logout() {
            $scope.authenticated = false;
            $location.path("/login");
            $cookieStore.remove('authenticated');
        }

        /**
         * Sidebar Toggle & Cookie Control
         */
        var mobileView = 992;

        $scope.getWidth = function () {
            return window.innerWidth;
        };

        $scope.$watch($scope.getWidth, function (newValue, oldValue) {
            if (newValue >= mobileView) {
                if (angular.isDefined($cookieStore.get('toggle'))) {
                    $scope.toggle = !$cookieStore.get('toggle') ? false : true;
                } else {
                    $scope.toggle = true;
                }
            } else {
                $scope.toggle = false;
            }

        });

        $scope.toggleSidebar = function () {
            $scope.toggle = !$scope.toggle;
            $cookieStore.put('toggle', $scope.toggle);
        };

        window.onresize = function () {
            $scope.$apply();
        };
    }