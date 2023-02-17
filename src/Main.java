import fr.esgi.qmolero.infrastructure.ConsolePrinter;
import fr.esgi.qmolero.infrastructure.LocalFileReader;
import fr.esgi.qmolero.infrastructure.Printer;
import fr.esgi.qmolero.infrastructure.Reader;
import fr.esgi.qmolero.service.CalculService;
import fr.esgi.qmolero.service.LoggedCalculService;
import fr.esgi.qmolero.service.SimpleCalculService;
import fr.esgi.qmolero.usecases.AdditionOperation;
import fr.esgi.qmolero.usecases.MultiplyOperation;
import fr.esgi.qmolero.usecases.Operation;
import fr.esgi.qmolero.usecases.SubtractOperation;

public class Main {
    public static void main(String[] args) {
        Printer consolePrinter = new ConsolePrinter();

        if (args.length < 2) {
            consolePrinter.print("No file path and operations provided");
            return ;
        }

        Reader localFileReader = new LocalFileReader(args[0]);
        Operation operation;
        if (args[1].equals("+")) {
            operation = new AdditionOperation();
        } else if (args[1].equals("-")) {
            operation = new SubtractOperation();
        } else if (args[1].equals("*")) {
            operation = new MultiplyOperation();
        } else {
            consolePrinter.print("Operation not supported");
            return ;
        }

        CalculService calculService;
        if (args.length == 3 && args[2].equals("-log")) {
            calculService = new LoggedCalculService();
        } else {
            calculService = new SimpleCalculService();
        }

        calculService.process(localFileReader.readNumbers(), operation, consolePrinter);
    }
}
