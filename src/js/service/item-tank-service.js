/**
 * Created by Aux-058 on 11/19/2016.
 */
angular.module('RDash')
    .factory('ItemTankService', ['$http', function ($http) {
        var baseURL = 'v1/itemTank';
        return {
            insert : function (itemTank) {
                return $http.post(baseURL + '/add', itemTank);
            },
            search : function () {

            },
            read : function () {
                return $http.get(baseURL + '/get');
            }
        };
    }]);