package olson.michael.pokemon.model;

import java.time.LocalDate;

public class Pokemon {
    private String name;
    private int level;
    private LocalDate captureDate;

    public Pokemon() {}

    public Pokemon(String name, int level, LocalDate captureDate) {
        this.setName(name);
        this.setLevel(level);
        this.setCaptureDate(captureDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateNotNull(name, "name");
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 0) {
            throw new IllegalArgumentException("Level must be positive");
        }
        this.level = level;
    }

    public LocalDate getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDate captureDate) {
        validateNotNull(captureDate, "captureDate");
        this.captureDate = captureDate;
    }

    private void validateNotNull(Object parm, String name) {
        if (parm == null) {
            throw new IllegalArgumentException(String.format("%s Cannot be null", name));
        }
    }

    public String serialize() {
        return String.format("%s|%d|%s",
                this.getName(), this.getLevel(), this.getCaptureDate());
    }

    public void deserialize(String line) {
        String[] pieces = line.split("\\|");
        this.setName(pieces[0].trim());
        this.setLevel(Integer.parseInt(pieces[1].trim()));
        String[] datePieces = pieces[2].trim().split("-");
        LocalDate ld = LocalDate.of(
                Integer.parseInt(datePieces[0].trim()),
                Integer.parseInt(datePieces[1].trim()),
                Integer.parseInt(datePieces[2].trim())
                );
        this.setCaptureDate(ld);
    }

    @Override
    public String toString() {
        return String.format("%s - %d (%s)", this.getName(), this.getLevel(), this.getCaptureDate());
    }
}