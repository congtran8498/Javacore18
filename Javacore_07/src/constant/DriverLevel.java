package constant;

public enum DriverLevel {
    LOAI_A("LOẠI A"),
    LOAI_B("LOẠI B"),
    LOAI_C("LOẠI C"),
    LOAI_D("LOẠI D"),
    LOAI_E("LOẠI E"),
    LOAI_F("LOẠI F");
    public String value;

    DriverLevel(String value) {
        this.value = value;
    }
}
