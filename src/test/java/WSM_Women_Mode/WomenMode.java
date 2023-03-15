package WSM_Women_Mode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WomenMode {
    private WebDriver webDriver;
    private int i;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://edev.sun-asterisk.vn/en/dashboard/users/4384/request_leaves/new");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='wsm-btn btn-login']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_email']"))).sendKeys("nguyen.thi.my.hanh@framgia.com.edev.test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_password']"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wsm-login-button']"))).click();

    }

    @Test
    public void TC01() throws InterruptedException {
        webDriver.get("https://edev.sun-asterisk.vn/en/dashboard/users/4384/request_leaves/new");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='wsm-btn btn-login']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_email']"))).sendKeys("nguyen.thi.my.hanh@framgia.com.edev.test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_password']"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wsm-login-button']"))).click();
        WebElement tiltle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='panel-title text-center']")));
        String tiltle1 = tiltle.getText();
        Assert.assertEquals(tiltle1, "Create new other request");
    }

    @Test
    public void TC02() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement tiltle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='panel-title text-center']")));
        String tiltle1 = tiltle.getText();
        Assert.assertEquals(tiltle1, "Create new other request");

        WebElement staffName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='employee_name']")));
        String staffName1 = staffName.getText();
        Assert.assertEquals(staffName1, "Staff name");

        WebElement staffCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='employee_code']")));
        String staffCodee1 = staffName.getText();
        Assert.assertEquals(staffName1, "Staff code");

        WebElement branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-workspace-selection-container']")));
        String branch1 = staffName.getText();
        Assert.assertEquals(staffName1, "Branch");

        WebElement group = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-group-selection-container']")));
        String group1 = staffName.getText();
        Assert.assertEquals(staffName1, "Group");

        WebElement leaveType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_leave_type_id']")));
        String leaveType1 = staffName.getText();
        Assert.assertEquals(staffName1, "Leave Type");

        WebElement requestDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_request_date']")));
        String requestDate1 = staffName.getText();
        Assert.assertEquals(staffName1, "Request Date");

        WebElement womenMode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=-swap_type_swap_woman']")));
        String womenMode1 = staffName.getText();
        Assert.assertEquals(staffName1, "Women's mode");

        WebElement annualLeave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='swap_type_swap_paid']")));
        String annualLeave1 = staffName.getText();
        Assert.assertEquals(staffName1, "Annual leave");

        WebElement unpaidLeave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='swap_type_swap_unpaid']")));
        String unpaidLeave1 = staffName.getText();
        Assert.assertEquals(staffName1, "Unpaid leave");

        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='submit' and @value='Save']")));
        String save1 = staffName.getText();
        Assert.assertEquals(staffName1, "Save");

    }

    @Test
    public void TC03() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement employeeName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='employee_name']")));
        String employeeName1 = employeeName.getAttribute("value");
//        System.out.println(employeeName1);
        List<Profile> list2 = new ArrayList<>();
        list2 = tableInformationUser();
        String employeeName2 = list2.get(0).getInfor();
        Assert.assertEquals(employeeName2, employeeName1);
    }

    @Test
    public void TC04() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement employeeCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='employee_code']")));
        String employeeCode1 = employeeCode.getAttribute("value");
        System.out.println(employeeCode1);
        List<Profile> list2 = new ArrayList<>();
        list2 = tableInformationUser();
        System.out.println(tableInformationUser());
        String employeeCode2 = list2.get(5).getInfor();
        Assert.assertEquals(employeeCode2, employeeCode1);
    }

    @Test
    public void TC05() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-workspace-selection-container']")));
        String branch1 = branch.getText();
        System.out.println(branch1);
        List<Profile> list2 = new ArrayList<>();
        list2 = tableInformationUser();
        System.out.println(tableInformationUser());
        String branch2 = list2.get(15).getInfor();
        Assert.assertEquals(branch2, branch1);
    }

    @Test
    public void TC06() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-group-selection-container']")));
        String branch1 = branch.getText();
        System.out.println(branch1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='#' and @class='dropdown-toggle avatar-circle no-background']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/en/dashboard/users/4384']"))).click();
        WebElement branch2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-original-title='Default group']//a")));
        String branch3 = branch2.getText();
        System.out.println(branch3);
        Assert.assertEquals(branch3, branch1);
    }

    @Test
    public void TC07() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        Select a = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='group-selection']"))));
        a.selectByVisibleText("SUN*/Human Resources Unit Vietnam/Human Resources Strategy");
//        a.selectByVisibleText("SUN*/Vietnam Education Unit/Education 2");
        String b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-group-selection-container']"))).getText();
        System.out.println(b);
//        List<WebElement> list1;
//        list1  = webDriver.findElements(By.xpath("//*[@id='group-selection']//option"));
//        checkValueInDropDownList(list1, b);
    }

    @Test
    public void TC08() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        Select a = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_leave_type_id']"))));
        a.selectByValue("90");
        WebElement selectDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_request_date']")));
        WebElement selectDate1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_request_date']")));
        selectDate1.click();
//        selectDate.sendKeys("2023/03/15");
        String b = selectDate.getAttribute("value");
        System.out.println(b);
//        String option = a.getFirstSelectedOption().getText();
//        System.out.println(option);

//        String b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_leave_type_id']"))).getText();
//        System.out.println(b);

    }

    private List<Profile> tableInformationUser() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='#' and @class='dropdown-toggle avatar-circle no-background']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/en/dashboard/users/4384']"))).click();
        List<WebElement> list;
        list = webDriver.findElements(By.xpath("//*[@class='table table-hover']//tr"));
        List<Profile> profile = new ArrayList<>();
        for (WebElement element : list) {
            List<WebElement> list1;
            list1 = element.findElements(By.xpath(".//td"));
//            System.out.println(list1);

            if (list1.size() == 2) {
                String nameInfor = list1.get(0).getText();
                String infor = list1.get(1).getText();

                Profile profile1 = new Profile(nameInfor, infor);
                profile.add(profile1);
            }
        }
        return profile;
    }

    private List<UserGroup> listGroup() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='#' and @class='dropdown-toggle avatar-circle no-background']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/en/dashboard/users/4384']"))).click();
        List<WebElement> list;
        list = webDriver.findElements(By.xpath("//*[@class='table table-hover']//tr//td//label//a"));
        List<UserGroup> group = new ArrayList<>();
//        group.add(list);
        for (WebElement element : list) {
            String a = element.getText();
            UserGroup group1 = new UserGroup(a);
            group.add(group1);
        }
        return group;
    }

    private void checkValueInDropDownList(List<WebElement> list2, String b) {
        int dem = 0;
        for (WebElement element : list2) {
            if (element.getText() == b) {
                dem++;
            }
        }
        if (dem >= 2) {
            System.out.println("Bi trung dl");
        } else {
            System.out.println("Chi duy nhat");
        }
    }

//    @After
//    public void tearDown() {
//        webDriver.close();
//        webDriver.quit();
//    }
}
