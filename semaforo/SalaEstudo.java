package semaforo;
import java.util.concurrent.Semaphore;

public class SalaEstudo {

    private Semaphore semaforo = new Semaphore(1);

    public void estudarComSemaforo(){
        try {
            semaforo.acquire();
            System.out.println("Aluno " + Thread.currentThread().getName() + " entrou na sala e está estudando!");
        }
        catch(InterruptedException e){

        } finally {
            System.out.println("Aluno " + Thread.currentThread().getName() + " terminou de estudar e saiu da sala!");
            semaforo.release();
        }
    
    }

    public void estudarSemSemaforo(){
        System.out.println("Aluno " + Thread.currentThread().getName() + " entrou na sala e está estudando!");
        System.out.println("Aluno " + Thread.currentThread().getName() + " terminou de estudar e saiu da sala!");
    }

}