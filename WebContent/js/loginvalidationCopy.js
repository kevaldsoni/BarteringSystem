$(document).ready(function() {
    $('#loginform').bootstrapValidator({
       // container: '#messages',
    	framework : 'bootstrap',
        err: {
            container: function($field, validator) {
                // Look at the markup
                //  <div class="col-xs-4">
                //      <field>
                //  </div>
                //  <div class="col-xs-5 messageContainer"></div>
                return $field.parent().next('.messageContainer');
            }
        },
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            
        	email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required and cannot be empty'
                    },
                    regexp: {
                        enabled: true,
                        regexp: /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/,
                        message: 'The email address is not valid'
                    }
                    
                }
            },
        	
        	
        	password: {
                validators: {
                    notEmpty: {
                        message: 'The full name is required and cannot be empty'
                    },
                    stringLength: {
                        enabled: true,
                        min: 8,
                        max: 40,
                        message: 'The full name must be more than 8 and less than 40 characters long'
                    },
                    regexp: {
                        enabled: true,
                        regexp: /^[a-zA-Z\s]+$/,
                        message: 'The full name can only consist of alphabetical, number, and space'
                    }
                }
            }
            
        }
    })
   
    
    .on('success.form.fv', function(e) {
        // Prevent form submission
        e.preventDefault();
        alert("success form submission");
       // var $form = $(e.target),
         //   fv    = $(e.target).data('formValidation');

        // Do whatever you want here ...

        // Then submit the form as usual
       // fv.defaultSubmit();
    });
    
    
    // $("#btn-login").bind('click',submitRegisterForm);

    function submitRegisterForm(){

    alert("hiii checking");
    
    //return false;
    //document.getElementById("loginform").submit();
    var value =$(".messageContainer").html();
    alert(value);
    }
});