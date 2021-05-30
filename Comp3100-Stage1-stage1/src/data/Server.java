package data;

public class Server implements Comparable<Server> {

    private String type;
    private String limit;
    private String bootupTime;
    private String hourlyRate;
    private int coreCount;
    private int memory;
    private int disk;
    
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
    

    // The Setters for the server
    public void setType(String type) {
        this.type = type;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public void setBootupTime(String bootupTime) {
        this.bootupTime = bootupTime;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setDisk(int disk) {
        this.disk = disk;
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
