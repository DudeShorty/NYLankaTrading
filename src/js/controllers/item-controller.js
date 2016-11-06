/**
 * Created by Aux-058 on 11/6/2016.
 */
angular.module('RDash')
    .controller('ItemCtrl', ['$scope', 'ItemService', function ($scope, ItemService) {

        console.log('ItemCtrl');
        $scope.itemDTO = {
            name: null
        };

        $scope.addItem = addItem;
        function addItem() {
            console.log('AddItem');
            ItemService.insert($scope.itemDTO)
                .success(function () {
                    alert('Success');
                })
                .error(function (error) {
                    alert(JSON.stringify(error));
                });
        }
    }]);