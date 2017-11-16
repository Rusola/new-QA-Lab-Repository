import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScriptB {
    public static void main (String[] args) {

        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement login=driver.findElement(By.name("email"));
        login.sendKeys("webinar.test@gmail.com");
        WebElement password=driver.findElement(By.name("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement button=driver.findElement(By.name("submitLogin"));
        button.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String [] menuNames=new String[]{"Заказы","Dashboard","Каталог","Клиенты","Служба поддержки","Статистика","Modules","Design","Доставка"};
        for (int i=0;i<menuNames.length;i++){
        WebElement element=driver.findElement(By.linkText(menuNames[i]));
        element.click();
            System.out.println("Page title is "+driver.getTitle());
            String url1=driver.getCurrentUrl();
            driver.navigate().refresh();
            String url2=driver.getCurrentUrl();
            if(url1.equals(url2)){
                System.out.println("пользователь остается в том же разделе после перезагрузки "+"\""+driver.getTitle()+"\""+"страницы");
            }else {
                System.out.println("ошибка!раздел поменялся!");
            }
        }
        driver.quit();


    }
    public static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        return new ChromeDriver();
    }
}

