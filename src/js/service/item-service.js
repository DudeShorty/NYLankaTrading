/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .factory('ItemService', ['$http', function ($http) {
    var baseURL = 'v1/item';
    return {
        insert : function (item) {
            return $http.post(baseURL + '/add', item);
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