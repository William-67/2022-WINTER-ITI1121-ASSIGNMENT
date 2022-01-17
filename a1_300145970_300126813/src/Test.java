import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test {

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

        String[][] a= new String[4][5];
        String[] b = new String[]{"tom","janne","ben","idot","will"};
        a[1] = b;
        System.out.println(Arrays.deepToString(a));





    }
}
