import java.util.Hashtable;
import java.util.Map;

public class ByKey {

    private Map<String, Integer> hashtable;
    private static final ByKey INSTANCE = new ByKey();

    private ByKey() {
        hashtable = new Hashtable<String, Integer>();
    }

    public void add(String str) {
        if (isRefAccountedFor(str)) {
            addExistingReference(str);
        } else {
            addNewReference(str);
        }
    }

    public boolean isRefAccountedFor(String dataReference) {
        return hashtable.containsKey(dataReference);
    }

    public void addNewReference(String dataReference) {
        hashtable.put(dataReference, 1);
        FrequencyList.getInstance().addFrequency(1, dataReference);
    }

    public void addExistingReference(String dataReference) {
        Integer frequency = hashtable.get(dataReference);
        FrequencyList frequencyList = FrequencyList.getInstance();
        hashtable.put(dataReference, frequency + 1);
        frequencyList.getNodeList(frequency).removeReference(dataReference);
        if (frequencyList.hasFrequency(frequency + 1)) {
            frequencyList.getNodeList(frequency + 1).addReference(dataReference);
        } else {
            frequencyList.addFrequency(frequency + 1, dataReference);
        }
    }

    public static ByKey getInstance() {
        return INSTANCE;
    }

    public boolean contains(String dataReference) {
        return hashtable.containsKey(dataReference);
    }
}
