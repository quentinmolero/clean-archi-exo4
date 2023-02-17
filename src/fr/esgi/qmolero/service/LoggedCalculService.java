package fr.esgi.qmolero.service;

import fr.esgi.qmolero.infrastructure.Printer;
import fr.esgi.qmolero.usecases.Operation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LoggedCalculService implements CalculService {

    @Override
    public void process(List<Integer> numbers, Operation operation, Printer printer) {
        printer.print(this.wrapInBrackets(this.getFormattedDate()) + "started");
        printer.print(this.wrapInBrackets(this.getFormattedDate()) + "applying operation " + operation.getFullName());
        int result = numbers.get(0);
        printer.print(this.wrapInBrackets(this.getFormattedDate()) + "parsed value = " + result);
        printer.print(String.valueOf(result));
        for (int i = 1; i < numbers.size(); i++) {
            printer.print(this.wrapInBrackets(this.getFormattedDate()) + "accumulation : " + result + " on line " + i + 1);
            printer.print(this.wrapInBrackets(this.getFormattedDate()) + "parsed value = " + numbers.get(i));
            result = operation.compute(result, numbers.get(i));
            printer.print(operation.getSymbol() + numbers.get(i) + "(=" + result + ")");
        }
        printer.print("-------");
        printer.print("Total = " + result);
        printer.print(this.wrapInBrackets(this.getFormattedDate()) + "end of program");
    }

    private String getFormattedDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss:SSSSSS"));
    }

    private String wrapInBrackets(String text) {
        return "[" + text + "][log] ";
    }
}
