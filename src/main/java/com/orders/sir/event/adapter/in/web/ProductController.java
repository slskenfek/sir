package com.orders.sir.event.adapter.in.web;

import com.orders.sir.common.enums.ResponseMsg;
import com.orders.sir.event.application.port.in.ProductPort;
import com.orders.sir.event.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ProductController {

    private final ProductPort productPort;

    @PostMapping("")
    public ResponseEntity addContent(@RequestBody ProductDTO.AddRequest request) {
        productPort.addContent(request);
        return ResponseEntity.ok().body(ResponseMsg.SUCCESS.getMsg());
    }
}
