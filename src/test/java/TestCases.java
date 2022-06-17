import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.JsonSettingsFile;
import forms.WelcomePage;
import forms.game.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Randomizer;

public class TestCases extends BaseTest {

    private static final String defaultURL = new JsonSettingsFile("settings.json").getValue("/default_url").toString();

    private WelcomePage welcomePage;
    private RegistrationPage registrationPage;

    private final int emailPasswordFromNumber = 1;
    private final int avatarInterestsFormNumber = 2;
    private final int thirdFormNumber = 3;

    @Test
    public void testCase1() {
        welcomePage = new WelcomePage();
        registrationPage = new RegistrationPage();

        AqualityServices.getBrowser().goTo(defaultURL);
        Assert.assertTrue(welcomePage.state().waitForDisplayed(), "welcome page hasn't been loaded");

        welcomePage.clickToStart();
        registrationPage.state().waitForDisplayed();
        Assert.assertTrue(registrationPage.isNumberCard(emailPasswordFromNumber), "card 1 hasn't been loaded");

        String email = Randomizer.getRandomEmailName();
        String domain = Randomizer.getRandomEmailDomain();
        String password = Randomizer.getRandomPassword(email);
        registrationPage.getCard1().enterPassword(password);
        registrationPage.getCard1().enterEmail(email);
        registrationPage.getCard1().enterDomain(domain);
        registrationPage.getCard1().clickRandomDropdownItem();
        registrationPage.getCard1().clickOnAcceptCheckbox();
        registrationPage.getCard1().clickOnNextButton();
        Assert.assertTrue(registrationPage.isNumberCard(avatarInterestsFormNumber), "card 2 hasn't been loaded");

        registrationPage.getCard2().clickOnUnselectAllCheckbox();
        registrationPage.getCard2().checkNRandomInterests((int) new JsonSettingsFile("testconfig.json").getValue("/interests_number_checked"));
        registrationPage.getCard2().uploadImage();
        registrationPage.getCard2().clickOnNext();
        Assert.assertTrue(registrationPage.isNumberCard(thirdFormNumber), "card 3 hasn't been loaded");
    }

    @Test
    public void testCase2() {
        welcomePage = new WelcomePage();
        registrationPage = new RegistrationPage();

        AqualityServices.getBrowser().goTo(defaultURL);
        Assert.assertTrue(welcomePage.state().waitForDisplayed(), "welcome page hasn't been loaded");

        welcomePage.clickToStart();
        registrationPage.state().waitForDisplayed();

        registrationPage.getHelpForm().clickToHideHelp();
        Assert.assertTrue(registrationPage.getHelpForm().isHelpFormHidden(), "help form hasn't been hidden");
    }

    @Test
    public void testCase3() {
        welcomePage = new WelcomePage();
        registrationPage = new RegistrationPage();

        AqualityServices.getBrowser().goTo(defaultURL);
        Assert.assertTrue(welcomePage.state().waitForDisplayed(), "welcome page hasn't been loaded");

        welcomePage.clickToStart();
        registrationPage.state().waitForDisplayed();

        registrationPage.getCookiesForm().clickToAcceptCookies();
        Assert.assertTrue(registrationPage.getCookiesForm().isCookiesFormClosed(), "cookies form hasn't been closed");
    }

    @Test
    public void testCase4() {
        welcomePage = new WelcomePage();
        registrationPage = new RegistrationPage();

        AqualityServices.getBrowser().goTo(defaultURL);
        Assert.assertTrue(welcomePage.state().waitForDisplayed(), "welcome page hasn't been loaded");

        welcomePage.clickToStart();
        registrationPage.state().waitForDisplayed();

        Assert.assertEquals(registrationPage.getTimerText(), "00:00:00", "timer is not null when page is loaded");
    }
}