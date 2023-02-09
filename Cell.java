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
        int intValue = 0;
        try {
            intValue = Integer.parseInt(value);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return intValue;
    }

    public double toDouble(String value) {
        double doubleValue = 0.0;
        try {
            doubleValue = Double.parseDouble(value);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return doubleValue;
    }

    public LocalDate toDate(String dateString, String dateFormat) {
        DateTimeFormatter formatter = null;
        try {
            formatter = DateTimeFormatter.ofPattern(dateFormat);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return LocalDate.parse(dateString, formatter);
    }
    public void reset(Cell cell) {
        value = null;
    }

}
class Main {
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(2, 2);
        spreadsheet.setCellAt(0, 0, new Cell("A"));
        spreadsheet.setCellAt(0, 1, new Cell("B"));
        spreadsheet.setCellAt(1, 0, new Cell("C"));
        spreadsheet.setCellAt(1, 1, new Cell("D"));
        System.out.println(spreadsheet.getCellAt(0, 0).getValue());
//        spreadsheet.addColumn(new String[]{"0", "9"}, 0);
        spreadsheet.addRow(new String[]{"0","1"}, 0);
        System.out.println(spreadsheet.getCellAt(0, 0).getValue());

    }
}
