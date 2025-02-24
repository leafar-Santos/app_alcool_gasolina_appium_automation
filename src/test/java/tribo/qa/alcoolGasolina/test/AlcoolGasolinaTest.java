package tribo.qa.alcoolGasolina.test;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tribo.qa.alcoolGasolina.core.BaseTest;
import tribo.qa.alcoolGasolina.core.DriverFactory;
import tribo.qa.alcoolGasolina.page.AlcoolGasolinaPage;


import static tribo.qa.alcoolGasolina.dataTests.epics.AlcoolGasolinaEpic.createAddressPage;
import static tribo.qa.alcoolGasolina.dataTests.histories.AlcoolGasolinaStory.alcoolGasolinaStory;


public class AlcoolGasolinaTest extends BaseTest {

    private static AndroidDriver driver;
    private AlcoolGasolinaPage page =  new AlcoolGasolinaPage();

    @BeforeAll
    public static void startAppium() {
       driver = DriverFactory.getDriver();
    }

    @Test
    @Epic(createAddressPage)
    @Story(alcoolGasolinaStory)
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Deve valida que que a melhor para uso é o àlcool")
    @Description("Inserir preço do alcool menor do que o preço da gasolina")
    public void deveCalcularMelhorOpcaoAlcool()  {
        page.informarAlcool("10.4");
        page.informarGasolina("16.7");
        page.clicarCalcular();
        page.verificarResultado("Melhor utilizar Álcool!");
    }

    @Test
    @Epic(createAddressPage)
    @Story(alcoolGasolinaStory)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Inserir preço do alcool maior do que o preço da gasolina")
    @DisplayName("Deve validaque que a melhor para uso é a gasolina")
    public void deveCalcularMelhorOpcaoGasolina() {
        page.informarAlcool("20.4");
        page.informarGasolina("10.7");
        page.clicarCalcular();
        page.verificarResultado("Melhor utilizar Gasolina!");
    }

    @Test
    @Epic(createAddressPage)
    @Story(alcoolGasolinaStory)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deixar os campos em branco e tentar calcular.")
    @DisplayName("Deve retornar mensagem de falha ao deixar campos vazios e clicar em Calcular")
    public void deveRetornarMensagemCamposVazios() {
        page.informarAlcool("");
        page.informarGasolina("");
        page.clicarCalcular();
        page.verificarResultado("Preencha os preços primeiro!");
    }

    @Test
    @Epic(createAddressPage)
    @Story(alcoolGasolinaStory)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deixar o campo alcool vazio e preencher o campo gasolina.")
    @DisplayName("Deve retornar mensagem de falha ao deixar campo álcool vazio clicar em Calcular")
    public void deveRetornarMensagemCampoAlcoolVazio() {
        page.informarAlcool("");
        page.informarGasolina("10.2");
        page.clicarCalcular();
        page.verificarResultado("Preencha os preços primeiro!");
    }

    @Test
    public void deveRetornarMensagemCampoGasolinalVazio(){
        page.informarAlcool("10.2");
        page.informarGasolina("");
        page.clicarCalcular();
        page.verificarResultado("Preencha os preços primeiro!");
    }

}
