package scheduler;

import data.Server;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class NewAlgorithm {
	
	/**
	 * [getServer]
	 * 
	 * The is method takes in an ArrayList of Server Objects
	 * the algorithm searches through the whole ArrayList finding the
	 * server with the lowest estimated waiting time. After this value
	 * has been found the method will then return the Server Type and ServerID
	 * in a String format.
	 * 
	 * @param serverList
	 * @return String
	 */
    public String getServer(ArrayList<Server> serverList) {
    	
    	//Iterates through the serverList and finds the server with the lowest estimated waiting time.
    	  Server optimalServer =  Collections.min(serverList, new Comparator<Server>() {
    		  
	            @Override
	            public int compare(Server S1, Server S2) {
	            	//Compares Server1 with Server2 in the list and check which has the lowest estimated waiting time.
	                 return Integer.compare(S1.getEstimatedWaittime(), S2.getEstimatedWaittime());
	            }
	       });
    	  
    	  //returns something like "xlarge 1"
    	  return optimalServer.getType()+" "+optimalServer.getId(); 
    	 
    }
}
