package ProgramIntegerNumber;

import java.util.Scanner;

public class PajakKode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char ulangi;
        do {
            System.out.println("=== Tax Code Calculator ===");

            // Meminta pengguna untuk memasukkan kode pajak
            int kodePajak1 = getInput("Masukkan Kode Pajak 1 (int): ");
            int kodePajak2 = getInput("Masukkan Kode Pajak 2 (int): ");

            // Meminta pengguna untuk memasukkan persentase pajak
            int persentasePajak1 = getInput("Masukkan Persentase Pajak 1 (int): ");
            int persentasePajak2 = getInput("Masukkan Persentase Pajak 2 (int): ");

            System.out.println("\n=== Hasil Perhitungan Pajak ===");

            // Menampilkan kode pajak
            displayResult("Kode Pajak 1", kodePajak1);
            displayResult("Kode Pajak 2", kodePajak2);

            // Menampilkan persentase pajak
            displayResult("Persentase Pajak 1", persentasePajak1 + "%");
            displayResult("Persentase Pajak 2", persentasePajak2 + "%");

            System.out.print("\nHitung pajak lagi? (Y/N): ");
            ulangi = input.next().charAt(0);
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
    }

    private static int getInput(String message) {
        Scanner input = new Scanner(System.in);
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(message);
                value = input.nextInt();
                valid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
                input.nextLine(); // Bersihkan buffer input
            }
        }
        return value;
    }

    private static void displayResult(String label, Object value) {
        System.out.println(label + ": " + value);
    }
}
