package data;

import java.util.Arrays;

public class CatColor {

    private final Color head;
    private final Color tail;
    private final Color body;
    private final Color belly;
    private final Color[] legs;

    public CatColor(Color head, Color tail, Color body, Color belly, Color[] legs) {
        this.head = head;
        this.tail = tail;
        this.body = body;
        this.belly = belly;
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "CatColor{" +
                "head=" + head +
                ", tail=" + tail +
                ", body=" + body +
                ", belly=" + belly +
                ", legs=" + Arrays.toString(legs) +
                '}';
    }
}