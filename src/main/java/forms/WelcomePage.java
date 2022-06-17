package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import logger.Log;
import org.openqa.selenium.By;

public class WelcomePage extends Form {

    private final ILink start = AqualityServices.getElementFactory().getLink(By.xpath("//a[@class='start__link']"), "start");

    public WelcomePage() {
        super(By.xpath("//div[contains(@class, 'start')]"), "WelcomePage");
    }

    public void clickToStart() {
        Log.info("click to start game");
        start.click();
    }
}