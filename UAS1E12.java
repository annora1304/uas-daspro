import java.util.Scanner;
public class UAS1E12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlahTim = 0;
        String[] namaTim = new String[10]; 
        int[][] skor = new int[10][2]; 

        int pilihanMenu;

        do {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Tambahkan Data Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihanMenu = sc.nextInt();
            sc.nextLine(); 

            switch (pilihanMenu) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        if (jumlahTim < 10) { 
                            System.out.print("Masukkan nama tim ke-" + (jumlahTim + 1) + ": ");
                            namaTim[jumlahTim] = sc.nextLine();

                            System.out.print("Masukkan skor " + namaTim[jumlahTim] + " untuk level 1: ");
                            skor[jumlahTim][0] = sc.nextInt();

                            System.out.print("Masukkan skor " + namaTim[jumlahTim] + " untuk level 2: ");
                            skor[jumlahTim][1] = sc.nextInt();
                            sc.nextLine(); 

                            jumlahTim++; 
                        } else {
                            System.out.println("Jumlah tim sudah mencapai batas maksimum.");
                            break; 
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nTabel Skor Turnamen");
                    System.out.printf("%-15s %-8s %-8s %-8s\n", "Nama Tim", "Level 1", "Level 2", "Total");
                    for (int i = 0; i < jumlahTim; i++) {
                        int totalSkor = skor[i][0] + skor[i][1];
                        System.out.printf("%-15s %-8d %-8d %-8d\n", namaTim[i], skor[i][0], skor[i][1], totalSkor);
                    }
                    break;
                case 3:
                    if (jumlahTim > 0) {
                        int juara = 0;
                        int skorMax = skor[0][0] + skor[0][1];
                        for (int i = 1; i < jumlahTim; i++) {
                            int totalSkor = skor[i][0] + skor[i][1];
                            if (totalSkor > skorMax) {
                                juara = i;
                                skorMax = totalSkor;
                            }
                        }
                        System.out.println("Selamat kepada tim " + namaTim[juara]);
                    } else {
                        System.out.println("Belum ada tim yang ditambahkan.");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
            }
        } while (pilihanMenu != 4);

        sc.close(); 
    }
}