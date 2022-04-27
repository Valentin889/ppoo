package cs108;

import java.util.List;
import java.util.function.IntBinaryOperator;

public final class Cell {
    private final int column, row;

    private String contentString;
    private List<Cell> arguments;
    private IntBinaryOperator operator;
    private int value;

    public Cell(int column, int row, int initialValue) {
        this.column = column;
        this.row = row;
        this.contentString = String.valueOf(initialValue);
        this.arguments = List.of();
        this.operator = (x, y) -> initialValue;
        this.value = initialValue;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getName() {
        return String.format("%c%d", 'A' + column, row + 1);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value = newValue;
    }

    public String getFormulaString() {
        return contentString;
    }

    public void setFormula(String newContentString, List<Cell> newArguments, IntBinaryOperator newOperator) {
        contentString = newContentString;
        arguments = newArguments;
        operator = newOperator;
    }
}
