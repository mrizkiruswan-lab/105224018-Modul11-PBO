import java.util.ArrayList;

public class ReservasiTiket {
    private ArrayList<KeretaApi> daftarKereta;
    public ReservasiTiket() {
        daftarKereta = new ArrayList<>();
        daftarKereta.add( new KeretaApi( "K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add( new KeretaApi( "K02", "Parahyangan", "JKT - BDG", 15));
    }
    public void tampilkanJadwal() {
        System.out.println("\n===== JADWAL KERETA =====");
        for (KeretaApi k : daftarKereta) { System.out.println(k);
        }
    }
    public void pesanTiket(String kodeKereta, String nik, String nama, int jumlahTiket) throws RuteTidakDitemukanException, 
            TiketHabisException {
        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException( "NIK harus 16 digit");
        }
        if (!nik.matches("\\d+")) {
            throw new DataPenumpangTidakValidException( "NIK hanya boleh angka");
        }
        KeretaApi keretaDitemukan = null;
        for (KeretaApi k : daftarKereta) {
            if (k.getKode().equalsIgnoreCase(kodeKereta)) {
                keretaDitemukan = k;
                break;
            }
        }
        if (keretaDitemukan == null) {
            throw new RuteTidakDitemukanException( "Kode kereta tidak ditemukan");
        }
        if (jumlahTiket >
                keretaDitemukan.getSisaKursi()) {

            throw new TiketHabisException( keretaDitemukan.getNama(), keretaDitemukan.getSisaKursi());
        }
        keretaDitemukan.kurangiKursi(jumlahTiket);
        System.out.println("\n=== PEMESANAN BERHASIL ===");
        System.out.println("Nama : " + nama);
        System.out.println("NIK  : " + nik);
        System.out.println("Kereta : " + keretaDitemukan.getNama());
        System.out.println("Jumlah Tiket : " + jumlahTiket);
    }
}