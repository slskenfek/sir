package com.orders.sir.test;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/test")
@RequiredArgsConstructor
@RestController
public class TestController {

    @GetMapping("/go")
     public List test() {
         return new ArrayList();
     }
}
