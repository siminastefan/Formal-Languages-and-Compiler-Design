import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

         SymbolTable symbolTable = new SymbolTable();
         PIF pif = new PIF();
         Scanner scanner = new Scanner(pif, symbolTable);

         scanner.scan();
         System.out.println(scanner.getTokens());
         System.out.println(symbolTable);
         System.out.println(pif);

    }
}
