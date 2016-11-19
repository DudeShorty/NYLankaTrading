/**
 * Created by Aux-058 on 11/19/2016.
 */
angular.module('RDash')
    .factory('ItemTankService', ['$http', function ($http) {
        var baseURL = 'v1/itemtank';
        return {
            insert : function (item) {
                return $http.post(baseURL + '/add', item);
            },
            search : function () {

            },
            read : function () {
                return $http.get(baseURL + '/get');
            }
        };
    }]);