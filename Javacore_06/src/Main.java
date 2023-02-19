import entity.Book;
import entity.BookBorrow;
import entity.BookBorrowDetail;
import entity.Reader;

import java.util.Scanner;

public class Main {
    public static Reader[] readers;
    public static Book[] books;
    public static BookBorrow[] bookBorrows = new BookBorrow[100];

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            showMenuContent();
            logicHandle();
        }
    }

    private static void logicHandle() {
        int functionChoice = chooseFunction();
        switch (functionChoice) {
            case 1:
                inputReader();
                break;
            case 2:
                showReader();
                break;
            case 3:
                inputBook();
                break;
            case 4:
                showBook();
                break;
            case 5:
                borrow();
                break;
            case 6:
                break;
            case 7:
                SearchReader();
                break;
            case 8:
                System.exit(0);
        }
    }

    private static void SearchReader() {
        System.out.println("Nhập tên bạn đọc: ");
        String readerName = new Scanner(System.in).nextLine();
        for (int i = 0; i < bookBorrows.length; i++) {
            if(bookBorrows[i].getReader().getFullName().equalsIgnoreCase(readerName)){
                System.out.println(bookBorrows[i]);
            }
        }
    }

    private static void showBook() {
        if (books == null || books.length == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }

    private static void inputBook() {
        System.out.print("Mời nhập số lượng sách: ");
        int n = new Scanner(System.in).nextInt();
        books = new Book[n];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book();
            books[i].inputInfo();
        }
    }

    private static void borrow() {
        if (readers == null || readers.length == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("Có mấy ông mượn sách: ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            //Xác định bạn đọc muốn mượn
            System.out.println("Nhập mã bạn đọc thứ " + (i + 1) + " muốn mượn sách: ");
            int readerId;
            Reader reader = null;
            do {
                readerId = new Scanner(System.in).nextInt();
                //Tìm kiếm mã bạn đọc có chính xác không (có tồn tại trong mảng readers hay không)
                for (int j = 0; j < readers.length; j++) {
                    if (readers[j].getReaderId() == readerId) {
                        reader = readers[j];
                        break;
                    }
                }
                if (reader != null) {
                    break;
                }
                System.out.println("Nhập mã không đúng, hãy nhập lại.");
            } while (true);
            if (books == null || books.length == 0) {
                System.out.println("Danh sách trống.");
                return;
            }

            //Xác định các cuốn sách mà bạn đọc muốn mượn
            System.out.println("Nhập số lượng đầu sách mà bạn đọc muốn mượn: ");
            int bookQuantity;
            do {
                bookQuantity = new Scanner(System.in).nextInt();
                if (bookQuantity <= 5 && bookQuantity > 0) {
                    break;
                }
                System.out.println("Số lượng không hợp lệ, vui lòng nhập lại.");
            } while (true);

            BookBorrowDetail[] sachMuon = new BookBorrowDetail[bookQuantity];
            for (int j = 0; j < bookQuantity; j++) {
                System.out.println("Cuốn sách thứ " + (j + 1) + " mà bạn đọc muốn mượn có mã là gì: ");
                int bookId;
                Book book = null;
                do {
                    bookId = new Scanner(System.in).nextInt();
                    //Tìm kiếm sách có chính xác không (có tồn tại trong mảng Books hay không)
                    for (int k = 0; k < books.length; k++) {
                        if (books[k].getId() == bookId) {
                            book = books[k];
                            break;
                        }
                    }
                    if (book != null) {
                        break;
                    }
                    System.out.println("Nhập mã không đúng, hãy nhập lại.");
                } while (true);

                System.out.println("Số lượng cuốn muốn mượn ở đầu sách này là: ");
                int temp;
                do {
                    temp = new Scanner(System.in).nextInt();
                    if (temp <= 3 && temp > 0) {
                        break;
                    }
                    System.out.println("Số lượng không hợp lệ, vui lòng nhập lại.");
                } while (true);
                BookBorrowDetail bookBorrowDetail = new BookBorrowDetail(book,temp);
                sachMuon[j] = bookBorrowDetail;
            }
            BookBorrow bookBorrow = new BookBorrow(reader, sachMuon);
            saveBookBorrow(bookBorrow);
            System.out.println(bookBorrow);
        }
    }

    private static void saveBookBorrow(BookBorrow bookBorrow) {
        for (int i = 0; i < bookBorrows.length; i++) {
            if(bookBorrows[i] == null){
                bookBorrows[i] = bookBorrow;
                break;
            }
        }
    }

    private static int chooseFunction() {
        System.out.print("Xin mời chọn chức năng: ");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 8) {
                break;
            }
            System.out.println("Giá trị không hợp lệ, vui lòng nhập lại.");
        } while (true);
        return functionChoice;
    }

    private static void showMenuContent() {
        System.out.println("============== PHẦN MỀM QUẢN LÝ MƯỢN SÁCH THƯ VIỆN =================");
        System.out.println("1. Nhập danh sách bạn đọc mới.");
        System.out.println("2. In ra danh sách bạn đọc");
        System.out.println("3. Nhập danh sách cuốn sách mới.");
        System.out.println("4. In ra danh sách cuốn sách");
        System.out.println("5. Cho mượn sách.");
        System.out.println("6. Sắp xếp danh sách mượn sách.");
        System.out.println("7. Tìm kiếm danh sách mượn sách.");
        System.out.println("8. Thoát.");
        System.out.println("===============================================================");
    }

    private static void showReader() {
        if (readers == null || readers.length == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i]);
        }
    }

    private static void inputReader() {
        System.out.print("Mời nhập số lượng bạn đọc: ");
        int n = new Scanner(System.in).nextInt();
        readers = new Reader[n];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader();
            readers[i].inputInfo();
        }
    }

}
