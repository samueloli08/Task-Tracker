public class Task {
    private String name;
    private String description;
    private String status;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = "to Do";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(int acao) {
        if (acao == 1){
            this.status = "to Do";
        }
        if (acao == 2){
            this.status = "in Progress";
        }
        if (acao == 3){
            this.status = "Done";
        }
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return  name + " - [" + status +']'
                +"\n-> " + description + '\n';
    }
}
