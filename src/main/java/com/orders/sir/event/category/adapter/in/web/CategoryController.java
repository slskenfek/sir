package com.orders.sir.event.category.adapter.in.web;


import com.orders.sir.common.code.ResponseSuccess;
import com.orders.sir.common.code.ApiResponse;
import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.application.port.in.CategoryEventPort;
import com.orders.sir.event.category.application.port.in.CategoryFindPort;
import com.orders.sir.event.category.dto.CategoryEventParams;
import com.orders.sir.event.category.dto.CategoryFindParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryEventPort categoryEventPort;

    private final CategoryFindPort categoryFindPort;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<CategoryEntity>>> getCategoryList(CategoryFindParams.SearchRequest searchRequest) {
        return ResponseSuccess.of(categoryFindPort.getCategorySearchList(searchRequest));
    }


    @PostMapping("")
    public ResponseEntity<String> addCategory(@RequestBody CategoryEventParams.AddRequest addRequest) {
        categoryEventPort.addCategory(addRequest);
        return ResponseEntity.ok().body("등록 하였습니다.");
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryEventParams.UpdateRequest updateRequest,
                                                 @PathVariable Long categoryId) {
        updateRequest.setId(categoryId);
        categoryEventPort.updateCategory(updateRequest);
        return ResponseEntity.ok().body("수정 하였습니다.");
    }


}
