import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotListener extends TestListenerAdapter {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        ScreenshotListener.driver = driver;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (driver != null) {
            captureScreenshot(result.getMethod().getMethodName());
        } else {
            System.out.println("WebDriver instance is null. Cannot capture screenshot.");
        }
    }

    private void captureScreenshot(String methodName) {
        String desktopDirPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator;
        createDirectoryIfNotExists(desktopDirPath);

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = getCurrentTimestamp();
        String screenshotPath = desktopDirPath + methodName + "_" + timestamp + ".png";
        try {
            Files.copy(screenshotFile.toPath(), Paths.get(screenshotPath));
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDirectoryIfNotExists(String directoryPath) {
        Path path = Paths.get(directoryPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return now.format(formatter);
    }
}