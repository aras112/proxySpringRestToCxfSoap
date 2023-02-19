package pl.bpsa.java2spring;

import com.thomas_bayer.blz.BLZServicePortType;
import https.www_w3schools_com.xml.TempConvertHttpPost;
import org.junit.jupiter.api.Test;
import pl.bpsa.java2spring.model.ApiModel;

import static org.junit.jupiter.api.Assertions.*;

class ClassParserTest {

    @Test
    void parse() {
        ApiModel parse = ClassParser.parse(BLZServicePortType.class);
    }

    @Test
    void parse2() {
        ApiModel parse = ClassParser.parse(TempConvertHttpPost.class);
    }
}