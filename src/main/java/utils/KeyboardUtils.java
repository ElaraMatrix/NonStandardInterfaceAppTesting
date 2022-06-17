package utils;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public final class KeyboardUtils {

    private KeyboardUtils() {}

    private static final Actions actionProvider = new Actions(AqualityServices.getBrowser().getDriver());

    public static void keyEnd() {
        actionProvider.sendKeys(Keys.END).build().perform();
    }

    public static void keyBackspace() {
        actionProvider.sendKeys(Keys.BACK_SPACE).build().perform();
    }
}