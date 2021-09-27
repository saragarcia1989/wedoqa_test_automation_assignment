package demoqa;

import base.SetGoogleWebSite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.demoqa.DemoqaPage;
import pages.demoqa.DroppablePage;
import pages.demoqa.ToolTipsPage;
import pages.google.GoogleResultsPage;

public class DemoqaTest extends SetGoogleWebSite {

    @Test
    public void firstTest() {

//        Go to Google
        setUpGoogle();

//        Search for demoqa.com
        GoogleResultsPage googleResultsPage = googlePage.searchInGoogle("demoqa.com");

//        Click the first result
        DemoqaPage demoqaPage = googleResultsPage.goToDemoqa();

//        Assertion to check we are in the right website
        Assertions.assertEquals("https://demoqa.com/", demoqaPage.getUrl(), "This website is not https://demoqa.com/");

//        Go to Interactions section
        demoqaPage.clickInteractions();

//        Go to Droppable page
        DroppablePage droppablePage = demoqaPage.clickDroppable();

//        Pick and drop "Drag Me" box into "Drop Here" box
        droppablePage.pickAndDropDragMeBox();

//        Assertion to check we get the right message
        Assertions.assertEquals("Dropped!", droppablePage.getTexFromDropHereBox(), "Text from 'Drop here' box is not 'Dropped!'");

        System.out.println("----- Text from 'Drop here' box is: " + droppablePage.getTexFromDropHereBox() + " -----");

//        Take screenshot
        takeScreenshot();

//        Click Widgets section
        droppablePage.clickWidgets();

//        Go to ToolTips page
        ToolTipsPage toolTipsPage = droppablePage.clickToolTips();

//        Move cursor to the "Hover me to see" button
        toolTipsPage.moveToHoverMeToSeeButton();

//        Print out text from pop-up tooltip
        System.out.println(toolTipsPage.getToolTipText());

    }
}
