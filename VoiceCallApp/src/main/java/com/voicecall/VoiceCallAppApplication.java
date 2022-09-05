package com.voicecall;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class VoiceCallAppApplication implements ApplicationRunner {

	private final static String SID_ACCOUNT = "AC35098b5a26bec745a6f38effabdf7272";
	private final static String AUTH_ID = "915fe4804c08a5c8ba61a808df02a011";
	private final static String FROM_NUMBER = "+18722679883";
	private final static String TO_NUMBER = "your number";

	static {
		Twilio.init(SID_ACCOUNT, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(VoiceCallAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				new URI("http://demo.twilio.com/docs/voice.xml")).create();
	}

}
