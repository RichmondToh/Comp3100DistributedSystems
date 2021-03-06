
import data.Job;
import data.Server;
import scheduler.*;
import java.io.IOException;
import java.util.ArrayList;

public class Client {
    private ClientRepository mRepository;
    private String message;
 

    /**
     * [main]
     * The main function which calls and runs all the other methods
     * resulting in the scheduling of jobs via the specification
     *
     * @param args
     */
    public static void main(String[] args) {
    	System.out.println("=========================================STARTED=======================================");
        ClientRepository repository = new ClientRepository();
        Client client = new Client(repository);
        client.connectToServer();
        client.serverHandshake();
        client.scheduleJobs();
        System.out.println("========================================COMPLETED======================================");
    }

    public Client(ClientRepository repository) {
        mRepository = repository;
    }

    // Calling the connectToServer method from the ClientRepository
    public void connectToServer() {
        try {
            mRepository.connectToServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * [serverHandshake description]
     * Initialising the connection between the client and the server
     * and getting the Auth along with the device name to print
     */
    public void serverHandshake() {
        try {
            mRepository.sendMessage("HELO");
            message = mRepository.readMessage();
            mRepository.sendMessage("AUTH " + System.getProperty("user.name"));
            message = mRepository.readMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * [scheduleJobs]
     * This is the main job scheduling part after handshaking with the server
     * The Client and server will continue to send and receive messages.
     * The Client will continue to listen so long as it doesn't get a "NONE"
     * from the server, which signifies that there are not jobs left.
     *
     * in our code below we have implemented a switch case for all the different
     * types of scenarios or messages the server can send the client so that it
     * can be individually dealt with.
     */
    private void scheduleJobs() {
        try {
            // Sends the first "REDY" to obtain the first job
            mRepository.sendMessage("REDY");
            String[] messageArray = null;

            // If a "NONE" is not recieved from the server it means that there are more jobs to schedule
            while (!mRepository.isNoneReceived) {

                // After the message has been read, we then split it into mutiple parts by placing it in an array
                message = mRepository.readMessage();
                messageArray = message.split(" ");

                switch (messageArray[0]) {
                    case "JOBN": // same as "JOBP"
                    case "JOBP":
                        Job job = new Job(messageArray);
                        mRepository.sendMessage("GETS Capable " + job.GET());
                        
                        message = mRepository.readMessage();
                        int ServerCount = Integer.parseInt(message.split(" ")[1]);
                        mRepository.sendMessage("OK");       
                        
                        //Gets the serverList which are capable of running the Job
                        ArrayList<Server> serverList = mRepository.getCapableServerList(ServerCount);
                        mRepository.sendMessage("OK");
                        message = mRepository.readMessage();
                        
                        //Schedules The Job and uses the "NewAlgorithm" on the list of provided servers to find the optimal Solution 
                        mRepository.sendMessage("SCHD " + job.getJobId() + " " + new NewAlgorithm().getServer(serverList));
                        
                        break;
                    // When server sends a complete message we send a REDY to fetch another job
                    case "JCPL":
                    case "OK":
                        mRepository.sendMessage("REDY");
                        break;
                    default:
                        break;
                }
            }
            quit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void quit() throws IOException {
        // Sends a message to the server to "QUIT"
        mRepository.sendMessage("QUIT");
        message = mRepository.readMessage();
        // Server sends back response to "Quit"
        if (message.equals("QUIT")) {
            // Connection closes
            mRepository.close();
        }
    }
}
