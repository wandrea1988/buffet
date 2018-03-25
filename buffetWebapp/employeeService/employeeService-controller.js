angular.module('buffetApp')

    .controller('employeeServiceController', function ($scope, employeeServiceService, $location) {

      $scope.employee={};
      $scope.updateEmployee={};

        $scope.saveNewEmployee = function (employee) {
           
           
                employeeServiceService.saveNewEmployee(employee)
                    .then(function (response) {
                       $scope.getAllEmployee();
                        $scope.employee={};
                        alert("Sikeres mentés")
                    },
                    function (error) {
                        alert("Nem sikerült a mentés")
                        

                    });
            
        }

        $scope.getAllEmployee = function () {
            employeeServiceService.getAllEmployee()
                .then(function (response) {
                    $scope.employees = response.data;
                },
                function (error) {
                    console.log(error)

                });

        }

        $scope.init = function(){
            $scope.getAllEmployee();
            document.getElementById("updateInput").setAttribute("style", "display:none");
            document.getElementById("saveUpdate").setAttribute("style", "display:none")
        }

        $scope.updateEmployeeFunction = function (){
            document.getElementById("updateInput").setAttribute("style", "display:initial");
            document.getElementById("saveUpdate").setAttribute("style", "display:initial");
            document.getElementById("searchUpdateName").setAttribute("style", "display:none");
            document.getElementById("update").setAttribute("style", "display:none");
            $scope.updateEmployee=JSON.parse($scope.updateEmployee);

        }

        $scope.saveUpdateEmployee = function (updateEmployee){
            if(!(updateEmployee.employeeName=="")){
            employeeServiceService.saveUpdateEmployee(updateEmployee)
            .then(function (response) {
             
                $scope.updateEmployee={};
                alert("Sikeres mentés")
            },
            function (error) {
                alert("Nem sikerült a mentés")
                

            });
            document.getElementById("updateInput").setAttribute("style", "display:none");
            document.getElementById("saveUpdate").setAttribute("style", "display:none");
            document.getElementById("searchUpdateName").setAttribute("style", "display:initial");
            document.getElementById("update").setAttribute("style", "display:initial");
            $scope.getAllEmployee();

        }else{
            alert("Nem adott meg új nevet")
        }
    }

    })