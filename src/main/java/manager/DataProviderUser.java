package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
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
        list.add(new Object[]{"masha91@gmail.com","MashaM1992!"});
        list.add(new Object[]{"pasha93@gmail.com","PashaM1993!"});

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

    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
       String line =  reader.readLine();//d@gmail.com,DariaM1991!
       while (line !=null ) {
           String[] all = line.split(",");//[d@gmail.com][DariaM1991!]
           list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
           line = reader.readLine();//masha91@gmail.com,MashaM1992!
       }


        return list.iterator();
    }
}
