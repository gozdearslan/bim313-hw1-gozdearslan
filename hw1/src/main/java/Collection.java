import org.paukov.combinatorics3.Generator;
import java.util.TreeSet;
import java.util.stream.Stream;


public class Collection {


    private final TreeSet<Triangle> triangles;


    public Collection() {
        triangles = new TreeSet<>();

        createTriangles();
    }


    private void createTriangles(){

        final TreeSet<City> cities = new TreeSet<>();


        for (int i = 0; i < TurkishNetwork.cities.length; i++){
            cities.add(new City(TurkishNetwork.getCityCode(TurkishNetwork.cities[i]), TurkishNetwork.cities[i]));
        }


        Generator.combination(cities).simple(3).stream().forEach(list -> {
            triangles.add(new Triangle(list.get(0), list.get(1), list.get(2)));
        });
    }


    public int size(){
        return triangles.size();
    }


    public Stream<Triangle> stream(){
        return triangles.stream();
    }

}