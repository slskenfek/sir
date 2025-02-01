package com.orders.sir.event.adapter.in.team.web;

import com.orders.sir.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamControllerTest extends ApiTest {

    @Test
    @DisplayName("팀 목록 조회하기")
    public void findTeamList() {
        //API 요청
        ExtractableResponse<Response> response =
                RestAssured.given().log().all()
                        .when()
                        .get("/api/team")
                        .then()
                        .log().all().extract();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
