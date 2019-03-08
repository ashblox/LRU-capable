import java.util.LinkedList;
import java.util.List;

public class FrequencyList {

    public List<NodeList> getFrequencies() {
        return frequencies;
    }

    private List<NodeList> frequencies;
    private static final FrequencyList INSTANCE = new FrequencyList();

    private FrequencyList() {
        frequencies = new LinkedList<NodeList>();
    }

    public static FrequencyList getInstance() {
        return INSTANCE;
    }

    public boolean hasFrequency(Integer frequency) {
        boolean hasFrequency = false;
        for(NodeList nodeList : frequencies) {
            if (nodeList.getFrequency() == frequency) {
                hasFrequency = true;
            }
        }
        return hasFrequency;
    }

    public void addFrequency(Integer frequency, String dataReference) {
        if (!hasFrequency(frequency)) {
            NodeList nodeList = new NodeList(frequency);
            nodeList.addReference(dataReference);
            frequencies.add(nodeList);
        } else {
            NodeList nodeList = getNodeList(frequency);
            nodeList.addReference(dataReference);
        }
}

    public NodeList getNodeList(Integer frequency) {
        NodeList requested = null;
        for(NodeList nodeList : frequencies) {
            if (nodeList.getFrequency() == frequency) {
                requested = nodeList;
            }
        }
        return requested;
    }

}
