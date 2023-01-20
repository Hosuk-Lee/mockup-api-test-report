package hs.api.test.report;

import hs.api.test.report.agent.Premain;
import hs.api.test.report.aspect.Rabbit;
import hs.api.test.report.doc.CreateReport;
import hs.api.test.report.sample.Dog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class AppTest {

    @Test
    public void premain() throws IOException {
        CreateReport.createReport();
    }

    @Test
    public void env(){
        System.out.println(System.getenv());
        System.out.println(System.getProperties());
        System.out.println("--");
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test
    public void path(){
        Path relativePath = Paths.get("");
        String path = relativePath.toAbsolutePath().toString();
        System.out.println("Working Directory = " + path);

        System.out.println(FileSystems.getDefault());

        String currDir = this.getClass().getResource(".").getPath();
        System.out.println(currDir);

        URL resource = this.getClass().getClassLoader().getResource(".");
        System.out.println("resource.getPath : "+resource.getPath());

        File f = new File(resource.getPath());
        System.out.println("parent : "+f.getParent());

    }

    @Test
    public void dirMake(){
        CreateReport cr = new CreateReport();
    }

    @Test
    public void aspectjAnnotationBaseExample() {
        Rabbit rabbit = new Rabbit();
        rabbit.drink();
        System.out.println();
        rabbit.eat();

//        Dog dog = new Dog();
//        dog.drink();
//        System.out.println();
//        dog.eat();
    }
}
