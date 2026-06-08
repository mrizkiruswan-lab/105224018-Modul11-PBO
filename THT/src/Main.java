import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ReservasiTiket reservasi = new ReservasiTiket();
        int pilihan = 0;
        do {
            try {
                System.out.println("\n=======================");
                System.out.println("     JAVA EXPRESS");
                System.out.println("=======================");
                System.out.println("1. Lihat Jadwal");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih Menu : ");

                pilihan = input.nextInt();
                input.nextLine();
                switch (pilihan) {
                    case 1:
                        reservasi.tampilkanJadwal();
                        break;
                    case 2:
                        System.out.print( "Kode Kereta : ");
                        String kode = input.nextLine();
                        System.out.print("NIK : ");
                        String nik = input.nextLine();
                        System.out.print("Nama : ");
                        String nama = input.nextLine();
                        System.out.print("Jumlah Tiket : ");
                        int jumlah = input.nextInt();
                        input.nextLine();
                        reservasi.pesanTiket(kode, nik, nama, jumlah);
                        break;
                    case 3:
                        System.out.println( "Terima kasih telah menggunakan JAVA EXPRESS");
                        break;
                    default:
                        System.out.println("Menu tidak tersedia");
                }
            }
            catch (InputMismatchException e) {
                System.out.println( "Input harus berupa angka!");
                input.nextLine(); 
            }
            catch (DataPenumpangTidakValidException e) {
                System.out.println("Error Data Penumpang : " + e.getMessage());
            }
            catch (RuteTidakDitemukanException e) {
                System.out.println("Error : " + e.getMessage());
            }
            catch (TiketHabisException e) {
                System.out.println( "Tiket tidak mencukupi!");
                System.out.println("Kereta : " + e.getNamaKereta());
                System.out.println("Sisa Kursi : " + e.getSisaKursi());
            }
            finally {
                System.out.println("\n[ Sistem siap menerima input berikutnya ]");
            }
        } while (pilihan != 3);
        input.close();
    }
}