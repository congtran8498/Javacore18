package entity;

import constant.ReaderType;

import java.util.Scanner;

public class Reader extends Person{
    private int readerId;
    private ReaderType readerType;
    private static int AUTO_ID = 10000;

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", readerType=" + readerType +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        this.readerId = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập loại bạn đọc: ");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giảng viên");
        int temp;
        do{
            temp = new Scanner(System.in).nextInt();
            if(temp >= 1 && temp <=3){
                break;
            }
            System.out.println("Giá trị không hợp lệ, vui lòng nhập lại.");
        }while (true);
        switch (temp){
            case 1:
                this.readerType = ReaderType.STUDENT;
                break;
            case 2:
                this.readerType = ReaderType.POST_STUDENT;
                break;
            case 3:
                this.readerType = ReaderType.TEACHER;
                break;
        }
    }
}
