package logic;

import entity.CongNhan;
import entity.XuongSanXuat;
import util.FileUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class XuongLogic {
    private List<XuongSanXuat> xuongSanXuats;

    public XuongLogic(List<XuongSanXuat> xuongSanXuats) {
        this.xuongSanXuats = xuongSanXuats;
    }

    public List<XuongSanXuat> getXuongSanXuats() {
        return xuongSanXuats;
    }

    public void setXuongSanXuats(List<XuongSanXuat> xuongSanXuats) {
        this.xuongSanXuats = xuongSanXuats;
    }

    public void nhapXuong(){
        System.out.println("Nhập số lượng xưởng: ");
        int soLuongXuong;
        do {
            try{
                soLuongXuong = new Scanner(System.in).nextInt();
                if(soLuongXuong > 0){
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        }while (true);
        for (int i = 0; i < soLuongXuong; i++) {
            System.out.println("Nhập thông tin xưởng thứ "+(i+1));
            XuongSanXuat xuongSanXuat = new XuongSanXuat();
            xuongSanXuat.inputInfo();
            saveXuong(xuongSanXuat);
        }

        FileUtil<XuongSanXuat> xuongFileUtil = new FileUtil<>();
        xuongFileUtil.writeDataToFile("Xuong.dat",xuongSanXuats);
    }

    private void saveXuong(XuongSanXuat xuongSanXuat) {
        xuongSanXuats.add(xuongSanXuat);
    }
    public void hienThiXuong(){
        for (XuongSanXuat x:xuongSanXuats) {
            System.out.println(x);
        }
    }

    public XuongSanXuat searchById(int maXuong) {
        XuongSanXuat xuongSanXuat = null;
        for (int i = 0; i < xuongSanXuats.size(); i++) {
            if(xuongSanXuats.get(i).getMa() == maXuong){
                xuongSanXuat = xuongSanXuats.get(i);
                break;
            }
        }
        return xuongSanXuat;
    }
}
