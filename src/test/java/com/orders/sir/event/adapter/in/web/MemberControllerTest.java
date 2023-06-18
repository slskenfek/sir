package com.orders.sir.event.adapter.in.web;

import com.orders.sir.event.application.port.in.MemberUseCasePort;
import com.orders.sir.event.domain.MemberDomain;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



class MemberControllerTest extends ApiTest {

    @Test
    @DisplayName("전체 회원 들고오기 테스트")
    public void findMemberList() {
    //API 요청

    }

    @Test
    @DisplayName("앱에서 회원 정보를 요청할때")
    void findAppMemberList() {

    }

    @Test
    @DisplayName("회원 찾기")
    void findMember() {
        final var request = 회원고유값();
        final var response = 회원찾기요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());

    }

    @NotNull
    private static Long 회원고유값() {
        final Long memberSeq = 1L;
        return memberSeq;
    }

    private static ExtractableResponse<Response> 회원찾기요청(Long memberSeq) {
        final ExtractableResponse<Response> response =
        RestAssured.given().log().all()
                    .when()
                    .get("/api/members/" + memberSeq)
                    .then()
                    .log().all().extract();
        return response;
    }

    @Test
    @DisplayName("회원 생성")
    void createMember() {
        final MemberDomain body = MemberDomain.builder()
                .memberId("testmember")
                .memberAddress("부산시 영도구")
                .memberPassword("qwe123")
                .memberName("홍길동")
                .seq(4L)
                .build();

        ExtractableResponse<Response> response =
                RestAssured.given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .body(body)
                        .when()
                        .post("/api/members")
                        .then()
                        .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

    }

    @Test
    @DisplayName("업데이트 요청")
    void updateMember() {
    }

    @Test
    void deleteMember() {

    }

}