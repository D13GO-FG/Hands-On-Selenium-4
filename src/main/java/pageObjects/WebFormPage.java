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

    @FindBy(how = How.NAME, using = "my-file")
    private WebElement fileInput;

    @FindBy(how = How.CSS, using = "[type=checkbox]:checked")
    private WebElement checkbox_1;

    @FindBy(how = How.CSS, using = "[type=checkbox]:not(:checked)")
    private WebElement checkbox_2;

    @FindBy(how = How.XPATH, using = "//*[@type='radio' and @checked]")
    private WebElement radio_1;

    @FindBy(how = How.XPATH, using = "//*[@type='radio' and not(@checked)]")
    private WebElement radio_2;

    @FindBy(how = How.NAME, using = "my-colors")
    private WebElement colorPicker;

    @FindBy(how = How.NAME, using = "my-date")
    private WebElement datePicker;

    @FindBy(how = How.NAME, using = "my-range")
    private WebElement rangeSlider;

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Submit']")
    private WebElement btnSubmit;

    @FindBy(how = How.CLASS_NAME, using = "lead")
    private WebElement successMsg;

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

    public WebElement getFileInput() {
        return fileInput;
    }

    public WebElement getCheckbox_1() {
        return checkbox_1;
    }

    public WebElement getCheckbox_2() {
        return checkbox_2;
    }

    public WebElement getRadio_1() {
        return radio_1;
    }

    public WebElement getRadio_2() {
        return radio_2;
    }

    public WebElement getColorPicker() {
        return colorPicker;
    }

    public WebElement getDatePicker() {
        return datePicker;
    }

    public WebElement getRangeSlider() {
        return rangeSlider;
    }

    public WebElement getBtnSubmit() {
        return btnSubmit;
    }

    public WebElement getSuccessMsg() {
        return successMsg;
    }
}
