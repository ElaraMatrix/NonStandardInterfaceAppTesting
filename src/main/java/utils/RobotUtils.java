package utils;

import aquality.selenium.core.utilities.JsonSettingsFile;
import logger.Log;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtils {

    private RobotUtils() {}

    private static void copyPathToWindowsPopupMenu(String path) throws AWTException {
        Log.info("enter " + System.getProperty("user.dir") + path + " to windows popup menu");
        StringSelection ss = new StringSelection(System.getProperty("user.dir") + path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void avatarUpload() {
        try {
            copyPathToWindowsPopupMenu((String) new JsonSettingsFile("testconfig.json").getValue("/upload_image_path"));
        } catch (AWTException e) {
            Log.error("image hasn't been uploaded");
        }
    }
}
