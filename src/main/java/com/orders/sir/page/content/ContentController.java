package com.orders.sir.page.content;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content/page")
@RequiredArgsConstructor
public class ContentController {

    @GetMapping("/home")
    public String mainPage(Model model) {
        return "layout/content/main";
    }

    @GetMapping("/add")
    public String contentCreate() {
        return "layout/content/main";
    }
}
