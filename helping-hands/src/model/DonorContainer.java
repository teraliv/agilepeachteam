package model;

import java.util.HashMap;
import java.util.Map;

public class DonorContainer {

	private static DonorContainer instance = null;
    public final    Map<String, Donor> donors;
    public int      totalDonors;

    static public DonorContainer GetInstance()
    {
    	if(instance == null) {
            instance = new DonorContainer();
         }
         return instance;
    }
    
    protected DonorContainer() {
        this.donors         = new HashMap<>();
        this.totalDonors    = 0;
    }

    public void addDonor(Donor donor) {
        donors.put(donor.userName, donor);
        totalDonors++;
    }
    
    public Donor getDonor(String userName) {
    	return donors.get(userName);
    }

    public boolean isDonor(String username) {
        return donors.containsKey(username);
    }
}
