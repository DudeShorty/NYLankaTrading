/**
 * Created by Aux-058 on 11/19/2016.
 */

angular.module('RDash')
    .controller('ItemTankCtrl', ['$scope', 'ItemService', 'TankService', 'ItemTankService', 'AlertService',
        function ($scope, ItemService, TankService, ItemTankService, AlertService) {

            $scope.loadItemTankDTO = loadItemTankDTO;
            function loadItemTankDTO() {
                $scope.itemTankDTO = {
                    "tank_id": null,
                    "qty": 0,
                    "unit_price": 0
                }
            }
            loadItemTankDTO();

            $scope.refreshItemTankDTO = refreshItemTankDTO;
            function refreshItemTankDTO(tank_id) {
                $scope.itemTankDTO = {
                    "tank_id": tank_id,
                    "qty": 0,
                    "unit_price": 0
                }
            }

            $scope.loadItems = loadItems;
            function loadItems() {
                ItemService.readActive()
                    .success(function (data) {
                        $scope.items = data;
                    })
                    .error(function (error) {
                        console.error(error);
                    });
            }
            loadItems();

            $scope.loadTanks = loadTanks;
            function loadTanks() {
                TankService.readActive()
                    .success(function (data) {
                        $scope.tanks = data;
                    })
                    .error(function (error) {
                        console.error(error);
                    });
            }
            loadTanks();

            $scope.loadItemTanks = loadItemTanks;
            function loadItemTanks() {
                if ($scope.itemTankDTO.tank_id == null || $scope.itemTankDTO.tank_id == '') {
                    $scope.itemTanks = [];
                } else {
                    ItemTankService.read($scope.itemTankDTO.tank_id)
                        .success(function (data) {
                            $scope.itemTanks = data;
                        })
                        .error(function (error) {
                            console.error(error);
                        });
                }
            }
            loadItemTanks();

            $scope.addItemTank = addItemTank;
            function addItemTank() {
                console.log('addItemTank');
                ItemTankService.insert($scope.itemTankDTO)
                    .success(function () {
                        loadItems();
                        loadTanks();
                        refreshItemTankDTO($scope.itemTankDTO.tank_id);
                        loadItemTanks();
                        AlertService.addSuccessAlert('Item Successfully Added To Tank.');
                    })
                    .error(function (error) {
                        console.error(error);
                    });
            }
        }]);