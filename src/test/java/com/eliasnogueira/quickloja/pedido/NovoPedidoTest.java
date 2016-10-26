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

public class NovoPedidoTest {

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
		mainPage.clicarEmPedidos().clicarEmNovoPedido();
		
		PedidoPage pedido = new PedidoPage(driver);
		pedido.selecionaCliente("Adaptworks");
		
		pedido.clicarAbaDadosDeEntrega();
		pedido.preencherEnderecoCompleto("Av Paulista, 1000", "Bela Vista", "45230000", "São Paulo", "São Paulo");
		
		pedido.clicarAbaItensDoPedido();
		pedido.preencherProduto("Nike Model Two");
		pedido.preencherQuantidadeProduto("2");
		pedido.clicarEmAdicionarProduto();
		
		assertEquals("R$ 398", pedido.retornaValorTotal());
		assertEquals("R$ 0,00", pedido.retornaDesconto());
		assertEquals("R$ 30,00", pedido.retornaFrete());
		assertEquals("R$ 428", pedido.retornaTotalGeral());
		
		pedido.clicarEmGravar();
		
	}

}
