
package coffeeshop;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TeaConsumerProducer {
    Random r = new Random();
    boolean isProduced = false;
    int theValue;
    
    public synchronized void produce(){
    if(isProduced){
        try {
            this.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(TeaConsumerProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    theValue = r.nextInt(10);
    System.out.println("Produced: " + theValue);
    isProduced = true;
    this.notify();
    }
    
    public synchronized void consume(){
    if(!isProduced){
        try {
            this.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(TeaConsumerProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    System.out.println("Consumed: " + theValue);
    isProduced = false;
    this.notify();
    
    
    }
}
