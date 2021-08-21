package primerEjemplo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class primerEjemplo {
    private WebDriver driver;

    //levantar/habilitar selenium
    @Before
    public void setUp(){
        //busca donde se encuentra el chromedriver -> sirve para abrir google
        System.setProperty("webdriver.chrome.driver", "C:/JAVA/chromedriver_win32/chromedriver.exe");

        //instancia de chromedriver(ejecuta cosas de chrome) al driver
        driver = new ChromeDriver();

        //maximiza la ventana de google en su totalidad
        driver.manage().window().maximize();

        //abrir pagina web
        driver.get("https://www.google.com");

    }

    //ejecucion de tests
    @Test
    public void testGoogle(){

        //se utiliza el WebElement que es una funcion de selenium para almacenar elementos web
        //Finelemente sirve para pasar la direccion al webElement
        //By.xpath sirve para pasar la dirrecion del elementos
        WebElement cajaBusqueda = driver.findElement(By.xpath("//input[@name='q']"));


        //Escribir en caja de texto en google
        //submit() -> apretar ENTER para buscar
        cajaBusqueda.sendKeys("Hola mundo");
        cajaBusqueda.submit();

        //awantaaa selenium 10 segundos antes de tirar error
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //AssertEquals es una asercion es decir comprobacion
        //en este caso comprueba que el titulo de la pestaña sea igual a hola mundo - Buscar con Google
        Assert.assertEquals("Hola mundo - Buscar con Google", driver.getTitle());




    }

    //cerrar selenium
    @After
    public void tearDown(){

        driver.quit();

    }



}
