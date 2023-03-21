package actions;

import org.openqa.selenium.support.Color;

import java.util.List;

import static org.testng.Assert.*;

public class AssertActions {
    public void verifyEquals(String actual, String expected, String description){
        assertEquals(actual, expected, description);
    }

    public void verifyEquals(List<String> actual, List<String> expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyEquals(Color actual, Color expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyNotEquals(String actual, String expected, String description){
        assertNotEquals(actual, expected, description);
    }

    public void verifyFalse(Boolean actual, String description){
        assertFalse(actual, description);
    }

    public void verifyTrue(Boolean actual, String description){
        assertTrue(actual, description);
    }
}
