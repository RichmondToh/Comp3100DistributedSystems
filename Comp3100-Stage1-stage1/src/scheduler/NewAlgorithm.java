package scheduler;

import data.Server;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class NewAlgorithm {
	

    public String getServer(ArrayList<Server> serverList) {
    	
    	  Server optimalServer =  Collections.min(serverList, new Comparator<Server>() {
    		  
	            @Override
	            public int compare(Server S1, Server S2) {
	                 return Integer.compare(S1.getEstimatedWaittime(), S2.getEstimatedWaittime());
	            }
	       });
    	  
    	  return optimalServer.getType()+" "+optimalServer.getId(); 
    	 
    }
}
