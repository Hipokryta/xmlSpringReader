$(document).ready(function() {

	
	$("#systemTable").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        "sAjaxSource": "/BlueSoft/AjaxDataSource",
        "bJQueryUI": true,
        "aoColumns": [
            { "mData": "id"},
            { "mData": "active" },
            { "mData": "amount" },
            { "mData": "amount_period" },
            { "mData": "amount_type" },
            { "mData": "auth" },
            { "mData": "from_date" },
            { "mData": "order_number" },
            { "mData": "request" },
            { "mData": "to_date" },
            { "mData": "system_id" },
            {
                "bSortable": false,
                "mRender": function(data, type, full) {
                    return '<div class=" delete-button"><input class="btn btn-info btn-sm" value="delete" type="button"/></div>';
                }
            }
            
        ] } ).makeEditable({
        	
       sUpdateURL: function(value, settings)
	                {
		                var columnIndex = this.cellIndex;
		                var id = this.parentNode.children[0].textContent;
		                $.ajax({
			        	  url: "UpdateData",
			              type: "POST",
			              async: false,
			              data:{"value": value,
	                	  "columnIndex": columnIndex,
	                	  "id":id},
	                	  success:function() {
			            	  $('#systemTable').dataTable().fnReloadAjax();
			            	  alert("done");
	                	  },
	                	  error:function() {}});
		                 $('#systemTable').dataTable().fnReloadAjax();
		                 return value;
        	          }
        	});
	

	var table = $('#systemTable').DataTable();
	 
	$('form.add-system').submit(function(event) {

        var formData = {
            'id'              : $('input[name=id]').val(),
            'active'             : $('input[name=active]').val(),
            'amount'    : $('input[name=amount]').val(),
            'amountPeriod'    : $('input[name=amount_period]').val(),
            'authorizationPercent'    : $('input[name=auth]').val(),
            'fromDate'    : $('input[name=from_date]').val(),
            'orderNumber'    : $('input[name=order_number]').val(),
            'request'    : $('input[name=request]').val(),
            'toDate'    : $('input[name=to_date]').val(),
            'systemId'    : $('input[name=system_id]').val(),
        };

        $.ajax({
            type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
            url         : 'AddData', // the url where we want to POST
            data        : formData, // our data object
            async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser  
            processData:false, // what type of data do we expect back from the server
            encode          : true,
            headers :{
            	'Content-Type': 'application/json'
            }
        }).done(function(data) {
        	$('#systemTable').dataTable().fnReloadAjax(); 
        });
        event.preventDefault();
    });
 
    $('body').on('click','div.delete-button',function () {
    	var closeTr = $(this).closest('tr');
    	var id = closeTr[0].children[0].textContent;
    	
    	$.ajax({
     	   url: "DeleteData",
            type: "POST",
            data:{"id":id},
            success:function() {
         	  $('#systemTable').dataTable().fnReloadAjax();
         	  alert("done");
         },
         error:function() {
        	 $('#systemTable').dataTable().fnReloadAjax();
       }});
        $('#systemTable').dataTable().fnReloadAjax();
         return value;
       });
    
	$('input.desc').css('visibility', 'hidden');
	$('input[type=file]').change(function (e) {
		var filePath = $(this).val();
        $("input.desc").val(filePath);
        console.log(filePath);
	});
 });