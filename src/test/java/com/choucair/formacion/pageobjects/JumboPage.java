package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


@DefaultUrl("https://www.tiendasjumbo.co/")

public class JumboPage extends PageObject {
    @FindBy(xpath = "//button[@class='product-item__add-to-cart product-add-to-cart btn red add-to-cart']")
    List<WebElementFacade> listAlimentos;

    @FindBy(xpath = "//div[@class='center']//div[@id='minicart-navigation']//a[@class='btn primary minicart__action minicart__action--buy']")
    WebElementFacade validar;

    @FindBy(xpath = "//button[@class='btn red minicart__action--toggle-open']")
    WebElementFacade btnitem;

    @FindBy(xpath = "//div[@class='center']//div[@id='minicart-navigation']//a[@class='btn primary minicart__action minicart__action--buy']")
    WebElementFacade btncarritofinalizar;

    public void metodoEntrega() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='delivery-header-wrapper']//div[@class='setup-delivery-container']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='select-recoge-en-tienda']//*[@class='delivery__option--svg']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[3]/div[1]/span[1]/span[1]/span[1]/span[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[3]/div[2]/span[1]/span[1]/span[1]/span[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[1]"))).click();
        wait.until((ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[3]/div[3]/span[1]/span[1]/span[1]/span[1]")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[3]/div[4]"))).click();
    }

    public void menu(String posicion) {
        waitFor(3).seconds();
        find(By.xpath("//button[@class='button-categories toggleSlide']")).click();
        String xpathCategoria = "//span[text()='CATEGORÍAS']";
        String xpathSupermercado = "//li[@class='navigation__item-category food-site special-menu']";
        String xpathMenu = "//div[@class='subcategory__col']//ul[@class='items__sub-categories']//li[";
        Actions act = new Actions(getDriver());
        waitFor(1).seconds();
        act.moveToElement($(xpathCategoria)).perform();
        waitFor(1).seconds();
        act.moveToElement($(xpathSupermercado)).perform();
        waitFor(1).seconds();
        act.moveToElement($(xpathMenu + posicion + "]")).perform();
    }

    private int PrecioTotal;
    public void productos(String precio) {
        int count= 16;
        int numProductos = 20;
        int contador = 0;
        int Precio = Integer.parseInt(precio);
        int i=1;
        while (true) {
            if (contador == numProductos || getPrecioTotal()>Precio) {
                break;
            } else {
                    contador++;
                    find(By.xpath("//li[@class='despensa active-menu']//li[" + i + "]")).click();
                    waitFor(5).seconds();
                    find(By.xpath("//span[@class='selection']")).click();
                    waitFor(2).seconds();
                    find(By.xpath("//option[contains(text(),'Menor precio')]")).click();
                    waitFor(5).seconds();
                    listAlimentos.get(1).waitUntilClickable().click();
                    waitFor(5).seconds();
                    String SubTotal = $("/html[1]/body[1]/div[26]/div[1]/div[2]/div[7]/div[5]/div[1]/div[2]/div[4]/div[1]/div[2]").getText();
                    menu("1");
                    String text = SubTotal.replaceAll("[^a-zA-Z0-9]", "");
                    PrecioTotal = Integer.parseInt(text);
                    i+=i;
                }   contador=0;
            }
        }


    public int getPrecioTotal(){
        return PrecioTotal;
    }

    public void validar(String precio) {

            Actions actcalidar = new Actions(getDriver());
            actcalidar.moveToElement($(btnitem)).click().perform();
            waitFor(10).second();
            actcalidar.moveToElement($(btncarritofinalizar)).click().perform();

        /*find(By.xpath("//button[@class='btn red minicart__action--toggle-open']")).click();
        Actions actcalidar = new Actions(getDriver());
        waitFor(5).second();
        actcalidar.moveToElement($("//div[@class='center']//div[@id='minicart-navigation']//a[@class='btn primary minicart__action minicart__action--buy']")).perform();
        actcalidar.click(validar);
        waitFor(5).seconds();*/
    }
}


