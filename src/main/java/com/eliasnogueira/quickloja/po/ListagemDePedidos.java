package com.eliasnogueira.quickloja.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eliasnogueira.quickloja.Utils;

public class ListagemDePedidos {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public ListagemDePedidos(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Integer.parseInt(Utils.getPropertyValue("timeout.global.web")));
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn.btn-danger")));
	}
	
	
	public boolean existeCliente(String cliente) {
		return driver.getPageSource().contains(cliente);
	}
	
	public boolean existeTotal(String total) {
		return driver.getPageSource().contains(total);
	}
	
	public boolean existeFrete(String frete) {
		return driver.getPageSource().contains(frete);
	}
	
	public boolean existeTotalGeral(String totalGeral) {
		return driver.getPageSource().contains(totalGeral);
	}
	
}
