package com.eliasnogueira.quickloja.pedido;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.eliasnogueira.quickloja.Utils;
import com.eliasnogueira.quickloja.po.LoginPage;
import com.eliasnogueira.quickloja.po.MainPage;
import com.eliasnogueira.quickloja.po.PedidoPage;

public class PedidoFuncionalTest {

	private WebDriver driver;
	LoginPage login;
	
	@Before
	public void preCondicao() throws Exception {
		driver = Utils.selectBrowser(Utils.getPropertyValue("browser"));
		login = new LoginPage(driver);
	}
	
	
	@After
	public void posCondicao() {
		driver.quit();
	}
	
	@Test
	public void testeSemPreencherCampos() {
		login.efetuarLogin("teste", "123");
		
		MainPage mainPage = new MainPage(driver);
		mainPage.clicarEmPedidos().clicarEmNovoPedido();
		
		PedidoPage pedido = new PedidoPage(driver);
		pedido.clicarAbaDadosDeEntrega();
		pedido.clicarAbaItensDoPedido();
		pedido.clicarEmGravar();
		
		assertEquals("Por favor, preencha os campos obrigatórios!", pedido.retornaMensagemAlerta());
		pedido.clicaOKMensagemAlerta();
	}

}
