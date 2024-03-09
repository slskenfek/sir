
function addCommas(element) {
                // 입력값에서 숫자만 추출
                const inputValue = element.value.replace(/[^0-9]/g, '');

                // 콤마를 추가한 포맷으로 변경
                const formattedValue = inputValue.replace(/\B(?=(\d{3})+(?!\d))/g, ',');

                // 변경된 값을 다시 입력 필드에 설정
                element.value = formattedValue;
}