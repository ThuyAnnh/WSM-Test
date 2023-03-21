package WSM_Women_Mode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WomenMode {
    private WebDriver webDriver;
    private int i;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://edev.sun-asterisk.vn/en/dashboard/users/4384/request_leaves/new");
//        webDriver.get("https://edev.sun-asterisk.vn/en/dashboard/users/227/request_leaves");

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='wsm-btn btn-login']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_email']"))).sendKeys("thuy.test@framgia.com.edev.test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_password']"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wsm-login-button']"))).click();

    }

    @Test
    public void TC01() throws InterruptedException {
        webDriver.get("https://edev.sun-asterisk.vn/en/dashboard/users/4384/request_leaves/new");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='wsm-btn btn-login']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_email']"))).sendKeys("thuy.test@framgia.com.edev.test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user_password']"))).sendKeys("123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wsm-login-button']"))).click();
//        WebElement tiltle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='panel-title text-center']")));
//        String tiltle1 = tiltle.getText();
//        Assert.assertEquals(tiltle1, "Create new other request");
    }

    @Test
    public void TC02() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement tiltle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='panel-title text-center']")));
        String tiltle1 = tiltle.getText();
        Assert.assertEquals(tiltle1, "Create new other request");

        WebElement staffName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='request_leave_Staff name']")));
        String staffName1 = staffName.getText();
        Assert.assertEquals(staffName1, "Staff name");

        WebElement staffCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='request_leave_Staff Code']")));
        String staffCode1 = staffCode.getText();
        Assert.assertEquals(staffCode1, "Staff code");

        WebElement branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='request_leave_workspace_id']")));
        String branch1 = branch.getText();
        Assert.assertEquals(branch1, "Branch");

        WebElement group = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='request_leave_group_id']")));
        String group1 = group.getText();
        Assert.assertEquals(group1, "Group");

        WebElement leaveType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='request_leave_leave_type_id']")));
        String leaveType1 = leaveType.getText();
        Assert.assertEquals(leaveType1, "Leave type");
        Select leaveTypeWomenMode = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_leave_type_id']"))));
        leaveTypeWomenMode.selectByValue("90");

        WebElement requestDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='request_leave_request_date']")));
        String requestDate1 = requestDate.getText();
        Assert.assertEquals(requestDate1, "Request date");

        WebElement actualMinutes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='swap_minutes']")));
        String actualMinutes1 = actualMinutes.getText();
        Assert.assertEquals(actualMinutes1, "Actual number of minutes to convert");

        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='submit' and @value='Save']")));
        String save1 = save.getAttribute("value");
        Assert.assertEquals(save1, "Save");
    }

    @Test
    public void TC03() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement employeeName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='employee_name']")));
        String employeeName1 = employeeName.getAttribute("value");
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
        WebElement branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-group-selection-container']")));
        String branch1 = branch.getText();

        webDriver.get("https://edev.sun-asterisk.vn/en/dashboard/users/5174");
        WebElement branch2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-original-title='Default group']")));
        String branch3 = branch2.getText();
        Assert.assertEquals(branch3, branch1);
    }

    @Test
    public void TC06() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-group-selection-container']")));
        String branch1 = branch.getText();
        System.out.println(branch1);

        webDriver.get("https://edev.sun-asterisk.vn/en/dashboard/users/5174");
        WebElement branch2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-original-title='Default group']//a")));
        String branch3 = branch2.getText();
        System.out.println(branch3);
        Assert.assertEquals(branch3, branch1);
    }

    @Test
    public void TC07() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        Select a = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='group-selection']"))));
        a.selectByVisibleText("SUN*/Creative & Engineering Unit Vietnam 01");
        String b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-group-selection-container']"))).getText();
        System.out.println(b);
    }

    @Test
    public void TC08() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        Select a = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_leave_type_id']"))));
        a.selectByValue("90");
        WebElement selectDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_request_date']")));
        selectDate.sendKeys("2023/03/15");
        String b = selectDate.getAttribute("value");
        System.out.println(b);
    }

    @Test
    public void TC09() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        Select a = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_leave_type_id']"))));
        a.selectByValue("90");
        WebElement selectDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_request_date']")));
        selectDate.sendKeys("2023/03/15");
        String b = selectDate.getAttribute("value");
