package logic;

import entity.CongNhan;
import util.FileUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CongNhanLogic {
    private List<CongNhan> congNhans;

    public CongNhanLogic(List<CongNhan> congNhans) {
        this.congNhans = congNhans;
    }

    public List<CongNhan> getCongNhans() {
        return congNhans;
    }

    public void setCongNhans(List<CongNhan> congNhans) {
        this.congNhans = congNhans;
    }
    public void nhapCongNhan(){
        System.out.println("Nhập số lượng công nhân: ");
        int soLuongCongNhan;
        do {
            try{
                soLuongCongNhan = new Scanner(System.in).nextInt();
                if(soLuongCongNhan > 0){
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        }while (true);
        for (int i = 0; i < soLuongCongNhan; i++) {
            System.out.println("Nhập thông tin công nhân thứ "+(i+1));
            CongNhan congNhan = new CongNhan();
            congNhan.inputInfo();
            saveCongNhan(congNhan);
        }

        FileUtil<CongNhan> congNhanFileUtil = new FileUtil<>();
        congNhanFileUtil.writeDataToFile("Cong-nhan.dat",congNhans);
    }

    private void saveCongNhan(CongNhan congNhan) {
        congNhans.add(congNhan);
    }
    public void hienThiCongNhan(){
        for (CongNhan c:congNhans) {
            System.out.println(c);
        }
    }

    public CongNhan searchById(int maCongNhan) {
        CongNhan congNhan = null;
        for (int i = 0; i < congNhans.size(); i++) {
            if(congNhans.get(i).getMa() == maCongNhan){
                congNhan = congNhans.get(i);
                break;
            }
        }
        return  congNhan;
    }
}
