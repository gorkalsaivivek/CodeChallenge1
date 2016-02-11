/**
 * Created by vivigorkal on 2/11/2016.
 */
import org.apache.commons.collections.map.MultiValueMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class KeyCount {

    public static void main(String[] args) {
        try {
            String fileName = "C://test.txt";
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(new File(fileName));
            ArrayList<String> name = new ArrayList<String>();
            ArrayList<Integer> value = new ArrayList<Integer>();
            Set totalNames = new TreeSet();

            MultiValueMap map = new MultiValueMap();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] completeData = line.split(",");
                if (completeData.length == 2) {
                    value.add(Integer.parseInt(completeData[1]));
                    totalNames.add(completeData[0]);
                    name.add(completeData[0]);
                    map.put(completeData[0], Integer.parseInt(completeData[1]));
                }
            }
            Iterator b = totalNames.iterator();
            while (b.hasNext()) {
                int valueCount = 0;
                String resultName = (String) b.next();
                Iterator a = map.iterator(resultName);
                while (a.hasNext()) {
                    valueCount = valueCount + (Integer)a.next();
                }
                System.out.println("The total for " + resultName + " is " + valueCount);
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }
}
