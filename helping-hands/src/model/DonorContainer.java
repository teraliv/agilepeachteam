package model;

import java.util.HashMap;
import java.util.Map;

public class DonorContainer {

	private static DonorContainer instance = null;
    public final    Map<String, Donor> donors;
    public int      totalDonors;


    protected DonorContainer() {
        this.donors         = new HashMap<>();
        this.totalDonors    = 0;
    }


    static public DonorContainer getInstance() {
        if(instance == null) {
            instance = new DonorContainer();
        }
        return instance;
    }


    public void addDonor(Donor donor) {
        donors.put(donor.username, donor);
        totalDonors++;
    }
    
    public Donor getDonor(String userName) {
    	return donors.get(userName);
    }

    public Donor getDonorByLogin(String login) {

        for (Donor current : donors.values()) {
            if (current.username.equals(login)) return current;
        }

        return null;
    }

    public boolean isDonor(String username) {
        return donors.containsKey(username);
    }


    public Donor getActiveDonor() {

        for (Donor current : donors.values())
            if (current.activeUser) return current;

        return null;
    }
}
