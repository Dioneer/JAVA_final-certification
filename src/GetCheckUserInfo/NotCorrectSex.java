package GetCheckUserInfo;

public class NotCorrectSex extends Exception{
    public String getMesage() {
        return "Пол указан не верно. Допустимы только 'f' или 'm'";
    }
}
