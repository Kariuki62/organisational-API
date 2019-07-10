package dao;


import models.DatabaseRule;
import models.Departments;
import models.News;

import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class Sql2oNewsDaoTest {
    private static Connection conn;
    private static Sql2oNewsDao newsDao;
    private static Sql2oDepartmentsDao departmentDao;
    private static Sql2oUsersDao usersDao;

    @Rule
    public DatabaseRule database = new DatabaseRule();



    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_api_test";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "1234");
        departmentDao = new Sql2oDepartmentsDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        departmentDao.clearAll();
        usersDao.clearAll();
        newsDao.clearAll();
    }
    @AfterClass
    public static void shutDown() throws Exception { //changed to static
        conn.close();
    }

    public News setupNewNews(){
        return new News("Leave Notice", 1);
    }
    public Departments setupDepartment (){
        return new Departments("Accounts", "Accounting biz", 23);
    }

    public Departments setupAltDepartment (){
        return new Departments ("Accounts", "Accounting biz", 23);
    }
}