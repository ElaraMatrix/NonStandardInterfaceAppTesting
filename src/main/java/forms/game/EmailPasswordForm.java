package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import logger.Log;
import org.openqa.selenium.By;
import utils.KeyboardUtils;
import utils.Randomizer;

public class EmailPasswordForm extends Form {

    private final ITextBox password = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'Choose Password')]"), "passwordField");
    private final ITextBox email = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'Your email')]"), "emailField");
    private final ITextBox domain = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'Domain')]"), "domainField");
    private final IButton selector = AqualityServices.getElementFactory()
            .getButton(By.xpath("//div[@class='dropdown__field']"), "selector");
    private final ICheckBox accept = AqualityServices.getElementFactory()
            .getCheckBox(By.xpath("//span[@class='checkbox__box']"), "accept");
    private final IButton next = AqualityServices.getElementFactory()
            .getButton(By.xpath("//a[@class='button--secondary']"), "next");

    private final String domainZoneItemLoc = "//div[@class='dropdown__list-item']";

    public EmailPasswordForm() {
        super(By.xpath("//a[@class='button--secondary']"), "Email&PasswordForm");
    }

    public void enterPassword(String password) {
        Log.info("enter password " + password);
        this.password.click();
        KeyboardUtils.keyEnd();
        for (int i = 0; i < 50; i++) {
            KeyboardUtils.keyBackspace();
        }
        this.password.type(password);
    }

    public void enterEmail(String email) {
        Log.info("enter email " + email);
        this.email.click();
        KeyboardUtils.keyEnd();
        for (int i = 0; i < 50; i++) {
            KeyboardUtils.keyBackspace();
        }
        this.email.type(email);
    }

    public void enterDomain(String domain) {
        Log.info("enter domain " + domain);
        this.domain.click();
        KeyboardUtils.keyEnd();
        for (int i = 0; i < 50; i++) {
            KeyboardUtils.keyBackspace();
        }
        this.domain.type(domain);
    }

    public void clickOnAcceptCheckbox() {
        Log.info("click on accept checkbox");
        accept.click();
    }

    public void clickRandomDropdownItem() {
        Log.info("click on random domain zone");
        selector.click();
        int size = AqualityServices.getBrowser().getDriver().findElements(By.xpath(domainZoneItemLoc)).size();
        int random = Randomizer.getRandomInt(1, size);
        ILabel label = AqualityServices.getElementFactory()
                .getLabel(By.xpath("(" + domainZoneItemLoc + ")[" + random + "]"), "item " + random);
        label.click();
    }

    public void clickOnNextButton() {
        Log.info("click on next");
        next.click();
    }
}