package tests;

import org.ibs.basetestsclass.BaseTest;
import org.junit.jupiter.api.Test;

public class TestAdd extends BaseTest {

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void startTest() {
        // проверки на стартовой страницы
        app.getHomePage()
                .clickButtonSandBox()
                .clickButtonProduct();
        sleep();

        //проверки на стриницы товара
        app.getFoodPage()
                .checkOpenFoodPage()
                .checkBtnAdd()
                .clickBtnAdd()
                .addingProduct("Манго","Фрукт", true)
                //.addingProduct("Картошка","Овощ",false)
                .clickButtonSave()
                .checkAddRow(5)
                .checkAdd("Манго","Фрукт", true)
                //.checkAdd("Картошка","Овощ",false)
        ;
        sleep();

        // проверке на стартовой(товара) странице
        app.getHomePage()
                .clickButtonSandBox()
                .clickButtonReset();
        sleep();
    }

}
