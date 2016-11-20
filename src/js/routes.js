'use strict';

/**
 * Route configuration for the RDash module.
 */
angular.module('RDash').config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

        // For unmatched routes
        $urlRouterProvider.otherwise('/login');

        $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: 'templates/secure/login.html'
            })
            .state('itemTank', {
                url: '/item-tank',
                templateUrl: 'templates/ui/itemTank.html'
            })
            .state('tank', {
                url: '/tank',
                templateUrl: 'templates/master/tank.html'
            })
            .state('item', {
                url: '/item',
                templateUrl: 'templates/master/items.html'
            })
            .state('brand', {
                url: '/brand',
                templateUrl: 'templates/master/brand.html'
            })
            .state('itemCategory', {
                url: '/item-category',
                templateUrl: 'templates/ui/itemCategory.html'
            })
            .state('model', {
                url: '/model',
                templateUrl: 'templates/master/model.html'
            });
    }
]);