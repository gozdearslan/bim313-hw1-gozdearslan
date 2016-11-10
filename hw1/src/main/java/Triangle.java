import java.util.Locale;


public final class Triangle implements Comparable<Triangle> {


    private final City X, Y, Z;

    private final int XY, XZ, YZ;

    public Triangle(City cityX,City cityY, City cityZ) throws NullPointerException, IllegalArgumentException {

        if (cityX == null || cityY == null || cityZ == null) throw new NullPointerException("Cities cannot be null!");

        if (cityX.equals(cityZ) || cityX.equals(cityY) || cityY.equals(cityZ)) throw new IllegalArgumentException("There are same cities in this triangle!");

        X = cityX;
        Y = cityY;
        Z = cityZ;

        XY = TurkishNetwork.getDistance(cityX, cityY);
        XZ = TurkishNetwork.getDistance(cityX, cityZ);
        YZ = TurkishNetwork.getDistance(cityY, cityZ);
    }


    public boolean violates(){
        return  (XZ > XY + YZ) || (XY > XZ + YZ) || (YZ > XY + XZ);
    }


    public boolean contains(City c){
        return c.equals(X) || c.equals(Y) || c.equals(Z);
    }

    public City getX() {
        return X;
    }

    public City getY() {
        return Y;
    }

    public City getZ() {
        return Z;
    }

    public int getXY() {
        return XY;
    }

    public int getXZ() {
        return XZ;
    }

    public int getYZ() {
        return YZ;
    }

    public int compareTo(Triangle o) {

        if (X != o.getX()) return X.compareTo(o.getX());

        if (Y != o.getY()) return Y.compareTo(o.getY());

        return Z.compareTo(o.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (XY != triangle.getXY()) return false;

        if (XZ != triangle.getXZ()) return false;

        if (YZ != triangle.getYZ()) return false;

        if (!X.equals(triangle.getX())) return false;
        if (!Y.equals(triangle.getY())) return false;
        return Z.equals(triangle.getZ());

    }

    @Override
    public int hashCode() {

        int res = X.hashCode();

        res = 31 * res + Y.hashCode();
        res = 31 * res + Z.hashCode();
        res = 31 * res + XY;
        res = 31 * res + XZ;
        res = 31 * res + YZ;

        return res;
    }

    @Override
    public String toString() {
        final Locale l = new Locale("tr", "TR");
        return String.format("%s %s %s %d %d %d %B",
                X.getIl().toUpperCase(l),
                Y.getIl().toUpperCase(l),
                Z.getIl().toUpperCase(l),
                XY, XZ, YZ, violates());
    }

}