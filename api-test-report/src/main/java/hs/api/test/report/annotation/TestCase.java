package hs.api.test.report.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
//@Repeatable(TestCases.class)
public @interface TestCase {
    String value();

    public boolean testCaseAround() default true;
    public boolean testCaseBefore() default true;
    public boolean testCaseAfter() default true;

}
