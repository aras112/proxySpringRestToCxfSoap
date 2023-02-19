package pl.bpsa.java2spring;

import com.thomas_bayer.blz.BLZServicePortType;
import https.www_w3schools_com.xml.TempConvertHttpPost;
import org.junit.jupiter.api.Test;
import pl.bpsa.java2spring.model.ApiModel;
import pl.bpsa.java2spring.model.ParamModel;
import pl.bpsa.java2spring.model.OperationModel;

import java.util.Arrays;

class ApiPrinterTest {

    @Test
    void print() {
        ApiModel apiModel = new ApiModel();

        apiModel.setClassName("BLZServicePortType");
        apiModel.setPackageName("com.thomas_bayer.blz");



        ParamModel input = new ParamModel();
        input.setClazz("java.lang.String");
        input.setName("blz");
        input.setLast(true);

        ParamModel output = new ParamModel();
        output.setClazz("com.thomas_bayer.blz.DetailsType");
        output.setName("param2");
        output.setLast(true);

        OperationModel operationModel = new OperationModel();
        operationModel.setName("getBank");
        operationModel.setInputs(Arrays.asList(input));
        operationModel.setOutput(output);
        apiModel.setOperations(Arrays.asList(operationModel));
        operationModel.setPath("/path");

        ApiPrinter.print(apiModel);
    }
    @Test
    void print2() {
        ApiPrinter.print(ClassParser.parse(BLZServicePortType.class));
    }
    @Test
    void print3() {
        ClassSaver.save(ApiPrinter.print(ClassParser.parse(TempConvertHttpPost.class)), "target/generated-sources/cxf/", ClassParser.parse(TempConvertHttpPost.class));
    }
    @Test
    void print4() {
        ApiModel parse = ClassParser.parse(TempConvertHttpPost.class);
        parse.setPackageName("pl.bpsa.java2spring");
        ClassSaver.save(ApiPrinter.print(parse), "target/generated-sources/cxf/", parse);
    }
}