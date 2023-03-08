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

        $('#btnSearchW10').on('click', function(){
            _this.searchW10();
        });

        $('#btnSearchW11').on('click', function(){
            _this.searchW11();
        });

        $('#btnSearchW12').on('click', function(){
            _this.searchW12();
        });

        $('#btnSearchW13').on('click', function(){
            _this.searchW13();
        });

    },
    searchW10 : function () {
        var data = {
            basin: $('#basin option:selected').val(),
            oper: $('#oper option:selected').val(),
            keynm: $('#keynm').val(),
            sort: $('#sort option:selected').val()
        };

        $.ajax({
            type: 'POST',
            url: '/we/search/w10',
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
    searchW11 : function () {
        var data = {
            obscd: $('#obscd').val()
        };

        $.ajax({
            type: 'POST',
            url: '/we/search/w11',
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
    searchW12 : function () {
        var data = {
            obscd: $('#obscd').val(),
            startdt: $('#startdt').val()!=""? moment($('#startdt').val()).format("YYYYMMDD") : "",
            enddt: $('#enddt').val()!=""? moment($('#enddt').val()).format("YYYYMMDD") : ""
        };

        $.ajax({
            type: 'POST',
            url: '/we/search/w12',
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
    searchW13 : function () {
        var data = {
            obscd: $('#obscd').val(),
            startdt: $('#startdt').val()!=""? moment($('#startdt').val()).format("YYYYMMDD") : "",
            enddt: $('#enddt').val()!=""? moment($('#enddt').val()).format("YYYYMMDD") : ""
        };

        $.ajax({
            type: 'POST',
            url: '/we/search/w13',
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