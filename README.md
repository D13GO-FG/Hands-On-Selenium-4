# Hands On Selenium 4 with Java

This repository is for practice fundamentals in Selenium 4.


### Test case: TC_WebForm_001
#### Description: Test to verify all elements requite to submit form.
#### Test scenario: Web form page: [Page tested](https://bonigarcia.dev/selenium-webdriver-java/web-form.html)
##### Test title: Web Form submit


| Steps                                                  | Expected result                | Actual result                              |
|--------------------------------------------------------|--------------------------------|--------------------------------------------|
| 1. Send inputs (text, password, text area).            | User type text in three inputs | User type it                               |
| 2. Check disable and readonly button.                  |                                | input disable and only read input          |
| 3. Verify dropdown by select and data list.            | Options NewYork , Chicago, LA  | Options are the same                       |
| 4. Check correct input of file.                        | User input file                | File correct                               |
| 5. Verify checkboxes if are selected or not.           |                                | One checkbox is checked and the other not  |
| 6. Verify radio if are selected or not.                |                                | One radio is checked and the other not     |
| 7. Change color picker and verify if color changed.    | User change colo default       | New color different to initial             |
| 8. Change date picker and verify if date is different. | User select new date           | date is the same less one year in the past |
| 9. Verify if change the slider multiple times.         | User move value                | value is changed                           |

