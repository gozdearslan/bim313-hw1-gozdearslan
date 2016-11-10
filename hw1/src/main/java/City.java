import java.util.Locale;

public final class City implements Comparable<City> {

    private final int c;

    private final String il;

    public City(int num, String name) throws IllegalArgumentException, NullPointerException {

        if (num < 1 || num > 81) throw new IllegalArgumentException("City number is not between 1 and 81.");

        if (name == null) throw new NullPointerException("Name cannot be null!");

        this.il = name.trim().toUpperCase(new Locale("tr", "TR"));

        this.c = num;
    }

    public String getIl(){

        return il;
    }


    public int getC(){

        return c;
    }

    public int compareTo(City o) {
        return new Integer(c).compareTo(o.getC());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (c != city.getC()) return false;

        return il.equals(city.getIl());
    }

    @Override
    public String toString() {

        return getIl();
    }

    @Override
    public int hashCode() {

        int res = il.hashCode();

        res = 31 * res + c;

        return res;
    }
}