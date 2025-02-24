package tribo.qa.alcoolGasolina.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import tribo.qa.alcoolGasolina.core.BasePage;


public class AlcoolGasolinaPage extends BasePage {


    public void informarAlcool(String valor){
       insertValue(By.id("editPrecoAlcool"),valor);
    }

     public void informarGasolina(String valor){
        insertValue(By.id("editPrecoGasolina"),valor);
    }

     public void clicarCalcular(){
         clickButton(By.id("btnCalcular"));
    }

     public void verificarResultado(String valor){
        Assertions.assertEquals(valor, assertResult(By.id("txtResultado")));
    }


}
