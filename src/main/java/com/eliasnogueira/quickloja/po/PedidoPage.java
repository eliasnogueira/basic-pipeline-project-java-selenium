package com.eliasnogueira.quickloja.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eliasnogueira.quickloja.Utils;

public class PedidoPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public PedidoPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Integer.parseInt(Utils.getPropertyValue("timeout.global.web")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("totalgeral")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clicarAbaCliente() {
		driver.findElement(By.cssSelector("a[href='#tab1']")).click();
	}

	public void clicarAbaDadosDeEntrega() {
		driver.findElement(By.cssSelector("a[href='#tab2']")).click();
	}
	
	public void clicarAbaItensDoPedido() {
		driver.findElement(By.cssSelector("a[href='#tab3']")).click();
	}
	
	public void clicarEmGravar() {
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}
	
	public String retornaMensagemAlerta() {
		return driver.switchTo().alert().getText();
	}
	
	public void clicaOKMensagemAlerta() {
		driver.switchTo().alert().accept();
	}
	
	public void selecionaCliente(String cliente) {
		driver.findElement(By.cssSelector(".icon-search")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("myModal")));
		
		driver.findElement(By.linkText(cliente)).click();
	}
	
	public void preencherCampoEndereco(String endereco) {
		driver.findElement(By.name("pedidoendereco")).sendKeys(endereco);
	}
	
	public void preencherCampoBairro(String bairro) {
		driver.findElement(By.name("pedidobairro")).sendKeys(bairro);
	}
	
	public void preencherCampoCEP(String cep) {
		driver.findElement(By.name("pedidocep")).sendKeys(cep);
	}
	
	public void preencherCampoCidade(String cidade) {
		driver.findElement(By.name("pedidocidade")).sendKeys(cidade);
	}
	
	public void selecionarEstado(String estado) {
		new Select(driver.findElement(By.id("pedidoestado"))).selectByVisibleText(estado);
	}
	
	public void preencherEnderecoCompleto(String endereco, String bairro, String cep, String cidade, String estado) {
		preencherCampoEndereco(endereco);
		preencherCampoBairro(bairro);
		preencherCampoCEP(cep);
		preencherCampoCidade(cidade);
		selecionarEstado(estado);
	}
	
	public void preencherProduto(String nomeProduto) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("produtonome")));
		driver.findElement(By.id("produtonome")).sendKeys(nomeProduto);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(nomeProduto)));
		driver.findElement(By.linkText(nomeProduto)).click();
	}
	
	
	public void preencherQuantidadeProduto(String quantidade) {
		By campoQuantidade = By.id("produtoquantidade");
		
		wait.until(ExpectedConditions.elementToBeClickable(campoQuantidade));
		driver.findElement(campoQuantidade).sendKeys(quantidade);
	}
	
	public void clicarEmAdicionarProduto() {
		driver.findElement(By.id("adicionar")).click();
	}
	
	
	public String retornaValorTotal() {
		return driver.findElement(By.id("total")).getText();
	}
	
	public String retornaDesconto() {
		return driver.findElement(By.id("desconto")).getText();
	}
	
	public String retornaFrete() {
		return driver.findElement(By.id("frete")).getText();
	}
	
	public String retornaTotalGeral() {
		return driver.findElement(By.id("totalgeral")).getText();
	}
	
}
