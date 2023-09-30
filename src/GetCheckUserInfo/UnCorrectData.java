package GetCheckUserInfo;

public class UnCorrectData extends Exception{
    public String getMesage() {
       return String.format("Данные не корректны, возможно, в дате рождения использованы не точки, или пол указан не одной буквой, или в телефоне имеются сиволы, отличные от цифр");
    }
}
