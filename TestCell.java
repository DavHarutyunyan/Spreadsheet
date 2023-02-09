package org.spreadsheet;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.time.LocalDate;

public class TestCell {

    @Test
    public void testSetValue() {
        Cell cell = new Cell();
        cell.setValue("1234");
        Assert.assertEquals("1234", cell.getValue());
    }
    @Test
    public void testToInt() throws ParseException {
        Cell cell = new Cell("123");

        Assert.assertEquals(123, cell.toInt(cell.getValue()));
    }
    @Test
    public void testToDouble() {
        Cell cell = new Cell("1.5");
        Assert.assertEquals(1.5, cell.toDouble(cell.getValue()));
    }
    @Test
    public void testToDate() throws ParseException {
        Cell cell = new Cell("08/02/2023");
        Assert.assertEquals(cell.toDate(cell.getValue(), "dd/MM/yyyy"), LocalDate.parse("2023-02-08"));
    }
    @Test
    public void testReset() {
        Cell cell = new Cell();
        cell.setValue("111");
        cell.reset(cell);
        Assert.assertEquals(cell.getValue(), null);
    }
    @Test
    public void testColor() {
        Cell cell = new Cell();
        cell.setColor(Color.RED);
        Assert.assertEquals(cell.getColor(), Color.RED);
    }
}
