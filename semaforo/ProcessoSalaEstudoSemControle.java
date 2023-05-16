package semaforo;

public class ProcessoSalaEstudoSemControle implements Runnable {
    
    private SalaEstudo salaEstudo;

    public ProcessoSalaEstudoSemControle(SalaEstudo s) {
        this.salaEstudo = s;
    }

    @Override
    public void run(){
        System.out.println("O aluno " + Thread.currentThread().getName() + " está pronto para entrar na sala de estudos.");
        salaEstudo.estudarSemSemaforo();
    }
    
}