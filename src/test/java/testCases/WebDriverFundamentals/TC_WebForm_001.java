package testCases.WebDriverFundamentals;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import steps.WebFormStep;
import testCases.BaseTest;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class TC_WebForm_001 extends BaseTest {
    @Test
    public void testWebForm(){
        WebFormStep webFormStep = new WebFormStep(getDriver());
        Faker faker = new Faker();

        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        // Send text to all inputs
        webFormStep.typeTextInput(faker.dragonBall().character());
        webFormStep.typePwdInput(faker.pokemon().name());
        webFormStep.typeTextAreaInput(faker.harryPotter().spell());

        // Verify readonly input and disable input
        assertFalse(webFormStep.isDisableInput(), "Is Available");
        assertEquals(webFormStep.isReadonlyInput(), "Readonly input", "Is not possible to read");

        // Verify selected element in dropdown with "select"
        assertEquals(webFormStep.dropDownFirstSelected("Three"), "Three", "Is not the element selected");

        // Compare current list of elements in select dropdown with list expected
        List<String> actualDropDownValues = Arrays.asList("Open this select menu", "One", "Two", "Three");
        assertEquals(actualDropDownValues, webFormStep.getAllOptionsDropDown(), "List of values is not equal to expected");

        // Verify selected element in dropdown with "data list"
        assertEquals(webFormStep.dropDownDataListSelectOptionValue("Los Angeles"), "Los Angeles", "Is not element selected");


    }
}
