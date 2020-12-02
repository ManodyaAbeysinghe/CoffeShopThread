
package coffeeshop;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CoffeeShop {

  
    public static void main(String[] args) {
       TeaConsumerProducer pc = new TeaConsumerProducer();
       Thread p = new Thread(new Runnable(){
           @Override
           public void run() {
              for(int i=0; i<10; i++){
              pc.produce();
                  try {
                      Thread.sleep(3000);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(CoffeeShop.class.getName()).log(Level.SEVERE, null, ex);
                  }
              } 
           }
       });
       
       Thread c = new Thread(new Runnable(){
           @Override
           public void run() {
               for(int i=0;i<10;i++){
               pc.consume();
                   try {
                       Thread.sleep(3000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(CoffeeShop.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
       });
        p.start();
        c.start();
    }
    
    
    
    
}
