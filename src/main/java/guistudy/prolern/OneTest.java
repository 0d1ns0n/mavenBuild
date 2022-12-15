package guistudy.prolern;

import javax.swing.*;

public class OneTest extends JFrame {

//static  ArrayList<String> ad = new ArrayList<>();
//
//    public static String readFile(File file) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        FileInputStream fis = new FileInputStream(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//
//        String line;
//        while ((line = br.readLine()) != null) {
//            sb.append(line).append(System.lineSeparator());
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//
//        File file = new File("C://abc.txt");
//        String content;
//        char[] s = new char[0];
//        try {
//            content = readFile(file);
//            s = content.toCharArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        String[] c = new String[s.length];
//
//        for (int i = 0; i < s.length; i++) {
//            ad.add(String.valueOf(s[i]));
//            c[i] = String.valueOf(s[i]).toUpperCase();
//
//        }
//        int count = 0;
//        for (int i = 0; i < s.length; i++) {
//            count++;
//            if (c[i].equals("Р")) {
//                System.out.println(" ДА БЛЯТЬ ТЫ ПОНЯЛ");
//                System.out.println(c[i]);
//            }
//        }
//        System.out.println(count);
//    }
}

//        setTitle("Test");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setSize(800,800);
//        setResizable(false);


//    public static void main(String[] args) { /// ВЫТЯНУТЬ СИМВОЛЫ метод 1
//        JFrame j = new OneTest();
//        j.setVisible(true);
//        Charset charset = StandardCharsets.UTF_8;
//        File file = new File("C://abc.txt");
//        try (FileInputStream abc = new FileInputStream(file)) {
//            byte []bytes= new byte[(int) file.length()];
//            abc.read(bytes);
//
//            String getFile = new String(bytes, charset);
//            System.out.println(getFile);
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}
