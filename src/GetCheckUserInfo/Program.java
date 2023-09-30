package GetCheckUserInfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        MainAsk ask1 = new MainAsk();
        CheckInfo check = new CheckInfo(ask1.getInfo());
        boolean result = check.checkResult();
        System.out.println(result);
        if(result){
            SpotCheck spotCheck = new SpotCheck(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getSex());
            try {
                if(spotCheck.outCome()){
                    StringRecordFormat recordFormat= new StringRecordFormat(check.getName(), check.getSurName(), check.getPatronymic(), check.getBirthDay(), check.getPhoneNumber(), check.getSex());
                    String info = recordFormat.StringBuild();
                    try(BufferedWriter buff = new BufferedWriter(new FileWriter(check.getSurName() + ".txt"))){
                        buff.write(info);
                    }
                }
            } catch (NotStringException e) {
                System.out.println(e.getMesage());
            } catch (BirdayException e) {
                System.out.println(e.getMesage());
            }catch (NotCorrectSex e) {
                System.out.println(e.getMesage());
            }
        }

    }
}