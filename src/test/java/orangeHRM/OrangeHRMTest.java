package orangeHRM;

import base.SetOrangeHRM;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.orangeHRM.CandidatesPage;
import pages.orangeHRM.OrangeHRMHomePage;

import java.util.concurrent.TimeUnit;

public class OrangeHRMTest extends SetOrangeHRM {

    @Test
    public void thirdTest() {

//        Go to https://orangehrm-demo-7x.orangehrmlive.com/
        setUpOrangeHRM();

//        Login the page
        OrangeHRMHomePage orangeHRMHomePage = OrangeHRMLogInPage.logIn();

//        Go to Recruitment page
        CandidatesPage candidatesPage = orangeHRMHomePage.clickOnRecruitment();

//        Get and print out the number of candidates
        int numberOfCandidates = candidatesPage.getNumberOfCandidates();
        int firstCandidatesNumber = candidatesPage.getNumberOfCandidates();
        System.out.println("----- Number of candidates is " + numberOfCandidates + " -----");

//        Click on the green Add button
        candidatesPage.clickAddButton();

//      Fill mandatory fields
        candidatesPage.addCandidate("QA", "Automation 27/09/2025", "automation@qa.com"
                , "C:\\Users\\sarag\\IdeaProjects\\test_automation_assignment\\resources\\resume.txt");

//      Assert if the number of candidates is increased by 1
        int secondCandidatesNumber = candidatesPage.getNumberOfCandidates();
        System.out.println("----- Number of candidates after add action is " + secondCandidatesNumber + " -----");
        Assertions.assertTrue(firstCandidatesNumber + 1 == secondCandidatesNumber, "Number of candidates is not increased by 1");

//        Select the freshly created candidate
        candidatesPage.selectCandidate(1);

//        Delete the candidate
        candidatesPage.deleteCandidate();

//        Assert to check if the number of candidates decreased by 1
        int thirdCandidatesNumber = candidatesPage.getNumberOfCandidates();
        System.out.println("----- Number of candidates after delete action is " + thirdCandidatesNumber + " -----");
        Assertions.assertTrue(secondCandidatesNumber - 1 == thirdCandidatesNumber);

//       Click logout
        candidatesPage.logOut();

    }

}
