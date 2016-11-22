/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .controller('BrandCtrl', ['$scope', 'BrandService', 'AlertService', function ($scope, BrandService, AlertService) {
        console.log('BrandCtrl');

        $scope.refreshBrandDTO = refreshBrandDTO;
        function refreshBrandDTO() {
            $scope.brandDTO = {
                name: null,
                active: true
            };
        }

        refreshBrandDTO();

        $scope.addBrand = addBrand;
        function addBrand() {
            console.log('AddBrand');
            BrandService.insert($scope.brandDTO)
                .success(function () {
                    readAll();
                    refreshBrandDTO();
                    AlertService.addSuccessAlert('Brand Saved Successfully.');
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

        $scope.deactivate = deactivate;
        function deactivate(id) {
            BrandService.deactivate(id)
                .success(function (data) {
                    readAll();
                })
                .error(function (error) {
                    console.error(error);
                });
        }

        readAll();
    }]);