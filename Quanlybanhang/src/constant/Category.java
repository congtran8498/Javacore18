package constant;

public enum Category {
    QUAN_AO_HE("Quần áo hè"),
    QUAN_AO_THU_DONG("Quần áo thu đông"),
    GIAY("Giày"),
    DEP("Dép"),
    PHU_KIEN("Phụ kiện");
    private String value;

    Category(String value) {
        this.value = value;
    }
}
