/**
 * Created by Aux-058 on 11/19/2016.
 */
/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .controller('TankCtrl', ['$scope', 'TankService', 'AlertService', function ($scope, TankService, AlertService) {

        console.log('TankCtrl');
        $scope.tankDTO = {
            name: null
        };

        $scope.readTanks = readTanks;
        function readTanks() {
            TankService.read()
                .success(function (data) {
                    $scope.tanks = data;
                })
                .error(function (error) {
                    console.error(error);
                })
        }
        readTanks();

        $scope.refreshTankDTO = refreshTankDTO;
        function refreshTankDTO() {
            $scope.tankDTO = {
                "name" : null
            };
        }

        $scope.addTank = addTank;
        function addTank() {
            console.log('addTank');
            TankService.insert($scope.tankDTO)
                .success(function () {
                    refreshTankDTO();
                    readTanks();
                    AlertService.addSuccessAlert('Tank Saved Successfully.')
                })
                .error(function (error) {
                    console.error(error);
                });
        }
    }]);