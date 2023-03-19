package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IncomeLogic {
    private BuyLogic buyLogic;
    private Date fromDate;
    private Date toDate;
    private String from;
    private String to;
    private double income;

    public IncomeLogic(BuyLogic buyLogic) {
        this.buyLogic = buyLogic;
    }

    public void income(){
        do {
            try {
                System.out.println("Xem từ ngày: ");
                this.from = new Scanner(System.in).nextLine();
                System.out.println("Xem đến ngày: ");
                this.to = new Scanner(System.in).nextLine();
                this.fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(from);
                this.toDate = new SimpleDateFormat("dd/MM/yyyy").parse(to);
                break;
            } catch (ParseException e) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < buyLogic.getBuyListHistory().size(); i++) {
            for (int j = 0; j < buyLogic.getBuyListHistory().get(i).getBuyList().size(); j++) {
                String buyDate = buyLogic.getBuyListHistory().get(i).getBuyList().get(i).getDate();
                Date buyDate1;
                try {
                     buyDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(buyDate);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                if(buyDate1.after(this.fromDate) && buyDate1.before(this.toDate)){
                    income+= buyLogic.getBuyListHistory().get(i).getBuyList().get(j).getPrice();
                }
            }
        }
        System.out.println("Doanh thu từ ngày "+from+" đến ngày "+to+" là: "+income);
    }
}
