package putRequests;

import java.util.Scanner;

public class Banka {


    public class ATM {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Başlangıç bakiyesi
            double bakiye = 1000.0;

            while (true) {
                System.out.println("********* ATM Sistemine Hoş Geldiniz *********");
                System.out.println("Lütfen bir işlem seçin:");
                System.out.println("1. Bakiye Görüntüle");
                System.out.println("2. Para Yatır");
                System.out.println("3. Para Çek");
                System.out.println("4. Çıkış Yap");
                System.out.print("Seçiminiz: ");
                int secim = scanner.nextInt();

                switch (secim) {
                    case 1:
                        // Bakiye görüntüleme
                        System.out.println("Mevcut Bakiyeniz: " + bakiye + " TL");
                        break;
                    case 2:
                        // Para yatırma
                        System.out.print("Yatırmak istediğiniz tutarı girin: ");
                        double yatirilanMiktar = scanner.nextDouble();
                        if (yatirilanMiktar > 0) {
                            bakiye += yatirilanMiktar;
                            System.out.println("Başarıyla " + yatirilanMiktar + " TL yatırdınız.");
                        } else {
                            System.out.println("Geçersiz bir tutar girdiniz!");
                        }
                        break;
                    case 3:
                        // Para çekme
                        System.out.print("Çekmek istediğiniz tutarı girin: ");
                        double cekilenMiktar = scanner.nextDouble();
                        if (cekilenMiktar > 0 && cekilenMiktar <= bakiye) {
                            bakiye -= cekilenMiktar;
                            System.out.println("Başarıyla " + cekilenMiktar + " TL çektiniz.");
                        } else if (cekilenMiktar > bakiye) {
                            System.out.println("Yetersiz bakiye!");
                        } else {
                            System.out.println("Geçersiz bir tutar girdiniz!");
                        }
                        break;
                    case 4:
                        // Çıkış
                        System.out.println("ATM sisteminden çıkış yapılıyor. İyi günler!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Geçersiz bir seçim yaptınız! Lütfen tekrar deneyin.");
                }

                System.out.println();
            }
        }
    }

}
