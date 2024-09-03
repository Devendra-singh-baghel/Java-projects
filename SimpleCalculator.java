import java.util.Scanner;

class OperationInCalculator
{
    double operand1;
    String operator;
    double operand2;

    public double add() 
    {
        return operand1 + operand2;
    }

    public double sub() 
    {
        return operand1 - operand2;
    }

    public double multi() 
    {
        return operand1 * operand2;
    }

    public double div()
    {
        return operand1 / operand2;
    }
}


public class SimpleCalculator {
    public static void main(String[] args) {

        OperationInCalculator fun = new OperationInCalculator();

        Scanner sc = new Scanner(System.in);

        while (true) 
        {
            System.out.print("Enter a number : ");
            fun.operand1 = sc.nextDouble();

            System.out.print("Enter operator : ");
            fun.operator = sc.next();

            System.out.print("Enter a number : ");
            fun.operand2 = sc.nextDouble();
            
            if (fun.operator.equals("+")) 
            {
                System.out.println("Addition Result is : " + fun.add());
            } 
            else if (fun.operator.equals("-")) 
            {
                System.out.println("Subtraction Result is : " + fun.sub());
            } 
            else if (fun.operator.equals("*")) 
            {
                System.out.println("Multiplication Result is : " + fun.multi());
            } 
            else if (fun.operator.equals("/")) 
            {
                if (fun.operand2 == 0) 
                {
                    System.out.println("Division by 0 is not allowed.");
                }
                else
                {
                    System.out.println("Division Result is : " + fun.div());
                }
                
            } 
            else 
            {
                System.out.println("You entered wrong operator / please enter valid operator!");
            }

            System.out.print("Do you want to perform another operation? (1 = yes/ 0 = no): ");

            int choice = sc.nextInt();

            if (choice == 1) 
            {
                continue;
            }
            else
            {
                System.out.println("Exit");
                break;
            } 
        }
        sc.close();
    }
}
