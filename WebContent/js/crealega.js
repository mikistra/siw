 $("#b1").click(function () {

	
     $.ajax({
    	 
           type : "POST",
 			url : "CreaLegaS",
 			data: { "nomelega" : $("#nomele").val()  },
     success: function (data) {
    	         
        if(data==1)
        	{
        	
        	swal(
        			  'Grande!',
        			  'Hai appena creato la tua lega',
        			  'success'
        			)
        			
               $("#b1").remove();//prop("disabled",true);
        	  $("#goback").show();
        	}
        else if(data==0)
        	{
        	swal(
      			  'Attenzione!',
      			  'Questa lega esiste gia\' ',
      			  'error'
      			)
        	}
        else if(data==2)
        	{
        	swal(
      			  'Attenzione!',
      			  'Nome non valido ',
      			  'error'
      			)
        	}
      
     }//success
     
     });//ajax
         
 });
 
	$('#cf').keypress(function(e) {
		if (e.which == 13) {
			$("#b1").click();
			return false;
		}
	});