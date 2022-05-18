import java.util.Scanner;

public class atm {

    public static void main(String [] args) {

    Scanner scanner = new Scanner(System.in);

    //! Variables
    String name = "Eray";
    String password = "256";
    boolean atmAccess = false;
    double money = 1000;

    System.out.println("\nATM uygulamasina hos geldiniz!\nDevam etmek icin lutfen giris yapiniz...\n");
    
    System.out.print("ID: ");
    String nameUser = scanner.nextLine();

    System.out.print("PW: ");
    String passwordUser = scanner.nextLine();

    if (Login(nameUser,passwordUser,name,password)){
        System.out.println("\nGiris basarili!\nHesaptaki para: " + money + " TL");
        atmAccess = true;
    }
    
    else {
        System.out.println("\nGiris Reddedildi!\nKulllanici adi veya sifre hatali...");
        atmAccess = false;

    }

    if(atmAccess)  {
        ATM(money);
    }
    else {
        scanner.close();
        return;
    }

    System.out.println("Islemler tamamlandi.");
        
    scanner.close();

    } //! MAIN FONKSIYONU KAPANDI





    //! DIGER FONKSIYONLAR

    public static void ATM (double money)  {     //! ATM Function

        Scanner scanner = new Scanner(System.in);

        int loopTest = 0;

        while(loopTest != 4){

        System.out.println("---------------------------------------------");
        System.out.println("1 - Para Yatır\n"
                          +"2 - Para Çek\n"
                          +"3 - Bakiye Sorgula\n"
                          +"4 - Çıkış\n");

        System.out.print("Islem Sec: ");
        int choose = scanner.nextInt();

        loopTest = choose;

        switch(choose)  {

            case 1: 
                money = Operations(choose, money);
                break;

            case 2:
            if (money != 0){
                money = Operations(choose, money);
                break;
            }
           
            else {
                System.out.println("Gecersiz bakiye ");
            }

            case 3:
                money = Operations(choose, money);
                break;

            case 4:
                System.out.println("Cikis yapiliyor...");
                break;

            default:
                System.out.println("Yanlis tuslama yapildi...");
            }
        }
        scanner.close();
    }

    public static boolean Login (String nameUser, String passwordUser, String name, String password)  { //! Login Function
    
        if ((nameUser.equals(name)) && (passwordUser.equals(password)))  {
            return true;
        }

        else {
            return false;
        }
        
    }




    public static double Operations (int choose, double money) {    //! Operations Function

        if (choose == 1){

            Scanner scanner = new Scanner(System.in);
           /*!*/ scanner.close();

            System.out.print("Miktar: ");
            double tempNumber = scanner.nextDouble();

            double tempMoney = money;

            if (tempNumber >= 0)  {
                money = money + tempNumber;

                System.out.println("Guncel Miktar: " + money + " TL");
    
                return money;
            }

            else {
                System.out.println("Negatif deger girilemez!");
                return tempMoney;
            }

           
        }

        else if (choose == 2)  {

            Scanner scanner = new Scanner(System.in);
            /*!*/ scanner.close();

            System.out.print("Miktar: ");
            double tempNumber = scanner.nextDouble();

            double tempMoney = money;

            if (money >= tempNumber)  {

                money = money - tempNumber;

                System.out.println("Guncel Miktar: " + money + " TL");

                return money;
            }

            else {
                System.out.println("Reddedildi.\nCekilmek istenen miktar, bakiyeden daha yuksek.");
                return tempMoney;
            }

            
        }

        else if (choose == 3)  {
            System.out.println("Guncel Miktar: " + money + " TL");
            return money;
        }

        else if (choose == 4)  {
            return 0;
        }

        else  {
            System.out.println("Yanlis tuslama yapildi...");
            return 0;
        }
    }
}