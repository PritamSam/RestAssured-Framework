package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.tesdata.TestData;

public class CSVUtils {
    public static Object[][] getTestData(String filePath) {

        List<TestData> dataList = new ArrayList<>();

        try {

            InputStream inputStream =
                    CSVUtils.class.getClassLoader().getResourceAsStream(filePath);

            if (inputStream == null) {
                throw new RuntimeException("File not found in resources: " + filePath);
            }

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(inputStream));

            String line;

            Map<String, String> map = new HashMap<>();

            // Skip header line: Field Value
            br.readLine();

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] values = line.split(",", 2);

                if (values.length < 2) continue;

                map.put(values[0].trim(), values[1].trim());
            }
            

            TestData data = new TestData();
            
            data.orderId = Integer.parseInt(map.get("OrderId"));
            data.petId = Integer.parseInt(map.get("PetId"));
            data.quantity = Integer.parseInt(map.get("Quantity"));
            data.status = map.get("Status");
            data.complete = Boolean.parseBoolean(map.get("Complete"));

            data.id = Integer.parseInt(map.get("Id"));
            data.username = map.get("Username");
            data.firstName = map.get("FirstName");
            data.lastName = map.get("LastName");
            data.email = map.get("Email");
            data.password = map.get("Password");
            data.phone = map.get("Phone");
            data.userStatus = Integer.parseInt(map.get("UserStatus"));

            dataList.add(data);

        } catch (Exception e) {
            throw new RuntimeException("CSV read failed: " + filePath, e);
        }

        return dataList.stream()
                .map(d -> new Object[]{d})
                .toArray(Object[][]::new);
    }
}

