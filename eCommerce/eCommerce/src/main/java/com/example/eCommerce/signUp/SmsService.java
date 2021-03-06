package com.example.eCommerce.signUp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SmsService {
     private final String ACCOUNT_SID ="AC380c885ec592621664d548aedf055be3";

    private final String AUTH_TOKEN = "5dfb8234c670443c807dbd78a106c931";

    private final String FROM_NUMBER = "+14043417638";

    public void send(SignUp sms) throws ParseException {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
    	
        int min = 100000;  
         int max = 999999; 
        int number=(int)(Math.random()*(max-min+1)+min);
      
        
        String msg ="Your OTP - "+number+ " please verify this OTP in your Application by Er Prince kumar Technoidentity.com";
       
        
        Message message = Message.creator(new PhoneNumber(sms.getPhoneNo()), new PhoneNumber(FROM_NUMBER), msg)
                .create();
       
      /*  Date myDate=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf. parse(myDate.toString()); 
        long millis = date. getTime(); 
        System.out.println(millis);
       OTPpojo.setOtp(number);
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction
*/
    }

    public void receive(MultiValueMap<String, String> smscallback) {
   
    }

}
