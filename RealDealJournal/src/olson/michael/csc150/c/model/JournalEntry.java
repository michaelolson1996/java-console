package olson.michael.csc150.c.model;

import java.time.LocalDate;

public class JournalEntry {
    private LocalDate date;
    private String data;

    public JournalEntry() {}

    public JournalEntry(LocalDate date, String data) {
        this.setDate(date);
        this.setData(data);
    }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) {
        validateNotNull(date, "date");
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        validateNotNull(data, "journal.txt entry");
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.data = data;
    }

    public void validateNotNull(Object parm, String name) {
        if (parm == null) {
            throw new IllegalArgumentException(String.format("%s cannot be null", name));
        }
    }

    public String serialize() {
        return String.format("%s|%s",
                this.getDate(), this.getData());
    }

    public void deserialize(String line) {
        String[] pieces = line.split("\\|");
        this.setData(pieces[1].trim());
        String[] datePieces = pieces[0].trim().split("-");
        LocalDate ld = LocalDate.of(
                Integer.parseInt(datePieces[0].trim()),
                Integer.parseInt(datePieces[1].trim()),
                Integer.parseInt(datePieces[2].trim())
        );
        this.setDate(ld);
    }

    @Override
    public String toString() {
        return String.format("%s\r\n%s", this.getDate(), this.getData());
    }
}