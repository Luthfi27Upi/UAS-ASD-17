import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static ArrayList<BarangRental> daftarKendaraan = new ArrayList<>();
    private static ArrayList<TransaksiRental> daftarTransaksi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inisialisasiKendaraanAwal();

        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Peminjaman Kendaraan");
            System.out.println("3. Tampilkan Seluruh Transaksi");
            System.out.println("4. Urutkan Transaksi Berdasarkan No TNKB");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    tampilkanDaftarKendaraan();
                    break;
                case 2:
                    peminjaman();
                    break;
                case 3:
                    tampilkanSeluruhTransaksi();
                    break;
                case 4:
                    urutkanTransaksiNoTNKB();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    private static void inisialisasiKendaraanAwal() {
        daftarKendaraan.add(new BarangRental(2017, 10000, "S 4567 YV", "Honda Beat", "Motor"));
        daftarKendaraan.add(new BarangRental(2018, 10000, "N 4511 VS", "Honda Vario", "Motor"));
        daftarKendaraan.add(new BarangRental(2022, 30000, "N 1453 AA", "Toyota Yaris", "Mobil"));
        daftarKendaraan.add(new BarangRental(2019, 60000, "AB 4321 A", "Toyota Innova", "Mobil"));
        daftarKendaraan.add(new BarangRental(2021, 25000, "B 1234 AG", "Toyota Avanza", "Mobil"));
    }

    private static void tampilkanDaftarKendaraan() {
        System.out.println("Daftar Kendaraan:");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-15s | %-15s | %-10s | %-15s | %-7s |%n", 
                "No", "No TNKB", "Nama Kendaraan", "Jenis", "Tahun", "Biaya Sewa");
        System.out.println("---------------------------------------------------------------------------------------------------");

        int index = 1;
        for (BarangRental barang : daftarKendaraan) {
            System.out.printf("| %-2d | %-15s | %-15s | %-10s | %-15d | %-10.2f |%n",
                    index, barang.getNoTNKB(), barang.getNamaKendaraan(), 
                    barang.getJenisKendaraan(), barang.getTahun(), barang.getBiayaSewa());
            index++;
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    private static void peminjaman() {
        tampilkanDaftarKendaraan();
        
        System.out.print("Pilih kendaraan yang akan dipinjam (masukkan nomor urut): ");
        int pilihanKendaraan = scanner.nextInt();
        scanner.nextLine(); 

        if (pilihanKendaraan < 1 || pilihanKendaraan > daftarKendaraan.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        BarangRental barangDipilih = daftarKendaraan.get(pilihanKendaraan - 1);

        System.out.print("Masukkan kode transaksi: ");
        int kodeTransaksi = scanner.nextInt();
        System.out.print("Masukkan lama pinjam (hari): ");
        int lamaPinjam = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Masukkan nama peminjam: ");
        String namaPeminjam = scanner.nextLine();

        double totalBiaya = lamaPinjam * barangDipilih.getBiayaSewa();
        TransaksiRental transaksi = new TransaksiRental(kodeTransaksi, lamaPinjam, namaPeminjam, totalBiaya, barangDipilih.getNoTNKB());
        daftarTransaksi.add(transaksi);

        System.out.println("Transaksi berhasil ditambahkan!");
        System.out.println("Detail Transaksi:");
        tampilkanTransaksi(transaksi);
    }

    private static void tampilkanSeluruhTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi.");
        } else {
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.printf("| %-12s | %-10s | %-15s | %-10s | %-15s | %-10s |%n", 
                    "Kode Transaksi", "Lama Pinjam", "Nama Peminjam", "Total Biaya", "No TNKB", "Diskon (%)");
            System.out.println("---------------------------------------------------------------------------------------------------");

            double totalPendapatan = 0;
            for (TransaksiRental transaksi : daftarTransaksi) {
                double biayaAsli = transaksi.getTotalBiaya();
                double diskon = hitungDiskon(transaksi.getLamaPinjam());
                double biayaAkhir = biayaAsli * (1 - diskon);
                totalPendapatan += biayaAkhir;

                tampilkanTransaksi(transaksi, biayaAsli, diskon, biayaAkhir);
            }

            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.printf("Total Pendapatan Hari Ini: %.2f%n", totalPendapatan);
        }
    }

    private static void tampilkanTransaksi(TransaksiRental transaksi) {
        tampilkanTransaksi(transaksi, transaksi.getTotalBiaya(), 0, transaksi.getTotalBiaya());
    }

    private static void tampilkanTransaksi(TransaksiRental transaksi, double biayaAsli, double diskon, double biayaAkhir) {
        System.out.printf("| %-12d | %-10d | %-15s | %-10.2f | %-15s | %-10s |%n", 
                transaksi.getKodeTransaksi(), transaksi.getLamaPinjam(), transaksi.getNamaPeminjam(), 
                biayaAkhir, transaksi.getNoTNKB(), String.format("%.0f", diskon * 100));
    }

    private static double hitungDiskon(int lamaPinjam) {
        if (lamaPinjam > 78) {
            return 0.20; // Diskon 20%
        } else if (lamaPinjam > 48) {
            return 0.10; // Diskon 10%
        } else {
            return 0.0;  // Tidak ada diskon
        }
    }

    private static void urutkanTransaksiNoTNKB() {
        Collections.sort(daftarTransaksi, Comparator.comparing(TransaksiRental::getNoTNKB));
        System.out.println("Transaksi berhasil diurutkan berdasarkan No TNKB!");
    }
}
