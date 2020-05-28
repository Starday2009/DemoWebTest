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
  private List<String> log = new LinkedList<>();

  private static DemoLogger instance;

  private DemoLogger() {}

  public static DemoLogger getInstance() {
    if (instance == null) {
      instance = new DemoLogger();
    }

    return instance;
  }

  public void loggerPrint(String message) {
    message = MessageFormat.format("{0} - {1} | {2}", returnMinSec(), "INFO", message);
    logger.info(message);
    log.add(" <testcase name=\"" + message + "\"/>");
  }

  public void loggerPrintError(String message) {
    message = MessageFormat.format("{0} - {1} | {2}", returnMinSec(), "ERROR", message);
    logger.error(message);
    log.add(" <testcase name=\"" + message + "\"/>");
  }

  public void loggerPrintWarn(String message) {
    message = MessageFormat.format("{0} - {1} | {2}", returnMinSec(), "WARNING", message);
    logger.warn(message);
    log.add(message);
  }

  public List<String> getLog() {
    return log;
  }

  private static String returnMinSec() {
    return new SimpleDateFormat("HH:mm:ss").format(new Date());
  }
}
