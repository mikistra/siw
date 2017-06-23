 $("#vai").on("click", function (event) {
	 
	//  event.preventDefault();
	 var gior = $( "#giorn option:selected").text();
	 
	 var form = $('#carica')[0];
	 var dati = new FormData(form);
	 dati.append("giorn", gior);
	
	
	 $.ajax({
	        type: "POST",
	        enctype: 'multipart/form-data',
            url: "UploadVotiS",
            data: dati,
	        processData: false,  
	        contentType: false,
	        cache: false,
	        timeout: 60000,
	        success: function (ris) {
	        		
	        	swal("Perfetto", "I voti della giornata "+gior+" sono stati caricati correttamente", "success" );
	        	
	        	
	        },
            error: function (e) {

                swal("caricamento fallito", "file non corretto", "error");

            }
              
	      });//ajax

	 return false;
	/////
 });
	 
	 
	 ////////////////
	 