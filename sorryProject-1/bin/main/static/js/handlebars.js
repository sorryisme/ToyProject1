//데이터 리스트, 작성한 templateComplie
var printData = (list, target, templateObject) => {
	var template=Handlebars.compile(templateObject.html());
	var html = template(list);
	target.append(html);
}

var successFunction = function (data){
	if(data.result === 'success'){
		console.log($('#dataTable').html());
     	    $('#dataTable').dataTable();
	}
}

var failFunction = function (data){
	if(data.result === 'error'){
		console.log('error');
	}
}

$(function(){
	var promise = $.ajax({
		  method: "GET",
		  url: "board/list",
		  success : function(result){
			  printData(result,$("#dataTable > tbody"),$("#template"));
		  }
	}); // ajax
	promise.done(successFunction);
	promise.fail(failFunction);

});


