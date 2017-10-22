package mars;

enum Heading {
    N(0), E(1), S(2), W(3);

    private final int direction;

    Heading(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    static Heading getHeading(int direction) {

        for (Heading h : Heading.values()) {
            if (h.direction == direction) {
                return h;
            }
        }

        throw new IllegalArgumentException("No Direction corresponding to argument: " + direction);
    }
}
