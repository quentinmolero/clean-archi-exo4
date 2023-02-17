package fr.esgi.qmolero.usecases;

public interface Operation {
    int compute(int a, int b);
    String getSymbol();
    String getFullName();
}
