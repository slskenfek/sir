package com.orders.sir;

import com.orders.sir.member.adapter.in.web.MemberController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SirApplicationTests {

	@Autowired
	MemberController memberController;
	@Test
	void contextLoads() throws Exception {
	System.out.println(memberController.findMemberList());

	}

}
