package org.spreadsheet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSpreadsheet {
    @Test
    public void testSpreadsheetConstructor() {
        Spreadsheet spreadsheet = new Spreadsheet(-1, 5);
    }

    @Test
    public void testSetCellAt() {
        Spreadsheet spreadsheet = new Spreadsheet(2,2);
        Cell cell = new Cell();
        spreadsheet.setCellAt(1, 1, cell);
        spreadsheet.setCellValueAt(1,1, cell,"123");
        Assert.assertEquals("123", spreadsheet.getCellAt(1,1).getValue(), "test value");
        Assert.assertEquals(cell, spreadsheet.getCellAt(1,1), "test cell");
    }
    @Test
    public void testAddRow() {
        Spreadsheet spreadsheet = new Spreadsheet(2,2);
        Cell cell = new Cell();
        spreadsheet.addRow(new String[]{"111", "555",}, 0);
        Assert.assertEquals(spreadsheet.getCellAt(0,0).getValue(), "111", "assert1");
        Assert.assertEquals(spreadsheet.getCellAt(0, 1).getValue(), "555", "assert2");
    }
    @Test
    public void testRemoveRow() {
        Spreadsheet spreadsheet = new Spreadsheet(2,2);
        Cell cell = new Cell();
        spreadsheet.addRow(new String[]{"111", "555"}, 2);
        Assert.assertEquals(spreadsheet.getCellAt(2, 0).getValue(), "111");
        spreadsheet.removeRow(2);
        Assert.assertEquals(spreadsheet.getCellsRows(), 2,  "testRemoveRow");
    }
    @Test
    public void testAddColumn() {
        Spreadsheet spreadsheet = new Spreadsheet(2,2);
        Cell cell = new Cell();
        spreadsheet.addColumn(new String[]{"0", "1"}, 0);
        Assert.assertEquals(spreadsheet.getCellAt(0, 0).getValue(), "0");
    }
    @Test
    public void testRemoveColumn() {
        Spreadsheet spreadsheet = new Spreadsheet(2,2);
        Cell cell = new Cell();
        spreadsheet.addColumn(new String[]{"1111", "2222"}, 0);
        Assert.assertEquals(spreadsheet.getCellsColumns(), 3, "testRemoveColumnBefore");
        spreadsheet.removeColumn(2);
        Assert.assertEquals(spreadsheet.getCellsColumns(), 2, "testRemoveColumnAfter");
    }
    @Test
    public void testSwapRows() {
        Spreadsheet spreadsheet = new Spreadsheet(2,2);
        Cell cell = new Cell();
        spreadsheet.setCellAt(0,0, new Cell("000"));
        spreadsheet.setCellAt(0,1, new Cell("111"));
        spreadsheet.setCellAt(1,0, new Cell("222"));
        spreadsheet.setCellAt(1,1, new Cell("333"));
        spreadsheet.swapRows(0,1);
        Assert.assertEquals(spreadsheet.getCellAt(0,0).getValue(), "222");
    }
    @Test
    public void testSwapColumns() {
        Spreadsheet spreadsheet = new Spreadsheet(2,2);
        Cell cell = new Cell();
        spreadsheet.setCellAt(0,0, new Cell("000"));
        spreadsheet.setCellAt(0,1, new Cell("111"));
        spreadsheet.setCellAt(1,0, new Cell("222"));
        spreadsheet.setCellAt(1,1, new Cell("333"));
        spreadsheet.swapColumns(0,1);
        Assert.assertEquals(spreadsheet.getCellAt(1,0).getValue(), "333");
    }
}
