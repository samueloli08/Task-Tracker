package aplication;

import java.time.LocalDateTime;

public class TaskComPrazo extends Task {
    private LocalDateTime prazo;

    public TaskComPrazo(String name, String description, LocalDateTime prazo) {
        super(name, description);
        setPrazo(prazo);
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        if (prazo == null) {
            throw new IllegalArgumentException("O prazo não pode ser nulo.");
        }
        this.prazo = prazo;
    }

    @Override
    public String getTipo() {
        return "Com Prazo";
    }

    @Override
    public boolean estaAtrasada() {
        return getStatus() != Status.FEITA && LocalDateTime.now().isAfter(prazo);
    }

    @Override
    protected String detalhesPrazo() {
        return "Prazo: " + prazo.format(FORMATO) + (estaAtrasada() ? "  ** ATRASADA **" : "");
    }
}
