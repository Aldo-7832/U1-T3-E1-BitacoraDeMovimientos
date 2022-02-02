angular.module("routingApp").controller("LoginCtrl", [
    "$rootScope",
    "$scope",
    "$http",
    "APP_URL",
    "$routeParams",
    "$window",
    function ($rootScope, $scope, $http, APP_URL, $routeParams, $window) {
      const notyf = new Notyf({
        duration: 2500,
        position: {
          x: "right",
          y: "top",
        },
      });
  
      this.sayHello = function(){
        notyf.error("Usuario y/o Contraseña Incorrecto");
        console.log("Hola");
      }
    },
  ]);
  