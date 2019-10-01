package com.choucair.formacion.steps;

import au.com.bytecode.opencsv.CSVReader;
import com.choucair.formacion.pageobjects.JumboPage;
import net.thucydides.core.annotations.Step;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class JumboSteps {
    JumboPage jumboPage;
    private static String[] datos;

    public static void leerCSV(String casoPrueba){
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader("src/test/resources/Datadriven/datos.csv"));
            String[] fila;
            while ((fila = reader.readNext())!=null){
                Logger.getLogger(fila[0]);
                if (casoPrueba.equals(fila[0].trim())){
                    datos = fila;
                }
            }reader.close();
        } catch (IOException e){
            Logger.getLogger(""+e);
        }
    }

    @Step
    public void lectura(String idCaso) {
        leerCSV(idCaso);    }

    public void seleccionarMenu() {
        jumboPage.open();
        jumboPage.metodoEntrega();
        jumboPage.menu(datos[1]);    }

    public void seleccionarProductos(String Precio) {
        jumboPage.productos(datos[2]);    }

    public void validacion(String subTotal) {
        jumboPage.validar(datos[2]);
    }
}
