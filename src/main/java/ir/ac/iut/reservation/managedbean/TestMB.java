package ir.ac.iut.reservation.managedbean;





import ir.ac.iut.reservation.service.TestService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by Alireza on 1/27/2017.
 */

@ManagedBean(name = "testMB")
@ViewScoped
public class TestMB {

    @ManagedProperty("#{testService}")
    private TestService testService;
    private int alireza=10;

    public void insert()
    {
        testService.myService();
        alireza=6;
    }

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public int getAlireza() {
        return alireza;
    }

    public void setAlireza(int alireza) {
        this.alireza = alireza;
    }
}
