var petStore = angular.module("PetStore", []);

var app = angular.module('myApp', [ 'ngRoute' ]);

app.config(function($routeProvider) {
	$routeProvider

	.when('/', {
		templateUrl : '/index.html',
		controller : 'HomePage'
	})

	.when('/View Pet Details', {
		templateUrl : '/viewPet.html',
		controller : 'ViewPet'
	})

	.when('/Search Pet', {
		templateUrl : '/searchPet.html',
		controller : 'SearchPet'
	})

	.when('/Add Pet', {
		templateUrl : '/addPet.html',
		controller : 'AddPet'
	})

	.when('/Delete Pet', {
		templateUrl : '/deletePet.html',
		controller : 'DeletePet'
	})

	.otherwise({
		redirectTo : '/'
	});
});

app.controller('ViewPet', function($scope) {
	$scope.message = 'Hello from HomeController';
});

app.controller('SearchPet', function($scope) {
	$scope.message = 'Hello from BlogController';
});

app.controller('AddPet', function($scope) {
	$scope.message = 'Hello from BlogController';
});

app.controller('DeletePet', function($scope) {
	$scope.message = 'Hello from AboutController';
});

app.controller('HomePage', function($scope) {
	$scope.message = 'HomePage';
});