package cs108;

import java.util.List;
import java.util.function.IntBinaryOperator;

public final class Cell extends AbstractSubject implements Observer {
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
        if(newValue != value){
            value = newValue;
            onChange();
        }
    }

    public String getFormulaString() {
        return contentString;
    }

    public void setFormula(String newContentString, List<Cell> newArguments, IntBinaryOperator newOperator) {
        for (Cell arguments : arguments) {
            arguments.removeObserver(this);
        }
        contentString = newContentString;
        arguments = newArguments;
        operator = newOperator;
        System.out.println(arguments);
        for (Cell arguments : arguments) {
            arguments.addObserver(this);
        }
        update();
    }

    @Override
    public void update() {
        setValue(
            arguments.size() == 0
            ? Integer.parseInt(contentString)
            : operator.applyAsInt(
                arguments.get(0).getValue(),
                arguments.get(1).getValue()
            )
        );
    }
}
