package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageObjectGoogleWithSearch {

    private String selectorSearchItem = "//div[@class='g']";
    private String selectorURL = ".//div[@class='r']/a[@href]";
    private String selectorNamePage = ".//div[@class='r']/a[@href]";
    private String selectorDiscriprion = ".//div[@class='s']";

    private WebDriver driver;

    private List<WebElement> searchItem = new ArrayList<>();
    private List<Map<String,Object>> collectResult = new ArrayList<>();

    public PageObjectGoogleWithSearch(WebDriver driver, String search) {
        this.driver = driver;
        this.driver.get("https://www.google.com/search?q="+ search);
        searchItem = driver.findElements(By.xpath(selectorSearchItem));
    }

    public PageObjectGoogleWithSearch(WebDriver driver) {
        this.driver = driver;
        searchItem = driver.findElements(By.xpath(selectorSearchItem));
    }

    public List<Map<String,Object>> getCollectResult() {
        for(WebElement result : searchItem) {
            collectResult.add(Map.of(
                    "WEB_ELEMENT", result,
                    "URL", result.findElement(By.xpath(selectorURL)).getAttribute("href"),
                    "NAME_PAGE", result.findElement(By.xpath(selectorNamePage)).getText(),
                    "DISCRIPTION", result.findElement(By.xpath(selectorDiscriprion)).getText()
            ));
        }

        return collectResult;
    }

}
