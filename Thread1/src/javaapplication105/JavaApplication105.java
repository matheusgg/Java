package javaapplication105;

public class JavaApplication105 {

    public static void main(String[] args) {
        Runnable threadJod = new MyRunnable();        
        Thread myThread = new Thread(threadJod); // Pode ser assim...
        //Thread myThread = new Thread(new MyRunnable()); // Ou assim
        myThread.start();
        System.out.println("Fim do programa.");
    }
}

class MyRunnable implements Runnable{
    public void run(){
        go();
    }
    
    public void go(){
        System.out.println("Funciona!!!");
    }
}


