package GetCheckUserInfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        ForDictionary forDictionary = new ForDictionary();
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Начнем, нажмите любую кнопку, если захотите закончить наберите out");
            if (!scanner.nextLine().equals("out")) {
                MainAsk ask1 = new MainAsk();
                CheckInfo check = new CheckInfo(ask1.getInfo());
                boolean result = check.checkResult();
                if (result) {
                    SpotCheck spotCheck = new SpotCheck(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getSex());
                    try {
                        if (spotCheck.outCome()) {
                            StringRecordFormat recordFormat = new StringRecordFormat(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getSex());
                            forDictionary.addDict(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getSex());
                            forDictionary.show();
                            try (BufferedWriter buff = new BufferedWriter(new FileWriter(check.getSurName() + ".txt"))) {
                                buff.write(recordFormat.StringBuild());
                            }
                        }
                    } catch (NotStringException e) {
                        System.out.println(e.getMesage());
                    } catch (BirdayException e) {
                        System.out.println(e.getMesage());
                    } catch (NotCorrectSex e) {
                        System.out.println(e.getMesage());
                    }
                }

            }else{
                flag = false;
            }
        }
    }
}