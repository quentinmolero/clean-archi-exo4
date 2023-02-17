package fr.esgi.qmolero.service;

import fr.esgi.qmolero.infrastructure.Printer;
import fr.esgi.qmolero.usecases.Operation;

import java.util.List;

public interface CalculService {
    void process(List<Integer> numbers, Operation operation, Printer printer);
}
