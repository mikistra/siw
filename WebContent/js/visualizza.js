$("#lelist").find("a").click(function() { 
	
	var nsqua=$(this).prop("id");
	var nle=$(this).attr("data-nl");
	
	$("#nlega").text(nle); 
	
	var addr= $("#goto").attr("href");
	
     var n = addr.indexOf('&');
	 var newaddr = addr.substring(0, n != -1 ? n : addr.length);
	  newaddr += "&nsquadra="+nsqua;
	  	  	  
	$("#goto").attr("href", newaddr);
	
	//aggiung classifs
	//classif
	
	$.ajax({ 
	       
	    
		url: 'SquadraServlet?action=getgiornate',
		datatype : "text",
		data : { "lega" : nle },
	success: function(data){
		
		var prog = data/38 * 100; 
	     $("#progbar").width(prog+"%");
		
    }//success
 });//ajax 
	
	
	//barra
	
$.ajax({ 
	       
	    
		url: 'ScoreServlet?action=getclassifica',
		datatype : "json",
		data : { "lega" : nle },
	success: function(data){
		
		$("tbody").empty();
		$.each(data, function(i, val) {
			var tr=$('<tr></tr>');
			tr.append('<th>'+(i+1)+'</th>');
			tr.append('<td>'+val.squadra+'</td>');
			tr.append('<td>'+val.punteggio+'</td>');
			$("tbody").append(tr);
		});//each
				
    }//success
 });//ajax 2
	
	
	////////////
	$("#classif").show();
	
});