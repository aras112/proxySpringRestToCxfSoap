package pl.bpsa.java2spring;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.jupiter.api.Test;

class MavenMainTest {

    @Test
    void execute() throws MojoExecutionException, MojoFailureException {
        MavenMain mavenMain = new MavenMain();
        mavenMain.setClazz("com.thomas_bayer.blz.BLZServicePortType");
        mavenMain.setPath("target/generated-sources/cxf/");
        mavenMain.setPackageName("pl.bpsa.java2spring");
        mavenMain.execute();
    }
}