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