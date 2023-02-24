package constant;

public enum NhomHang {
    DIEN_TU("Điện tử"),
    DIEN_LANH("Điện lạnh"),
    MAY_TINH("Máy tính"),
    THIET_BI_VAN_PHONG("Thiết bị văn phòng");
    private String value;

    NhomHang(String value) {
        this.value = value;
    }
}
