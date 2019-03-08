import java.util.Map;

public class MainApplication {

    public static void main(String[] args) {
        LFU_Cache lfu_cache = new LFU_Cache();
        lfu_cache.addDataReference("This data location");
        lfu_cache.addDataReference("This data location");
        lfu_cache.addDataReference("Another test location");
        lfu_cache.addDataReference("Another test location");
        lfu_cache.addDataReference("Another test location");
        lfu_cache.addDataReference("this is another new location");
        lfu_cache.addDataReference("and another");
        lfu_cache.addDataReference("this is another new location");
        lfu_cache.addDataReference("and another");
        lfu_cache.addDataReference("more testing");
        lfu_cache.addDataReference("more testing");

        System.out.println(FrequencyList.getInstance().getNodeList(1).getDataReferences());
        System.out.println(FrequencyList.getInstance().getNodeList(2).getDataReferences());
        System.out.println(FrequencyList.getInstance().getNodeList(3).getDataReferences());

        lfu_cache.removeLeastFreqUsed();

        System.out.println(FrequencyList.getInstance().getNodeList(1).getDataReferences());
        System.out.println(FrequencyList.getInstance().getNodeList(2).getDataReferences());
        System.out.println(FrequencyList.getInstance().getNodeList(3).getDataReferences());


    }


}
