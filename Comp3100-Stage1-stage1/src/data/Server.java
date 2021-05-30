package data;

public class Server implements Comparable<Server> {

    private String type;
    private int id;
    private String state;
    private int bootupTime;
    private int coreCount;
    private int memory;
    private int disk;
    private int estimatedWaittime;
    private int estimatedRuntime;
    
    
    //Setting all the Values for the server
    public Server(String type, int id, String state, int bootupTime, int coreCount, int memory, int disk, int estimatedWaittime, int estimatedRuntime) {
        this.type = type;
        this.id = id;
        this.state = state;
        this.bootupTime = bootupTime;
        this.coreCount = coreCount;
        this.memory = memory;
        this.disk = disk;
        this.estimatedWaittime = estimatedWaittime;
        this.estimatedRuntime = estimatedRuntime;
    }
    
    // The Getters for the server
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public String getState() {
        return state;
    }
    public int getbootupTime() {
        return bootupTime;
    }
    public int getCoreCount() {
        return coreCount;
    }
    public int getMemory() {
        return memory;
    }
    public int getDisk() {
        return disk;
    }
    public int getEstimatedWaittime() {
        return estimatedWaittime;
    }
    public int getEstimatedRuntime() {
        return estimatedRuntime;
    }

    @Override
    public int compareTo(Server server) {
        // The order of comparison is : Corecount -> Memory -> Disk space
        int coreComparison = Integer.compare(coreCount, server.coreCount);
        int memoryComparison = Integer.compare(memory, server.memory);
        int diskComparison = Integer.compare(disk, server.disk);
        return coreComparison != 0 ? coreComparison : memoryComparison != 0 ? memoryComparison : diskComparison;
    }

   
}
