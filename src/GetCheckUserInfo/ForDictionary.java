package GetCheckUserInfo;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ForDictionary extends CheckInfo {
    Map<String, ArrayList<ArrayList<String>>> forDict= new HashMap<>();

    public void addDict(String name, String surName, String patronymic, String birthDay, int phoneNumber, char sex){
        ArrayList<String> lists = new ArrayList<>();
        ArrayList<ArrayList<String>> doubleArr = new ArrayList<>();
        lists.add(name);
        lists.add(patronymic);
        lists.add(birthDay);
        lists.add(Integer.toString(phoneNumber));
        lists.add(Character.toString(sex));
        if(forDict.containsKey(surName)){
            for (Map.Entry<String, ArrayList<ArrayList<String>>> entry : forDict.entrySet()) {
                doubleArr.add(entry.getValue().get(0));
                }
            doubleArr.add(lists);
            forDict.put(surName, doubleArr);
        }else{
            doubleArr.add(lists);
            forDict.put(surName, doubleArr);
        }
    }
    public void show(){
        forDict.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
