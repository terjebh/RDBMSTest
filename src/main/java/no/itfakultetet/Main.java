package no.itfakultetet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (args.length == 1) {
            new Postgres(args[0]);
        } else {
            while (true) {
                Scanner in = new Scanner(System.in);
                System.out.print("Tast 1 for Oracle, 2 for PostgreSQL: ");
                String db = in.nextLine();
                System.out.println("Tast inn en SELECT-setning (eller q for å avslutte): ");
                String sql = in.nextLine();
                if (sql.equals("q")) {
                    System.out.println("Farvel...");
                    System.exit(0);
                } else {
                    if (db.equals("1")) {
                        new Oracle(sql);
                    } else if (db.equals("2")) {
                        new Postgres(sql);
                    } else {
                        System.out.println("Tast 1 for Oracle, 2 for PostgreSQL");
                    }
                }

                }
            }

        }
    }