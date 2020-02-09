package com.maxmayev.twilio.service;

import com.maxmayev.twilio.config.TwilioConfiguration;
import com.maxmayev.twilio.data.SendingData;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
@Slf4j
public class SendMessageImpl implements SendMessage {

    TwilioConfiguration twilioConfiguration;

    @Autowired
    public SendMessageImpl(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendMesage(SendingData sendingData) {
        if (ifPhoneNumberValid(sendingData.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(sendingData.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = sendingData.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            log.info("Send sms {}" + sendingData);
        } else {
            throw new IllegalArgumentException("Phone number invalid");
        }
    }

    private boolean ifPhoneNumberValid(String phoneNumber) {
        return true;
    }
}
