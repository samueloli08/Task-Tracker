package aplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private String name;
    private String description;
    private Status status;
    private final LocalDateTime criadaEm;

    protected Task(String name, String description) {
        setName(name);
        setDescription(description);
        this.status = Status.A_FAZER;
        this.criadaEm = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome da tarefa não pode ser vazio.");
        }
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = (description == null) ? "" : description.trim();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("Status inválido.");
        }
        this.status = status;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public abstract String getTipo();
    public abstract boolean estaAtrasada();
    protected String detalhesPrazo() {
        return "";
    }

    @Override
    public String toString() {
        String prazo = detalhesPrazo();
        return name + " - [" + status + "] (" + getTipo() + ")"
                + (prazo.isEmpty() ? "" : "\n   " + prazo)
                + "\n-> " + description + "\n";
    }
}
