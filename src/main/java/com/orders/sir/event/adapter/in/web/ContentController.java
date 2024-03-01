package com.orders.sir.event.adapter.in.web;

import com.orders.sir.common.enums.ResponseMsg;
import com.orders.sir.event.application.port.in.ContentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentPort contentPort;

    @PostMapping("")
    public ResponseEntity addContent() {
        contentPort.addContent();
        return ResponseEntity.ok().body(ResponseMsg.SUCCESS.getMsg());
    }
}
