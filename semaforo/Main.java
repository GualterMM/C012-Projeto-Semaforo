package semaforo;

import java.util.concurrent.Semaphore;

public class Main {
    SalaEstudo salaEstudo = new SalaEstudo();
    Thread[] threads = new Thread[3];
    Semaphore controleExibicao = new Semaphore(1);

    public static void main(String[] args) {
        Main exemplo = new Main();
        exemplo.startThreads();
    }

    public void startThreads() {

        try{
            controleExibicao.acquire();
            System.out.println("Exemplo de entrada na sala de estudos sem controle");
            for(int i = 0; i < 3; i++) {
                threads[i] = new Thread(new ProcessoSalaEstudoSemControle(salaEstudo));
            }

            for(int j = 0; j < 3; j++) {
                threads[j].start();
            }
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        } finally{
            for(int j = 0; j < 3; j++) {
                try {
                    threads[j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\n");
            controleExibicao.release();
        }
        
        
        try{
            controleExibicao.acquire();
            System.out.println("Exemplo de entrada na sala de estudos com controle (semáforo)");
            for(int i = 0; i < 3; i++) {
                threads[i] = new Thread(new ProcessoSalaEstudo(salaEstudo));
            }

            for(int j = 0; j < 3; j++) {
                threads[j].start();
            }
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        } finally{
            for(int j = 0; j < 3; j++) {
                try {
                    threads[j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            controleExibicao.release();
        }
    }
}