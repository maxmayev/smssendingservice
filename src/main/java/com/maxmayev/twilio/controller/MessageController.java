package com.maxmayev.twilio.controller;


import com.maxmayev.twilio.data.SendingData;
import com.maxmayev.twilio.service.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sendsms")
@Slf4j
public class MessageController {

    SendMessage sendMessage;

    @Autowired
    public MessageController(@Qualifier("twilio") SendMessage sendMessage) {
        this.sendMessage = sendMessage;
    }

    @PostMapping
    public String sendSms(SendingData sendingData){
         sendMessage.sendMesage(sendingData);
         log.info(sendingData.toString());
        return "index";
    }

    @GetMapping
    public String getForm(){
        return "index";
    }
}
