package Controller;

import Database.Db;

public class DbConnection {
    public Db db;

    public DbConnection() {
        db = new Db();
    }
}