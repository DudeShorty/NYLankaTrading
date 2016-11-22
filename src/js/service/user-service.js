/**
 * Created by Aux-058 on 11/22/2016.
 */
angular.module('RDash')
    .factory('UserService', ['$http', function ($http) {
        var baseURL = 'v1/user';
        return {
            insert : function (userDTO) {
                return $http.post(baseURL + '/add', userDTO);
            },
            login : function (userDTO) {
                return $http.post(baseURL + '/login', userDTO);
            }
        };
    }]);