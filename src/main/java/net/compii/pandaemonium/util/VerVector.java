/*

    Pandaemonium
    VerVector.java
    Gets screen vectors for VersionRender

 */

package net.compii.pandaemonium.util;

public class VerVector {
    private final int x;
    private final int y;

    public VerVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.format("{x: %d, y: %d}", x, y);
    }
}
