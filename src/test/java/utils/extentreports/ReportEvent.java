package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReportEvent {
    public static void main(String []args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\Reshoketswe\\IdeaProjects\\UIAutomationAssessment\\reports");
        File file = new File("report.html");
        ExtentTest BaseTest = extentReports.createTest("BaseTest");
       extentReports.createTest("BaseTest").log(Status.PASS,"pass")
               .log(Status.SKIP,"Skip")
               .log(Status.FAIL,"fail")
       ;

        extentReports.attachReporter(sparkReporter);
        extentReports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());

    }
}
