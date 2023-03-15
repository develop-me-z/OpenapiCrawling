var main = {
    init : function () {
        var _this = this;

        $('#btnSearchRadar').on('click', function(){
            _this.searchRadar();
        });

    },
    searchRadar : function () {
        var data = {
            width: $('#width').val(),
            height: $('#height').val(),
            minx: $('#minx').val(),
            miny: $('#miny').val(),
            maxx: $('#maxx').val(),
            maxy: $('#maxy').val(),
            time: $('#year option:selected').val() + $('#month option:selected').val() + $('#day option:selected').val() + $('#hour option:selected').val() + $('#minute option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/gis/search/radar',
            //dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend : function(){
              //location.reload();

            },
            success: function (result){
                //alert(result);
                document.write(result);
            }
        }).done(function() {

        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();