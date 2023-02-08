package org.spreadsheet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cell {
    private String value;
    private Color color;

    Cell(String value) {
        this.value = value;
    }

    Cell() {}
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int toInt(String value) {
        int intValue = Integer.parseInt(value);
        return intValue;
    }

    public double toDouble(String value) {
        double doubleValue = Double.parseDouble(value);
        return doubleValue;
    }

    public LocalDate toDate(String dateString, String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDate.parse(dateString, formatter);
    }
    public void reset(Cell cell) {
        value = null;
    }

}
class Main {
    public static void main(String[] args) {
        Cell cell = new Cell("08/02/2023");
        System.out.println(cell.toDate(cell.getValue(), "dd/MM/yyyy"));
    }
}
