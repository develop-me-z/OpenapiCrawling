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

        $('#btnSearchW34').on('click', function(){
            _this.searchW34();
        });

        $('#btnSearchW35').on('click', function(){
            _this.searchW35();
        });

        $('#btnSearchW36').on('click', function(){
            _this.searchW36();
        });

        $('#btnSearchW37').on('click', function(){
            _this.searchW37();
        });
    },
    searchW34 : function () {
        var data = {
            mngorg: $('#mngorg option:selected').val(),
            basin: $('#basin option:selected').val(),
            obsknd: $('#obsknd option:selected').val(),
            keynm: $('#keynm').val(),
            sort: $('#sort option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkd/search/w34',
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
    searchW35 : function () {
        var data = {
            damcd: $('#damcd').val(),
            startdt: $('#startdt').val(),
            enddt: $('#enddt').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkd/search/w35',
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
    searchW36 : function () {
        var data = {
            damcd: $('#damcd').val(),
            startdt: $('#startdt').val(),
            enddt: $('#enddt').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkd/search/w36',
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
    searchW37 : function () {
        var data = {
            damcd: $('#damcd').val(),
            startdt: $('#startdt').val(),
            enddt: $('#enddt').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkd/search/w37',
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