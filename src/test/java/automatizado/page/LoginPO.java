package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id= "email")
    public WebElement inputEmail;

    @FindBy(id= "senha")
    public WebElement inputSenha;

    @FindBy(id= "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css ="form.form-login>div.alert>span")
    public WebElement spanMensagem;

    /**
     * Construtor padrão para criação de uma nova instância da pagina de login
     * @param driver Drive da página de login.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem() {
        return spanMensagem.getText();
    }

    public void escrever(WebElement input, String texto){
        input.sendKeys(texto  + Keys.TAB);
    }


    
}
