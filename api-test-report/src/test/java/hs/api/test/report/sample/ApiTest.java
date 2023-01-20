package hs.api.test.report.sample;

import hs.api.test.report.annotation.TestCase;
import hs.api.test.report.annotation.TestGroup;
import hs.api.test.report.doc.CreateReport;
import org.junit.Test;

@TestGroup("Group 1")
public class ApiTest {

    @TestCase("Hosuk.Lee foo~~")
    @Test
    public void foo() {
        System.out.println("Foo~~");
//        CreateReport cr = new CreateReport();

    }
}
