var app = angular.module("GameManagement", []);

let controller = app.controller("GameController", function($scope, $http){
    $scope.games = [];
    $scope.gameForm={
        id : "",
        name: "",
        studioName:"",
        cost:"",
        photo:"",
        description:""
    };
    //Update
    __refreshGameData();

    $scope.submitGame = function(){
        var methode = "POST";
        var url = "/public/rest/games";
        $http({
            methode:methode,
            url:url,
            data:angular.toJson($scope.gameForm),
            headers:{
                "Content-Type" : "application/json"
            }
        }).then(_success, _error)
    };

    $scope.appendGame = function () {

        let game = {
            "name" : document.getElementById("adding").name.value,
            "studioName" : document.getElementById("adding").studioName.value,
            "cost" : document.getElementById("adding").cost.value
        };
        console.log(document.getElementById("adding").value);
        $http.post("/public/rest/games", angular.toJson(game)).then(_success,_error);
        // $http({
        //     methode: "POST",
        //     url:"/public/rest/games",
        //     data:angular.toJson(game),
        //     headers:{
        //         "Content-Type" : "application/json"
        //     }
        // }).then(_success, _error);
        _clearFormData();
        __refreshGameData();
    };

    $scope.deleteGame = function (game) {
        $http.delete("/public/rest/games",{
            params:{ id:game.id}
        }).then(_success,_error);
    };

    $scope.editGame = function (game){
        game.name = document.getElementById(game.id).name.value;
        game.studioName = document.getElementById(game.id).studioName.value;
        game.cost = document.getElementById(game.id).cost.value;
        $http({
            method: "PUT",
            url:"/public/rest/games",
            data: angular.toJson(game),
            headers:{
                "Content-Type" : "application/json"
            }
        })
    };

    function _clearFormData() {
        document.getElementById("adding").name.value = "Название";
        document.getElementById("adding").studioName.value = "Студия";
        document.getElementById("adding").cost.value = "Стоимость"
    }


    function _success(res) {
        __refreshGameData();
        _clearFormData();
    }
    function __refreshGameData() {
        $http({
            method: "GET",
            url:"/public/rest/games"
        }).then(
            function (res) {
                $scope.games = res.data;
            },
            function (res) {
                console.log("Error" + res.status + ":" + res.data);
            }
        )
    }

    function _error(res) {
        let data = res.data;
        let status = res.status;
        let header = res.header;
        let config = res.config;
        alert("Error: " + status + ":" + data);
    }

});