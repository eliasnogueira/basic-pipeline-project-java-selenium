package com.eliasnogueira.quickloja.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eliasnogueira.quickloja.Utils;

public class MainPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Integer.parseInt(Utils.getPropertyValue("timeout.global.web")));
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sair")));
	}

	public void clicaremSair() {
		driver.findElement(By.linkText("Sair")).click();
	}

	public String retornaNomeUsuarioLogado() {
		return driver.findElement(By.cssSelector(".navbar-link")).getText();
	}

	public MainPage clicarEmPedidos() {
		driver.findElement(By.xpath("//a[contains(text(),'Pedidos')]")).click();

		return this;
	}

	public MainPage clicarEmNovoPedido() {
		driver.findElement(By.xpath("//a[contains(text(),'Novo pedido')]")).click();

		return this;
	}

	public MainPage clicarEmListagemDePedidos() {
		driver.findElement(By.xpath("//a[contains(text(),'Listagem de pedidos')]")).click();

		return this;
	}

	public MainPage clicarEmMovimentacoes() {
		driver.findElement(By.xpath("//a[contains(text(),'Movimentações')]")).click();

		return this;
	}

}
