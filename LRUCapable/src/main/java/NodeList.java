import java.util.LinkedList;
import java.util.List;

public class NodeList {

    private Integer frequency;

    private List<String> dataReferences;

    public NodeList(Integer frequency) {
        dataReferences = new LinkedList<String>();
        this.frequency = frequency;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public boolean containsElement() {
       return dataReferences.size() != 0;
    }

    public void addReference(String dataReference) {
        dataReferences.add(dataReference);
    }

    public void removeReference(String dataReference) {
        dataReferences.remove(dataReference);
    }

    public List<String> getDataReferences() {
        return dataReferences;
    }

    public void clearNodeList() {
        this.dataReferences = new LinkedList<String>();
    }

}
