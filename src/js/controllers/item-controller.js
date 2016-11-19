/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .controller('ItemCtrl', ['$scope', 'ItemService', 'AlertService', function ($scope, ItemService, AlertService) {

        console.log('ItemCtrl');
        $scope.itemDTO = {
            name: null
        };

        $scope.readItems = readItems;
        function readItems() {
            ItemService.read()
                .success(function (data) {
                    $scope.items = data;
                })
                .error(function (error) {
                    console.error(error);
                })
        }
        readItems();

        $scope.refreshItemDTO = refreshItemDTO;
        function refreshItemDTO() {
            $scope.itemDTO = {
                "name" : null
            };
        }

        $scope.addItem = addItem;
        function addItem() {
            console.log('AddItem');
            ItemService.insert($scope.itemDTO)
                .success(function () {
                    refreshItemDTO();
                    readItems();
                    AlertService.addSuccessAlert('Item Saved Successfully.')
                })
                .error(function (error) {
                    console.error(error);
                });
        }
    }]);