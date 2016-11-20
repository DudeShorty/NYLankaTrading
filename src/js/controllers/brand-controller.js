/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .controller('BrandCtrl', ['$scope', 'BrandService', function ($scope, BrandService) {

        console.log('BrandCtrl');
        $scope.brandDTO = {
            name: null,
            active: true
        };

        $scope.addBrand = addBrand;
        function addBrand() {
            console.log('AddBrand');
            BrandService.insert($scope.brandDTO)
                .success(function () {
                    alert('Success');
                })
                .error(function (error) {
                    console.error(error);
                });
        }

        $scope.readAll = readAll;
        function readAll() {
            BrandService.readAll()
                .success(function (data) {
                    $scope.brands = data;
                })
                .error(function (error) {
                    console.error(error);
                });
        }
        readAll();
    }]);