//CSDS 132 YINGYU ZHU

package chess;

public enum ColorValue {
    BLACK("#212121"),
    DARK_GRAY("#BDBDBD"),
    EAST("#F44336"),
    EAST_HIGHLIGHTED("#FF8A80"),
    LIGHT_GRAY("#E0E0E0"),
    NORTH("#4CAF50"),
    NORTH_HIGHLIGHTED("#B9F6CA"),
    SOUTH("#FFC107"),
    SOUTH_HIGHLIGHTED("#FFE57F"),
    WEST("#2196F3"),
    WEST_HIGHLIGHTED("#82B1FF"),
    WHITE("#FAFAFA");

    private final String value;

    ColorValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
