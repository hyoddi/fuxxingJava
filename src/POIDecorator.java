abstract class POIDecorator implements IPOI{
    IPOI decorated; // 필드에 장식자를 가지고 있다 (정확히는 참조하고 있다)

    public POIDecorator(IPOI decorated) { 
        this.decorated = decorated;
    }


    @Override
    public Location getLocation() {
        return this.decorated.getLocation();
    }

    // 벗기기
    public static IPOI unWrap(IPOI poi){
        while (poi instanceof POIDecorator) { // POIDecorator가 장식자가 아니게 될 때까지 (다 벗겨져서 poi가 됨)
            poi = ((POIDecorator)poi).decorated; // IPOI 타입에는 decorated가 정의된게 아니니 다운캐스팅해서 접근해야한다..
        }
        return poi;
    }

}
