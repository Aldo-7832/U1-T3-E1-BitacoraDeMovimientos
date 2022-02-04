angular
  .module('routingApp', ['ngRoute'])
  .config([
    '$routeProvider',
    function ($routeProvider) {
      $routeProvider
        .when('/', {
          templateUrl: 'login.html',
        })
        .when('/login', {
          templateUrl: 'login.html',
          controller: 'LoginCtrl',
          controllerAs: 'ctrlLogin',
        })
        .when('/products', {
          templateUrl: '/products.html',
          controller: 'LoginCtrl',
          controllerAs: 'ctrlLogin',
        })
        .when('/products/form', {
          templateUrl: '/productsForm.html',
          controller: 'LoginCtrl',
          controllerAs: 'ctrlLogin',
        })
        .when('/commits', {
          templateUrl: '/view/binnacle/binnacle.html',
          controller: 'BinnacleCtrl',
          controllerAs: 'ctrlBinnacle',
        })
        .otherwise({
          redirectTo: '/login',
        })
    },
  ])
  .constant('APP_URL', {
    url: 'http://localhost:8080',
  })
