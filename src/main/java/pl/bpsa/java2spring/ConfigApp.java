package pl.bpsa.java2spring;

import https.www_w3schools_com.xml.DetailsType;
import https.www_w3schools_com.xml.GetBankResponseType;
import https.www_w3schools_com.xml.GetBankType;
import https.www_w3schools_com.xml.TempConvertHttpPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Holder;

@Configuration
public class ConfigApp {

    @Bean
    TempConvertHttpPost bean() {
        return new TempConvertHttpPost() {

            @Override
            public String celsiusToFahrenheit(String celsius) {
                return "{'a':'b'}";
            }

            @Override
            public void fahrenheitToCelsius(GetBankType fahrenheit, GetBankType fahrenheit2, Holder<String> body, Holder<GetBankResponseType> body2) {
                body.value = "asdasdasd";
                GetBankResponseType value = new GetBankResponseType();
                DetailsType value1 = new DetailsType();
                value1.setBic("123");
                value.setDetails(value1);
                body2.value = value;

            }
        };
    }


}
