// This is a manifest file that'll be compiled into admin.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require jquery-ui-1.12.0.min
//= require bootstrap
//= require codemirror-3.20.0
//= require codemirror-xml-3.20.0
//= require codemirror-formatting-2.36.0
//= require summernote.min
//= require jquery.mjs.nestedSortable
//= require_tree .
//= require_self

$("#slug").attr('readonly', true);

$("#name").keyup(function(){
        var Text = $(this).val();
        Text = Text.toLowerCase();
        Text = Text.replace(/[^a-zA-Z0-9]+/g,'-');
        $("#slug").val(Text);
});

if (typeof jQuery !== 'undefined') {
    (function($) {
        $('#spinner').ajaxStart(function() {
            $(this).fadeIn();
        }).ajaxStop(function() {
            $(this).fadeOut();
        });
        


        $("#content").summernote({
            height: 400,
            placeholder: "Type here...",
            callbacks: {
                onImageUpload: function(files, editor, welEditable) {
                    for (var i = files.length - 1; i >= 0; i--) {
                        var data = new FormData();
                        data.append("file", files[i]);
                        $.ajax({
                            data: data,
                            type: 'POST',
                            url: '/asset/upload',
                            cache: false,
                            contentType: false,
                            enctype: 'multipart/form-data',
                            processData: false,
                            success: function(data) {
                            	$("#content").summernote('editor.insertImage', data.uri);
                            }
                        });
                    }
                }
            }
        });
        
        
    	$(".menu").nestedSortable({
    		handle: 'div',
    		items: 'li',
    		placeHolder: 'li',
    		toleranceElement: '> div',
    		listType: 'ul',
			update: function(event, ui) {
				var data =  $(this).nestedSortable('toArray');
				var menuOrder = JSON.stringify(data);
				console.log(menuOrder);
				$.ajax({
					data: 'menuOrder=' + menuOrder, 
					dataType: 'json',
					type: 'POST',
					url: "/menu/order",
					success: function(data, text) {
						console.log(data.retMess);
						console.log(text);
					},
					error: function(xhr, err, errThrown) {
						console.log(errThrown);
					}
				});
			}
    	});
    	      
  })(jQuery);
}



