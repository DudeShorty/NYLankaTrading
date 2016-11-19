/**
 * Created by Aux-058 on 11/19/2016.
 */

angular.module('RDash')
    .controller('ItemTankCtrl', ['$scope', 'ItemService', 'ItemTankService', 'AlertService',
        function ($scope, ItemService, ItemTankService, AlertService) {

            $scope.loadItemTankDTO = loadItemTankDTO;
            function loadItemTankDTO() {
                $scope.itemTank = {
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
        }]);