/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

/**
 *
 * @author davidborges
 */
public class PublicadorTest {
    //definir a classe dispostivo de teste e criar um "Mockery" que representa 
    //o contexto no qual o Publicador existe. O contexto simula os objetos que 
    //o Publicador colabora com (no caso, um Inscrito) e verifica se eles são
    //usados corretamente no teste.
    Mockery context = new Mockery();
    
    //método que vai realizar nosso teste
    @Test
    public void testarUmInscritoRecebeMensagem1(){
        System.out.println("PRIMEIRO TESTE - RESULTADO ESPERADO: PASSAR");
        
        //configurar o contexto no qual nosso teste será executado.
        
        //criação do mock Inscrito, que vai receber a mensagem
        final Inscrito inscrito = context.mock(Inscrito.class);
        
        //registro do inscrito na lista do publicador 
        Publicador publicador = new Publicador();
        publicador.addInscrito(inscrito);
        
        //criação do objeto mensagem, para publicação
        final String messagem = "Teste 1";
       
         //expectativas do mock Inscrito, que especifica os métodos esperados 
         //pra serem chamados durante a execução do teste
        context.checking(new Expectations() {{
            oneOf (inscrito).receberMensagem(messagem);
        }});
        
        //executar o código que queremos testar
        publicador.publicar(messagem);
       
        //verificar se o mock Inscrito foi chamado como esperado.
        context.assertIsSatisfied();
    }
    
    @Test
    public void testarUmInscritoRecebeMensagem2(){
        System.out.println("SEGUNDO TESTE - RESULTADO ESPERADO: NÃO PASSAR");
        
        //configurar o contexto no qual nosso teste será executado.
        
        //criação do mock Inscrito, que vai receber a mensagem
        final Inscrito inscrito = context.mock(Inscrito.class);
        
        //registro do inscrito na lista do publicador 
        Publicador publicador = new Publicador();
        publicador.addInscrito(inscrito);
        
        //criação do objeto mensagem, para publicação
        final String messagem = "Teste 1";
       
         //expectativas do mock Inscrito, que especifica os métodos esperados 
         //pra serem chamados durante a execução do teste
        context.checking(new Expectations() {{
            oneOf (inscrito).receberMensagem(messagem);
        }});
        
        //o método publicarMensagem não chama a mensagem receberMensagem.
        publicador.publicarMensagem(messagem);
       
        //verificar se o mock Inscrito foi chamado como esperado.
        context.assertIsSatisfied();
    }
    
    @Test
    public void testarUmInscritoRecebeDuasMensagens1(){
        System.out.println("TERCEIRO TESTE -  RESULTADO ESPERADO: PASSAR");
       //configurar o contexto no qual nosso teste será executado.
        
        //criação do mock Inscrito, que vai receber a mensagem
        final Inscrito inscrito = context.mock(Inscrito.class);
        
        //registro do inscrito na lista do publicador 
        Publicador publicador = new Publicador();
        publicador.addInscrito(inscrito);
        
        //criação do objetos mensagem1 e mensagem2, para publicação
        final String messagem1 = "Teste 1";
        final String messagem2 = "Teste 2";
       
         //expectativas do mock Inscrito, que especifica os métodos esperados 
         //pra serem chamados durante a execução do teste
         //esperamos que o método receberMensagem seja chamado
        context.checking(new Expectations() {{
            //nessa versão, esperarmos receber as duas mensagens diferentes
            oneOf (inscrito).receberMensagem(messagem1);
            oneOf (inscrito).receberMensagem(messagem2);
        }});
        
        //executar o código que queremos testar
        publicador.publicar(messagem1);
        publicador.publicar(messagem2);
       
        //verificar se o mock Inscrito foi chamado como esperado.
        context.assertIsSatisfied();
    }
    
    @Test
   public void testarUmInscritoRecebeDuasMensagens2(){
        System.out.println("QUARTO TESTE -  RESULTADO ESPERADO: NÃO PASSAR");
       //configurar o contexto no qual nosso teste será executado.
        
        //criação do mock Inscrito, que vai receber a mensagem
        final Inscrito inscrito = context.mock(Inscrito.class);
        
        //registro do inscrito na lista do publicador 
        Publicador publicador = new Publicador();
        publicador.addInscrito(inscrito);
        
        //criação do objetos mensagem1 e mensagem2, para publicação
        final String messagem1 = "Teste 1";
        final String messagem2 = "Teste 2";
       
         //expectativas do mock Inscrito, que especifica os métodos esperados 
         //pra serem chamados durante a execução do teste
         //esperamos que o método receberMensagem seja chamado
        context.checking(new Expectations() {{
            //nesta versão esperamos receber apenas uma mensagem
            oneOf (inscrito).receberMensagem(messagem1);
            //oneOf (inscrito).receberMensagem(messagem2);
        }});
        
        //executar o código que queremos testar
        publicador.publicar(messagem1);
        publicador.publicar(messagem2);
       
        //verificar se o mock Inscrito foi chamado como esperado.
        context.assertIsSatisfied();
    }
}
