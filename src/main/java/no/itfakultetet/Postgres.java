package no.itfakultetet;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class Postgres {

    public Postgres(String query) {

        String url = "jdbc:postgresql://noderia.com/hr?user=kurs&password=kurs123&ssl=false";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.printf("%-2s \t","#");
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                try {
                    System.out.printf("%20s", rsmd.getColumnName(i) + "\t");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            System.out.println("\n" + "-".repeat((rsmd.getColumnCount()+1) * 20 + 3));

            while (rs.next()) {
               System.out.printf("%2s", rs.getRow() + "\t");
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.printf("%20s", rs.getObject(i));
                }
                System.out.println();

            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

