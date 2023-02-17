package fr.esgi.qmolero.usecases;

public class AdditionOperation implements Operation {
    @Override
    public int compute(int a, int b) {
        return a + b;
    }

    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public String getFullName() {
        return "addition";
    }
}
