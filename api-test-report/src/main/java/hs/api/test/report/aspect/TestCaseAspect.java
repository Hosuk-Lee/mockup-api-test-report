package hs.api.test.report.aspect;

import hs.api.test.report.annotation.TestCase;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestCaseAspect {

    @Pointcut("@annotation(testCase)")
    public void callAt(TestCase testCase) {

    }
    @Around("callAt(testCase)")
    public Object around(ProceedingJoinPoint pjp, TestCase testCase) throws Throwable {
        if(!testCase.testCaseAround()) return pjp.proceed();

        String name = pjp.getSignature().toShortString();
        System.out.println("** " + name + " around 실행**");
        Object result = pjp.proceed();

        System.out.println("RESULT : "+result);
        System.out.println("pjp.getKind() : " + pjp.getKind());
        System.out.println("pjp.toLongString() : " + pjp.toLongString());
        System.out.println("pjp.getSignature().toLongString() : " + pjp.getSignature().toLongString());
        System.out.println("pjp.getSignature().toString() : " + pjp.getSignature().toString());
        System.out.println("pjp.getSignature().getName() : " + pjp.getSignature().getName());
        System.out.println(pjp.getSignature().getDeclaringType().getPackageName());
        System.out.println(pjp.getSignature().getDeclaringType().getTypeName());
        System.out.println(pjp.getSignature().getDeclaringType().getSimpleName());
        System.out.println("pjp.getSignature().getClass().getPackageName() : " + pjp.getSignature().getClass().getPackageName());

        System.out.println("** " + name + " around 끝**");
        return result;
    }

    @Before("callAt(testCase)")
    public void before(TestCase testCase) {
        if(testCase.testCaseBefore()) {
            System.out.println("-- before log --");
        }
    }

    @After("callAt(testCase)")
    public void after(TestCase testCase) {
        if(testCase.testCaseAfter()) {
            System.out.println("-- after log --");
        }
    }
}
