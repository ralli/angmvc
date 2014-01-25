'use strict';

(function () {
    var app = angular.module("ownerApp", ['ngResource', 'ngRoute', 'ui']);

    app.config(["$routeProvider", "$locationProvider",
        function ($routeProvider, $locationProvider) {
            $locationProvider.html5Mode(false);
            $locationProvider.hashPrefix("!");
            $routeProvider
                .when('/', {
                    templateUrl: 'resources/scripts/crud/list.tpl.html',
                    controller: 'OwnerListCtrl'
                });
            $routeProvider
                .when('/new', {
                    templateUrl: 'resources/scripts/crud/create.tpl.html',
                    controller: 'OwnerCreateCtrl'
                });
            $routeProvider
                .when('/:id', {
                    templateUrl: 'resources/scripts/crud/show.tpl.html',
                    controller: 'OwnerShowCtrl'
                });
            $routeProvider
                .when('/:id/edit', {
                    templateUrl: 'resources/scripts/crud/edit.tpl.html',
                    controller: 'OwnerEditCtrl'
                });
        }
    ]);
}).call(this);