package com.eliasnogueira.quickloja.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.eliasnogueira.quickloja.login.LoginFuncionalTest;
import com.eliasnogueira.quickloja.pedido.PedidoFuncionalTest;

@RunWith(Suite.class)
@SuiteClasses( {LoginFuncionalTest.class, PedidoFuncionalTest.class} )
public class SuiteTesteWeb_Funcional {

}
