package gdsproject.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseReport {

    ExtentReports extent;
    ExtentTest test;

    public BaseReport() {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/GDS_project_automation_result.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }
}
