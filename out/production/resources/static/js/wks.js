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

        $('#btnSearchW20').on('click', function(){
            _this.searchW20();
        });

        $('#btnSearchW21').on('click', function(){
            _this.searchW21();
        });

        $('#btnSearchW22').on('click', function(){
            _this.searchW22();
        });

        $('#btnSearchW23').on('click', function(){
            _this.searchW23();
        });

        $('#btnSearchW24').on('click', function(){
            _this.searchW24();
        });

        $('#btnSearchW25').on('click', function(){
            _this.searchW25();
        });

        $('#btnSearchW26').on('click', function(){
            _this.searchW26();
        });

        $('#btnSearchW27').on('click', function(){
            _this.searchW27();
        });

        $('#btnSearchW38').on('click', function(){
            _this.searchW38();
        });

        $('#btnSearchW39').on('click', function(){
            _this.searchW39();
        });

        $('#btnSearchW40').on('click', function(){
            _this.searchW40();
        });

        $('#btnSearchW41').on('click', function(){
            _this.searchW41();
        });

        $('#btnSearchW42').on('click', function(){
            _this.searchW42();
        });

        $('#btnSearchW43').on('click', function(){
            _this.searchW43();
        });

        $('#btnSearchW44').on('click', function(){
            _this.searchW44();
        });

        $('#btnSearchW45').on('click', function(){
            _this.searchW45();
        });

        $('#btnSearchW46').on('click', function(){
            _this.searchW46();
        });

        $('#btnSearchW48').on('click', function(){
            _this.searchW48();
        });

        $('#btnSearchW49').on('click', function(){
            _this.searchW49();
        });

        $('#btnSearchW50').on('click', function(){
            _this.searchW50();
        });

        $('#btnSearchW51').on('click', function(){
            _this.searchW51();
        });

        $('#btnSearchW52').on('click', function(){
            _this.searchW52();
        });

        $('#btnSearchW53').on('click', function(){
            _this.searchW53();
        });

    },
    searchW20 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w20',
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
    searchW21 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w21',
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
    searchW22 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w22',
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
    searchW23 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w23',
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
    searchW24 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w24',
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
    searchW25 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w25',
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
    searchW26 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w26',
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
    searchW27 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w27',
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
    searchW38 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w38',
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
    searchW39 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w39',
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
    searchW40 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w40',
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
    searchW41 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w41',
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
    searchW42 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w42',
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
    searchW43 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w43',
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
    searchW44 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w44',
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
    searchW45 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w45',
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
    searchW46 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w46',
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
    searchW48 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w48',
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
    searchW49 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w49',
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
    searchW50 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w50',
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
    searchW51 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w51',
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
    searchW52 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w52',
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
    searchW53 : function () {
        var data = {
            admcd: $('#admcd option:selected').val(),
            basin: $('#basin option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/wks/search/w53',
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