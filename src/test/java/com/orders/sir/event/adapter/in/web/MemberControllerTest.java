package com.orders.sir.event.adapter.in.web;

import com.orders.sir.ApiTest;
import com.orders.sir.event.domain.Member;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class MemberControllerTest extends ApiTest {

    ExecutorService executorService = Executors.newFixedThreadPool(10);


    @Test
    @DisplayName("전체 회원 들고오기 테스트")
    public void findMemberList() {
    //API 요청
    ExtractableResponse<Response> response =
        RestAssured.given().log().all()
                .when()
                .get("/api/members")
                .then()
                .log().all().extract();
    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
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
    @Transactional
    @DisplayName("회원 생성")
    void createMember() throws InterruptedException {

        for(int i=0; i<10000; i++) {
            final Member body2 = Member.builder()
                    .memberId("kimsu" + i)
                    .memberAddress("창원시 경찰서" + i)
                    .memberPassword("q001" + i)
                    .memberName("뽀삐" + i)
                    .build();

                ExtractableResponse<Response> response2 =
                        RestAssured.given().log().all()
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .body(body2)
                                .when()
                                .post("/api/members")
                                .then()
                                .log().all().extract();

                assertThat(response2.statusCode()).isEqualTo(HttpStatus.CREATED.value());


        }


    }

    @Test
    @Transactional
    @DisplayName("업데이트 요청")
    void updateMember() {
        final Member body =  Member.builder()
                .memberId("ppTest1")
                .memberAddress("서울특별시 관악구")
                .memberPassword("q1w2e3")
                .memberName("세흥")
                .build();
        final Long memberSeq = 회원번호();

        ExtractableResponse<Response> response =
                RestAssured.given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .body(body)
                        .when()
                        .put("/api/members/" + memberSeq)
                        .then()
                        .log().all().extract();
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());


    }

    @NotNull
    private static Long 회원번호() {
        final Long memberSeq = 13L;
        return memberSeq;
    }

    @Test
    @Transactional
    void deleteMember() throws InterruptedException {
        long plus = 0L;
        for (int i = 0; i < 10; i++) {
            long finalPlus = plus;
            executorService.submit(() -> {

                 var memberSeq = 회원번호() + finalPlus;
                System.out.println("번호 : "+ memberSeq);
                ExtractableResponse<Response> response =
                        RestAssured.given().log().all()
                                .when()
                                .delete("/api/members/" + memberSeq)
                                .then()
                                .log().all().extract();
                assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());

                }

            );

            plus ++;
        }


    }
}