
$(function(){
	var l =$("#nlega").text();
$.ajax({ 
	       
	    
			url: 'SquadraServlet?action=getgiornate',
    		datatype : "text",
    		data : { "lega" : l },
    	success: function(data){
    		
    		if(data!=0)
    		for (var n = 0; n < data; ++ n)
            {
    			$("#ngiornata ul").append('<li><a>'+(n+1)+'</a></li>');
            }
    		else
    			$("#ngiornata ul").append('<li> In questa lega non sono presenti giornate </li>');
        }//success
	});//ajax
	


$.ajax({ 
    
    
		url: 'SquadraServlet?action=getgiornatenc',
		datatype : "json",
		data : { "lega" : l },
	success: function(data){
	     
		$.each(data, function(i, val) {
				$("#giorndd").append("<option>"+val+"</option>");
			});

		}//success
});//ajax 2

$.ajax({ 
    
    
	url: 'SquadraServlet?action=getmysquadra',
	datatype : "json",
	data : { "lega" : l },
success: function(data){

		$.each(data, function(i, val) {
			
		   var dove="#my";
		   dove+=val.ruolo;
		
		   var button=$("<div></div>");
		   button.addClass("list-group-item");
		   button.addClass(val.ruolo+val.ruolo);
		   button.attr("id",val.codice);
		   button.text(val.nome);
		   
		   $(dove).append(button);
	    });

		$(init);
	}//success
}); //ajax 3




});//main function
///////////////////

///////////////////
$('#indgiorn').on('click',"a", function () {	
	var giorn= $(this).text();
	var l =$("#nlega").text();
	
	$("#allsq").empty();
$.ajax({
		
		url : 'ScoreServlet?action=risgiornata',
		dataType : "json",
		data : {
				"lega": l,
				"giornata":giorn
		},
		
		success : function(data) {
			
			$.each(data, function(i, val) {
				
				var div=$('<div class="teamscore"></div>');
				div.addClass("col-xs-2");
				div.append("<h4>"+val.nomesquadra+"</h4>");
				div.append("<h4>Punteggio:"+val.punteggio+"</h4>");
				$("#allsq").append(div);
				
				
				});
			
		}
	}); //ajax
	
});

//////////////////////////////////////////////////////////////////////

$("#modulo").change(function () { //cambio modulo
	
	  $(".mydd  div").first().appendTo("#myD");
	  $(".mydd  div").first().appendTo("#myD");
	  
	  $(".myad  div").first().appendTo("#myA");
	  $(".myad  div").first().appendTo("#myA");
	  
	  $(".mycd  div").first().appendTo("#myC");
	  $(".mycd  div").first().appendTo("#myC");
	
	init(); 

});




////////////////////////////////////////////////////////////////
function init() {   ///init sortable
		
	var mod = $("#modulo").val().split('-');
	var d=mod[0];
	var c=mod[1];
	var a=mod[2];
	   
    
    $("#myP, .mypd").sortable({
        connectWith: ".dropp",
        	 receive: function(event, ui) {
                 var $this = $(this);
                 if ($this.children('div').length > 1 && $this.attr('id') != "myP") 
                 {
                     $(ui.sender).sortable('cancel');
                     swal("Operazione non consentita", "rispetta il modulo scelto");

                 }
     
        	 }//funct
    }).disableSelection();
   
    
    $("#myD, .mydd").sortable({
        connectWith: ".dropd",
        	 receive: function(event, ui) {
                 var $this = $(this);
                 if ($this.children('div').length > d && $this.attr('id') != "myD") 
                 {
                     $(ui.sender).sortable('cancel');
                     swal("Operazione non consentita", "rispetta il modulo scelto");

                 }
     
        	 }//funct
    }).disableSelection();
    
    $("#myC, .mycd").sortable({
        connectWith: ".dropc",
        	 receive: function(event, ui) {
                 var $this = $(this);
                 if ($this.children('div').length > c && $this.attr('id') != "myC") 
                 {
                     $(ui.sender).sortable('cancel');
                     swal("Operazione non consentita", "rispetta il modulo scelto");

                 }
     
        	 }//funct
    }).disableSelection();
    
    $("#myA, .myad").sortable({
        connectWith: ".dropa",
        	 receive: function(event, ui) {
                 var $this = $(this);
                 if ($this.children('div').length > a && $this.attr('id') != "myA") 
                 {
                     $(ui.sender).sortable('cancel');
                     swal("Operazione non consentita", "rispetta il modulo scelto");
                 }
     
        	 }//funct
    }).disableSelection();
       
	  
	}//init

///////////////////////sub


$("#subform").click(function() {
	var l =$("#nlega").text();
	var s=$("#nsquadra").text();
	var g=$("#giorndd").val();
	
	var ris=$("#myteam .list-group-item").toArray();
	var arrid=[];
	$.each( ris, function( i, value ){
	   arrid.push($(this).attr("id"));
	});
	
	$.ajax({ 
	    	    
		url: 'SquadraServlet?action=insformazione',
		datatype : "text",
		data : { "lega" : l, 
				  "squadra" : s, 
				   "giornata": g,
				  "riserve" :JSON.stringify(arrid)
				},
	success: function(data){
	     
		  if(data==0)
			  swal("Perfetto!", "La tua formazione e' stata modificata con successo", "success");
		  else if(data==1)
			  swal("Oops...", "Si e' verificato un errore con la tua formazione!", "error");
		  
		}//success
});//ajax 
	
});

