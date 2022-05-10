package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        SelenideElement from = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        from.$("[data-test-id=name] input.input__control").setValue("Семен Кузьмин");
        from.$("[data-test-id=phone] input.input__control").setValue("+79111133030");
        from.$("[data-test-id=agreement]").click();
        from.$(".button__content").click();
        $(withText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.")).shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));


    }
}
