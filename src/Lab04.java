import java.util.Stack;

public class Lab04 {
    public static void main(String[] args) {
        String diamonds = "< < <..<......< < < <....>";

        Stack<String> stack = new Stack<>();

        int contDiamonds = 0;
        for(int i = 0; i < diamonds.length(); i++){
            if(diamonds.charAt(i) == '>' && !stack.isEmpty()){
                stack.pop();
                contDiamonds++;
            }
            else if(diamonds.charAt(i) == '<'){
                stack.push("<");
            }
        }

        System.out.println("Diamonds: " + contDiamonds);
    }
}
