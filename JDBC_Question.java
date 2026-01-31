/* JDBC_Question.java 

Id      Name      Faculty    Semester    GPA
1       Ram       BCA        VI          3.54
2       Sita      BCA        VI          3.49
3       Suraj     BCA        I           3.80
4       Ishwor    BBA        III         3.67

9. Write a JDBC program to retrieve the following data from the MySQL database.
Database Name - StudentDb
Table Name - ResultTable

*/


import java.sql.*; // Import necessary JDBC classes

public class RetrieveStudentData {
    public static void main(String[] args) {
        // Define connection parameters 
        String url = "jdbc:mysql://localhost:3306/StudentDb"; 
        String user = "root";
        String password = "";

        try {
            // Step 1: Register the Driver 
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Step 3: Create Statement object 
            Statement stmt = con.createStatement();

            // Step 4: Execute SQL query to retrieve data 
            String query = "SELECT * FROM ResultTable";
            ResultSet rs = stmt.executeQuery(query);

            // Display Table Headers
            System.out.println("Id | Name | Faculty | Semester | GPA");
            System.out.println("---------------------------------------");

            // Loop through the ResultSet to print each record 
            while (rs.next()) {
                // Fetching values by column index or name 
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                String faculty = rs.getString("Faculty");
                String semester = rs.getString("Semester");
                double gpa = rs.getDouble("GPA");

                System.out.println(id + " | " + name + " | " + faculty + " | " + semester + " | " + gpa);
            }

            // Step 5: Close the connection 
            con.close();

        } catch (Exception e) {
            // Handle any database or driver errors
            System.out.println("Error: " + e);
        }
    }
}