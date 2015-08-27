/**
 * 
 */

$(function() {
  
    // Setup form validation on the #register-form element
    $("#createticketform").validate({
    
        // Specify the validation rules
        rules: {
        	Creator: "required",
        	Assigned_To: "required",
        	Comments: "required",
            Status: "required",
            Name: "required",
            Contact_number: 
            	{
            	required: true,
            	number: true,
            	minlength: 10,
            	maxlength: 10
            	}
            
        },
        
        // Specify the validation error messages
        messages: {
        	Creator: "Please enter the value",
        	Assigned_To: "Please enter the value",
        	Comments: "Please enter the value",
        	Status: "Please select a Status",
        	Name: "Please fill the name",
 			Contact_number: "Please enter the correct number"
            
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });
});