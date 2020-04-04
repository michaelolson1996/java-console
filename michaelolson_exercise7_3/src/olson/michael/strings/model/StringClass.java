package olson.michael.strings.model;

public class StringClass {
    private String message;

    public StringClass() {}

    public StringClass(String message) {
        this.setMessage(message);
    }

    private String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        validateNotNull(message);
        this.message = message;
    }

    private void validateNotNull(String message) {
        if (message.equals("") || message == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }

    public String serialize() {
        return String.format("%smichael", this.getMessage());
    }

    public void deserialize(String line) {
        this.setMessage(line);
    }
}
