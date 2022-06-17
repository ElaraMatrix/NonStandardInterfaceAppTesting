package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import logger.Log;
import org.openqa.selenium.By;

public class CookiesForm extends Form {

    private final IButton accept = AqualityServices.getElementFactory()
            .getButton(By.xpath("//div[@class='cookies']//button[contains(text(), 'no')]"), "accept");

    public CookiesForm() {
        super(By.xpath("//div[@class='cookies']//button[contains(text(), 'no')]"), "CookiesForm");
    }

    public void clickToAcceptCookies() {
        Log.info("click to accept cookies");
        accept.state().waitForExist();
        accept.click();
    }

    public boolean isCookiesFormClosed() {
        Log.info("is cookies form closed checking");
        return accept.state().waitForNotExist();
    }
}