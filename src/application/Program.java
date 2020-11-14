package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
            st.setInt(1, 2);

            int affectedRows = st.executeUpdate();

            System.out.println("Done! Affected rows: " + affectedRows);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
