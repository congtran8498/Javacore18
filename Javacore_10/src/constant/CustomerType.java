package constant;

public enum CustomerType {
    CA_NHAN("Cá Nhân"),
    DAI_DIEN_DON_VI_HANH_CHINH("Đại diện đơn vị hành chính"),
    DAI_DIEN_DON_VI_KINH_DOANH("Đại diện đơn vị kinh doanh");
    private String value;

    CustomerType(String value) {
        this.value = value;
    }
}
