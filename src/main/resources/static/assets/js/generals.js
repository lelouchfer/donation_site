$('#confirm-delete').on('click', '.btn-ok', function(e) {
    var $modalDiv = $(e.delegateTarget);
    var id = $(this).data('recordId');
    var data = { id : id }

    $.ajax({url: window.location.href+"delete", type: "POST", data: data, success:function(data) {
            $('#myTable tr:last').remove();
        },  error : function(data) {
            alert("failed to get the data");
        }})
    //$.post('/admin/country/delete/' , data).then()
    $modalDiv.addClass('loading');
    setTimeout(function() {
        $modalDiv.modal('hide').removeClass('loading');
    }, 1000);
    $('body').removeClass('modal-open');
    $('.modal-backdrop').remove();

});
$('#confirm-delete').on('show.bs.modal', function(e) {
    var data = $(e.relatedTarget).data();
    $('.title', this).text(data.recordTitle);
    $('.btn-ok', this).data('recordId', data.recordId);
});

function loadData(identifier,frm) {
    var data = $(identifier).data();
   populate(frm, data);
}

function populate(frm, data) {
    $.each(data, function(key, value) {
        var ctrl = $('[name='+key+']', frm);
        switch(ctrl.prop("type")) {
            case "radio": case "checkbox":
                ctrl.each(function() {
                    if($(this).attr('value') == value) $(this).attr("checked",value);
                });
                break;
            default:
                ctrl.val(value);
        }
    });
}