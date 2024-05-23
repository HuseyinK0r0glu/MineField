import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("mayın tarlası oyununa hoşgeldiniz");
        System.out.println("lütfen oynamak istediğiniz boyutları giriniz:");
        System.out.println("satır sayısı:");
        int row = scan.nextInt();
        System.out.println("sütun sayısı:");
        int column = scan.nextInt();
        MayinTarlasi mayin = new MayinTarlasi(row,column);
        mayin.run();

    }
}