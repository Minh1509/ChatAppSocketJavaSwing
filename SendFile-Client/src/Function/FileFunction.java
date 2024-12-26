package Function;


import Models.User;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileFunction {    
    public static void CheckFile(String dir) throws IOException {
        File f = new File(dir);
        if(!f.exists()) {
           f.createNewFile();
        }
    }
    
    public static void WriteFile(String file, User users) {
        try {
            FileWriter fw = new FileWriter(file, true);
            
            User user = new User(users.getUserName(), users.getPassword());
            
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(user.toString());
            
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Lỗi ghi file: " + ex);
        }
    }
    
    public static void ReadFile(String file, List<User> users) {
        try {
            FileReader fr = new FileReader(file);
            //Bước 2: Đọc dữ liệu
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
              String[] user = line.split("-");
              User tmp = new User (user[0], user[1]);
              users.add(tmp);
              System.out.println(tmp.getPassword());
            }
            fr.close();
            br.close();
        } catch (IOException ex) {
             System.out.println("Lỗi đọc file: "+ex);
        }
    }
}
