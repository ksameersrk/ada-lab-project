import java.util.Arrays;

public class Regex1
{
    char regex[];
    char text[];
    public Regex1()
    {
        //regex = new Char[1024];
        //text = new Char[1024];
    }

    public boolean match(String r,String t)
    {
        r = r + "<";
        t = t + "<";
        regex = r.toCharArray();
        text = t.toCharArray();
        //System.out.println(Arrays.toString(regex)+" "+Arrays.toString(text));
        int i=0;
        int j=0;
        do
        {
            if(matchthis(regex,i,text,j))
            {
                return true;
            }
        }
        while(text[j++] != '<');

        return false;
    }

    public boolean matchthis(char[] regex,int i,char [] text,int j)
    {
        //System.out.println("regex["+i+"] "+regex[i]+" text["+j+"] "+text[j]);
        if(regex[i] == '<' && text[j] == '<')
        {
            return true;
        }
        if(regex[i] == '<' && text[j] != '<')
        {
            return false;
        }
        if(regex[i+1] == '*')
        {
            return matchStar(regex[i],regex,i+2,text,j);
        }
        if(text[j] != '<' && (regex[i] == '?' || regex[i] == text[j]))
        {
            return matchthis(regex,i+1,text,j+1);
        }
       return false;
    }

    public boolean matchStar(char c,char []regex,int i,char []text,int j)
    {
        do
        {
            if(matchthis(regex,i,text,j))
            {
                return true;
            }
        }
        while(text[j] != '<' && (text[j++] == c || c == '?'));

        return false;
    }
}
