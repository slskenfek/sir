function add_product() {

    $.ajax({
        url: 'https://example.com/data',
        method: 'POST',  // 요청 방식 (GET, POST 등)
        dataType: 'json',  // 응답 데이터 형식 (json, html 등)
        success: function(response) {
            // 성공적으로 요청이 완료됨
            console.log(response);
        },
        error: function() {
            // 요청이 실패했을 때의 처리
            console.error('AJAX request failed');
        }
    });
}