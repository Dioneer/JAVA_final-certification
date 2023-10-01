package GetCheckUserInfo;

public class StringRecordFormat extends CheckInfo{
    private String name;
    private String surName;
    private String patronymic;
    private String birthDay;
    private int phoneNumber;
    private char sex;
    public StringRecordFormat(String name, String surName, String patronymic, String birthDay, int phoneNumber, char sex){
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String StringBuild(){
        StringBuilder builder = new StringBuilder();
        builder.append("<");
        builder.append(surName);
        builder.append(">");
        builder.append("<");
        builder.append(name);
        builder.append(">");
        builder.append("<");
        builder.append(patronymic);
        builder.append(">");
        builder.append("<");
        builder.append(birthDay);
        builder.append(">");
        builder.append("<");
        builder.append(phoneNumber);
        builder.append(">");
        builder.append("<");
        builder.append(sex);
        builder.append(">");
        return builder.toString();
    }
}
