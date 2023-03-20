package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WebFormPage extends BasePage{
    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "my-text-id")
    private WebElement textInput;

    @FindBy(how = How.NAME, using = "my-password")
    private WebElement pwdInput;

    @FindBy(how = How.NAME, using = "my-textarea")
    private WebElement textAreaInput;

    @FindBy(how = How.NAME, using = "my-disabled")
    private WebElement disabledInput;

    @FindBy(how = How.NAME, using = "my-readonly")
    private WebElement readonlyInput;

    @FindBy(how = How.NAME, using = "my-select")
    private WebElement dropdownSelect;

    @FindBy(how = How.NAME, using = "my-datalist")
    private WebElement dropdownDataList;

    @FindBy(how = How.XPATH, using = "//datalist/option[2]")
    private WebElement dataListValueNewYork;

    @FindBy(how = How.XPATH, using = "//datalist/option[4]")
    private WebElement dataListValueLA;

    public WebElement getTextInput() {
        return textInput;
    }

    public WebElement getPwdInput() {
        return pwdInput;
    }

    public WebElement getTextAreaInput() {
        return textAreaInput;
    }

    public WebElement getDisabledInput() {
        return disabledInput;
    }

    public WebElement getReadonlyInput() {
        return readonlyInput;
    }

    public WebElement getDropdownSelect() {
        return dropdownSelect;
    }

    public WebElement getDropdownDataList() {
        return dropdownDataList;
    }

    public WebElement getDataListValueNewYork() {
        return dataListValueNewYork;
    }

    public WebElement getDataListValueLA() {
        return dataListValueLA;
    }
}
