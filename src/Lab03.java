import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Lab03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        int option = 0;

        ArrayList<String> argsList = new ArrayList<>();

        do {
            System.out.println("Informe uma operação");
            System.out.println("1 - Adicionar ação");
            System.out.println("0 - Sair");
            option = s.nextInt();
            if(option == 0){
                continue;
            }
            System.out.println("Informe uma ação no jogo");
            String str = s.next();

            argsList.add(str);
        }while(option != 0);

        for(String str : argsList){
            switch(str){
                case "+":
                    int lastNum = stack.pop();
                    int sum = lastNum + stack.peek();
                    stack.push(lastNum);
                    stack.push(sum);
                    break;
                case "D":
                    stack.push(stack.peek()*2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(str));
                    break;

            }
        }

        int sumVal = 0;

        for(int arg: stack){
            sumVal+= arg;
        }
        System.out.println(sumVal);
    }
}
