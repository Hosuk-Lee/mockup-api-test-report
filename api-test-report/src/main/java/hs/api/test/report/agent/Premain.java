package hs.api.test.report.agent;

import hs.api.test.report.doc.CreateReport;
import java.io.File;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.net.URL;

public class Premain {

    public static void premain(String agentArgs, Instrumentation inst) throws IOException {

        URL resource = Premain.class.getClassLoader().getResource(".");
        File f = new File(new File(resource.getPath()).getParent() + "/api-report");
        System.out.println("premain : Parent Dir : "+f);

        CreateReport.createReport();

//        Thread printingHook = new Thread(() -> System.out.println("In the middle of a shutdown"));
//        Runtime.getRuntime().addShutdownHook(printingHook);
    }

}