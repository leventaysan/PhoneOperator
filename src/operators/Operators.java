/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Murat
 */
public class Operators {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        Semaphore operators = new Semaphore(2);
         
        CyclicBarrier waitMessage = new CyclicBarrier(2, new Wait());
     
        System.out.println("The call center is ready to answer");
         
        System.out.println("Available operators initially=" + operators.availablePermits() );
        
        
        new Caller(operators,waitMessage,"Veli");
        new Caller(operators,waitMessage,"Ayse");
        new Caller(operators,waitMessage,"Deniz");
        new Caller(operators,waitMessage,"Eren");
        new Caller(operators,waitMessage,"Hasan");
        new Caller(operators,waitMessage,"Erdal");
        new Caller(operators,waitMessage,"Ismail");
        new Caller(operators,waitMessage,"Emine");
        new Caller(operators,waitMessage,"Izel");
        new Caller(operators,waitMessage,"Elif");
    }
    
}
