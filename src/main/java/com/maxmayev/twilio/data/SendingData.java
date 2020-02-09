package com.maxmayev.twilio.data;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SendingData {

    private String phoneNumber;
    private String message;

    public SendingData(@JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
}

