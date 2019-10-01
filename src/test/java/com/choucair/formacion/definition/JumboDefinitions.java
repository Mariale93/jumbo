package com.choucair.formacion.definition;

import com.choucair.formacion.steps.JumboSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class JumboDefinitions {
    @Steps
    JumboSteps jumboSteps;
    String casoPrueba;

    @Given("^se debe seleccionar la categoria para comprar productos de despensa (\\d+)$")
    public void se_debe_seleccionar_la_categoria_para_comprar_productos_de_despensa(String id)  {
        this.casoPrueba = id;
        jumboSteps.lectura("1");
        jumboSteps.seleccionarMenu();
    }

    @When("^se debe seleccionar un producto por categoria hasta acabar el dinero (\\d+)$")
    public void se_debe_seleccionar_un_producto_por_categoria_hasta_acabar_el_dinero(String Precio) {
        jumboSteps.seleccionarProductos(Precio);
    }

    @Then("^configuro metodo de entrega y valido el carrito de compras (\\d+)$")
    public void configuro_metodo_de_entrega_y_valido_el_carrito_de_compras(String SubTotal)  {
        jumboSteps.validacion(SubTotal);

    }
}
