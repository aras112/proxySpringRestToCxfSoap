package pl.bpsa.java2spring;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import lombok.SneakyThrows;
import pl.bpsa.java2spring.model.ApiModel;

import java.io.StringWriter;

public class ApiPrinter {

    @SneakyThrows
    public static String print(ApiModel apiModel) {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("src/main/resources/spring.mustache");
        StringWriter writer = new StringWriter();
        mustache.execute(writer, apiModel).flush();
        String result = writer.toString();
        System.out.println(result);
        return result;
    }

}
