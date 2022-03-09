import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test {

    private int a;
    public void add(){
        a++;
        System.out.println(a);
    }

    public static void doTheTest(String strFilename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(strFilename));
        int num = 0;
        int col = 0;
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            // WRITE YOUR CODE HERE!
            if (str.equals("###")){
                break;
            }
            if (!str.equals("")){
                System.out.println(deleteAllSpaces(str));
                col = str.split(",").length;
                num++;

            }

        }
        System.out.println("row = "+ num +" col = "+ col);
    }

    private static String deleteAllSpaces(String str){
        return str.replaceAll(" ","");
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
//
//        String strFilename = scanner.nextLine();
//        doTheTest(strFilename);

//        String[][] a= new String[4][5];
//        String[] b = new String[]{"tom","janne","ben","idot","will"};
//        a[1] = b;
//        System.out.println(Arrays.deepToString(a));
//        int a = 50;
//        double THRESHOLD = 5.0d;
//        double c = (double) a/35;
//        System.out.println(THRESHOLD);
//        System.out.println(c);
        List<String> list = new SinglyLinkedList<>();
        list.add("ahasd");
        list.add("ad");
        list.add("aha");
        list.add("ah");
        int i = 0;
        while (i< list.size()){
            list.remove(i);
            System.out.println(list.toString());
        }






    }
}
