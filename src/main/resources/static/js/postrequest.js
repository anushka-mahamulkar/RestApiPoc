$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#employeeForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		//alert(window.location.href + "employee/");
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		id : $("#id").val(),
    		firstName : $("#firstname").val(),
    		lastName :  $("#lastname").val()
    	}
    	
		alert(JSON.stringify(formData));
		
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location.href + "employee/",
			data : JSON.stringify(formData),
			success : function(result) {
				//if(result.code == 201){
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br> </p>");
				//}else{
//					$("#postResultDiv").html("<strong>Error</strong>");
	//			}
				//console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	$("#firstname").val("");
    	$("#lastname").val("");
    }
})