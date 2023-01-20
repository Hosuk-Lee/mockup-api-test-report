package hs.api.test.report.doc;

import hs.api.test.report.annotation.TestCase;
import hs.api.test.report.annotation.TestGroup;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.reflections.Reflections;
import org.reflections.scanners.MethodParameterScanner;

public class CreateReport {

    public static File createReport() throws IOException {
        URL resource = CreateReport.class.getClassLoader().getResource(".");
        File f = new File(new File(resource.getPath()).getParent() + "/api-report");
        System.out.println("Parent Dir : "+f);
        f.mkdir();

        findClasses("hs"); // org.example ..
        return f;

    }

    private static void findClasses(String pkg) {
        Reflections reflections = new Reflections(pkg);
        Set<Class<?>> types = reflections
                .getTypesAnnotatedWith(TestGroup.class);
        List<String> annotatedClasses = types.stream()
                .map(clazz -> clazz.getAnnotation(TestGroup.class)
                        .value())
                .collect(Collectors.toList());
        System.out.println("Group Name : " + annotatedClasses);

        for (Class<?> type : types) {
            System.out.println("type : " + type);
            System.out.println("type : " + type.getSimpleName());
            System.out.println("type : " + type.getPackageName());
            System.out.println("type : " + type.getCanonicalName());
            Method[] methods = findMethods(type);

        }


    }

    private static Method[] findMethods(Class<?> type) {
//        Reflections reflections = new Reflections("report.acceptance.group2.ApiTest");
//        System.out.println("findMethods : " + type.getCanonicalName());
//
//        Set<Method> mtds = reflections.getMethodsAnnotatedWith(TestCase.class);
//        System.out.println("mtds : " + mtds);
//        for (Method mtd : mtds) {
//            System.out.println("@@"+mtds);
//        }

        Method[] methods = type.getMethods();
        for (Method method : methods) {
            System.out.println("@@"+method+"," + method.getAnnotations());
            for (Annotation annotation : method.getAnnotations()) {
                System.out.print("-- : " + annotation.getClass().getSimpleName());
            }
            System.out.println();

        }
        long count = Arrays.stream(methods).map(
                method -> method.getAnnotation(TestCase.class).value()
        ).count();
        System.out.println("##"+count);

        return null;
    }

}
