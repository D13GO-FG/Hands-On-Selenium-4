package steps;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import pageObjects.WebFormPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WebFormStep extends BaseStep{
    WebFormPage webFormPage = PageFactory.initElements(getDriver(), WebFormPage.class);
    public WebFormStep(WebDriver driver) {
        super(driver);
    }

    public void typeTextInput(String text){
        type(webFormPage.getTextInput(), text);
    }

    public void typePwdInput(String pwd){
        type(webFormPage.getPwdInput(), pwd);
    }

    public void typeTextAreaInput(String textArea){
        type(webFormPage.getTextAreaInput(), textArea);
    }

    public Boolean isDisableInput(){
        return waitForDisplayed(webFormPage.getDisabledInput(), MED_WAIT).isEnabled();
    }


    public String isReadonlyInput() {
        return waitForDisplayed(webFormPage.getReadonlyInput(), MED_WAIT).getAttribute("value");
    }

    public void dropDownSelect(String value){
        Select select = new Select(webFormPage.getDropdownSelect());
        select.selectByVisibleText(value);
    }

    public List<String> getAllOptionsDropDown(){
        Select select = new Select(webFormPage.getDropdownSelect());
        List<String> listValues = new ArrayList<>();
        for (WebElement element: select.getOptions()) {
            listValues.add(element.getText());
        }
        return listValues;
    }

    public String dropDownFirstSelected(String value){
        dropDownSelect(value);
        Select select = new Select(webFormPage.getDropdownSelect());
        return select.getFirstSelectedOption().getText();
    }
    
    public String dropDownDataListSelectOptionValue(String value){
        WebElement dataList = webFormPage.getDropdownDataList();
        click(dataList);
        String option = switch (value) {
            case "New York" -> webFormPage.getDataListValueNewYork().getAttribute("value");
            case "Los Angeles" -> webFormPage.getDataListValueLA().getAttribute("value");
            default -> value;
        };
        type(dataList, option);
        return option;
    }

    public void setFileInput() throws IOException {
        Path tempFile = Files.createTempFile("tempfiles", ".tmp");
        String fileName = tempFile.toAbsolutePath().toString();
        webFormPage.getFileInput().sendKeys(fileName);
    }

    public String getAttributeCheckbox1(String attribute){
        return readAttribute(webFormPage.getCheckbox_1(), attribute);
    }

    public String getAttributeCheckbox2(String attribute){
        return readAttribute(webFormPage.getCheckbox_2(), attribute);
    }

    public Boolean isCheckbox1Selected(){
        return webFormPage.getCheckbox_1().isSelected();
    }

    public Boolean isCheckbox2Selected(){
        return webFormPage.getCheckbox_2().isSelected();
    }

    public String getAttributeRadio1(String attribute){
        return readAttribute(webFormPage.getRadio_1(), attribute);
    }

    public String getAttributeRadio2(String attribute){
        return readAttribute(webFormPage.getRadio_2(), attribute);
    }

    public Boolean isRadio1Selected(){
        return webFormPage.getRadio_1().isSelected();
    }

    public Boolean isRadio2Selected(){
        return webFormPage.getRadio_2().isSelected();
    }

    public String getColor() {
        return readAttribute(webFormPage.getColorPicker(), "value");
    }

    public Color selectColorJS(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Color red = new Color(255, 0, 0, 1);
        String script = String.format("arguments[0].setAttribute('value', '%s');", red.asHex());
        js.executeScript(script, webFormPage.getColorPicker());
        return red;
    }

    private LocalDate today;

    public void selectDate(){
        // Get the current date from the system clock
        today = LocalDate.now();
        int currentYear = today.getYear();
        int currentDay = today.getDayOfMonth();

        // Click on the date picker to open the calendar
        click(webFormPage.getDatePicker());

        // Click on the current month by searching by text
        WebElement monthElement = getDriver().findElement(By.xpath(String.format(
                "//th[contains(text(),'%d')]", currentYear)));
        click(monthElement);

        // Click on the left arrow using relative locators
        WebElement arrowLeft = getDriver().findElement(RelativeLocator
                .with(By.tagName("th")).toRightOf(monthElement));
        click(arrowLeft);

        // Click on the current month of that year
        WebElement monthPastYear = getDriver().findElement(RelativeLocator
                .with(By.cssSelector("span[class$=focused]")).below(arrowLeft));
        click(monthPastYear);

        // Click on the present day in that month
        WebElement dayElement = getDriver().findElement(By.xpath(String.format(
                "//td[@class='day' and contains(text(),'%d')]", currentDay)));
        click(dayElement);
    }

    public String oneYearBack(){
        // Get the final date on the input text
        return readAttribute(webFormPage.getDatePicker(), "value");
    }

    public String expectedDate(){
        // Assert that the expected date is equal to the one selected in the
        // date picker

        //LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minusYears(1);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return previousYear.format(dateFormat);
    }

    public String getValueSlider(){
        return readAttribute(webFormPage.getRangeSlider(), "value");
    }

    public void moveSlider(){
        for (int i = 0; i < 5; i++) {
            webFormPage.getRangeSlider().sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void clickSubmit(){
        click(webFormPage.getBtnSubmit());
    }

    public String successfulMsg(){
        return readText(webFormPage.getSuccessMsg());
    }
}
