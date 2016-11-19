/**
 * Created by Aux-058 on 11/19/2016.
 */

angular.module('RDash')
    .factory('AlertService', ['$timeout', function (timeout) {
        return {
            alerts: [],
            addSuccessAlert: function (message) {
                var alert = {
                    type: 'success',
                    msg: message
                }
                this.alerts.push(alert);
            },
            addFailedAlert: function (message) {
                this.alerts.push({
                    type: 'danger',
                    msg: message
                });
            },
            clearAlerts: function () {
                for (var x in this.alerts) {
                    delete this.alerts[x];
                }
            }
        };
    }]);