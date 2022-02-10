var action = 0;
var productUpdate = {
  id: null,
  name: null,
  price: null,
  total: null,
  description: null
}

var productDelete = {
  id: null,
  name: null,
  price: null,
  total: null,
  description: null
};
angular.module("routingApp").controller("BinnacleCtrl", [
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


    this.findAllCommits = () => {
      return $http({
        method: 'GET',
        url: APP_URL.url + "/commits",
        headers: {
        },
      }).then((res) => {
        setTimeout(executeDataTable, 1);
        $scope.listCommits = res.data;
        console.log("commits");
        console.log($scope.listCommits);
      }).catch((e) => {
        console.log(e);
      })
    }

    this.findAllLogins = () => {
      return $http({
        method: 'GET',
        url: APP_URL.url + "/lastLogin",
        headers: {
        },
      }).then((res) => {
        setTimeout(executeDataTable2, 1);
        $scope.listLastLogin = res.data;
      }).catch((e) => {
        console.log(e);
      })
    }

    function executeDataTable() {
      $('#commitsTable').DataTable({
        language: {
          url: '//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json',
        },
      });
    }

    function executeDataTable2() {
        $('#loginsTable').DataTable({
          language: {
            url: '//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json',
          },
        });
      }
  },
]);
