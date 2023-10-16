package ProgramFloatingNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PajakTahunandanBulanan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char ulangi;
        do {
            System.out.println("=== Kalkulator Pajak ===");
            try {
                double pendapatanTahunan = getInput("Masukkan Pendapatan Tahunan (Double)\t: $");
                String jenisPajak = getTaxType();
                double tarifPajak = getTaxRate(jenisPajak);
                double pendapatanBulanan = getInput("Masukkan Pendapatan Bulanan (Double)\t: $");

                double jumlahPajakTahunan = calculateTax(pendapatanTahunan, tarifPajak);
                double jumlahPajakBulanan = calculateTax(pendapatanBulanan, tarifPajak);

                System.out.println("\n=== Hasil Perhitungan Pajak ===");
                displayResult("Pendapatan Tahunan (Double)\t", String.format("$%.2f", pendapatanTahunan));
                displayResult("Jenis Pajak\t\t\t", jenisPajak);
                displayResult("Tarif Pajak (Double)\t\t", String.format("%.2f%%", tarifPajak));
                displayResult("Pajak Tahunan (Double)\t\t", String.format("$%.2f", jumlahPajakTahunan));

                System.out.println();

                displayResult("Pendapatan Bulanan (Double)\t", String.format("$%.2f", pendapatanBulanan));
                displayResult("Jenis Pajak\t\t\t", jenisPajak);
                displayResult("Tarif Pajak (Double)\t\t", String.format("%.2f%%", tarifPajak));
                displayResult("Pajak Bulanan (Double)\t\t", String.format("$%.2f", jumlahPajakBulanan));

                double totalPajak = jumlahPajakTahunan + jumlahPajakBulanan;
                displayResult("Total Pajak\t\t\t", String.format("$%.2f", totalPajak));
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Pastikan Anda memasukkan angka yang benar.");
            }

            ulangi = getYesNoInput("Hitung pajak lagi? (Y/N):");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
    }

    private static double getInput(String message) {
        Scanner input = new Scanner(System.in);
        double value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print(message);
                value = input.nextDouble();
                if (value >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Masukkan angka positif.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Pastikan Anda memasukkan angka yang benar.");
                input.next(); // Clear the invalid input
            }
        }
        return value;
    }

    private static double calculateTax(double pendapatan, double tarif) {
        return pendapatan * (tarif / 100);
    }

    private static void displayResult(String label, String value) {
        System.out.println(label + ": " + value);
    }

    private static char getYesNoInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        String response = input.nextLine().trim();
        if (response.length() > 0) {
            return response.charAt(0);
        }
        return 'N';
    }

    private static String getTaxType() {
        Scanner input = new Scanner(System.in);
        String jenisPajak = "";
        boolean validInput = false;
        do {
            System.out.print("Jenis Pajak (Penghasilan/Properti/Lainnya):\t");
            jenisPajak = input.nextLine();
            if (jenisPajak.equalsIgnoreCase("Penghasilan") || jenisPajak.equalsIgnoreCase("Properti") || jenisPajak.equalsIgnoreCase("Lainnya")) {
                validInput = true;
            } else {
                System.out.println("Pilihan jenis pajak tidak valid. Silakan masukkan opsi yang valid.");
            }
        } while (!validInput);
        return jenisPajak;
    }

    private static double getTaxRate(String jenisPajak) {
        if (jenisPajak.equalsIgnoreCase("Penghasilan")) {
            return 15.0; // Tarif pajak penghasilan
        } else if (jenisPajak.equalsIgnoreCase("Properti")) {
            return 5.0; // Tarif pajak properti
        } else {
            return 10.0; // Tarif pajak default untuk jenis lainnya
        }
    }
}