//        System.out.println(b);
        WebElement swap = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='swap_minutes']")));
        swap.sendKeys("160");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='swap_type_swap_woman']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-disable-with='Save']"))).click();
        String c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='alert alert-danger']"))).getText();
        String d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='text-danger']"))).getText();
        Assert.assertEquals("The form contains 1 error", c);
        Assert.assertEquals("Exceeded the maximum time limit for making a form. Up to 2.5 hours", d);
    }

    @Test
    public void TC10() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        Select a = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='request_leave_leave_type_id']"))));
        a.selectByValue("90");
        selectDay(1, 2, 2023);
        WebElement swap = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='swap_minutes']")));
        swap.click();
        swap.sendKeys("5");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='swap_type_swap_woman']"))).click();
//        WebElement buttonSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-disable-with='Save']")));
//        buttonSave.click();
    }

    @Test
    public void TC13() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        Select status = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='q_status_eq']"))));
        status.selectByValue("1"); // 0:Pending; 1:Approved; 2:Rejected; 3:Forwarded; 4:Canceled
        Select workspace = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='q_workspace_id_eq']"))));
        workspace.selectByVisibleText("Hanoi Office");
        selectMonth(3, 2020);
        WebElement buttonSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn btn-primary pull-right' and @type='submit']")));
        buttonSearch.click();
    }

    @Test
    public void TC14() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement buttonApplication = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Application']")));
        buttonApplication.click();
        WebElement buttonAsset = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-user-tool-id='61447']")));
        buttonAsset.click();

        Set<String> windowshandles = webDriver.getWindowHandles();//chứa tất cả windowHandles
        List<String> listwindows = new ArrayList<>(windowshandles);// convert từ set thành list
        String currentwd = webDriver.getWindowHandle();
        System.out.println(currentwd);
        String otherwd = null;
        for (String CDwindow : listwindows) {
            if (!CDwindow.equals(currentwd)) {
                otherwd = CDwindow;
            }
        }
//        System.out.println("otherwd" + otherwd);
        webDriver.switchTo().window(otherwd);
        webDriver.get("https://gas:123456*0@stg-dms.sun-asterisk.vn/");
        WebElement buttonSignInViaWSM = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/auth/framgia']")));
        buttonSignInViaWSM.click();
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='toast-message']")));
        String message = toastMessage.getText();
        System.out.println(message);
        Assert.assertEquals(message,"Sign in with framgia successfully");


    }

    private List<Profile> tableInformationUser() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='#' and @class='dropdown-toggle avatar-circle no-background']"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/en/dashboard/users/4384']"))).click();
        webDriver.get("https://edev.sun-asterisk.vn/en/dashboard/users/5174");
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

    public void selectMonth(int month, int year) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement monthPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month")));
        monthPicker.click();
        int currentYear = Year.now().getValue(), i;
        if (year == currentYear) {
            WebElement monthKeyWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table-condensed']//td//span[" + month + "]")));
            monthKeyWord.click();
        } else if (year <= currentYear) {
            for (i = 0; i < currentYear - year; i++) {
                WebElement previousYearIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table-condensed']//th[1]")));
                previousYearIcon.click();
            }
            WebElement monthKeyWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table-condensed']//td//span[" + month + "]")));
            monthKeyWord.click();
        } else {
            for (i = 0; i < year - currentYear; i++) {
                WebElement nextYearIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table-condensed']//th[3]")));
                nextYearIcon.click();
            }
            WebElement monthKeyWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table-condensed']//td//span[" + month + "]")));
            monthKeyWord.click();
        }
    }

    public void selectDay(int day, int month, int year) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        WebElement monthPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("request_leave_request_date")));
        monthPicker.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='datepicker-days']//*[@class='datepicker-switch']"))).click();

        int currentYear = Year.now().getValue(), i;
        if (year == currentYear) {
            WebElement monthKeyWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='datepicker-months']//span[" + month + "]")));
            monthKeyWord.click();
        } else if (year <= currentYear) {
            for (i = 0; i < currentYear - year; i++) {
                WebElement previousYearIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table-condensed']//*[@class='prev']")));
                previousYearIcon.click();
            }
            WebElement monthKeyWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='datepicker-months']//td//span[" + month + "]")));
            monthKeyWord.click();
        } else {
            for (i = 0; i < year - currentYear; i++) {
                WebElement nextYearIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table-condensed']//*[@class='next']")));
                nextYearIcon.click();
            }
            WebElement monthKeyWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='datepicker-months']//td//span[" + month + "]")));
            monthKeyWord.click();
        }
        List<WebElement> list;
        list = webDriver.findElements(By.xpath("//*[@class='datepicker-days']//td[@class='day']"));
        for (WebElement d : list) {
            System.out.println(d.getText());
            String s = String.valueOf(day);
            if (d.getText().equals(s)) {
                d.click();
                return;
            }
        }
    }

//    @After
//    public void tearDown() {
//        webDriver.close();
//        webDriver.quit();
//    }
}