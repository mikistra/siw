

$("#conf").click(function() { //conferma


	if(!$("#usin").val() || !$("#nsin").val() )
		swal("Completa tutti i campi");
	else 
		{
		    var p=$("#mypo > button").length;
		    var d=$("#mydi > button").length;
		    var c=$("#myce > button").length;
		    var a=$("#myat > button").length;
		    
		    if(p!=2 || d!=5 || c!=5 || a!=4)
		    swal("Numero di giocatori errato",
	    	"Ricordati di scegliere: 2 portieri, 5 difensori, 5 centrocampisti e 4 attaccanti" );
		    else
		    {
		    	//var s;
		    	var buttons = $('#myteam').find("button");
		    	var tuttigio=[];
		    	
		    	$.each(buttons, function(i, val) {
		    	  
		    		var str = val["innerText"].split(' | ');
		    			   var gioc={
		    					   "codice":val["value"],
		    			   			"nome" :str[0],
		    			   			"ruolo":$(this).attr("data-ruolo"),
		    			   			"club":str[1]
		    			        }
		    			   tuttigio.push(gioc);
		 				}); //each
		 
		    	var selected = $("a[class='list-group-item active']").prop('id');
		    
		    	$.ajax({
		    		
		    		type : "POST",
		    		url : "AdminServlet?action=creasquadra",
		    		datatype : "text",
		    		data : { 

		    				ouser : $("#usin").val(),
		    				nomesqua : $("#nsin").val(),
		    				legaselez : selected,
		    				newsquadra : JSON.stringify(tuttigio)
		    			
		    				},
		    		
		    		success: function(data){
		    			
		    			if(data==1)
		    				{
		    				  swal("User inesistente", "puoi aggiungere solo utenti registrati");
		    				}
		    			else if(data==2)
		    				{
		    					swal("Errore", "Controlla tutti i campi", "error" );
		    				}
		    			else if(data==3)
		    				{
		    				   swal("Questa squadra risulta gia' iscritta ");
		    				}
		    			else if(data==4)
	    				{
		    				swal("Attenzione", ""+$("#usin").val()+" partecipa gia' a questa lega")
	    				}
		    			else if(data==0)
		    				{
		    					swal("Perfetto!", "Squadra creata con successo", "success");
		    					
		    					$("#mypo").empty();
		    					$("#mydi").empty();
		    					$("#myce").empty();
		    					$("#myat").empty();
		    				}
		    		
		    		}//success	
		    				
		    	 });//ajax
		    				
		    }//else II
		    	
		    
		}//else I	
	
});



	$('.list-group').on('click',"button", function () {		//aggiunge/rimuove giocatori
		if($(this).parent().prop("id").indexOf("my") != -1  )
		  {
			$(this).remove();
		  }
		else if($(this).attr("data-ruolo")=="P" )
		  {
			var valore=$(this).val()
			if($("button[value="+valore+"]").length <2)			
				$("#mypo").append($(this).clone());
			else
				swal("giocatore gia' selezionato");
			
		  }
		else if($(this).attr("data-ruolo")=="D" )
		{
			var valore=$(this).val()
			if($("button[value="+valore+"]").length <2)
				$("#mydi").append($(this).clone());
			else
				swal("giocatore gia' selezionato");
		}
		else if($(this).attr("data-ruolo")=="C" )
		{
			var valore=$(this).val()
			if($("button[value="+valore+"]").length <2)
				$("#myce").append($(this).clone());
			else
				swal("giocatore gia' selezionato");
		}
		else if($(this).attr("data-ruolo")=="A" )
		  {
			var valore=$(this).val()
			if($("button[value="+valore+"]").length <2)
			$("#myat").append($(this).clone());
			else
				swal("giocatore gia' selezionato");
		  }
		
	});




$( "#lelist" ).find("a").click(function() { //mostra contenuto
	var le = $(this).prop("id");
	
	$("#myteam").find("div").empty();
	
	fill('#portli','p',le);
	fill('#difli','d',le);
	fill('#cenli','c',le);
	fill('#attli','a',le);

	$( "#lelist" ).find("a").attr('class', 'list-group-item');
	$(this).attr('class', 'list-group-item active');
	
	// ----------------
	$("#evbutt").empty();
	var nl=$(this).text();
	$.ajax({ 
	    
		url: 'SquadraServlet?action=getgiornatenc',
		datatype : "json",
		data : { "lega" : nl },
	success: function(data){
		$("#indgiorn").empty();
		
		if(data.length == 0)
			$("#indgiorn").append('<li>'+"Tutte le giornate sono state calcolate"+'</li>');
		else
		{
		$.each(data, function(i, val) {
			$("#indgiorn").append('<li><a>'+val+'</a></li>');
		      });
		}
		
		}//success
});//ajax 
	
	//
	 $('[href="#1"]').tab('show');
	//
	
	$("#hid").show();
});


$('#indgiorn').on('click',"a", function () {	

   checkav($(this).text());
   
});  //click a

$("#evbutt").on('click',"div", function () {	
var le= $("#lelist .active").prop("id");
var n=$(this).prop("id");

$.ajax({
		
		url : 'ScoreServlet?action=calcolag',
		dataType : "text",
		data : {
			"giornata" : n,
			"lega" : le
		},
		
		success : function(data) {
			
		    	$("#evbutt").empty();
		    	swal("Fatto!", "I risultati di giornata sono stati calcolati", "success");
		    	$('[href="#1"]').tab('show');
		}
	}); //

});  //confirm

function checkav(n)
{
	$.ajax({
		
		url : 'ScoreServlet?action=checkv',
		dataType : "text",
		data : {
			"giornata" : n
		},
		
		success : function(data) {
			$("#evbutt").empty();
			
			if(data==0)
			swal("Voti non presenti", "I voti di questa giornata non sono ancora disponibili");	
			else
			$("#evbutt").append('<div id="'+n+'" type="button" class="btn btn-primary btn-lg">Calcola risultati</div>');
		}
	}); //aj

};


function fill(w, r, l){ //riempire liste 
	
	$(w).empty();
	 $.ajax({
		
		url : 'AdminServlet?action=getgiocatori',
		dataType : "json",
		data : {
			"ru": r,
			"lega" : l
		},
		
		success : function(data) {
			
			$.each(data, function(i, val) {
				  $(w).append("<button type=\"button\" data-ruolo=\""+val.ruolo+"\"  class=\"list-group-item "+r+r+"  \"  value=\""+val.codice+"\" >"+ "<strong>"+ val.nome +"</strong>" +" | "+val.club+"</button>");
				});
		}
	}); //ajax
	
}

