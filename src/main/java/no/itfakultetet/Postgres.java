package no.itfakultetet;

import java.sql.*;

public class Postgres {

    public Postgres(String query) {

        String url = "jdbc:postgresql://noderia.com/hr?user=kurs&password=kurs123&ssl=false";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            SQLUtils.writeMetadata(rsmd);
            SQLUtils.writeRecords(rs, rsmd);

            rs.close();
            st.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

