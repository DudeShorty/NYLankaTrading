/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .factory('BrandService', ['$http', function ($http) {
        var baseURL = 'v1/brand';
        return {
            insert: function (brandDTO) {
                return $http.post(baseURL + '/add', brandDTO);
            },
            search: function () {

            },
            readAll: function () {
                return $http.get(baseURL + '/get');
            },
            deactivate: function (brandId) {
                return $http.get(baseURL + '/deactivate/' + brandId);
            }
        };
    }]);