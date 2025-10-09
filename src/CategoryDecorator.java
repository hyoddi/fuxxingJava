class CategoryDecorator extends POIDecorator {
    private String category;

    public CategoryDecorator(IPOI poi, String category) {
        super(poi);
        this.category = category;
    }
    
    @Override
    public String getInformation(){
        return decorated.getInformation() + "  category:" + category;
    }
}
