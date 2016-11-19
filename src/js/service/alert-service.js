/**
 * Created by Aux-058 on 11/19/2016.
 */

angular.module('RDash')
    .factory('AlertService', [function() {
    return {
        alerts: [],
        addSuccessAlert: function(message) {
            this.alerts.push({
                type: 'success',
                msg: message
            });
        },
        addFailedAlert: function(message) {
            this.alerts.push({
                type: 'danger',
                msg: message
            });
        },
        clearAlerts: function() {
            for(var x in this.alerts) {
                delete this.alerts[x];
            }
        }
    };
}]);