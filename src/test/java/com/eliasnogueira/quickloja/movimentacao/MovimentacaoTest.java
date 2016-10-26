package com.eliasnogueira.quickloja.movimentacao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.eliasnogueira.quickloja.Utils;
import com.eliasnogueira.quickloja.po.LoginPage;
import com.eliasnogueira.quickloja.po.MainPage;
import com.eliasnogueira.quickloja.po.MovimentacoesPage;

public class MovimentacaoTest {

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
	public void testeValidacaoMovimentacao() {
		login.efetuarLogin("teste", "123");
		
		MainPage mainPage = new MainPage(driver);
		mainPage.clicarEmMovimentacoes();
		
		MovimentacoesPage movimentacoes = new MovimentacoesPage(driver);
		assertTrue("TIPO não encontrado!", movimentacoes.existeTipo("Entrada"));
		assertTrue("ORIGEM não encontrada!", movimentacoes.existeOrigem("Automática"));
		assertTrue("VALOR não encontrado!", movimentacoes.existeValor("R$ 428,00"));
		assertTrue("ITENS não encontrados!", movimentacoes.existeItens("Nike Model Two"));
		
	}

}
