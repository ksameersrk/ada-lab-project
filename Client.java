import java.util.Scanner;

public class Client
{
    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
        String text;
        String regex;
        Regex r = new Regex();
        regex = in.next();
        text = in.next();
        System.out.println("String satisfy the "+
            "regex : "+r.match(regex,text));
    }
}
