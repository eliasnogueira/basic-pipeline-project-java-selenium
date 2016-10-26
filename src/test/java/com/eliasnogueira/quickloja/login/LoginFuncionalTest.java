package com.eliasnogueira.quickloja.login;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.eliasnogueira.quickloja.Utils;
import com.eliasnogueira.quickloja.po.LoginPage;
import com.eliasnogueira.quickloja.po.MainPage;

public class LoginFuncionalTest {

	
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
	public void testeLogin_UsuarioESenhaErrados() {
		login.preencherCampoUsuario("nao existe");
		login.preencherCampoSenha("nao existe");
		login.clicarNoBotaoEntrar();
		
		assertEquals("Usuário ou senha incorretos", login.retornaMensagemErro());
	}
	
	@Test
	public void testeLogin_UsuarioErrado() {
		login.preencherCampoUsuario("nao existe");
		login.preencherCampoSenha("123");
		login.clicarNoBotaoEntrar();
		
		assertEquals("Usuário ou senha incorretos", login.retornaMensagemErro());
	}
	
	@Test
	public void testeLogin_SenhaErrada() {
		login.preencherCampoUsuario("teste");
		login.preencherCampoSenha("nao existe");
		login.clicarNoBotaoEntrar();
		
		assertEquals("Usuário ou senha incorretos", login.retornaMensagemErro());
	}

	@Test
	public void testeLogin_SemPreencherUsuario() {
		login.preencherCampoSenha("123");
		login.clicarNoBotaoEntrar();
		
		assertEquals("Usuário ou senha incorretos", login.retornaMensagemErro());
	}
	
	@Test
	public void testeLogin_SemPreencherSenha() {
		login.preencherCampoUsuario("teste");
		login.clicarNoBotaoEntrar();
		
		assertEquals("Usuário ou senha incorretos", login.retornaMensagemErro());
	}
	
	@Test
	public void testeLogin_SemprencherCampos() {
		login.clicarNoBotaoEntrar();
		
		assertEquals("Usuário ou senha incorretos", login.retornaMensagemErro());
	}
	
	@Test
	public void testeLogin_Sucesso() {
		login.preencherCampoUsuario("teste");
		login.preencherCampoSenha("123");
		login.clicarNoBotaoEntrar();
		
		MainPage mainPage = new MainPage(driver);
		assertEquals("Teste", mainPage.retornaNomeUsuarioLogado());
		
		mainPage.clicaremSair();
	}
	
}
