package aplication;

public enum Status {
    A_FAZER("A Fazer"),
    EM_PROGRESSO("Em Progresso"),
    FEITA("Feita");

    private final String rotulo;

    Status(String rotulo) {
        this.rotulo = rotulo;
    }
    public String getRotulo() {
        return rotulo;
    }

    public static Status deOpcao(int opcao) {
        return switch (opcao) {
            case 1 -> A_FAZER;
            case 2 -> EM_PROGRESSO;
            case 3 -> FEITA;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return rotulo;
    }
}