import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);

            System.out.print("Masukkan pembilang: ");
            int pembilang = scanner.nextInt();

            System.out.print("Masukkan penyebut: ");
            int penyebut = scanner.nextInt();

            Kalkulator kalkulator = new Kalkulator();

            double hasil = kalkulator.bagi(pembilang, penyebut);

            System.out.println("Hasil pembagian = " + hasil);

        } catch (ArithmeticException e) {
            System.out.println("Error: Penyebut tidak boleh bernilai 0!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!");

        } finally {
            if (scanner != null) {
                scanner.close();
            }

            System.out.println(
                "Proses kalkulasi selesai dan resource memori telah dibersihkan."
            );
        }
    }
}