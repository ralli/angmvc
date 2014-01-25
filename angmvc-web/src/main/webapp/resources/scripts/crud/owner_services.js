'use strict';

(function () {
  var app = angular.module("ownerApp");

  app.factory("ownerService", ["$resource", function ($resource) {
    return $resource("api/owners/:id",
      { 'id': '@id'},
      {
        'update': { 'method': 'PUT'},
        'delete': { 'method': 'DELETE'}
      }
    );
  }]);

  app.factory("messageService", function () {
    var result = {};
    result.showError = function (message) {
      toastr.error(message);
    };

    result.showSuccess = function (message) {
      toastr.success(message);
    };

    result.showInfo = function (message) {
      toastr.info(message);
    };

    result.showWarning = function (message) {
      toastr.warning(message);
    };

    return result;
  });
}).call(this);