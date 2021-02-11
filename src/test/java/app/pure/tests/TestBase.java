package app.pure.tests;

import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import static app.pure.helpers.DriverHelper.configureDriver;


@ExtendWith({AllureJunit5.class})
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        configureDriver();
    }



}
