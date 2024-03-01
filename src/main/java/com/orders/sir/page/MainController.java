package com.orders.sir.page;

import com.orders.sir.event.application.port.in.MemberUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
@RequiredArgsConstructor
public class MainController {

    private final MemberUseCasePort memberUseCasePort;

    @GetMapping("/member")
    public String home(Model model) {
        model.addAttribute("member_list", memberUseCasePort.findMemberList());
        return "main";
    }


}
