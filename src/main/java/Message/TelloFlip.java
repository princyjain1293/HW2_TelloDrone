package Message;

public enum TelloFlip {
    l,
    r,
    f,
    bl,
    br,
    fl,
    fr;

    public static final boolean contains(String s) {
        try {
            TelloFlip.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
