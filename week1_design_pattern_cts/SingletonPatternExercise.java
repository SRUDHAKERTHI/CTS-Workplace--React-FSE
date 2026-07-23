package week1_design_pattern_cts;

public class SingletonPatternExercise {

    static class DatabaseConnection {
        private static DatabaseConnection instance;

        private DatabaseConnection() {
            System.out.println("Database connection created!");
        }

        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        public void query(String sql) {
            System.out.println("Running query: " + sql);
        }
    }

    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        DatabaseConnection conn2 = DatabaseConnection.getInstance();

        conn1.query("SELECT * FROM users");
        conn2.query("SELECT * FROM orders");

        System.out.println("Are conn1 and conn2 the same object? " + (conn1 == conn2));
    }
}
