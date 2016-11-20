/**
 * Master Controller
 */

angular.module('RDash')
    .controller('MasterCtrl', ['$scope', '$cookieStore', '$http', '$location', MasterCtrl]);

function MasterCtrl($scope, $cookieStore, $http, $location) {

    var authenticate = function (credentials, callback) {
        // $http.get('user', {headers: headers}).then(function (response) {
        if (credentials.username == 'admin' && credentials.password == '123') {
            $scope.authenticated = true;
        } else {
            $location.path("/login");
            $scope.authenticated = false;
        }
        $scope.credentials = {
            "username": null,
            "password": null
        };
        callback && callback();
        // }, function () {
        //     $rootScope.authenticated = false;
        //     callback && callback();
        // });

    };

    $scope.credentials = {
        "username": null,
        "password": null
    };

    $scope.login = login;
    function login() {
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

    login();

    $scope.logout = logout;
    function logout() {
        // $http.post('logout', {}).finally(function() {
        $scope.authenticated = false;
        $location.path("/login");
        // });
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