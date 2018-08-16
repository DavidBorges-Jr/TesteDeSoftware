/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidborges
 */
public class Publicador {
    private List<Inscrito> inscritos = new ArrayList<>();
    
    public void addInscrito(Inscrito inscrito){
        this.inscritos.add(inscrito);
    }
    
    public void publicar(String mensagem){
        int cont = 0;
        for(Inscrito inscrito:this.inscritos){
            inscrito.receberMensagem(mensagem);
            cont++;
            System.out.println("Mensagem para o inscrito nº "+cont+": "+mensagem);
            
        }
    }
    
     public void publicarMensagem(String mensagem){        
        System.out.println("Mensagem enviada a nenhum inscrito: "+mensagem);
            
    }
    
}
