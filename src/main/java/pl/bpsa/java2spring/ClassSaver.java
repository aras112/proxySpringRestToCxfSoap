package pl.bpsa.java2spring;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import lombok.SneakyThrows;
import pl.bpsa.java2spring.model.ApiModel;

import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassSaver {

    @SneakyThrows
    public static String save(String str, String fileName, ApiModel apiModel) {
        Path path = Paths.get(fileName+apiModel.getPackageName().replace(".","/"));
        Files.createDirectories(path);
        byte[] strToBytes = str.getBytes();
        Files.write(path.resolve(apiModel.getClassName()+"RestApi.java"), strToBytes);
        return str;
    }

}
