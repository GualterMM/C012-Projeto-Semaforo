package semaforo;

public class ProcessoSalaEstudo implements Runnable {
    
    private SalaEstudo salaEstudo;

    public ProcessoSalaEstudo(SalaEstudo s) {
        this.salaEstudo = s;
    }

    @Override
    public void run(){
        System.out.println("O aluno " + Thread.currentThread().getName() + " está pronto para entrar na sala de estudos.");
        salaEstudo.estudarComSemaforo();
    }
}