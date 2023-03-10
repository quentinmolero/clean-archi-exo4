# Remarques sur mon code

J'ai voulu découpé mon code en plusieurs fichiers pour le rendre plus lisible et plus facilement maintenable.
Les interfaces `Printer` et `Reader` permettent d'abstraire mes Input/Output de mon programme. Voir mon package `infrastructure`.

J'ai une interface `Operation` qui me permet d'abstraire mon calcul ainsi que les opérations associées, c'est-à-dire renvoyer le signe et le nom complet de l'operation. Voir mon package `usecases`.

J'ai également un package `service` qui me permet d'avoir deux implémentations, l'une qui fait le calcul demandé et l'autre qui gère les logs.
J'aurais souhaité  travailler plus cette partie, mais c'était difficile dans les temps impartis.

Je pense que mon `LoggedCalculService` a trop de responsabilités, avec plus de temps j'aurais a minima fait une classe pour récupérer le temps et surement géré le logging autrement.


# Instructions  

This program takes a file name as argument and an operation (+, - or *) 
- it parses the file in this file, each line of the file should hopefully have a valid number
- it should take each number and print the operation, along with the intermediary result
- it should print at the end the total result of the defined operation applied to
all numbers found in this file (along with the text name of the operation)

ex:
for a file named `numbers.txt`
```csv
1
2
3
```

and a call to the app with this file and the operation `+` `calc numbers.txt "+"`, it should produce the following result:

```bash
  1
 +2 (=3)
 +3 (=6)
 -------
 total = 6 (addition)
```

The app could be called with an optional 3rd argument `-log`. With this log option, it should show detailled information about it's execution in the exact same model of this one:

```bash
[112330:169804][log] started
[112330:208525][log] applying operation addition
[112330:208734][log] parsed value = 1
1
[112330:208832][log] accumulation : 1 on line 1
[112330:208852][log] parsed value = 2
+2 (= 1)
[112330:208861][log] accumulation : 3 on line 2
[112330:208866][log] parsed value = 3
+3 (= 3)
[112330:208881][log] accumulation : 6 on line 3
--------------
Total = 10
[112330:208889][log] end of program
```

the format for these log lines is:
`[hhmmss:ffffff][log] message`


## Anything else ?

The key points for this exercice will be:

- make it work...first without log, then with the log
- structure your code with clear separation of concerns: your business code should be clearly separated from infratructure code (IO, UI...)
- you should have tests covering your most important business features 
