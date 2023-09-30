package GetCheckUserInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainAsk {
    private boolean mainFlag = true;
    private final ArrayList<String> info = new ArrayList<>();
    public ArrayList<String> getInfo() {
        mainAsk();
        return info;
    }

    private ArrayList<String> mainAsk() {
        while (mainFlag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ввиедите через пробел: Фамилию Имя Отчество, дату рождения(в формате dd.mm.yyyy), номер телефона, пол(f или m). Для выхода введите exit.");
            String[] result = scanner.nextLine().trim().split(" ");
            if(result[0].equals("exit")){
                System.out.println("Я понимаю как бесит такой ввод, прощайте!");
                mainFlag = false;
                return info;
            }
            try{
            if(result.length-1 == 5) {
                info.addAll(Arrays.asList(result));
                System.out.println("Данные приняты к обработке");
                mainFlag = false;
            }else{
                throw new FillArrayException(result);
            }
            }catch(FillArrayException e){
                System.out.println(e.getMesage());
            }
        }
        return info;
    }
}
