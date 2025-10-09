abstract class POIDecorator implements IPOI{
    IPOI decorated; // 장식자를 가지고 있는다

    public POIDecorator(IPOI decorated) {
        this.decorated = decorated;
    }


    @Override
    public Location getLocation() {
        return this.decorated.getLocation();
    }

    // 벗기기
    public static IPOI unWrap(IPOI poi){
        while (poi instanceof POIDecorator) { // POIDecorator가 POI 자체일때까지 (다 벗겨질 때까지)
            poi = ((POIDecorator)poi).decorated; // IPOI 타입에는 decorated가 정의된게 아니니 다운캐스팅해서 접근해야한다..
        }
        return poi;
    }
    
}
