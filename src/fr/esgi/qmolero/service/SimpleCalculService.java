package fr.esgi.qmolero.service;

import fr.esgi.qmolero.infrastructure.Printer;
import fr.esgi.qmolero.usecases.Operation;

import java.util.List;

public class SimpleCalculService implements CalculService {
    @Override
    public void process(List<Integer> numbers, Operation operation, Printer printer) {
        int result = numbers.get(0);
        printer.print(String.valueOf(result));
        for (int i = 1; i < numbers.size(); i++) {
            result = operation.compute(result, numbers.get(i));
            printer.print(operation.getSymbol() + numbers.get(i) + "(=" + result + ")");
        }
        printer.print("-------");
        printer.print("total = " + result + "(" + operation.getFullName() + ")");
    }
}
