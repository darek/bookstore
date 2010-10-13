$(document).ready(function(){
	
	
	$(".single-button").button();
	$('.form input[type="submit"]').button({icons: {primary: 'ui-icon-locked'}});
	
	$(".dateBox").datepicker();
	$(".dataTable").dataTable({"bJQueryUI": true});

})