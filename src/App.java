import javax.lang.model.element.ModuleElement.DirectiveVisitor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jdk.tools.jlink.internal.DirArchive;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.drivethrurpg.com/index.php");
        Thread.sleep(5000);
        String titulo = driver.getTitle();
        System.out.println(titulo);
        //probamos el cuado de búsqueda(Prueba 3)
        WebElement searchBox = driver.findElement(By.id("search_bar"));

        searchBox.sendKeys("Eclipse Phase");
        searchBox.sendKeys(Keys.ENTER);
        //comprobamos que el primer resutlado que aparece el el articulo qeu buscamos
        Thread.sleep(2000);
        //Seleccionamos el primer producto "Eclipse Phase(frist edition)" (Prueba 2)
        driver.findElement(By.linkText("Eclipse Phase (first edition)")).click();
        Thread.sleep(2000);
        //Seleccionamos la tercera opcion del producto "Hard cover"(Prueba 5)
        driver.findElement(By.xpath("//input[@id='option_selection' and @value='20|6,4,6,6,1,17,2,20,3,40,4,50,6,51,6,52,6,53']")).click();
        Thread.sleep(2000);
        //Añadimos el producto al carrito,
        //este paso lo prodriamos repetir con un bucle para la prueba de llegar la maximo de productos del carrito
        driver.findElement(By.id("addtocartbutton")).click();
        Thread.sleep(2000);
        
        
        //comprobamos que el menu lateral funciona(Prueba 7)
        driver.get("https://www.drivethrurpg.com/index.php");
        driver.findElement(By.id("nav-icon-rule-system")).click();
        Thread.sleep(2000);
        //seleccionamos uno de los sistemas de juego y vemos que nos muestra productos de dicho sistema
        driver.findElement(By.linkText("Fate")).click();
        Thread.sleep(2000);

        //Comprobamos que podemos cambiar la moneda en la que se muestran los productos de la tienda
        //cambiamos de la moneda pord efecto dolares a Euros(Prueba 9)
        driver.get("https://www.drivethrurpg.com/index.php");
        driver.findElement(By.id("currency_titletext")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("currency_msa_1")).click();
        Thread.sleep(5000);

        
        driver.quit();

        }
}
