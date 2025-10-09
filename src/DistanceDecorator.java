public class DistanceDecorator extends POIDecorator {
    private Location cur;

    public DistanceDecorator(IPOI poi, Location cur) {
        super(poi);
        this.cur = cur;
    }
    
    @Override
    public String getInformation(){
        return decorated.getInformation() + "  howFar:"+ 
        String.format("%.2f", GeoUtil.distanceMeters(super.getLocation(), cur));
    }
}
