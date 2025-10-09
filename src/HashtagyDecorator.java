class HashtagyDecorator extends POIDecorator {
    private String hashtag;

    public HashtagyDecorator(IPOI poi, String hashtag) {
        super(poi);
        this.hashtag = hashtag;
    }
    
    @Override
    public String getInformation(){
        return decorated.getInformation() + "  #"+hashtag;
    }
}
