package com.eliasnogueira.quickloja.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eliasnogueira.quickloja.Utils;

public class LoginPage {

	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Integer.parseInt(Utils.getPropertyValue("timeout.global.web")));
		driver.get(Utils.getPropertyValue("url.inicial.web"));
	}
	
	public void preencherCampoUsuario(String usuario) {
		driver.findElement(By.id("usuariologin")).sendKeys(usuario);
	}
	
	public void preencherCampoSenha(String senha) {
		driver.findElement(By.id("usuariosenha")).sendKeys(senha);
	}
	
	public void clicarNoBotaoEntrar() {
		driver.findElement(By.cssSelector(".btn.btn-medium.btn-primary")).click();
	}
	
	public void efetuarLogin(String usuario, String senha) {
		preencherCampoUsuario(usuario);
		preencherCampoSenha(senha);
		clicarNoBotaoEntrar();
	}
	
	public String retornaMensagemErro() {
		By elementError = By.cssSelector(".alert.alert-error");
		wait.until(ExpectedConditions.presenceOfElementLocated(elementError));
		return driver.findElement(elementError).getText();
	}
	
	
	
}
