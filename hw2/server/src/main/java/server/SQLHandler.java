package server;

import java.sql.*;

public class SQLHandler {
    private static Connection connection;
    private static PreparedStatement psGetNickname;
    private static PreparedStatement psRegistration;
    private static PreparedStatement psChangeNikname;

    public static boolean connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            prepareStatements();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     private static void prepareStatements() throws SQLException {
         psGetNickname = connection.prepareStatement("SELECT nickname FROM users WHERE login = ? AND password = ?;");
         psRegistration = connection.prepareStatement("INSERT INTO users(login, password, nickname) SELECT  ? , ?, ?;");
         psChangeNikname = connection.prepareStatement("UPDATE users SET nickname = ? WHERE nickname = ?;");
     }

     public static boolean changeNickname (String oldNick, String newNick) {
         try {
             psChangeNikname.setString(1,newNick);
             psChangeNikname.setString(2,oldNick);
             psChangeNikname.executeUpdate();
             return true;
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }
     }

    public static boolean registration(String login, String password, String nickname) {
        try {
            psRegistration.setString(1, login);
            psRegistration.setString(2, password);
            psRegistration.setString(3, nickname);
            psRegistration.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static String getNicknameByLoginAndPassword(String login, String password) {
        String nickname = null;
        try {
            psGetNickname.setString(1, login);
            psGetNickname.setString(2, password);
            ResultSet rs = psGetNickname.executeQuery();
            while(rs.next()) {
                nickname = rs.getString(1);
            }
            rs.close();


        } catch (SQLException e) {
           e.printStackTrace();
        }
        return nickname;

    }


    public static void disconnect() {
        try {

            psGetNickname.close();
      } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
