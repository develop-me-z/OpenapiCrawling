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
    save : function () {
        //CSV 문자열 생성
        let downLink = document.getElementById('btnSave');
        let csv = ''; //CSV최종 문자열을 저장하는 변수
        let rows = document.querySelectorAll("#dataTable tr"); // 테이블에서 행 요소들을 모두 선택
        let fileName = '강수량관측소.csv';

        //행단위 루핑
        for (var i = 0; i < rows.length; i++) {
            let cells = rows[i].querySelectorAll("td, th");
            let row = [];
            //행의 셀 값을 배열로 얻기
            cells.forEach(function(cell){
                row.push(cell.innerHTML);
            });

            csv += row.join(',') + (i != rows.length-1 ? '\n':''); // 배열을 문자열+줄바꿈으로 변환
        }

        //CSV 파일 저장
        csvFile = new Blob([csv], {type: "text/csv"}); // 생성한 CSV 문자열을 Blob 데이터로 생성
        downLink.href = window.URL.createObjectURL(csvFile); // Blob 데이터를 URL 객체로 감싸 다운로드 하이퍼링크에 붙임.
        downLink.download = fileName; // 인자로 받은 다운로드 파일명을 지정
    }

};

main.init();