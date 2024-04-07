package org.ibs.basetestsclass;

import org.ibs.managers.DriverManager;
import org.ibs.managers.PageManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

public class BaseTest {

    static String homePageURL = "http://localhost:8080/";
    static String foodPageURL = "http://localhost:8080/food";


    /**
     * Менеджер страничек
     * @see PageManager#getPageManager()
     */
    protected PageManager app = PageManager.getPageManager();

    /**
     * Менеджер WebDriver
     * @see DriverManager#getDriverManager()
     */
    private static final DriverManager driverManager = DriverManager.getDriverManager();


    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(homePageURL);
        driverManager.getDriver().manage().window().maximize(); // обязательно делаем максимальное окно
        // не явные ожидания
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void quitDriver() {driverManager.quitDriver();}
}
