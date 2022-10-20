package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Assignment 5");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Student", "Temir Mendigali");
        extentReports.setSystemInfo("Teacher", "Kymbat Khairosheva");
        extentReports.setSystemInfo("Subject", "Software Quality Assurance and Testing");
        return extentReports;
    }
}
