/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .controller('BrandCtrl', ['$scope', 'BrandService', function ($scope, BrandService) {

        console.log('BrandCtrl');
        $scope.brandDTO = {
            name: null,
            active: 1
        };

        $scope.addBrand = addBrand;
        function addBrand() {
            console.log('AddBrand');
            BrandService.insert($scope.brandDTO)
                .success(function () {
                    alert('Success');
                })
                .error(function (error) {
                    alert(JSON.stringify(error));
                });
        }

        // $scope.readAll = readAll;
        // function readAll() {
        //     BrandService.readAll()
        //         .success(function (data) {
        //             $scope.items = data;
        //         })
        //         .error(function (error) {
        //             alert(JSON.stringify(error));
        //         });
        // }
        // readAll();
    }]);