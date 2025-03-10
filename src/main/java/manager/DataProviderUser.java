package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"d@gmail.com","DariaM1991!DariaM1991!"});
        list.add(new Object[]{"d@gmail.com","DariaM1991!"});
        list.add(new Object[]{"d@gmail.com","DariaM1991!"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModel(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("d@gmail.com").setPassword("DariaM1991!")});
        list.add(new Object[]{new User().setEmail("d@gmail.com").setPassword("DariaM1991!")});
        list.add(new Object[]{new User().setEmail("d@gmail.com").setPassword("DariaM1991!")});


        return list.iterator();
    }
}
