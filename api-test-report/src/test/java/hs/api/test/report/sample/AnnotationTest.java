package hs.api.test.report.sample;

import hs.api.test.report.annotation.TestGroup;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;
import org.reflections.Reflections;

public class AnnotationTest {

    @Test
    public void test(){

        Reflections reflections = new Reflections("hs.api.test.report");

        Set<Class<?>> types = reflections
                .getTypesAnnotatedWith(TestGroup.class);
        List<String> annotatedClasses = types.stream()
                .map(clazz -> clazz.getAnnotation(TestGroup.class)
                        .value())
                .collect(Collectors.toList());

        System.out.println(annotatedClasses);

    }

}
