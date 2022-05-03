package dao;

import db.DBConnection;

import java.sql.*;

public class SQLUtil {
    private static PreparedStatement getPreparedStatement(String sql, Object... params) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject((i + 1), params[i]);
        }
        return pstm;
    }

    public static boolean executeUpdate(String sql,Object... params) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(sql, params).executeUpdate()>0;
    }

    public static ResultSet executeQuery(String sql, Object... params) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(sql, params).executeQuery();
    }
}
