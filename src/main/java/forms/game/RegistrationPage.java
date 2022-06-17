package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import logger.Log;
import org.openqa.selenium.By;

public class RegistrationPage extends Form {

    private final ILabel pageIndicator = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//div[@class='page-indicator']"), "pageIndicator");
    private final ILabel timer = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'timer')]"), "timer");

    private final EmailPasswordForm emailPasswordForm = new EmailPasswordForm();
    private final AvatarInterestsForm avatarInterestsForm = new AvatarInterestsForm();
    private final HelpForm helpForm = new HelpForm();
    private final CookiesForm cookiesForm = new CookiesForm();

    public RegistrationPage() {
        super(By.xpath("//div[contains(@class, 'game')]"), "RegistrationPage");
    }

    public EmailPasswordForm getCard1() {
        return emailPasswordForm;
    }

    public AvatarInterestsForm getCard2() {
        return avatarInterestsForm;
    }

    public HelpForm getHelpForm() {
        return helpForm;
    }

    public CookiesForm getCookiesForm() {
        return cookiesForm;
    }

    public boolean isNumberCard(int cardNumber) {
        Log.info("is number card checking. expected value: " + cardNumber);
        return Integer.parseInt(String.valueOf(pageIndicator.getText().charAt(0))) == cardNumber;
    }

    public String getTimerText() {
        Log.info("get timer value");
        timer.state().waitForExist();
        return timer.getText();
    }
}