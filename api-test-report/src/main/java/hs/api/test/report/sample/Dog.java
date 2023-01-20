package hs.api.test.report.sample;

import hs.api.test.report.aspect.PrintLog;

public class Dog {
    @PrintLog
    public void eat() {
        // around, before, after 로그 출력
        System.out.println("개가 음식을 먹습니다.");
    }

    @PrintLog(printAround = false)
    public void drink() {
        // before, after 로그 출력
        System.out.println("개가 물을 마십니다.");
    }
}
