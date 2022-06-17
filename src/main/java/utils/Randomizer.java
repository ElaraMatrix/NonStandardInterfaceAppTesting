package utils;

import aquality.selenium.core.utilities.JsonSettingsFile;
import logger.Log;

import java.util.Random;

public final class Randomizer {

    private Randomizer() {}

    public static String getRandomEmailName() {
        Log.info("get random email name");
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int emailLength = (int) new JsonSettingsFile("testconfig.json").getValue("/email_length");
        for (int i = 0; i < emailLength; i++) {
            char tmp = (char) ('a' + random.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static String getRandomEmailDomain() {
        Log.info("get random email domain");
        String[] domains = new String[] {"gmail", "yahoo", "yandex", "mail", "tut"};
        return domains[(int) (Math.random() * domains.length)];
    }

    public static String getRandomPassword(String email) {
        Log.info("get random password from email: " + email);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int passwordLength = (int) new JsonSettingsFile("testconfig.json").getValue("/email_length");

        sb.append((int) (Math.random() * 10));
        sb.append((char) ('а' + random.nextInt('я' - 'а')));
        sb.append(email.charAt((int) (Math.random() * email.length())));

        for (int i = 0; i < passwordLength; i++) {
            char tmp = (char) ('a' + random.nextInt('z' - 'a'));
            if (i == 0) {
                sb.append(String.valueOf(tmp).toUpperCase());
            } else {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }

    public static int getRandomInt(int from, int toIncl) {
        return (int) (Math.random() * (toIncl - from + 1)) + from;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.print(getRandomInt(5, 10) + " ");
        }
    }
}