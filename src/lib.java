import java.io.*;
import java.util.*;

public class lib {
    private Map<String, Integer> map1;
    private Map<String, Integer> map2;

    public Map<String, Integer> getMap1() {
        return map1;
    }

    public Map<String, Integer> getMap2() {
        return map2;
    }

    private List<Map.Entry<String,Integer>> orderList1;
    private List<Map.Entry<String,Integer>> orderList2;

    public lib() {
        super();
        map1 = new HashMap<String, Integer>();
        map2 = new HashMap<String, Integer>();
    }

    public void dealFile(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                dealLine(line);
                //System.out.println(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
            System.exit(0);
        }
    }

    public void dealLine(String line) {
        Boolean isSubHavaNum = false;
        int length = line.length();

        if(length > 0) {
            for (int i = 0; i < length; i++) {
                String temp = String.valueOf(line.charAt(i));
                if (!map1.containsKey(temp)) {
                    map1.put(temp, 1);
                } else {
                    map1.put(temp, map1.get(temp) + 1);
                }
            }
            if (!(isSplit(line.charAt(length - 1)))) {
                line = line.concat(".");
            }
            for (int i = 0; i < length; i++) {
                int first = i;
                int end = i;
                char temp1 = line.charAt(i);

                if (isZ(temp1)) {
                    i++;
                    while (!(isSplit(line.charAt(i)))) {
                        end = i;
                        i++;
                    }

                    String subString = line.substring(first, end + 1);

                    int lengthSub = subString.length()>4? 4:subString.length();
                    for (int j=0 ;j<lengthSub;j++)
                    {
                        if(isNumber(subString.charAt(j))){
                            isSubHavaNum = true;
                        }
                    }
                    subString.toLowerCase();
                   // System.out.println(subString);
                    if (subString.length() > 3 && !isSubHavaNum) {
                        if (!map2.containsKey(subString)) {
                            map2.put(subString, 1);
                        } else {
                            map2.put(subString, map2.get(subString) + 1);
                        }
                    }
                }
            }
        }
    }

    public List<Map.Entry<String, Integer>> sortMap (Map <String,Integer > map) {
        List<Map.Entry<String, Integer>> orderList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(orderList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return orderList;
    }

    public void out (String fileName,List<Map.Entry<String, Integer>> list) {
        try {
            FileWriter fwriter = new FileWriter(fileName);
            int length = (list.size() < 10) ? list.size() : 10;
            for (int i=0; i<length ;i++) {
                fwriter.write(list.get(i).getKey() + " : " + list.get(i).getValue() + "\r\n");
            }
            fwriter.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Boolean isZ(char temp){
        if (((temp <= 'Z') && (temp >= 'A')) || ((temp >= 'a') && temp <= 'z')) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isNumber (char temp){
    if ((temp <= '9') && (temp >= '0')) {
        return true;
    } else {
        return false;
    }
}

    public Boolean isSplit(char temp) {
        if(isZ(temp) || isNumber(temp)){
            return false;
        } else {
            return true;
        }
    }
}