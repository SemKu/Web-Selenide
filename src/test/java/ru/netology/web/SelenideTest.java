package ru.netology.web;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[data-test-id=name] input.input__control").setValue("Семен Кузьмин");
        $("[data-test-id=phone] input.input__control").setValue("+79111133030");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $(withText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."))
                .shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldNameFieldValidation() {
        open("http://localhost:9999");
        $("[data-test-id=name] input.input__control").setValue("Semen Kuz");
        $(".button__content").click();
        $(withText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."))
                .shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldTelFieldValidation() {
        open("http://localhost:9999");
        $("[data-test-id=name] input.input__control").setValue("Семен Кузьмин");
        $("[data-test-id=phone] input.input__control").setValue("9111133030");
        $(".button__content").click();
        $(withText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."))
                .shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldCheckboxFieldValidation() {
        open("http://localhost:9999");
        $("[data-test-id=name] input.input__control").setValue("Семен Кузьмин");
        $("[data-test-id=phone] input.input__control").setValue("+79111133030");
        $(".button__content").click();
        $(".input_invalid")
                .shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных" +
                        " и разрешаю сделать запрос в бюро кредитных историй"));
    }
}