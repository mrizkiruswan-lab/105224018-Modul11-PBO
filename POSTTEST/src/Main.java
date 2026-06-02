public class Main {

    public static void main(String[] args) {

        AkunBank rekeningA =
                new AkunBank("123456789", 5000000);

        AkunBank rekeningB =
                new AkunBank("987654321", 3000000);

        try {

            System.out.println("=== TARIK TUNAI ===");

            rekeningA.tarikTunai(2000000);

            rekeningA.tarikTunai(4000000);

            System.out.println("\n=== TRANSFER ===");

            rekeningA.transfer(rekeningB, 11000000);

        }

        catch (SaldoTidakMencukupiException e) {

            System.out.println("Error Saldo: " + e.getMessage());

            System.out.println("Kekurangan saldo: Rp" + e.getKekuranganSaldo());
        }

        catch (BatasTransferHarianException e) {

            System.out.println("Error Transfer: " + e.getMessage());
        }

        finally {

            System.out.println("\nSesi transaksi ATM Anda telah diakhiri. " + "Kartu dikeluarkan otomatis.");
        }
    }
}