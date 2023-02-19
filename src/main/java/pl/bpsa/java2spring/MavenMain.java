package pl.bpsa.java2spring;

import lombok.Getter;
import lombok.Setter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import pl.bpsa.java2spring.model.ApiModel;

@Mojo(name = "cxf2spring", defaultPhase = LifecyclePhase.PROCESS_RESOURCES)
public class MavenMain extends AbstractMojo {

    @Parameter(defaultValue = "path", required = true, readonly = true)
    @Getter
    @Setter
    String path;
    @Parameter(property = "apiClass")
    @Getter
    @Setter
    private String clazz;
    @Parameter(property = "packageName")
    @Getter
    @Setter
    private String packageName;

    @Override
    public void execute() throws MojoExecutionException {
        try {
            Class<?> aClass = MavenMain.class.getClassLoader().loadClass(clazz);
            ApiModel api = ClassParser.parse(aClass);
            api.setPackageName(packageName);
            String print = ApiPrinter.print(api);
            ClassSaver.save(print, path, api);

        } catch (Exception e) {
            throw new MojoExecutionException(e.getMessage());
        }
    }
}
