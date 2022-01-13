$( document ).ready(function() {
	
	// GET REQUEST
	$("#getAllEmployees").click(function(event){
		event.preventDefault();
		//alert(window.location.href + "employee/");	
		ajaxGet();
	});
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : window.location.href + "employee/0",
			success: function(result){				
				//alert(result[0].firstName);	
				
				//if(result.status == "Done"){
					$('#getResultDiv ul').empty();
					var custList = "";
					$.each(result, function(i, employee){
						var employee = "- Employee with Id = " + i + ", firstname = " + employee.firstName + ", lastName = " + employee.lastName + "<br>";
						$('#getResultDiv .list-group').append(employee)
			        });
					console.log("Success: ", result);
				//}else{
				//	$("#getResultDiv").html("<strong>Error</strong>");
				//	console.log("Fail: ", result);
				//}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})