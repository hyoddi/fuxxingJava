public class ProximityPOIDecorator extends POIDecorator {
    private Location cur;
    private double radiusMeter;

    public ProximityPOIDecorator(IPOI poi, Location cur, double radiusMeter) {
        super(poi);
        this.cur = cur;
        this.radiusMeter = radiusMeter;
    }
    
    @Override
    public String getInformation(){
        return decorated.getInformation() + "  isIn:"+ 
        ((GeoUtil.distanceMeters(super.getLocation(), cur) <= radiusMeter) ? "Y" : "N");
    }

}
