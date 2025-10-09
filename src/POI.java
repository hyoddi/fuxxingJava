public class POI implements IPOI{ // 원본 객체(데코레이팅 될 객체)
    public final String name;
    public final Location location;

    // 이름이랑 위치 가지고 있음
    public POI(String name, Location location) {
        this.name = name; 
        this.location = location;
    }

    // toString이랑 똑같긴 하지만..
    @Override
    public String getInformation() {
        return name + " @ (" + location +")"; 
    }

    public Location getLocation() {
        return location;
    }


    @Override
    public String toString(){
        return name + " @ (" + location +")"; 
    }
}