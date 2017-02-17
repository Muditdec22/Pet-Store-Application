//Controller Part
petStore.controller("AddPetController", [ '$scope', '$http',
		function($scope, $http) {
			//Initialize page with default data which is blank in this example
			$scope.form = {
				petName : "",
				petCategory : "",
				petTag : "",
				photoURLS : ""
			};

			$scope.petCategory = [];

			$scope.petTag = [];
			
			$scope.successMessage = null;

			_loadPetCategory();

			function _loadPetCategory() {
				$http({
					method : 'GET',
					url : 'petStore/petCategory'
				}).then(function successCallback(response) {
					$scope.petCategory = response.data;
				}, function errorCallback(response) {
					console.log(response.status);
				});
			}

			_loadPetTag();

			function _loadPetTag() {
				$http({
					method : 'GET',
					url : 'petStore/petTag'
				}).then(function successCallback(response) {
					$scope.petTag = response.data;
				}, function errorCallback(response) {
					console.log(response.status);
				});
			}

			$scope.submitPet = function() {
				$http({
					method : 'POST',
					url : 'petStore/addPet',
					data : angular.toJson($scope.form),
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(_success, _error);
			};

			function _success(response) {
				_clearForm();
				$scope.successMessage = "Pet Details have been saved.";
			}

			function _error(response) {
				console.log(response.status);
			}

			//Clear the form
			function _clearForm() {
				$scope.form.petName = "";
				$scope.form.petCategory = "";
				$scope.form.petTag = "";
				$scope.form.photoURLS = "";
			}

		} ]);