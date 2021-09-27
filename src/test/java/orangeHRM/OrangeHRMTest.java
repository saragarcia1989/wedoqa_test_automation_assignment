package orangeHRM;

import base.SetOrangeHRM;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.orangeHRM.CandidatesPage;
import pages.orangeHRM.OrangeHRMHomePage;

public class OrangeHRMTest extends SetOrangeHRM {

    @Test
    public void thirdTest() {

//        Go to https://orangehrm-demo-7x.orangehrmlive.com/
        setUpOrangeHRM();

//        Login the page
        OrangeHRMHomePage orangeHRMHomePage = OrangeHRMLogInPage.logIn();

//        Go to Recruitment section and open left side panel
        orangeHRMHomePage.clickRecruitmentButton();

//        Click on candidates
        CandidatesPage candidatesPage = orangeHRMHomePage.clickCandidates();
        candidatesPage.switchToCandidatesFrame();

        int firstCandidatesNumber = candidatesPage.getNumberOfCandidates();

//        Print out the number of candidates
        System.out.println("----- Number of candidates is " + firstCandidatesNumber + " -----");

//        Click on the green Add button
        candidatesPage.clickAddButton();

//        Fill mandatory fields
        candidatesPage.addCandidate("QA", "Automation 27/09/2021", "automation@qa.com"
                , "C:\\Users\\sarag\\IdeaProjects\\test_automation_assignment\\resources\\resume.txt", 10);

        int secondCandidatesNumber = candidatesPage.getNumberOfCandidates();
        System.out.println("----- Number of candidates after add action is " + secondCandidatesNumber + " -----");

//        Assert if the number of candidates is increased by 1
        Assertions.assertTrue(firstCandidatesNumber + 1 == secondCandidatesNumber, "Number of candidates is not increased by 1");

//        Select the freshly created candidate
        candidatesPage.selectCandidate(0);

//        Click on the three dots in the left upper side of the table
        candidatesPage.openCandidateOptions();

//        Delete the candidate
        candidatesPage.deleteCandidate();

        int thirdCandidatesNumber = candidatesPage.getNumberOfCandidates();
        System.out.println("----- Number of candidates after delete action is " + thirdCandidatesNumber + " -----");

//        Assert to check if the number of candidates decreased by 1
        Assertions.assertTrue(secondCandidatesNumber - 1 == thirdCandidatesNumber);

//        Open the side menu
        candidatesPage.displaySideMenu();

//        Click logout
        candidatesPage.logOut();

    }

}
