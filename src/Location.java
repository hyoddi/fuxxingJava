public class Location {
    public final double lat;
    public final double lon;

    public Location(double lat, double lon) { 
        this.lat = lat; this.lon = lon; 
    }

    public double getLat() {
        return this.lat;
    }


    public double getLon() {
        return this.lon;
    }

    @Override public String toString() { 
        return lat + ", " + lon; 
    }
}
