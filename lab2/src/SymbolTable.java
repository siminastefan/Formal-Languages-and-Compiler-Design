import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private List<List<String>> st;

    public SymbolTable() {
        this.st = new ArrayList<>();
        for (int index = 0; index < 255; index++) {
            this.st.add(new ArrayList<>());
        }
    }

    public Map.Entry<Integer, Integer> pos(String token) {

        int hash = hashFunction(token);
        List<String> values = this.st.get(hash);
        if (values.contains(token) == false) {
            values.add(token);
        }
        return Map.entry(hash, values.indexOf(token));
    }

    public int hashFunction(String token) {
        int sum = 0;

        for (int index = 0 ; index<token.length(); index++) {
            sum += token.charAt(index);
        }
        return sum % 256;
    }
}
