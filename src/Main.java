
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    
    public static void main(String[] args) {
        MyStack<Fraction> stk = new MyStack();
        HashMap<String, Fraction> memory = new HashMap<String, Fraction>();

        System.out.print("Enter an expression: ");
        Scanner scanIn = new Scanner(System.in);
        String line = scanIn.nextLine();

        while (!line.equals("")) {

            //Process the line
            String firstChar;
            double num;
            //Scanner lineIn = new Scanner(line);
            StringTokenizer lineIn = new StringTokenizer(line, " ()+-*/", true);
            boolean isNum = false;

            try {

                while (lineIn.hasMoreTokens()) {
                    String token = lineIn.nextToken();
                    String top, bottom, tmp;
                    int numBottom, numTop;

                    char aChar = token.charAt(0);
                    switch (aChar) {
                        case '(':

                            top = lineIn.nextToken();

                            // Read one character at a time
                            tmp = lineIn.nextToken();

                            // Read until found a )
                            bottom = lineIn.nextToken();

                            // Read one character at a time
                            tmp = lineIn.nextToken();
                            //System.out.println("Here is: " + top + "/" + bottom);

                            // Create Fraction object and push onto the stack
                            stk.push(new Fraction(new Integer(top), new Integer(bottom)));

                            break;
                        case '+':
                            Fraction f1 = stk.pop();
                            Fraction f2 = stk.pop();
                            Fraction resAdd = f1.add(f2);
                            stk.push(resAdd);
                            String sdf = "sadfsd";
                            break;
                        case ' ':
                            break;
                        case '/':
                            Fraction f3 = stk.pop();
                            Fraction f4 = stk.pop();
                            Fraction resDiv = f4.divide(f3);
                            stk.push(resDiv);
                            break;
                        case '-':
                            Fraction f5 = stk.pop();
                            Fraction f6 = stk.pop();
                            Fraction resSub = f5.subtract(f6);
                            stk.push(resSub);
                            break;
                        case '*':
                            Fraction f7 = stk.pop();
                            Fraction f8 = stk.pop();
                            Fraction resMul = f7.multiply(f8);
                            stk.push(resMul);
                            break;
                        case 'S':
                            // The below line parses past the space between the Save character and the label
                            tmp = lineIn.nextToken();
                            // The below line is the label for the saved fraction
                            token = lineIn.nextToken();
                            Fraction sFrac = stk.pop();
                            memory.put(token, sFrac);
                            stk.push(sFrac);
                            break;
                        case 'R':
                            // The below line parses past the space between the Save character and the label
                            tmp = lineIn.nextToken();
                            // The below line is the label for the saved fraction
                            token = lineIn.nextToken();
                            Fraction rFrac = memory.get(token);
                            stk.push(rFrac);
                            break;
                        default:
                            isNum = true;
                            num = new Double(token);
                            numBottom = 1;

                            while (num - (int) num != 0) {
                                numBottom = numBottom * 10;
                                num = num * 10;
                            }
                            numTop = (int) num;

                            stk.push(new Fraction(numTop, numBottom));
                            String sadlgkj = "sld;kf";
                            break;
                    }
                }
                Fraction res = stk.pop();
                if (stk.isEmpty()) {
                    if (isNum) {
                        System.out.println("It is: " + res.getDec());
                    }
                    else {
                        System.out.println("It is: " + res);
                    }
                }
                else {
                    System.out.println("Malformed Expression");
                }

            // Below line cathces malformed expression exceptions
            } catch (Exception ex) {
                System.out.println("Malformed Expression");
            }
            System.out.print("Enter an expression: ");
            line = scanIn.nextLine();
        }
    }
}
