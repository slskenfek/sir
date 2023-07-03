package com.orders.sir.event.adapter.in.web;

import com.orders.sir.ApiTest;
import com.orders.sir.event.domain.MemberDomain;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

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
        final MemberDomain body = MemberDomain.builder()
                .memberId("kk1234")
                .memberAddress("부산시 영도구")
                .memberPassword("qwe123")
                .memberName("홍길동")
                .build();
        for(int i=0; i<10; i++) {
            executorService.submit(() -> {
                ExtractableResponse<Response> response =
                        RestAssured.given().log().all()
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .body(body)
                                .when()
                                .post("/api/members")
                                .then()
                                .log().all().extract();

                assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }

    @Test
    @Transactional
    @DisplayName("업데이트 요청")
    void updateMember() {
        final MemberDomain body =  MemberDomain.builder()
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