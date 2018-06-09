package operators;

class Wait implements Runnable {
    
    public Wait() {
        
    }
    @Override
    public void run() {
        System.out.println("All operators are busy !");
    }
}