package com.google.search.POM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String BASE_URL = "https://qa-scooter.praktikum-services.ru";

    private final By skipCookieButton = By.className("App_CookieButton__3cvqF");

    @Step("Открытие главной страницы")
    public MainPage openMain() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Принять куки")
    public MainPage skipCookie() {
        driver.findElement(skipCookieButton).click();
        return this;
    }

    @Step("Скролл до вопроса и клик")
    public MainPage scrollQuestionAndClick(String question) {
        WebElement questionElement = driver.findElement(By.xpath(String.format("//div[@class='accordion__button' and text()='%s']", question)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        questionElement.click();
        return this;
    }

    @Step("Проверяем, что есть нужный ответ")
    public boolean checkAnswer(String answer) {
        return driver.findElements(By.xpath(String.format("//p[text()='%s']", answer))).size() > 0;
    }

}
