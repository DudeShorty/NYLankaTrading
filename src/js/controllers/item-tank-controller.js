/**
 * Created by Aux-058 on 11/19/2016.
 */

angular.module('RDash')
    .controller('ItemTankCtrl', ['$scope', 'ItemService', 'TankService', 'ItemTankService', 'AlertService',
        function ($scope, ItemService, TankService, ItemTankService, AlertService) {

            $scope.loadItemTankDTO = loadItemTankDTO;
            function loadItemTankDTO() {
                $scope.itemTankDTO = {
                    "tank_id": -1,
                    "item_id": -1,
                    "qty": 0,
                    "unit_price": 0
                }
            }
            loadItemTankDTO();

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

            $scope.addItemTank = addItemTank;
            function addItemTank() {
                console.log('addItemTank');
                ItemTankService.insert($scope.itemTankDTO)
                    .success(function () {
                        loadItemTankDTO();
                        loadItems();
                        loadTanks();
                        AlertService.addSuccessAlert('Item Successfully Added To Tank.');
                    })
                    .error(function (error) {
                        console.error(error);
                    })
            }
        }]);