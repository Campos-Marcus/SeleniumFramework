package marcus_campos.selenium_java_framework.utils;

import marcus_campos.selenium_java_framework.models.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<User> readUsersFromCsv() {

        List<User> users = new ArrayList<>();

        try {
            Reader reader = new InputStreamReader(
                    CsvReader.class.getClassLoader().getResourceAsStream("users.csv"));

            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader);

            for (CSVRecord record : records) {

                users.add(new User(
                        record.get("username"),
                        record.get("password"),
                        Boolean.parseBoolean(record.get("shouldLoginSucceed"))));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
