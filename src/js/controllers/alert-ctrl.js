/**
 * Alerts Controller
 */

angular
    .module('RDash')
    .controller('AlertsCtrl', ['$scope', 'AlertService', AlertsCtrl]);

function AlertsCtrl($scope, AlertService) {
    $scope.alerts = [{
        type: 'success',
        msg: 'Thanks for visiting! Feel free to create pull requests to improve the dashboard!'
    }, {
        type: 'danger',
        msg: 'Found a bug? Create an issue with as many details as you can.'
    }];

    $scope.alerts = AlertService.alerts;

    $scope.addAlert = addAlert;
    function addAlert() {
        $scope.alerts.push({
            msg: 'Another alert!'
        });
    };

    $scope.addSuccessAlert = addSuccessAlert;
    function addSuccessAlert(message) {
        $scope.alerts.push({
            type: 'success',
            msg: message
        });
    };

    $scope.closeAlert = closeAlert;
    function closeAlert(index) {
        $scope.alerts.splice(index, 1);
    };
}