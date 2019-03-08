import java.util.List;

public class LFU_Cache {

    private ByKey byKey;
    private FrequencyList frequencyList;

    public LFU_Cache() {
        byKey = ByKey.getInstance();
        frequencyList = FrequencyList.getInstance();
    }

    public void addDataReference(String dataReference) {
        byKey.add(dataReference);
    }

    public NodeList findLeastFreqUsed() {
        NodeList leastFreq = null;
        for (NodeList nodeList : frequencyList.getFrequencies()) {
            if (nodeList.containsElement()) {
                if (leastFreq == null || nodeList.getFrequency() < leastFreq.getFrequency()) {
                    leastFreq = nodeList;
                }
            }
        }
        return leastFreq;
    }

    public void removeLeastFreqUsed() {
        findLeastFreqUsed().clearNodeList();
    }
}
