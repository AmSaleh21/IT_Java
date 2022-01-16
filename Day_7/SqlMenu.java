import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class SqlMenu {
    Connection con;
    String[] menuItems = { "1) Select all",
            "2) Insert new",
            "3) update", "4) delete",
            "5) exit" };

    boolean isRunning = true;

    void printMenu() {
        System.out.println("\n");
        for (String item : menuItems) {
            System.out.println(item);
        }
        System.out.println("\n Operation");
    }

    String readUser() { // read the user option
        String userInput = "";
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            userInput = bReader.readLine();
        } catch (IOException io) {
            io.printStackTrace();
            System.out.println("read error");
        }

        return userInput;
    }

    public SqlMenu() {
        try {
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            } catch (SQLException e) {
                System.out.println("Driver failed");
            }
            try {
                /*
                [ph 1] is the database name
                [ph 2] is the user name
                [ph 3] for the password
                */
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/[ph 1]", "[ph 2]", "[ph 3]");
            } catch (SQLException e) {
                System.out.println("con failed");
            }

            System.out.println("Connected Succesfully");
            int option, id;
            String name;
            PreparedStatement preparedStatement;
            ResultSet result;

            while (isRunning) {
                printMenu();
                option = Integer.parseInt(readUser());

                switch (option) {
                    case 1:
                        preparedStatement = con.prepareStatement("SELECT * FROM users");
                        preparedStatement.executeQuery();
                        result = preparedStatement.getResultSet();
                        System.out.println("\n---------------");
                        while (result.next()) {
                            System.out.println(result.getInt("id") + "  " + result.getString("name"));
                        }
                        System.out.println("---------------");
                        result.close();
                        preparedStatement.close();
                        break;
                    case 2:
                        System.out.print("New user name: ");
                        name = readUser();
                        preparedStatement = con.prepareStatement("INSERT INTO users(name) VALUES(?)");
                        preparedStatement.setString(1, name);
                        preparedStatement.executeUpdate();
                        System.out.println(">>added \n\n");
                        preparedStatement.close();
                        break;
                    case 3:
                        System.out.print("User ID: ");
                        id = Integer.parseInt(readUser());
                        System.out.print("Updated User Name: ");
                        name = readUser();
                        preparedStatement = con.prepareStatement("UPDATE users SET name = ? WHERE id = ?");
                        preparedStatement.setString(1, name);
                        preparedStatement.setInt(2, id);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println(">>Updated Successfully.\n\n");
                        break;
                    case 4:
                        System.out.print("User ID: ");
                        id = Integer.parseInt(readUser());
                        preparedStatement = con.prepareStatement("DELETE FROM users WHERE id = ?");
                        preparedStatement.setInt(1, id);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println(">>Deleted Successfully.\n\n");
                        break;
                    case 5:
                        isRunning = false;
                        break;
                    default:
                        System.out.println(">>Negative, select from 1 to 5\n");
                        break;
                }
            }
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("\nException happened in the operation");
        }
    }

    public static void main(String[] args) {
        new SqlMenu();
    }

}
