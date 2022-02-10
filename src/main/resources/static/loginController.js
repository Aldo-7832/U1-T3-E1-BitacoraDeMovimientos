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
      let date = new Date();
      let time = date.toLocaleString('en-US', { hour: 'numeric', hour12: false }) + ":" + date.getMinutes() + ":" + date.getSeconds();
      if (action == 1) {
        $scope.commit = {
          product: $scope.product,
          user: JSON.parse(this.decode(localStorage.getItem("Usuario"))),
          date: date,
          hour: time,
          action: "Registrar",
          table: "1"
        }
      } else {
        $scope.commit = {
          product: $scope.product,
          user: JSON.parse(this.decode(localStorage.getItem("Usuario"))),
          date: date,
          hour: time,
          action: "Actualizar",
          table: "1"
        }
      }
      $scope.commit.product.status = 1;
      $http({
        method: "POST",
        url: `${APP_URL.url}/product/save`,
        headers: {},
        data: $scope.commit.product
      }).then((res) => {
        if(res.data) {
          if(action == 1) {
            notyf.success("¡Se ha registrado correctamente el producto!")
          } else {
            notyf.success("¡Se ha actualizado correctamente el producto!")
          }
          $scope.commit.product = res.data;
          $http({
            method: "POST",
            url: `${APP_URL.url}/commits/save`,
            headers: {},
            data: $scope.commit
          }).then((res) => {
            if(res.data){
              $window.location.href = '#!products';
            }
          })
        }
      })
    }


    this.selectProduct = function (item) {
      productDelete = item;
    }

    this.encode = (txt) => {
      return window.btoa(unescape(encodeURIComponent(txt)));
    }

    this.decode = (txt) => {
      return decodeURIComponent(escape(window.atob(txt)));
    }

    this.inicioSesion = () => {
      console.log($scope.user);
      return $http({
        method: "POST",
        url: `${APP_URL.url}/users/login`,
        headers: {},
        data: $scope.user
      }).then((res) => {
        if(res.data){
          notyf.success("¡BIENVENIDO!");
          localStorage.setItem("Usuario", this.encode(JSON.stringify(res.data)));
          
          $window.location.href = '#!products';
        }else{
          notyf.error("Usuario y/o contraseña incorrectos");
        }
      })
    }

    this.deleteProduct = function () {
      let date = new Date();
      let time = date.toLocaleString('en-US', { hour: 'numeric', hour12: false }) + ":" + date.getMinutes() + ":" + date.getSeconds();
      $scope.commit = {
        product: productDelete,
        user: JSON.parse(this.decode(localStorage.getItem("Usuario"))),
        date: date,
        hour: time,
        action: "Eliminar",
        table: "1"
      }
      $scope.commit.product.status = 0;
      $http({
        method: 'POST',
        url: APP_URL.url + "/product/save",
        headers: {
        },
        data: $scope.commit.product
      }).then((res) => {
        this.findAll();
        $('#productsTable').DataTable().destroy();
      }, (error) => {
        notyf.error('Ha ocurrido un error inesperado' + error);
      })
      $http({
        method: "POST",
        url: `${APP_URL.url}/commits/save`,
        headers: {},
        data: $scope.commit
      }).then((res) => {
        if(res.data){
        }
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
