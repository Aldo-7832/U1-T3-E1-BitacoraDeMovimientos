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
  
      this.findAll = () => {
        return $http({
            method: 'GET',
            url: APP_URL.url + "/product",
            headers: {
            },
            }).then((res) => {
            setTimeout(executeDataTable, 1);
            $scope.listProducts = res.data;
            }).catch((e)=>{
            console.log(e);
        })
    }

    function executeDataTable() {
      $('#productsTable').DataTable({
      language: {
          url: '//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json',
      },
      });
  }
    },
  ]);
  