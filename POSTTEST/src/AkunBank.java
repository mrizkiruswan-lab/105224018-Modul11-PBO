public class AkunBank {

    private String nomorRekening;
    private double saldo;
    private double totalTransferHariIni;

    private static final double LIMIT_TRANSFER = 10000000;

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHariIni = 0;
    }

    public void tarikTunai(double nominal)
            throws SaldoTidakMencukupiException {

        if (nominal > saldo) {

            double kekurangan = nominal - saldo;

            throw new SaldoTidakMencukupiException("Saldo tidak mencukupi!", kekurangan);
        }

        saldo -= nominal;

        System.out.println("Tarik tunai berhasil Rp" + nominal);
        System.out.println("Sisa saldo: Rp" + saldo);
    }

    public void transfer(AkunBank tujuan, double nominal)
            throws SaldoTidakMencukupiException,BatasTransferHarianException {

        if (nominal > saldo) {

            double kekurangan = nominal - saldo;

            throw new SaldoTidakMencukupiException("Saldo tidak mencukupi untuk transfer!",kekurangan);
        }

        if ((totalTransferHariIni + nominal)
                > LIMIT_TRANSFER) {

            throw new BatasTransferHarianException("Transfer melebihi batas harian Rp10.000.000");
        }

        saldo -= nominal;
        tujuan.saldo += nominal;
        totalTransferHariIni += nominal;

        System.out.println("Transfer berhasil Rp" + nominal);
        System.out.println("Sisa saldo rekening pengirim: Rp" + saldo);
    }
}