package aplication;

public class TaskSimples extends Task {

    public TaskSimples(String name, String description) {
        super(name, description);
    }

    @Override
    public String getTipo() {
        return "Simples";
    }

    @Override
    public boolean estaAtrasada() {
        return false;
    }
}
