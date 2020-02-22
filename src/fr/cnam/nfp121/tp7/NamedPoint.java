package fr.cnam.nfp121.tp7;


public class NamedPoint extends Point {

    protected String name;

    public NamedPoint(double a_x, double a_y, String a_name) {

        super(a_x, a_y);
        this.name = a_name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isEqual(NamedPoint a_np) {
        return (super.isEqual(a_np) && this.name.equals(a_np.getName()));
    }

    @Override
    public boolean isEqual(Point a_p) {
        if (a_p instanceof NamedPoint) {
            return this.isEqual((NamedPoint) a_p);
        } else {
            return false;
        }
    }

}
