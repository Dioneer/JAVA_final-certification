package GetCheckUserInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CheckInfo {
    String name;
    String surName;
    String patronymic;
    String birthDay;
    int phoneNumber;
    char sex;
    private ArrayList<String> array;
    public CheckInfo() {

    }

    protected String getName() {
        return name;
    }

    protected String getSurName() {
        return surName;
    }

    protected String getPatronymic() {
        return patronymic;
    }

    protected String getBirthDay() {
        return birthDay;
    }

    protected int getPhoneNumber() {
        return phoneNumber;
    }

    protected char getSex() {
        return sex;
    }

    public CheckInfo(ArrayList<String> array) {
        this.array = array;
    }

    private void parseArray() {
        List<String> tempoArr = new ArrayList<>();
        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i).length() == 1) {
                sex = array.get(i).charAt(0);
                tempoArr.add(array.get(i));
            }
            if (array.get(i).contains(".") && array.get(i).length() > 1) {
                birthDay = array.get(i);
                tempoArr.add(array.get(i));
            }
            if (isNumeric(array.get(i)) && array.get(i).length() > 1) {
                phoneNumber = Integer.parseInt(array.get(i));
                tempoArr.add(array.get(i));
            }
        }
        array.removeAll(tempoArr);
        surName = array.get(0);
        name = array.get(1);
        patronymic = array.get(2);
    }

    protected boolean isNumeric(String str) {
        try {
            int tempo = Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public boolean checkResult() {
        parseArray();
        try {
            if(surName != null && name != null && patronymic != null && birthDay != null && phoneNumber != 0 && sex!=0) {
                System.out.printf("surname %s, name %s, p %s,birthday %s, phone %d, sex %s ", surName, name, patronymic, birthDay, phoneNumber, sex);
            }else{
                throw new UnCorrectData();
            }
        }catch(UnCorrectData e){
            System.out.println(e.getMesage());
        }
        return true;
   }

}
