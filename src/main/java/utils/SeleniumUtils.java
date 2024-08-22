package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	private WebDriver driver;
	private WebDriverWait wait;

    public SeleniumUtils(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }
    
    public void logout(By logoutButtonLocator) {
        try {
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutButtonLocator));
            logoutButton.click();
            System.out.println("User has been logged out successfully.");
        } catch (Exception e) {
            System.out.println("Failed to log out: " + e.getMessage());
            takeScreenshot("logout_error.png"); // Take a screenshot if logout fails
            throw new RuntimeException("Logout failed.", e);
        }
    }
    
    private void takeScreenshot(String filePath) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destinationPath = Path.of(filePath);
            Files.copy(screenshot.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
    
    public void click(By locator) {
        try {
        	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (NoSuchElementException e) {
            takeScreenshot("screenshots/click_error.png");
            throw new RuntimeException("Element not found for locator: " + locator.toString(), e);
        } catch (ElementNotInteractableException e) {
            takeScreenshot("screenshots/click_error.png");
            throw new RuntimeException("Element not interactable for locator: " + locator.toString(), e);
        } catch (TimeoutException e) {
            takeScreenshot("screenshots/click_error.png");
            throw new RuntimeException("Timeout waiting for element to be clickable: " + locator.toString(), e);
        } catch (Exception e) {
            takeScreenshot("screenshots/click_error.png");
            throw new RuntimeException("Exception occurred while clicking on element: " + e.getMessage(), e);
        }
    }
    
    public void type(By locator, String text) {
        try {
        	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();  
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            takeScreenshot("screenshots/type_error.png");
            throw new RuntimeException("Element not found for locator: " + locator.toString(), e);
        } catch (TimeoutException e) {
            takeScreenshot("screenshots/type_error.png");
            throw new RuntimeException("Timeout waiting for element to be visible: " + locator.toString(), e);
        } catch (Exception e) {
            takeScreenshot("screenshots/type_error.png");
            throw new RuntimeException("Exception occurred while typing into element: " + e.getMessage(), e);
        }
    }
    
    public boolean isDisplayed(By locator) {
        try {
        	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            takeScreenshot("screenshots/display_error.png");
            throw new RuntimeException("Element not found for locator: " + locator.toString(), e);
        } catch (TimeoutException e) {
            takeScreenshot("screenshots/display_error.png");
            throw new RuntimeException("Timeout waiting for element to be visible: " + locator.toString(), e);
        } catch (Exception e) {
            takeScreenshot("screenshots/display_error.png");
            throw new RuntimeException("Exception occurred while checking if element is displayed: " + e.getMessage(), e);
        }
    }
    
    public String getText(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();
        } catch (NoSuchElementException e) {
            takeScreenshot("getText_error.png");
            throw new RuntimeException("Element not found for locator: " + locator.toString(), e);
        } catch (TimeoutException e) {
            takeScreenshot("getText_error.png");
            throw new RuntimeException("Timeout waiting for element to be visible: " + locator.toString(), e);
        } catch (Exception e) {
            takeScreenshot("getText_error.png");
            throw new RuntimeException("Exception occurred while getting text from element: " + e.getMessage(), e);
        }
    }
}
