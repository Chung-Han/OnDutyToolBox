$(document).ready(function() {
	$('.submenu a').click(function(e) {
		e.preventDefault();
		$("#content").load($(this).attr('href'));
	});
});