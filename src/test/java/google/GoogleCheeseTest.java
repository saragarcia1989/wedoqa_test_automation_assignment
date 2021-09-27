package google;

import base.SetGoogleWebSite;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import pages.google.GoogleResultsPage;

public class GoogleCheeseTest extends SetGoogleWebSite {

    @Test
    public void secondTest() {

//        Go to google.com
        setUpGoogle();

//        Search for cheese
        GoogleResultsPage googleResultsPage = googlePage.searchInGoogle("cheese");

//        Assertion comparing the number of results to 777
        Assertions.assertEquals(777, googleResultsPage.getNumberOfResults(), "----- There is too much cheese on the internet -----");
    }
}
