package org.spreadsheet;
public class Spreadsheet {
    private Cell[][] cells;
    private int rows;
    private int columns;
    Spreadsheet(int rows, int columns) {
        try {
            this.rows = rows;
            this.columns = columns;
            cells = new Cell[rows][columns];
        } catch (Exception e) {
            if (rows < 0 || columns < 0) {
                e.printStackTrace();
            }
        }
    }
    public int getCellsRows() {
        return cells[columns-1].length;
    }
    public int getCellsColumns() {
        return cells[rows-1].length;
    }
    public void setCellAt(int row, int column, Cell cell) {
            cells[row][column] = cell;
    }
    public void setCellValueAt(int row, int column, Cell cell, String value) {
        cell.setValue(value);
        cells[row][column] = cell;
    }
    public Cell getCellAt(int row, int column) {
        return cells[row][column];
    }
    public void addRow(String[] values) {
        Cell[] newRow = new Cell[columns];
        for (int i = 0; i < values.length; ++i) {
            newRow[i] = new Cell(values[i]);
        }
        Cell[][] newCells = new Cell[rows + 1][columns];
        for (int i = 0; i < rows; ++i) {
            newCells[i] = cells[i];
        }
        newCells[rows] = newRow;
        cells = newCells;
        ++rows;
    }
    public void removeRow(int row) {
        Cell[][] newCells = new Cell[rows - 1][columns];
        int newRowIndex = 0;
        for(int i= 0; i < rows; ++i) {
            if(i == row) {
                continue;
            }
            newCells[newRowIndex] = cells[i];
            ++newRowIndex;
        }
        cells = newCells;
        --rows;
    }
    public void addColumn(String[] values) {
        ++columns;
        Cell[] newColumn = new Cell[rows];
        for (int i = 0; i < values.length; ++i) {
            newColumn[i] = new Cell(values[i]);
        }
        Cell[][] newCells = new Cell[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns - 1; ++j) {
                newCells[i][j] = cells[i][j];
            }
            newCells[i][columns-1] = newColumn[i];
        }
        cells = newCells;
    }
    public void removeColumn(int column) {
        --columns;
        int newColumnIndex = 0;
        Cell[][] newCells = new Cell[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j <= columns; ++j) {
                if(j == column) {
                    continue;
                }
                newCells[i][newColumnIndex] = cells[i][j];
                ++newColumnIndex;
            }
            newColumnIndex = 0;
        }
        cells = newCells;
    }
    public void swapRows(int row1, int row2) {
        Cell[] temp = cells[row1];
        cells[row1] = cells[row2];
        cells[row2] = temp;
    }
    public void swapColumns(int column1, int column2) {
        for (int i = 0; i < rows; ++i) {
            Cell[] temp = new Cell[rows];
            temp[i] = cells[i][column1];
            cells[i][column1] = cells[i][column2];
            cells[i][column2] = temp[i];
        }
    }
}
