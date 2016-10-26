package com.eliasnogueira.quickloja.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.eliasnogueira.quickloja.movimentacao.MovimentacaoTest;
import com.eliasnogueira.quickloja.pedido.ListagemPedidoTest;
import com.eliasnogueira.quickloja.pedido.NovoPedidoTest;


@RunWith(Suite.class)
@SuiteClasses( {NovoPedidoTest.class, ListagemPedidoTest.class, MovimentacaoTest.class} )
public class PedidoListaMovimentacao_Aceitacao {

}
