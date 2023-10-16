package ProgramUnderscore;

import java.util.Scanner;

public class Pajak_ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char ulangi;
        do {
            System.out.println("=== Program Angka ===");

            int angka = getInput("Masukkan angka: ");

            System.out.println("======================================="); // Garis pemisah

            if (angka < 0) {
                System.out.println("Angka tidak valid. Masukkan angka positif.");
            } else {
                System.out.println("Angka yang Anda masukkan: " + angka);

                System.out.println("Pilihan operasi matematika:");
                System.out.println("1. Kuadrat");
                System.out.println("2. Akar Kuadrat");
                System.out.print("Pilih operasi (1/2): ");
                int pilihan = input.nextInt();

                if (pilihan == 1) {
                    int kuadrat = calculateSquare(angka);
                    System.out.println("Kuadrat angka: " + kuadrat);
                } else if (pilihan == 2) {
                    double akarKuadrat = calculateSquareRoot(angka);
                    System.out.println("Akar kuadrat angka: " + akarKuadrat);
                } else {
                    System.out.println("Operasi tidak valid. Silakan pilih 1 atau 2.");
                }
            }

            System.out.println("======================================="); // Garis pemisah

            ulangi = getYesNoInput("Ingin memasukkan angka lagi? (Y/N): ");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
    }

    private static int getInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextInt();
    }

    private static int calculateSquare(int angka) {
        return angka * angka;
    }

    private static double calculateSquareRoot(int angka) {
        return Math.sqrt(angka);
    }

    private static char getYesNoInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.next().charAt(0);
    }
}
