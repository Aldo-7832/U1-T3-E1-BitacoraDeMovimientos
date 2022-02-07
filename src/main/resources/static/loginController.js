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

var user = {
  id: 0,
  username: null,
  pass: null
};
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

    $scope.product = {
      id: null,
      name: null,
      price: null,
      total: null,
      description: null
    }

    // $scope.user = {
    //   id: null,
    //   username: null,
    //   pass: null
    // }

    this.createText = function () {
      action = 1;
    }

    this.updateText = function (item) {
      action = 2;
      productUpdate = item
    }

    this.setMessage = function () {
      if (action == 1) {
        $scope.titulo = "Registro de Productos";
        $scope.boton = "Registrar";
      } else {
        $scope.titulo = "Actualizar de Productos";
        $scope.boton = "Actualizar";
        $scope.product = productUpdate;
      }
    }

    this.cleanObjectCancel = function () {
      $scope.product = null;
    }

    this.findAll = () => {
      return $http({
        method: 'GET',
        url: APP_URL.url + "/product",
        headers: {
        },
      }).then((res) => {
        setTimeout(executeDataTable, 1);
        $scope.listProducts = res.data;
      }).catch((e) => {
        console.log(e);
      })
    }

    this.create = () => {
      $("#form").prop("disabled", true);
      return $http({
        method: "POST",
        url: APP_URL.url + "/product/save",
        headers: {
        },
        data: $scope.product
      }).then(res => {
        console.log(res);
        if (res.data) {

          if (action == 1) {
            notyf.success('¡Se ha registrado correctamente el Producto!');
          } else {
            notyf.success('¡Se ha actualizado correctamente el Producto!');
          }
          location.replace("#!/products");
        } else {
          notyf.error('¡Ha ocurrido un error inesperado al guardar el Producto!');
        }

      }, e => console.log("Error", e.message));
    };

    this.selectProduct = function (item) {
      productDelete = item;
    }

    this.inicioSesion = function () {
      user = $scope.user;
      return $http({
        method: 'POST',
        url: APP_URL.url + "/lastLogin/login/"+$scope.user.username+"/"+$scope.user.pass,
        headers: {
        },
      }).then((res) => {
        console.log(res.data);
        if (res.data) {
          notyf.success('¡BIENVENIDO!');
          console.log(res.data);
          return $http({
            method: 'POST',
            url: APP_URL.url + "/lastLogin/procedure/" + res.data.id,
            headers: {
            },
          }).then((res) => {
            $window.location.href = '#!products';
          }, (error) => {
            notyf.error('Ha ocurrido un error inesperado' + error);
          })
        } else {
          notyf.error('USUARIO INCORRECTO');
        }
      }, (error) => {
        notyf.error('Ha ocurrido un error inesperado');
      })
    }

    this.deleteProduct = function () {
      return $http({
        method: 'POST',
        url: APP_URL.url + "/product/delete",
        headers: {
        },
        data: productDelete
      }).then((res) => {
        this.findAll();
        $('#productsTable').DataTable().destroy();
      }, (error) => {
        notyf.error('Ha ocurrido un error inesperado' + error);
      })
    }

    this.prcedimiento = function(){
      console.log("Llega al llamado");
      return $http({
        method: 'POST',
        url: APP_URL.url + "/lastLogin/procedure/" + 2,
        headers: {
        },
      }).then((res) => {
        console.log(res.data);
      }, (error) => {
        notyf.error('Ha ocurrido un error inesperado' + error);
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
