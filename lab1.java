package lab3;
import java.util.*;
public class RDparser {
public static int index=0;
public static char Token;
public static String s;

public static char getToken() {
Token = s.charAt(index);
index++;
return Token;

}

public static boolean S() {
int save =index;
if (getToken()=='a')
return true;
else {
index= save;
if (getToken()=='^')
return true;
else {
index= save;
if(getToken()=='(' && T() && getToken()==')')
return true;
}

}

index=save;
return false;

}

public static boolean T() {
int save =index;

if ( S() && Tprime()) {
return true;
}

index =save;
return false;
}

public static boolean Tprime() {
int save =index;
if(getToken()==',' && S() && Tprime())
return true;

index =save;
return true;
}



public static void main(String[] args) {
Scanner scan =new Scanner(System.in);
s = scan.nextLine();
if (S() && getToken()=='$')
System.out.println("ACCEPT");
else
System.out.println("REJECT");

}
}

