public class UpperCaseDecorator extends POIDecorator {

    public UpperCaseDecorator(IPOI poi) {
        super(poi);
    }

    @Override
    public String getInformation() {
        return decorated.getInformation().toUpperCase();
    }
}