package manager;

import model.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginDataCls(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"bunny@mail.com", "Bunny12345$"});
        list.add(new Object[]{"bunny1@mail.com", "Bunny12345$"});
        list.add(new Object[]{"bunny@mail.com", "Bunny12345$"});

        return list.listIterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataUser(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{User.builder().email("bunny@mail.com").password("Bunny12345$").build()});
        list.add(new Object[]{User.builder().email("bunny1@mail.com").password("Bunny12345$").build()});
        list.add(new Object[]{User.builder().email("bunny@mail.com").password("Bunny12345$").build()});


        return list.listIterator();

    }

    @DataProvider
    public Iterator<Object[]> loginDataUserFromFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/test/resources/Data.csv")));
        String line = bufferedReader.readLine();
        while(line != null){
            String[] split = line.split(","); //разрезай по запятой. [0]email [1]password
            list.add(new Object[]{User.builder().email(split[0]).password(split[1]).build()});
            line = bufferedReader.readLine();
        }

        return list.listIterator();
    }
}
