package javaapplication26;

public class JavaApplication26 {

    public static void main(String[] args) {
        /*Runnable theJob = new MyRunnable();
        Thread t = new Thread(theJob);
        t.start();
        System.out.println("back in main");*/
        
        Thread alpha = new Thread(new RunThreads()); 
        Thread beta = new Thread(new RunThreads());
        alpha.setName("alpha"); // Seta o nome do Segmento
        beta.setName("beta");
        alpha.start();
        beta.start();
    }
}

class MyRunnable implements Runnable{
    public void run(){
        go();        
    }
    public void go(){
        try{
            Thread.sleep(2000);            
        }catch (InterruptedException ex){ex.printStackTrace();}
        
        doMore();
    }
    public void doMore(){
        System.out.println("top'o the stack\n");
    }
}

class RunThreads implements Runnable{
    public void run(){
        for (int i = 0; i < 25; i++) {
            String theName = Thread.currentThread().getName();    
            System.out.println("O segmento " + theName + " está sendo executado");
        }        
    }   
}
