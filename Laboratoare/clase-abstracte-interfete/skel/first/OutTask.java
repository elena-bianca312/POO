package first;

public class OutTask implements Task{

    private String message;

    public OutTask(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void execute() {
        System.out.println(message);
    }

}
