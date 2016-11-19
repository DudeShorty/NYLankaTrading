/**
 * Created by Aux-058 on 11/19/2016.
 */
angular.module('RDash')
    .factory('TankService', ['$http', function ($http) {
        var baseURL = 'v1/tank';
        return {
            insert : function (tank) {
                return $http.post(baseURL + '/add', tank);
            },
            search : function () {

            },
            read : function () {
                return $http.get(baseURL + '/get');
            },
            readActive : function () {
                return $http.get(baseURL + '/get/active');
            }
        };
    }]);