/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Murat
 */
public class Caller extends Thread {
    
    CyclicBarrier waitMessage;
    private Semaphore operators;
    
    Scanner input = new Scanner(System.in);
    PhoneAnswered x = new PhoneAnswered();
 
    public Caller(Semaphore operators, CyclicBarrier waitMessage,
            String name) {
        this.waitMessage = waitMessage;
        this.operators = operators;
        this.setName(name);
        this.start();
    }
 
    @Override
    public void run() {

        // simulate the time required for the phone call (between one and six seconds...
        long duration = ThreadLocalRandom.current().nextLong(1,15);
 
        try {
 
            System.out.println(getName() + " is waiting to speak to the operator...");
 
            waitMessage.await();
            // if you put acquire first and then await the operators are not
            // free and all the customers are not called
            String abc = x.getRandArrayElement();
            
            operators.acquire();
 
            System.out.println(getName()+ " is getting the connection to the operator for the "+ abc);
                        //using TimeUnit enumeration to make the code more readable
            Thread.sleep(TimeUnit.SECONDS.toMillis(duration));
            
            System.out.println("operator is getting the connection to the "+ abc);
                        //using TimeUnit enumeration to make the code more readable
            Thread.sleep(TimeUnit.SECONDS.toMillis(duration));
            
           
            System.out.println(getName() +" is getting the connection to the "+ abc);
                        //using TimeUnit enumeration to make the code more readable
           
            
            Thread.sleep(TimeUnit.SECONDS.toMillis(duration));
            
            System.out.println(getName()+ "´s phone call with the operator ending.");
            operators.release();
            
            System.out.println("Available operators="
                    + operators.availablePermits());
             
        } catch (InterruptedException | BrokenBarrierException e) {
            System.err.println(e);
        } 
    
    }
}
