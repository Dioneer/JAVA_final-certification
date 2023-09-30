package GetCheckUserInfo;

public class FillArrayException extends Exception{
    private String[] arr;
    public FillArrayException(String[] arr) {
        this.arr = arr;

    }

    public String getMesage() {
        String message = "Вы ввели неверное количество данных.";
       if(arr.length-1 < 5) {
           message += " Слишком мало";
        } else {message += " Слишком много";}
        return message;
    }
}
