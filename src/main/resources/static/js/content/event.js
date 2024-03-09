function add_product() {


    const formData = {
         productName: document.getElementById('product_name').value,
         productPrice: document.getElementById('product_price').value.replaceAll(",", "")
     };

    $.ajax({
        url: '/api/content',
        method: 'POST',  // 요청 방식 (GET, POST 등)
        dataType: 'json',  // 응답 데이터 형식 (json, html 등)
        data: JSON.stringify(formData),
        contentType: 'application/json',

        success: function(response) {
            alert("상품등록 성공 하였습니다.")
        },
        error: function() {
            alert("실패 하였습니다")
        }
    });
}


