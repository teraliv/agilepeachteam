package model;

import java.util.HashMap;
import java.util.Map;

public class DonorContainer {

    public final    Map<String, Donor> donors;
    public int      totalDonors;

    public DonorContainer() {
        this.donors         = new HashMap<>();
        this.totalDonors    = 0;
    }

    public void addDonor(Donor donor) {
        donors.put(donor.name, donor);
        totalDonors++;
    }

    public boolean isDonor(String name) {
        return donors.containsKey(name);
    }
}
