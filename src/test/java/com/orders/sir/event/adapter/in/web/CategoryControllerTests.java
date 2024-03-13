package com.orders.sir.event.adapter.in.web;

import com.orders.sir.event.category.domain.CategoryManager;
import com.orders.sir.event.category.dto.CategoryEventParams;
import com.orders.sir.event.product.dto.ProductDTO;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryControllerTests {


    @Test
    @DisplayName("카테고리 등록")
    public void addContent() {
        CategoryEventParams.AddRequest request = new CategoryEventParams.AddRequest(
                CategoryManager.GARMENT.getName(),
                CategoryManager.GARMENT.getCode(),
                1
        );

        ExtractableResponse<Response> response =
                RestAssured.given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .body(request)
                        .when()
                        .post("/api/category")
                        .then()
                        .log().all().extract();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());


    }
}
