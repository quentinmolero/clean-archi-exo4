package fr.esgi.qmolero.usecases;

public class SubtractOperation implements Operation {
    @Override
    public int compute(int a, int b) {
        return a - b;
    }

    @Override
    public String getSymbol() {
        return "-";
    }

    @Override
    public String getFullName() {
        return "subtraction";
    }
}
