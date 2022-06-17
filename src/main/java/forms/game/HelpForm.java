package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import logger.Log;
import org.openqa.selenium.By;

public class HelpForm extends Form {

    private final IButton hide = AqualityServices.getElementFactory()
            .getButton(By.xpath("//button[contains(@class, 'help-form__send')]"), "hide");
    private final ILabel helpContainer = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//div[contains(@class,'help-form')]"), "helpContainer");

    public HelpForm() {
        super(By.xpath("//h2[@class='help-form__title']"), "HelpForm");
    }

    public void clickToHideHelp() {
        Log.info("click to hide help form");
        hide.click();
    }

    public boolean isHelpFormHidden() {
        Log.info("is help form hidden checking");
        return AqualityServices.getConditionalWait().waitFor(() -> helpContainer.getCssValue("height").equals("10px"));
    }
}