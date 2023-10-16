import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Description;
import org.example.TestExample;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenSocks extends TestExample {

    @Test
    @Description("Авторизация на сайте")
    void authorization() {
        page.navigate("http://localhost/");
        page.locator("#login").click();
        page.locator("#username-modal").click();
        page.locator("#username-modal").fill("Nat");
        page.locator("#password-modal").click();
        page.locator("#password-modal").fill("123qwe");
        page.getByText("Log in").click();
        page.waitForLoadState();
        //нужна проверка, что авторизация выполнена
    }


    @Test
    @Description("Добавление товара в корзину и сравнение суммы товаров с total суммой")
    public void bySocks() {
        page.navigate("http://localhost/");
        page.locator("#tabCatalogue").click();
        page.locator(".buttons > a:nth-child(2)").first().click();
        page.locator("div:nth-child(2) > .product > .text > .buttons > a:nth-child(2)").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("2 item(s) in cart")).click();

        String text1 = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("$99.99")).nth(1).innerText();
        String text2 = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("$18.00")).nth(1).innerText();
        text1 = text1.replaceAll("\\D+", "");
        text2 = text2.replaceAll("\\D+", "");
        String total = page.locator("#cartTotal").innerText();
        total = total.replaceAll("\\D+", "");
        int оnePrice = Integer.parseInt(text1);
        int twoPrice = Integer.parseInt(text2);
        int totalPrice = Integer.parseInt(total);
        double one = оnePrice / 100.0;
        double two = twoPrice / 100.0;
        double totalSocks = totalPrice / 100.0;
        System.out.println(totalSocks + "=" + (one + two));
        assertEquals(totalSocks, (one + two));


    }
}
