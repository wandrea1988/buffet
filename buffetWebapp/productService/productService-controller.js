angular.module('buffetApp')

    .controller('productServiceController', function ($scope, productServiceService, $location) {

        $scope.product = {};
        $scope.updateProduct = {};




        $scope.saveNewProduct = function (product) {

            productServiceService.saveNewProduct(product)
                .then(function (response) {
               
                    $scope.product = {};
                    $scope.getAllProduct();
                    alert("Sikeres mentés")
                },
                function (error) {
                    alert("Nem sikerült a mentés")


                });

        }

        $scope.getAllProduct = function () {
            productServiceService.getAllProduct()
                .then(function (response) {
                    $scope.products = response.data;
                },
                function (error) {
                    console.log(error)

                });

        }


        $scope.init = function () {
            $scope.getAllProduct();
            document.getElementById("saveUpdateProduct").setAttribute("style", "display:none");

        }


        $scope.updateProductFunction = function () {
            document.getElementById("saveUpdateProduct").setAttribute("style", "display:true");
            document.getElementById("updateProduct").setAttribute("style", "display:none");
            $scope.updateProduct = JSON.parse($scope.updateProduct)
        }

        $scope.saveUpdateProduct = function (updateProduct) {

            if (!(updateProduct.productName == "" || updateProduct.productPrice == "")) {
                productServiceService.saveUpdateProduct(updateProduct)
                    .then(function (response) {
                        
                        $scope.updateProduct = {};
                        alert("Sikeres mentés")
                    },
                    function (error) {
                        alert("Nem sikerült a mentés")


                    });
                document.getElementById("saveUpdateProduct").setAttribute("style", "display:none");
                document.getElementById("updateProduct").setAttribute("style", "display:true");
                $scope.getAllProduct();
            } else {
                alert("Nem adott meg új nevet")
            }
        }



    })



