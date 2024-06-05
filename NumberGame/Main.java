import java.util.Random;
import java.util.Scanner;
public class Main{
    static int score = 0;
    static int round = 0;
    public static void gameRunner(){
        round++;
        Random random = new Random();
        int ans = random.nextInt(20)+1;
        System.out.println("You are having 5 chances and you have to guess the ans from 1 to 20. ");
        Scanner sc = new Scanner(System.in);
        while(true){
            for(int i =0;i<5;i++){
                int input=-1;
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    break;
                }
                if(input==ans){
                    score++;
                    System.out.println("You got the answer. Your score is "+Integer.toString(score));
                    break;
                }else if(input<=20 && input>=1 && input!=ans){
                    if(input>ans+3){
                        System.out.println("Too High. Try Again");
                    }else if(input<ans-3){
                        System.out.println("Too Low. Try Again");
                    }else{
                        System.out.println("You are close!! Try Again");
                    }
                }else{
                    System.out.println("Invalid Input");
                }
            }
            break;
        }
        repeatPermission(ans);
    }
    public static void repeatPermission(int ans){
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print("Press 1 to continue and 0 to close the game ");
            int input=-1;
            try {
                input = s.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Try Again !");
                repeatPermission(ans);
                break;
            }
            if(input==1){
                gameRunner();
                break;
            }else if(input==0){
                break;
            }else{
                System.out.println("Invalid Input.Try Again !");
            }
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Kindly input your name: ");
            String name = sc.nextLine();
            
            gameRunner();
            System.out.println("The score of "+ name +" is "+Integer.toString(score)+" and the number of rounds played are "+Integer.toString(round));
        }
    }
}