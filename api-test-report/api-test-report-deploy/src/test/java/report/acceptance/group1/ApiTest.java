package report.acceptance.group1;

import hs.api.test.report.annotation.TestCase;
import hs.api.test.report.annotation.TestGroup;
import org.junit.Test;

@TestGroup("수신입금 신규 주택청약")
public class ApiTest {

    @TestCase("주택청약 신규 케이스는 일반입니다.")
    @Test
    public void SampleTest(){
        System.out.println("주택청약 신규");
    }
}
