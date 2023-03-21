package testCases.WebDriverFundamentals;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;
import steps.WebFormStep;
import testCases.BaseTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_WebForm_001 extends BaseTest {
    @Test
    public void testWebForm() throws IOException {
        WebFormStep webFormStep = new WebFormStep(getDriver());
        Faker faker = new Faker();

        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        // Send text to all inputs
        webFormStep.typeTextInput(faker.dragonBall().character());
        webFormStep.typePwdInput(faker.pokemon().name());
        webFormStep.typeTextAreaInput(faker.harryPotter().spell());

        // Verify readonly input and disable input
        assertActions.verifyFalse(webFormStep.isDisableInput(), "Is Available");
        assertActions.verifyEquals(webFormStep.isReadonlyInput(), "Readonly input", "Is not possible to read");

        // Verify selected element in dropdown with "select"
        assertActions.verifyEquals(webFormStep.dropDownFirstSelected("Three"), "Three", "Is not the element selected");

        // Compare current list of elements in select dropdown with list expected
        List<String> actualDropDownValues = Arrays.asList("Open this select menu", "One", "Two", "Three");
        assertActions.verifyEquals(actualDropDownValues, webFormStep.getAllOptionsDropDown(), "List of values is not equal to expected");

        // Verify selected element in dropdown with "data list"
        assertActions.verifyEquals(webFormStep.dropDownDataListSelectOptionValue("Los Angeles"), "Los Angeles", "Is not element selected");

        // Choose file in file input
        webFormStep.setFileInput();

        // Verify if checkbox 1 is checked
        assertActions.verifyEquals(webFormStep.getAttributeCheckbox1("id"), "my-check-1", "This is not Checkbox 1 which is supposed to be checked");
        assertActions.verifyTrue(webFormStep.isCheckbox1Selected(), "Is not selected");

        // Verify if checkbox 2 is not checked
        assertActions.verifyEquals(webFormStep.getAttributeCheckbox2("id"), "my-check-2", "This is not Checkbox 2 which is not supposed to be checked");
        assertActions.verifyFalse(webFormStep.isCheckbox2Selected(), "Is selected");

        // Verify if radio 1 is checked
        assertActions.verifyEquals(webFormStep.getAttributeRadio1("id"), "my-radio-1", "This is not Radio 1 which is supposed to be checked");
        assertActions.verifyTrue(webFormStep.isRadio1Selected(), "Is not selected");

        // Verify if radio 2 is not checked
        assertActions.verifyEquals(webFormStep.getAttributeRadio2("id"), "my-radio-2", "This is not Radio 2 which is not supposed to be checked");
        assertActions.verifyFalse(webFormStep.isRadio2Selected(), "Is selected");

        // Verify that new color is different that init color in color picker
        String initColor = webFormStep.getColor();
        Color red = webFormStep.selectColorJS();
        String finalColor = webFormStep.getColor();
        assertActions.verifyNotEquals(finalColor, initColor, "New color is equals to init one");
        assertActions.verifyEquals(Color.fromString(finalColor), red, "Final color is not equals to red");

        // Verify date picker
        webFormStep.selectDate();
        String oneYearBack = webFormStep.oneYearBack();
        String expectedDate = webFormStep.expectedDate();
        assertActions.verifyEquals(oneYearBack, expectedDate, "Date is not correct");

        // Verify moving of slicer and its value
        String initValue = webFormStep.getValueSlider();
        webFormStep.moveSlider();
        String endValue = webFormStep.getValueSlider();
        assertActions.verifyNotEquals(endValue, initValue, "Value is the same, doesn't change value");

        // Verify Submit button
        webFormStep.clickSubmit();

        // Verify final message
        assertActions.verifyEquals(webFormStep.successfulMsg(), "Received!", "Wrong message");
    }
}
