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

        $('#btnSearchW28').on('click', function(){
            _this.searchW28();
        });

        $('#btnSearchW29').on('click', function(){
            _this.searchW29();
        });

        $('#btnSearchW30').on('click', function(){
            _this.searchW30();
        });

        $('#btnSearchW31').on('click', function(){
            _this.searchW31();
        });

        $('#btnSearchW32').on('click', function(){
            _this.searchW32();
        });

        $('#btnSearchW33').on('click', function(){
            _this.searchW33();
        });

    },
    searchW28 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkf/search/w28',
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
    searchW29 : function () {
        var data = {
            code: $('#code').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkf/search/w29',
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
    searchW30 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkf/search/w30',
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
    searchW31 : function () {
        var data = {
            code: $('#code').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkf/search/w31',
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
    searchW32 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkf/search/w32',
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
    searchW33 : function () {
        var data = {
            code: $('#code').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wkf/search/w33',
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