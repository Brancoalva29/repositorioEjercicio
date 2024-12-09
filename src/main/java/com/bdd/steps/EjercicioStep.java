package com.bdd.steps;

import com.bdd.page.EjercicioPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;



public class EjercicioStep {

    private static Scenario scenario;
    EjercicioPage ejercicioPage;

    @Before
    public void beforeScenario(Scenario scenario) {
        EjercicioStep.scenario = scenario;
    }

    @Step
    @Given("como usuario quiero ingresar a facebook")
    public void comoUsuarioQuieroIngresarAFacebook() throws Exception {
        ejercicioPage.comoUsuarioQuieroIngresarAFacebook();
    }

    @Step
    @When("ingreso mi usuario {} , password {}")
    public void ingresoMiUsuarioYPassword(String usuario, String password) throws Exception {
        ejercicioPage.ingresoMiUsuarioYPassword(usuario,password);

    }

    @Step
    @And("hago clic en Iniciar Sesion")
    public void hagoClicEnIniciarSesion() throws Exception {
        ejercicioPage.hagoClicEnIniciarSesion();

    }

    @Step
    @Then("se muestra el login incorrecto")
    public void seMuestraElLoginIncorrecto() throws Exception{
        ejercicioPage.seMuestraElLoginIncorrecto();


    }

    //-------------------------------Ejercicio2-------------------------------

    @Step
    @And("se muestra el home")
    public void seMuestraElHome() {
        ejercicioPage.seMuestraElHome();

    }

    @Step
    @And("se hace clic en Notificaciones")
    public void seHaceClicEnNotificaciones() {
        ejercicioPage.seHaceClicEnNotificaciones();

    }

    @Step
    @And("se hace scroll a las notifaciones y se elige una notificacion")
    public void seHaceScrollALasNotifacionesYSeEligeUnaNotificacion() {
        ejercicioPage.seHaceScrollALasNotifacionesYSeEligeUnaNotificacion();

    }

    @Step
    @And("se verifica que se haya cargado correctamente la notificacion")
    public void seVerificaQueSeHayaCargadoCorrectamenteLaNotificacion() {
        ejercicioPage.seVerificaQueSeHayaCargadoCorrectamenteLaNotificacion();

    }

    @Step
    @And("se le da clic en Me gusta")
    public void seLeDaClicEnMeGusta() {
        ejercicioPage.seLeDaClicEnMeGusta();

    }

    @Step
    @Then("se verifica que el post haya recibido el Me gusta")
    public void seVerificaQueElPostHayaRecibidoElMeGusta() {
        ejercicioPage.seVerificaQueElPostHayaRecibidoElMeGusta();

    }

    @AfterStep
    public void tomarCapturas() throws Exception {
        ejercicioPage.tomarCaptura();
    }


}
