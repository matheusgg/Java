public class RyanAndMonicaJob implements Runnable{
    private BankAccount account = new BankAccount();
    
    public static void main(String[] args) {
        Thread one = new Thread(new RyanAndMonicaJob());
        Thread two = new Thread(new RyanAndMonicaJob());
        
        one.setName("Ryan");
        two.setName("Monica");
        
        one.start();
        two.start();        
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Estouro!");
            }            
        }
    }
    
    private synchronized void makeWithdrawal(int amount){ // Evita a concorrência entre os segmentos
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " vai fazer uma retirada");
            try{
                System.out.println(Thread.currentThread().getName() + " vai dormir");
                Thread.sleep(500);
            }catch(InterruptedException ex){ex.printStackTrace();}
            System.out.println(Thread.currentThread().getName() + " acordou");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " concluiu a retirada");
        } else{
            System.out.println("Desculpe, não tem o suficiente para " + Thread.currentThread().getName());
        }
     }
}

class BankAccount{
    private int balance = 100;
    public int getBalance(){
        return balance;
    }
    public void withdraw(int amount){
        balance -= amount;
    }
}

/************************** SYNCHRONIZED **********************************/
class Test_Sync{    
    public void go(){
        synchronized(this){ // Utilizado desta maneira, faz com que esta chamada de método seja sincronizada, isto é, apenas um segmento poderá acessá-la de cada vez
            go_text();
        }
    }
    public void go_text(){
        System.out.println("Test");
    }
}
