
class Distance {

    private int feet;
    private float inches;

    public Distance(int feet, float inches) {
        this.feet = feet;
        this.inches = inches;
        normalize();
    }

    private void normalize() {
        if (inches >= 12) {
            feet += (int) inches / 12;
            inches = inches % 12;
        }
    }

    public Distance add(Distance other) {
        int totalFeet = this.feet + other.feet;
        float totalInches = this.inches + other.inches;
        return new Distance(totalFeet, totalInches);
    }

    public boolean isEqualTo(Distance other) {
        return this.toInches() == other.toInches();
    }

    private float toInches() {
        return this.feet * 12 + this.inches;
    }

    public void display() {
        System.out.println(feet + " feet " + inches + " inches");
    }

    public static void main(String[] args) {
        Distance d1 = new Distance(5, 9.5f);
        Distance d2 = new Distance(3, 7.8f);

        System.out.print("Distance 1: ");
        d1.display();
        System.out.print("Distance 2: ");
        d2.display();

        Distance sum = d1.add(d2);
        System.out.print("Sum of distances: ");
        sum.display();

        if (d1.isEqualTo(d2)) {
            System.out.println("Both distances are equal.");
        } else {
            System.out.println("The distances are not equal.");
        }
    }
}
