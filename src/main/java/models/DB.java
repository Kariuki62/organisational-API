package models;
import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/org_api", "postgres", "1234");
}