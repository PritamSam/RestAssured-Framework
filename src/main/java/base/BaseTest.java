package base;

import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import core.RestAssuredFactory;
import utils.LoggerUtils;

@Listeners({
    utils.ExtentListener.class
})
public class BaseTest {

    protected Logger logger =
            LoggerUtils.getLogger(this.getClass());

    @BeforeSuite(alwaysRun = true)
    public void setup() {

        logger.info("========================================");
        logger.info("API Automation Execution Started");
        logger.info("Initializing Rest Assured Framework");
        logger.info("========================================");

        RestAssuredFactory.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {

        logger.info("========================================");
        logger.info("API Automation Execution Completed");
        logger.info("Generating Reports");
        logger.info("========================================");
    }
}
