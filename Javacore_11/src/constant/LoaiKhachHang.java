package constant;

public enum LoaiKhachHang {
    CA_NHAN("Cá nhân"),
    TAP_THE("Tập thể"),
    DOANH_NGHIEP("Doanh nghiệp");
    private String value;

    LoaiKhachHang(String value) {
        this.value = value;
    }
}
