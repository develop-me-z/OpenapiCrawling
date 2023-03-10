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

        $('#btnSearchW1').on('click', function(){
            _this.searchW1();
        });

        $('#btnSearchW2').on('click', function(){
            _this.searchW2();
        });

        $('#btnSearchW3').on('click', function(){
            _this.searchW3();
        });

        $('#btnSearchW4').on('click', function(){
            _this.searchW4();
        });

        $('#btnSearchW5').on('click', function(){
            _this.searchW5();
        });
    },
    searchW1 : function () {
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
    searchW2 : function () {
        var data = {
            obscd: $('#obscd').val()
        };

        $.ajax({
            type: 'POST',
            url: '/rf/search/w2',
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
    searchW3 : function () {
        var data = {
            obscd: $('#obscd').val(),
            startdt: $('#startdt').val()!=""? moment($('#startdt').val()).format("YYYYMMDD") : "",
            enddt: $('#enddt').val()!=""? moment($('#enddt').val()).format("YYYYMMDD") : ""
        };

        $.ajax({
            type: 'POST',
            url: '/rf/search/w3',
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
    searchW4 : function () {
        var data = {
            obscd: $('#obscd').val(),
            startdt: $('#startdt').val()!=""? moment($('#startdt').val()).format("YYYYMMDD") : "",
            enddt: $('#enddt').val()!=""? moment($('#enddt').val()).format("YYYYMMDD") : ""
        };

        $.ajax({
            type: 'POST',
            url: '/rf/search/w4',
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
    searchW5 : function () {
        var data = {
            obscd: $('#obscd').val(),
            startyear: $('#startyear').val(),
            endyear: $('#endyear').val()
        };

        $.ajax({
            type: 'POST',
            url: '/rf/search/w5',
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