package com.bdd.page;

import com.ibm.icu.impl.Assert;

import io.cucumber.java.Scenario;
import net.serenitybdd.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@DefaultUrl("https://www.facebook.com/")

public class EjercicioPage extends PageObject {

    // input username
    @FindBy(xpath = "//input[@id='email']")
    private WebElement inpt_username;

    // input password
    @FindBy(xpath = "//input[@id='pass']")
    private WebElement inpt_password;

    //btn login
    @FindBy(xpath = "//button[@name=\"login\"]")
    private WebElement btn_login;

    //label error
    @FindBy(xpath = "//div[contains(text(), 'El correo electrónico que has introducido no está conectado a una cuenta')]")
    private WebElement lbl_error;

    // boton home
    @FindBy(xpath = "//a[@aria-label='Inicio']//span[@class='x1n2onr6']//*[name()='svg']")
    private WebElement btn_home;

    //btn notificaciones
    @FindBy(xpath = "//a[@aria-label='Notificaciones']")
    private WebElement btn_notificaciones;

    //label publicacion
    @FindBy(xpath = "//span[contains(text(),'Publicación')]")
    private WebElement lbl_publicacion;

    //btn me_gusta
    @FindBy(xpath = "//span[text()='Me gusta']")
    private WebElement btn_me_gusta;

    //img me_gusta
    @FindBy(xpath = "//img[@role='presentation']")
    private WebElement img_me_gusta;


    public void tomarCaptura() throws Exception
    {
        Date d =new Date();
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("captures/"+d.toString().replace(":", "_")+".png"));
    }



    public void comoUsuarioQuieroIngresarAFacebook() throws Exception {
        System.setProperty("webdriver.chrome.driver", new File("resources/chromedriver-131.exe").getAbsolutePath());
        setDriver(new ChromeDriver());
        open();
        getDriver().manage().window().maximize();
        waitFor(1).seconds();

    }

    public void ingresoMiUsuarioYPassword(String usuario, String password) throws Exception {
        inpt_username.sendKeys(usuario);
        waitFor(300).millisecond();
        inpt_password.sendKeys(password);
        waitFor(300).millisecond();

    }

    public void hagoClicEnIniciarSesion() throws Exception{
        btn_login.click();
        waitFor(300).millisecond();

    }

    public void seMuestraElLoginIncorrecto() throws Exception{
        if(lbl_error.isDisplayed()){
            Assert.assrt(true);
        }
        else{
            Assert.fail("Ocurrio un error mientras se logeaba el usuario");
        }



    }

    //-------------------------------Ejercicio2-------------------------------

    public void seMuestraElHome() {

        waitFor(1).second();
        new Actions(getDriver())
                .keyDown(Keys.ESCAPE)
                .perform();

        if(btn_home.isDisplayed()){
            Assert.assrt(true);
        }
        else{
            Assert.fail("No se esta mostrando el Home");
        }
        waitFor(500).millisecond();
    }
    public void seHaceClicEnNotificaciones() {
        btn_notificaciones.click();
        waitFor(300).millisecond();

    }
    public void seHaceScrollALasNotifacionesYSeEligeUnaNotificacion() {



        String xpathContenedorNotificaciones = "//div[@class='x78zum5 xdt5ytf x1iyjqo2 x1n2onr6']";

        //wait
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));

        //contenedor de las notificaciones
        WebElement contenedorNotificaciones = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathContenedorNotificaciones)));

        //scroll en 200 pixeles de forma vertical
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,200)", contenedorNotificaciones);
        waitFor(500).millisecond();


        String xpathNotificaciones = "//div[@class='x1n2onr6']";

        // Esperar a que las notificaciones estén visibles
        List<WebElement> listaNotificaciones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathNotificaciones)));


        // Seleccionar una notificación aleatoria
        Random random = new Random();
        int indiceAleatorio = random.nextInt(listaNotificaciones.size());

        // En este caso se usa 0 ya que solo la primera tiene esa publicacion para dar Me gusta
        indiceAleatorio = 0;
        WebElement notificacionSeleccionada = listaNotificaciones.get(indiceAleatorio);

        // Hacer clic en la notificación seleccionada
        notificacionSeleccionada.click();
        waitFor(1).second();

    }
    public void seVerificaQueSeHayaCargadoCorrectamenteLaNotificacion() {
        if(lbl_publicacion.isDisplayed()){
            Assert.assrt(true);
        }
        else{
            Assert.fail("No se esta mostrando la publicacion");
        }
        waitFor(4).second();
    }

    public void seLeDaClicEnMeGusta() {
        btn_me_gusta.click();
        waitFor(500).millisecond();
    }
    public void seVerificaQueElPostHayaRecibidoElMeGusta() {
        if(img_me_gusta.isDisplayed()){
            Assert.assrt(true);
        }
        else{
            Assert.fail("Ocurrio un error");
        }
    }


}
