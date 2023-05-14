package no.itfakultetet;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (args.length == 1) {
            Postgres query = new Postgres(args[0]);
        } else {
            while(true) {
                System.out.println("Tast inn en SELECT-setning (eller q for å avslutte: ");
                Scanner in = new Scanner(System.in);
                String sql = in.nextLine();
                if(sql.equals("q")) {
                    System.out.println("Farvel...");
                    System.exit(0);
                } else {
                    Postgres query = new Postgres(sql);
                }


            }
        }

    }
}