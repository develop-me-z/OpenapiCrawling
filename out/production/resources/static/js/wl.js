var main = {
    init : function () {
        var _this = this;

        $("#startdt").datepicker({
            dateFormat: "yy-mm-dd"
        });
        $("#enddt").datepicker({
            dateFormat: "yy-mm-dd"
        });


        $('#btnSave').on('click', function(){
            _this.save();
        });

        $('#btnSearchW6').on('click', function(){
            _this.searchW6();
        });

        $('#btnSearchW7').on('click', function(){
            _this.searchW7();
        });

        $('#btnSearchW8').on('click', function(){
            _this.searchW8();
        });

        $('#btnSearchW9').on('click', function(){
            _this.searchW9();
        });

    },
    searchW6 : function () {
        var data = {
            basin: $('#basin option:selected').val(),
            oper: $('#oper option:selected').val(),
            mngorg: $('#mngorg option:selected').val(),
            obsknd: $('#obsknd option:selected').val(),
            keynm: $('#keynm').val(),
            sort: $('#sort option:selected').val(),
            output: $('#output option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/rf/search/w1',
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
    },
    searchW7 : function () {
        var data = {
            obscd: $('#obscd').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wl/search/w7',
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
    },
    searchW8 : function () {
        var data = {
            obscd: $('#obscd').val(),
            startdt: $('#startdt').val()!=""? moment($('#startdt').val()).format("YYYYMMDD") : "",
            enddt: $('#enddt').val()!=""? moment($('#enddt').val()).format("YYYYMMDD") : ""
        };

        $.ajax({
            type: 'POST',
            url: '/wl/search/w8',
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
    },
    searchW9 : function () {
        var data = {
            obscd: $('#obscd').val(),
            startdt: $('#startdt').val()!=""? moment($('#startdt').val()).format("YYYYMMDD") : "",
            enddt: $('#enddt').val()!=""? moment($('#enddt').val()).format("YYYYMMDD") : ""
        };

        $.ajax({
            type: 'POST',
            url: '/wl/search/w9',
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
    },
    save : function () {
        //CSV ????????? ??????
        let downLink = document.getElementById('btnSave');
        let csv = ''; //CSV?????? ???????????? ???????????? ??????
        let rows = document.querySelectorAll("#dataTable tr"); // ??????????????? ??? ???????????? ?????? ??????
        let fileName = '??????????????????.csv';

        //????????? ??????
        for (var i = 0; i < rows.length; i++) {
            let cells = rows[i].querySelectorAll("td, th");
            let row = [];
            //?????? ??? ?????? ????????? ??????
            cells.forEach(function(cell){
                row.push(cell.innerHTML);
            });

            csv += row.join(',') + (i != rows.length-1 ? '\n':''); // ????????? ?????????+??????????????? ??????
        }

        //CSV ?????? ??????
        csvFile = new Blob([csv], {type: "text/csv"}); // ????????? CSV ???????????? Blob ???????????? ??????
        downLink.href = window.URL.createObjectURL(csvFile); // Blob ???????????? URL ????????? ?????? ???????????? ?????????????????? ??????.
        downLink.download = fileName; // ????????? ?????? ???????????? ???????????? ??????
    }

};

main.init();