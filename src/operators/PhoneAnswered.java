/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Murat
 */
public class PhoneAnswered extends Thread{
   Scanner input = new Scanner(System.in);
    
   private String[] items = new String[]{"Murat","Levent","Ozan","Ahmet","Sena","Fikri","Mahmut","Esra","Miray","Bugra"};
    
   private Random rand = new Random();

   public String getRandArrayElement(){
       return items[rand.nextInt(items.length)];
    }
}
