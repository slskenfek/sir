package com.orders.sir.event.adapter.in.product.web;

import com.orders.sir.event.product.dto.ProductDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductControllerTests {


    @Test
    @DisplayName("상품 등록")
    public void addContent() {
        ProductDTO.AddRequest request = new ProductDTO.AddRequest(
                "롤백진짜되냐??",
                7000,
                "",
                ""
        );

        ExtractableResponse<Response> response =
                RestAssured.given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .body(request)
                        .when()
                        .post("/api/content")
                        .then()
                        .log().all().extract();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());


    }
}
