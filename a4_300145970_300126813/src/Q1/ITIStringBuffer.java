package Q1;

import java.util.Iterator;

public class ITIStringBuffer {

    //instance variable
    private SinglyLinkedList<String> itiStringList;
    private int length;

    //if toString method is called before, this can be directly be used
    private String str="";


//constructor
    public ITIStringBuffer() {
        itiStringList = new SinglyLinkedList<String>() ;
        length = 0;
    }

    public ITIStringBuffer(String  firstString){
        itiStringList = new SinglyLinkedList<String>();
        itiStringList.add(firstString);
        length = 0;
    }

    public void append(String nextString){
        itiStringList.add(nextString);
        length+=nextString.length();
    }

    public String toString(){

//        if (itiStringList.isEmpty()){
//            return "";
//        }

        if (str.length()==length) return str;

        Iterator<String> i = itiStringList.iterator();
        char [] result = new char[length];
        int position = 0;

        while (i.hasNext()){
            String tmp = i.next();
            char[] currentChar = tmp.toCharArray();


            for (char c: currentChar){
                result[position++] = c;
            }
        }
        str = new String(result);
        return str;

    }

}
