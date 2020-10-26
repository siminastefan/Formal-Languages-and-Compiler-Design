import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PIF {

    private List<PIFElement> table;

    public PIF() {
        this.table = new ArrayList<>();
    }

    public void addToPIF(PIFElement pifElement) {
        this.table.add(pifElement);
    }

}
