package com.eliasnogueira.quickloja.pedido;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.eliasnogueira.quickloja.Utils;
import com.eliasnogueira.quickloja.po.ListagemDePedidos;
import com.eliasnogueira.quickloja.po.LoginPage;
import com.eliasnogueira.quickloja.po.MainPage;

public class ListagemPedidoTest {

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
	public void testeNovoPedidoSucesso() {
		login.efetuarLogin("teste", "123");
		
		MainPage mainPage = new MainPage(driver);
		mainPage.clicarEmPedidos().clicarEmListagemDePedidos();
		
		ListagemDePedidos listaPedidos = new ListagemDePedidos(driver);
		assertTrue("Não existe o CLIENTE especificado", listaPedidos.existeCliente("Adaptworks"));
		assertTrue("Não existe o TOTAL especificado", listaPedidos.existeTotal("R$398,00"));
		assertTrue("Não existe o FRETE especificado", listaPedidos.existeFrete("R$30,00"));
		assertTrue("Não existe o TOTAL GERAL especificado", listaPedidos.existeTotalGeral("R$428,00"));
		
	}

}
