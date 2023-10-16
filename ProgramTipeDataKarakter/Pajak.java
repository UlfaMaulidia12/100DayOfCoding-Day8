package ProgramTipeDataKarakter;

import java.util.Scanner;

public class Pajak {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char ulangi;
        int percobaan = 0;

        do {
            System.out.println("=== Program Jenis Kelamin ===");

            char jenisKelamin = getGenderInput("Masukkan Jenis Kelamin Anda (L/P): ");

            System.out.println("======================================="); // Garis pemisah

            if (jenisKelamin == 'L' || jenisKelamin == 'l') {
                System.out.println("Anda adalah seorang Laki-laki.");
            } else if (jenisKelamin == 'P' || jenisKelamin == 'p') {
                System.out.println("Anda adalah seorang Perempuan.");
            } else {
                System.out.println("Jenis kelamin tidak valid. Silakan masukkan 'L' atau 'P'.");
                percobaan++;
            }

            if (percobaan >= 3) {
                System.out.println("Anda telah mencoba sebanyak 3 kali. Keluar dari program.");
                break;
            }

            System.out.println("======================================="); // Garis pemisah

            ulangi = getYesNoInput("Ingin memasukkan jenis kelamin lagi? (Y/N): ");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
    }

    private static char getGenderInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        char jenisKelamin = input.next().charAt(0);
        return jenisKelamin;
    }

    private static char getYesNoInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        char response = input.next().charAt(0);
        return response;
    }
}
