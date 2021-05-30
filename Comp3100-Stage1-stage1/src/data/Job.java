package data;

public class Job {
    String jobType;
    int submitTime;
    int jobId;
    int estRuntime;
    int core;
    int memory;
    int disk;

    /**
     * Parses all the XML of the job into this class
     * using a string array.
     *
     * @param JobInfo
     */
    public Job(String[] JobInfo) {
        this(
        		JobInfo[0],
                Integer.parseInt(JobInfo[1]),
                Integer.parseInt(JobInfo[2]),
                Integer.parseInt(JobInfo[3]),
                Integer.parseInt(JobInfo[4]),
                Integer.parseInt(JobInfo[5]),
                Integer.parseInt(JobInfo[6])
        );

    }

    /**
     * A parameterized version of parsing the data
     * into the job class, with 7 parameters.
     *
     * @param jobType
     * @param submitTime
     * @param jobId
     * @param estRuntime
     * @param core
     * @param memory
     * @param disk
     */
    public Job(String jobType, int submitTime, int jobId, int estRuntime, int core, int memory, int disk) {
        this.jobType = jobType; 
        this.submitTime = submitTime;
        this.jobId = jobId;
        this.estRuntime = estRuntime;
        this.core = core;
        this.memory = memory;
        this.disk = disk;
    }
    public int getEstRuntime() {
        return estRuntime;
    }

    public int getCore() {
        return core;
    }

    public int getMemory() {
        return memory;
    }

    public int getDisk() {
        return disk;
    }

    public int getJobId() {
        return jobId;
    }

    public String GET() {
        return core + " " + memory + " " + disk;
    }
}
