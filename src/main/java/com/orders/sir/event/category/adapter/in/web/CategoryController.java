package com.orders.sir.event.category.adapter.in.web;


import com.orders.sir.event.category.application.port.in.CategoryEventPort;
import com.orders.sir.event.category.dto.CategoryEventParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryEventPort categoryEventPort;

    @PostMapping("")
   public ResponseEntity<String> addCategory(@RequestBody CategoryEventParams.AddRequest addRequest) {
        categoryEventPort.addCategory(addRequest);
        return ResponseEntity.ok().body("등록 하였습니다.");
   }
}
