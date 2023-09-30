package GetCheckUserInfo;

public class BirdayException extends Exception{
    public String getMesage() {
        return "Неверный формат даты";
    }
}
