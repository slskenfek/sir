

        const products = [
            "상품 1", "상품 2", "상품 3", "상품 4", "상품 5",
            "상품 6", "상품 7", "상품 8", "상품 9", "상품 10",
            "상품 11", "상품 12", "상품 13", "상품 14", "상품 15",
            "상품 16", "상품 17", "상품 18", "상품 19", "상품 20"
        ];

        const productContainer = document.getElementById("product-container");
        const loadCount = 12;
        // 초기 상품 로드
        loadProducts(0, loadCount);

        // 스크롤 이벤트 감지
        window.addEventListener("scroll", () => {
            if (window.innerHeight + window.scrollY >= document.body.offsetHeight - 100) {
                // 스크롤이 페이지 하단에 닿으면 추가 상품 로드
                loadProducts(productContainer.children.length, loadCount);
            }
        });

        // 상품 로드 함수
        function loadProducts(startIndex, count) {
            for (let i = startIndex; i < startIndex + count && i < products.length; i++) {
                const productDiv = document.createElement("div");
                productDiv.className = "main-product";
                productDiv.innerHTML = `<p>${products[i]}</p><button>장바구니에 추가</button>`;
                productContainer.appendChild(productDiv);
            }
        }