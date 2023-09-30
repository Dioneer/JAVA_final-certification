package GetCheckUserInfo;

public class SpotCheck extends CheckInfo {
    public SpotCheck(String name, String surName, String patronymic, String birthDay, int phoneNumber, char sex){
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    private boolean isAlpha(String s) throws NotStringException{
        if(s!=null&&s.matches("^[a-zA-Zа-яА-Я]*$")){
            return true;
        }else{
            throw new NotStringException(s);
        }
    }

    private boolean isBirthday(String s) throws BirdayException {
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if(isNumeric(arr[0])&&isNumeric(arr[1])&&isNumeric(arr[3])&&isNumeric(arr[4])&&isNumeric(arr[6])&&isNumeric(arr[7])&&isNumeric(arr[8])&&isNumeric(arr[9])&&(arr[2].equals("."))&&(arr[5].equals("."))){
                return true;
            }else{
                throw new BirdayException();
            }
        }
        return false;
    }

    private boolean isSex(Character s)throws NotCorrectSex{
        if(s.equals('f')||s.equals('m')){
            return true;
        }else{
            throw new NotCorrectSex();
        }
    }

    public boolean outCome() throws NotStringException, BirdayException, NotCorrectSex {
        if(isAlpha(surName) && isAlpha(name)&& isAlpha(patronymic)&&isBirthday(birthDay)&&isSex(sex)){
            return true;
        }else{return false;}
    }

}