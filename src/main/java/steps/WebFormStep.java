package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.WebFormPage;

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
}
