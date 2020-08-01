package com.google;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class Tests extends WebDriverSettings{

    String searchWord = "Гладиолус"; // Слово, которое будем искать в Google
    int minimumNumberOfSearchResults = 3;  // Переменная для проверки количества результатов поиска(минимальное необходимое число)

    /*      Тест кейс номер 1.
            "Проверка поиска интересующего слова в поисковике Google.ru"
            Шаги: 1. зайти на сайт Google.ru
                  2. Выполнить поиск слова Гладиолус
                  3. Убедиться, что количество результатов поиска больше трех
                  4. Вывести результаты теста в Allure
     */
    @Test
    @Description(value = "Поиск слова Гладиолус на сайте-поисковике Google")
    public void test2020_07_30_1() {
        PageObjectGoogleWithSearch googleWithSearch = new PageObjectGoogleWithSearch(chromeDriver, searchWord);
        List<Map<String,Object>> resultSearch = googleWithSearch.getCollectResult();
        //resultSearch.stream().forEach(x-> System.out.println(x.get("URL").toString()));
        Steps.checkNumberOfSearchResults(resultSearch.size(),minimumNumberOfSearchResults,chromeDriver);
    }

    /*      Тест кейс номер 2.
            "Наличие среди результатов поиска слова Гладиолус в поисковике Google.ru сайта Википедии"
            Шаги: 1. зайти на сайт Google.ru
                  2. Выполнить поиск слова Гладиолус
                  3. Проверить наличие сайта Википедии (ru.wikipedia.org) среди результатов поиска
                  4. Вывести результаты теста в Allure
     */
    @Test
    @Description(value = "Поиск сайта Википедии среди результатов поиска")
    public void test2020_07_30_2() {
        PageObjectGoogleWithSearch googleWithSearchWiki = new PageObjectGoogleWithSearch(chromeDriver, searchWord);
        List<Map<String,Object>> resultSearchWithWiki = googleWithSearchWiki.getCollectResult();
        Steps.checkContainsURL(resultSearchWithWiki, chromeDriver);

    }


}
