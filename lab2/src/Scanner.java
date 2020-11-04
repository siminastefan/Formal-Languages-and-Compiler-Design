import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scanner {

    private final static List<String> reservedWords = Arrays
            .asList("R", "W", "int", "bool", "-", "->");
    private final static List<String> separators = Arrays.asList("[", "]", "{", "}", "(", ")", ",", ":", " ", "\n", ";");
    private final static List<String> operators = Arrays.asList("+", "-", "=", "*", "/", "%", "<", ">", "=<", ">=", "&", "|");

    private SymbolTable symbolTable;
    private PIF pifTable;

    List<String> tokens;

    public List<String> getTokens() {
        return tokens;
    }

    public Scanner(PIF pifTable, SymbolTable symbolTable) {

        this.tokens = new ArrayList<>();

        try {
            String elementsInFile = new String(Files.readAllBytes(Paths.get("E:\\Facultate\\Anul 3\\FLCD\\lab1b-new\\Formal-Languages-and-Compiler-Design\\lab2\\src\\p1.txt")));

            String specialSymbols = new String(Files.readAllBytes(Paths.get("E:\\Facultate\\Anul 3\\FLCD\\lab1b-new\\Formal-Languages-and-Compiler-Design\\lab2\\src\\token.txt")));
            StringTokenizer stringTokenizer = new StringTokenizer(elementsInFile, "+-=*/% <>&|[]{}(),;:RW\n", true);
//            StringTokenizer stringTokenizer = new StringTokenizer(elementsInFile, specialSymbols, true);

            while (stringTokenizer.hasMoreTokens()) {
                this.tokens.add(stringTokenizer.nextToken());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        this.pifTable = pifTable;
        this.symbolTable = symbolTable;
    }

    public void scan() {
        for (int index = 0; index < this.tokens.size(); index++) {

            String token = this.tokens.get(index);

            if (this.isReservedWord(token) == true || this.isOperator(token) == true || this.isSeparator(token) == true) {
                PIFElement element = new PIFElement(token, Map.entry(0, -1));
                this.pifTable.addToPIF(element);
            } else if (this.isIdentifier(token) == true) {
                Map.Entry<Integer, Integer> position = this.symbolTable.pos(token);
                PIFElement element = new PIFElement("1", position);
                this.pifTable.addToPIF(element);
            } else if (this.isConstant(token) == true) {
                Map.Entry<Integer, Integer> position = this.symbolTable.pos(token);
                PIFElement element = new PIFElement("0", position);
                this.pifTable.addToPIF(element);
            } else {
                System.out.println("Lexical error for token = " + token);
            }
        }
    }

    private boolean isConstant(String token) {
        Pattern pattern = Pattern.compile("0 | [1-9][0-9]* | \\+[1-9][0-9]* | -[1-9][0-9]*");
        Matcher matcher = pattern.matcher(token);
        return matcher.matches();
    }

    private boolean isIdentifier(String token) {
//        Pattern pattern = Pattern.compile("[a-bA-Z]* [0-9]{0,1}");
        Pattern pattern = Pattern.compile("[a-zA-Z]+[0-9]?");
        Matcher matcher = pattern.matcher(token);
        return matcher.matches();
    }

    private boolean isSeparator(String token) {
        return separators.contains(token);
    }

    private boolean isOperator(String token) {
        return operators.contains(token);
    }

    private boolean isReservedWord(String token) {
        return reservedWords.contains(token);
    }
}
