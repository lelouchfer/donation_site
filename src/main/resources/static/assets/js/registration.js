function cargarDepartamento(val) {
    if (val > 0){

        var data = {id: val}
        $.ajax({
            url: window.origin + "/ws/getDepartments",
            dataType: 'json',
            type: "POST",
            data: data,
            success: function (data) {
                //var result = $.parseJSON(data);
                $('#idDepartment').html(data['response']);
            },
            error: function () {
                alert("failed to get the data");
            }
        })
    }
}