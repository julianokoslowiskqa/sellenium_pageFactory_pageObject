package automatizado.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.LoginPO;

public class LoginTest extends BaseTest {

    private static LoginPO loginPage;


    private void executarAcaoDeLogar(String email, String senha){
        loginPage.escrever(loginPage.inputEmail, email);
        loginPage.escrever(loginPage.inputSenha, senha); 

        loginPage.buttonEntrar.click();
        }

    @BeforeClass
    public static void preperarTestes(){
        loginPage = new LoginPO(driver); 
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComUEmailESenhasVazios(){

        executarAcaoDeLogar("","");

        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }
    
    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){

        executarAcaoDeLogar("teste","");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){

        executarAcaoDeLogar("","teste");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usu\u00E1rio e senha, os campos n\u00E3o podem ser brancos.");
    } 

}
