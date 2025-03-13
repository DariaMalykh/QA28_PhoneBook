package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }

    @DataProvider
        public Iterator<Object[]> contactSuccess () {
            List<Object[]> list = new ArrayList<>();
            list.add(new Object[]{
                    Contact.builder()
                            .name("Bobby").LastName("Stark").address("NY").phone("1235781908").email("stark@gmail.com").description("The best").build()
            });
            list.add(new Object[]{
                    Contact.builder()
                            .name("Poppy").LastName("Stook").address("Akko").phone("828578189098").email("stook@gmail.com").build()
            });
            list.add(new Object[]{
                    Contact.builder()
                            .name("Vally").LastName("Rock").address("Acre").phone("789061235781").email("vally@gmail.com").build()
            });
            list.add(new Object[]{
                    Contact.builder()
                            .name("Good").LastName("Good").address("Good").phone("123576798781").email("good@gmail.com").description("good").build()
            });


            return list.iterator();

        }
    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Bobby").LastName("Stark").address("NY").phone("").email("stark@gmail.com").description("The best").description("wrong phone").build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Poppy").LastName("Stook").address("Akko").phone("8285").email("stook@gmail.com").description("wrong phone").build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Vally").LastName("Rock").address("Acre").phone("789061235781000000").email("vally@gmail.com").description("wrong phone").build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Good").LastName("Good").address("Good").phone("mfmfmfmfm").email("good@gmail.com").description("good").build()
        });


        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] all = line.split(",");
            list.add(new Object[]{
                    Contact.builder()
                            .name(all[0]).LastName(all[1]).address(all[4]).phone(all[3]).email(all[2]).description(all[5]).build()
            });
            line = reader.readLine();
        }


        return list.iterator();
    }

    }

