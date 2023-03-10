var main = {
    init : function () {
        var _this = this;

        /*$("#startyear").datepicker({
            dateFormat: "yy-mm-dd"
        });
        $("#endyear").datepicker({
            dateFormat: "yy-mm-dd"
        });*/


        $('#btnSave').on('click', function(){
            _this.save();
        });

        $('#btnSearchW16').on('click', function(){
            _this.searchW16();
        });

        $('#btnSearchW17').on('click', function(){
            _this.searchW17();
        });

        $('#btnSearchW18').on('click', function(){
            _this.searchW18();
        });

        $('#btnSearchW19').on('click', function(){
            _this.searchW19();
        });

    },
    searchW16 : function () {
        var data = {
            basin: $('#basin option:selected').val(),
            mngorg: $('#mngorg option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkw/search/w16',
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
    searchW17 : function () {
        var data = {
            obscd: $('#obscd').val(),
            startyear: $('#startyear').val(),
            endyear: $('#endyear').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkw/search/w17',
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
    searchW18 : function () {
        var data = {
            basin: $('#basin').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkw/search/w18',
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
    searchW19 : function () {
        var data = {
            obscd: $('#obscd').val(),
            year: $('#year').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkw/search/w19',
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