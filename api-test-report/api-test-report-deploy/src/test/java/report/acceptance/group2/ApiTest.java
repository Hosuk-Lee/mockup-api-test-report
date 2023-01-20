package report.acceptance.group2;

import hs.api.test.report.annotation.TestCase;
import hs.api.test.report.annotation.TestCases;
import hs.api.test.report.annotation.TestGroup;
import hs.api.test.report.doc.CreateReport;
import org.junit.Test;

@TestGroup("적립식입금 신규 주택청약")
public class ApiTest {

    @TestCase("적립식입금 신규 케이스는 일반입니다.")
    @Test
    public void SampleTest(){
        System.out.println("적립식신규");
    }

    @TestCases(
            {@TestCase("tt"),
            @TestCase("qt")}
    )
    @Test
    public void SampleTes2t(){
        System.out.println("적립식신규");
    }
}
