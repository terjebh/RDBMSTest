package no.itfakultetet;

import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.*;

public class Oracle {
public Oracle (String query) {

        try { OracleDataSource ods = new OracleDataSource();
        String URL = "jdbc:oracle:thin:kurs/kurs123@//itfakultetet.no:1521/FREE";
        ods.setURL(URL);
        Connection conn = ods.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery (query);
        ResultSetMetaData rsmd = rs.getMetaData();

            SQLUtils.writeMetadata(rsmd);
            SQLUtils.writeRecords(rs, rsmd);

            rs.close();
            st.close();

        } catch (
    SQLException e) {
        throw new RuntimeException(e);
    }

}

}
