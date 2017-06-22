
$( "input[name='usr']").change(function() {

	if($(this).val().length==0)
	{
		 $("#availability").text("").css({ 'color': 'blue', 'font-size': '100%' });
	}
	else{
	$.ajax({
		
		type : "POST",
		url : "AccessServlet?action=checkusername",
		datatype : "json",
		data : { 
					datapkt : JSON.stringify({"useridea":$(this).val()})
			
				},
		
		success: function(data){
			
			if(data==1){
			 $("#availability").text("username disponibile").css({ 'color': 'green', 'text-align': 'center', 'font-size': '100%' });
			}
			else if(data==0)
			{
			 $("#availability").text("username gia' in uso").css({ 'color': 'red', 'font-size': '100%' });
			}
		
		}//success	
				
								
	}); //ajax

	}//else empty
	
	
	});

function testfields(form) {

	if (form.psw.value != form.pswrepeat.value) {


		swal({
			  title: "Attenzione!",
			  text:"I campi 'password' e 'conferma password' non corrispondono",
			  type: "error",
			  confirmButtonText: "Riprova"
			});
		
		
		form.pswrepeat.focus();
		form.pswrepeat.select();
		return false;
	}
	
	 if(! (form.mail.value.match(".+[@].+")))
	{
		swal({
			  title: "Attenzione!",
			  text:"Inserisci una mail valida",
			  type: "error",
			  confirmButtonText: "Riprova"
			});
		
		form.mail.focus();
		form.mail.select();
		
		return false;
	}


}