public class Main {

    public static void main(String[] args) {
         SymbolTable symbolTable = new SymbolTable();
         System.out.println(symbolTable.pos("a"));
         System.out.println(symbolTable.pos("b"));
         System.out.println(symbolTable.pos("A"));

         System.out.println(symbolTable.pos("+,")); // 43 44 ASCII CODE = 87
         System.out.println(symbolTable.pos("W")); // ASCII CODE 87

        // printed:
//        97=0
//        98=0
//        65=0
//        87=0
//        87=1
    }
}
