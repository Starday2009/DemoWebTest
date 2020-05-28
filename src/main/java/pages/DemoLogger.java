package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DemoLogger {
  private Logger logger = LoggerFactory.getLogger(CommonActions.class.getName());

  private static DemoLogger instance;

  private DemoLogger() {}

  public static DemoLogger getInstance() {
    if (instance == null) {
      instance = new DemoLogger();
    }
    return instance;
  }

  public void loggerPrint(String message) {
    logger.info(message);
  }

  public void loggerPrintError(String message) {
    logger.error(message);
  }

  public void loggerPrintWarn(String message) {
    logger.warn(message);
  }
}
