package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import logger.Log;
import org.openqa.selenium.By;
import utils.Randomizer;
import utils.RobotUtils;
import java.util.ArrayList;

public class AvatarInterestsForm extends Form {

    private final ICheckBox unselectAll = AqualityServices.getElementFactory()
            .getCheckBox(By.xpath("//label[@for='interest_unselectall']//span[@class='checkbox__box']"), "unselectAll");
    private final IButton upload = AqualityServices.getElementFactory()
            .getButton(By.xpath("//a[contains(@class, 'upload-button')]"), "upload");
    private final IButton next = AqualityServices.getElementFactory()
            .getButton(By.xpath("//button[contains(text(), 'Next')]"), "next");
    private final ILabel avatar = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'avatar-image')]"), "avatar");

    private final String interestsLoc = "//label[contains(@for, 'interest')]";
    private final String interestsNamesLoc = "//span[contains(@class, 'checkbox small')]/following-sibling::span";

    public AvatarInterestsForm() {
        super(By.xpath("//label[@for='interest_unselectall']"), "Avatar&InterestsForm");
    }

    public void clickOnUnselectAllCheckbox() {
        Log.info("click on unselectAll checkbox");
        unselectAll.click();
    }

    public void clickOnNext() {
        Log.info("click on next");
        next.click();
    }

    public void checkNRandomInterests(int interestsNumber) {
        Log.info("check " + interestsNumber + " random interests");
        ArrayList<Integer> indexes = new ArrayList<>();
        while (indexes.size() < interestsNumber) {
            int randomIndex = Randomizer.getRandomInt(1, 20);
            String interestName = AqualityServices.getElementFactory()
                    .getCheckBox(By.xpath("(" + interestsNamesLoc + ")[" + randomIndex + "]"), "interestName").getText();
            if (!indexes.contains(randomIndex) && !interestName.equals("Select all")) {
                indexes.add(randomIndex);
                AqualityServices.getElementFactory()
                        .getCheckBox(By.xpath("(" + interestsLoc + ")[" + randomIndex + "]"), "interest").click();
            }
        }
    }

    public void uploadImage() {
        Log.info("image uploading");
        upload.click();
        RobotUtils.avatarUpload();
        avatar.state().waitForDisplayed();
    }
}