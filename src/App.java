import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // list of poi (NewPOI.json)
        List<POI> pois = POIGsonFileLoader.load("NewPOI.json");
        pois.forEach(System.out::println);
        
        // category & hashtag decorator (used in POIGsonFileLoader.loadAsDecorated method)
        List<IPOI> decoratedBase = POIGsonFileLoader.loadAsDecorated("NewPOI.json");
        System.out.println("\n\n== Base decorated (from JSON) ==");
        decoratedBase.forEach(d -> System.out.println(" - " + d.getInformation()));

        Location[] path = new Location[] {
            new Location(37.5779, 126.9760),
            new Location(37.5784, 126.9766),
            new Location(37.5789, 126.9772),
            new Location(37.5795, 126.9787),
            new Location(37.5797, 126.9794),
            new Location(37.5800, 126.9800)
        };

        System.out.println("\n\n== Along path ==");
        
        for (Location cur : path) {
            System.out.printf("\n-- step @ (%.5f, %.5f)%n",
            cur.getLat(), cur.getLon());
            
            for (IPOI baseChain : decoratedBase) {
                // distance & proximity 데코레이터 적용해서 출력
                baseChain = new DistanceDecorator(baseChain, cur);
                baseChain = new ProximityPOIDecorator(baseChain, cur, 300);

                System.out.println(baseChain.getInformation());
            }
        }

        // yourcode : 대문자 데코레이터
        System.out.println("\n\n== UpperCaseDecorator ==");
        System.out.println(new UpperCaseDecorator(decoratedBase.get(0)).getInformation());
        // 참고로 후에 추가한 데코레이터는 for문 안에서만 한거라서 읽어올 때 적용한 두 개만 보인다. 

        System.out.println("\n\n== After unWrap ==");
        
        for (IPOI poi : decoratedBase){
            System.out.println(POIDecorator.unWrap(poi)); // 사실 얘도 두 개만 벗기는 셈이다.
        }
    }
}