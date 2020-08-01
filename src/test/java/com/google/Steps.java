package com.google;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class Steps {

    @Step("Удостоверяемся, что результатов поиска на странице больше {minimumNumberOfSearchResults}")

    public static void checkNumberOfSearchResults(int NumberOfSearchResults, int minimumNumberOfSearchResults, WebDriver driver) {
        CustomUtils.getScreen(driver);
        Assertions.assertTrue(
                NumberOfSearchResults > minimumNumberOfSearchResults
                , "Результатов поиска заданного слова на странице менее {minimumNumberOfSearchResults}"
        );
    }

    @Step("Удостоверяемся, что среди результатов поиска есть сайт Википедии")

    public static void checkContainsURL(List<Map<String,Object>> resultSearch, WebDriver driver) {
        CustomUtils.getScreen(driver);
        Assertions.assertTrue(
                resultSearch.stream().anyMatch(x->x.get("URL").toString().contains("ru.wikipedia.org"))
                , "Среди результатов поиска отсутствует сайт Википедии"
        );
    }
}
