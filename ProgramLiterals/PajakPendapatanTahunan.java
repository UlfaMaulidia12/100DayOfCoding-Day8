package ProgramLiterals;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PajakPendapatanTahunan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char ulangi;
        do {
            System.out.println("=== Kalkulator Pajak Pendapatan Tahunan ===");

            double pendapatanTahunanDecimal = getInputDouble("Masukkan Pendapatan Tahunan (Desimal)\t: $");
            double tarifPajak = getInputDouble("Masukkan Tarif Pajak (Persentase)\t: ");

            System.out.println("======================================="); // Garis pemisah

            // Validasi input
            if (pendapatanTahunanDecimal < 0 || tarifPajak < 0 || tarifPajak > 100) {
                System.out.println("Input tidak valid. Pendapatan harus positif, dan tarif pajak harus dalam rentang 0-100%.");
            } else {
                double tarifPajakDecimal = tarifPajak / 100;

                // Menghitung jumlah pajak
                double jumlahPajakDecimal = calculateTax(pendapatanTahunanDecimal, tarifPajakDecimal);

                // Format tampilan dengan dua angka desimal
                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

                // Menampilkan hasil perhitungan
                System.out.println("Pendapatan Tahunan (Desimal)\t: $" + decimalFormat.format(pendapatanTahunanDecimal));
                System.out.println("Tarif Pajak (Persentase)\t: " + tarifPajak + "%");
                System.out.println("Jumlah Pajak (Desimal)\t: $" + decimalFormat.format(jumlahPajakDecimal));
            }

            System.out.println("======================================="); // Garis pemisah

            ulangi = getYesNoInput("Hitung pajak lagi? (Y/N): ");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
    }

    private static double getInputDouble(String message) {
        Scanner input = new Scanner(System.in);
        double value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(message);
                value = input.nextDouble();
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka desimal yang benar.");
                input.nextLine(); // Bersihkan buffer input
            }
        }
        return value;
    }

    private static double calculateTax(double pendapatan, double tarif) {
        return pendapatan * tarif;
    }

    private static char getYesNoInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        char response = input.next().charAt(0);
        return response;
    }
}
