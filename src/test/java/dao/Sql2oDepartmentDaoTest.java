package dao;


import models.DatabaseRule;
import models.Departments;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {

    private static Connection conn;
    private static Sql2oDepartmentsDao departmentDao;
    private static Sql2oNewsDao newsDao;
    private static Sql2oUsersDao usersDao;


    @Rule
    public DatabaseRule database = new DatabaseRule();


    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/org_api_test";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "1234");
        departmentDao = new Sql2oDepartmentsDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
    }


    @Test
    public void add() throws Exception{
        Departments testDepartment = setupDepartment();
        int originalDepartmentId = testDepartment.getId();
        departmentDao.add(testDepartment);
        assertNotEquals(originalDepartmentId, testDepartment.getId());

    }

    @Test
    public void addedDepartmentAreReturnedFromGetAll() throws Exception {
        Departments testDepartment = setupDepartment();
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void noDepartmentReturnsEmptyList() throws Exception{
        assertEquals(0, departmentDao.getAll().size());
    }
    //
    @Test
    public void findByIdReturnsCorrectDepartment() throws Exception {
        Departments testDepartment = setupDepartment();
        Departments otherDepartment = setupDepartment();
        assertEquals(testDepartment, departmentDao.findById(testDepartment.getId()));
    }

    @Test
    public void deleteByIdDeletesCorrectDepartments() throws Exception {
        Departments testDepartment = setupDepartment();
        departmentDao.deleteById(testDepartment.getId());
        assertEquals(1, departmentDao.getAll().size());
    }
    //
    @Test
    public void clearAll() throws Exception {
        Departments testDepartment = setupDepartment();
        Departments otherDepartment = setupDepartment();
        departmentDao.clearAll();
        assertEquals(0, departmentDao.getAll().size());
    }

    public Departments setupDepartment (){
        Departments department = new Departments("Marketing","marketing",24);
        departmentDao.add(department);
        return department;
    }

    public Departments setupAltDepartment (){
        Departments department = new Departments("Marketing", "adverts", 12);
        departmentDao.add(department);
        return department;
    }
}