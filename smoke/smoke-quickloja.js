casper.options.viewportSize = {
    width: 1024, 
    height: 768
};

var testCount = 3;
var usuario;

casper.test.begin("Login Quickloja", testCount, function(test) {
    
    casper.start("http://eliasnogueira.com/quickloja/", function () {
        this.test.comment("Acesso a pagina inicial");
        
        this.waitForSelector('#usuariologin', function () {
            this.captureSelector('pagina-login.png', 'html');
        });
    });
    
    casper.then(function() {
        this.test.comment("Verifica se os campos estão sendo exibidos");
        this.test.assertExists("#usuariologin"); 
        this.test.assertExists("#usuariosenha"); 
        this.test.assertExists("button"); 
    });
    
    casper.then(function() {
        this.test.comment("Efetuar o login com usuario e senha validos");
        
        this.sendKeys('#usuariologin', 'teste');
        this.sendKeys('#usuariosenha', '123');
        this.click('button');
        
        this.waitForSelector("a[class='navbar-link']", function () {
            this.captureSelector('pagina-inicial.png', 'html');
        });
    });
    
    casper.then(function() {
        this.test.comment("Sair da aplicação");
        this.clickLabel('Sair');
    });
    
    casper.run(function () {
        this.test.done();
    });
    
});