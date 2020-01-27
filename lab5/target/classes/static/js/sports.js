var app = angular.module('sports', []);

app.controller("SportsController", function ($scope, $http) {

    $scope.getSports = function () {
        $http.get('/public/rest/sports').success(function (data, status, headers, config) {
            $scope.sportsList = data;
        }).error(function (data, status, headers, config) {
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

    $scope.delete = function (id) {
        $http.delete('/public/rest/sports/delete/' + id).success(function (data, status, headers, config) {
            for (var i = 0; i < $scope.sportsList.length; i++) {
                var j = $scope.sportsList[i];
                if (j.id === id) {
                    $scope.sportsList.splice(i, 1);
                    break;
                }
            }
        }).error(function (data, status, headers, config) {
            console.error(status, data, headers);
        });
    };

    $scope.addSport = function () {
        $http.post('/public/rest/sports/add/' + $scope.number + "/" + $scope.name).success(function (data, status, headers, config) {
            $scope.sportsList.splice(0, 0, data);
        }
        ).error(function (data, status, headers, config) {
            console.error(status, data, headers);
        });

    };
});
