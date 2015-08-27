/**
 * 
 */

$(function() {
  
    // Setup form validation on the #register-form element
    $("#searchform").validate({
    
        // Specify the validation rules
        rules: {
        	id: "required"
            
        },
        
        // Specify the validation error messages
        messages: {
        id: "Please enter the id."
            
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });
});