/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .controller('ItemCtrl', ['$scope', 'ItemService', 'AlertService', function ($scope, ItemService, AlertService) {

        console.log('ItemCtrl');
        $scope.itemDTO = {
            name: null
        };

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
                    AlertService.addSuccessAlert('Item Saved Successfully.')
                })
                .error(function (error) {
                    alert(JSON.stringify(error));
                });
        }
    }]);