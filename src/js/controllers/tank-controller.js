/**
 * Created by Aux-058 on 11/19/2016.
 */
/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .controller('TankCtrl', ['$scope', 'TankService', 'AlertService', '$cookieStore', '$location',
        function ($scope, TankService, AlertService, $cookieStore, $location) {

            if ($cookieStore.get('authenticated')) {
                console.log('TankCtrl');

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
                    var date = new Date();
                    $scope.tankDTO = {
                        "name": null,
                        "identify_number": null,
                        "received_date": date,
                        "status": null
                    };
                }

                refreshTankDTO();

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
            } else {
                $location.path('/login');
            }
        }]);