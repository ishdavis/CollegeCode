/**
 * Created by Ishdavis on 3/23/2016.
 */
public class Page {
    boolean dBit, rBit;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isrBit() {
        return rBit;
    }

    public void setrBit(boolean rBit) {
        this.rBit = rBit;
    }

    public boolean isdBit() {
        return dBit;
    }

    public void setdBit(boolean dBit) {
        this.dBit = dBit;
    }

    String location;
    
    public Page(){}
    
    public Page(boolean dBit, boolean rBit, String loc){
        this.dBit = dBit;
        this.rBit = rBit;
        this.location = loc;
    }
}
