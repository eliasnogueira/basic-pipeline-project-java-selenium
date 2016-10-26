package com.eliasnogueira.quickloja.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eliasnogueira.quickloja.Utils;

public class MovimentacoesPage {

	
	@SuppressWarnings("unused")
	private WebDriver driver;
	private WebDriverWait wait;
	private String conteudoPagina;
	
	public MovimentacoesPage(WebDriver driver) {
		this.driver = driver;
		
		wait = new WebDriverWait(driver, Integer.parseInt(Utils.getPropertyValue("timeout.global.web")));
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn.btn-danger")));
		
		conteudoPagina = driver.getPageSource();
	}
	
	public boolean existeTipo(String tipo) {
		return conteudoPagina.contains(tipo);
	}
	
	public boolean existeOrigem(String origem) {
		return conteudoPagina.contains(origem);
	}
	
	public boolean existeValor(String valor) {
		return conteudoPagina.contains(valor);
	}
	
	public boolean existeItens(String itens) {
		return conteudoPagina.contains(itens);
	}
	
}
