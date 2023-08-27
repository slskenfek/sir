package com.orders.sir.page;


import com.orders.sir.event.application.port.in.SocketPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/socket")
public class SocketController {

    private final SocketPort socketPort;

    @GetMapping("/page")
    public String page(Model model) throws Exception {
       model.addAttribute("socket_list", socketPort.getHistoryList());

        return "socket";
    }


}
