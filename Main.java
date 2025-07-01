import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static char[][] mat = new char[3][3];
    public static int col, row;
    public static char turn = 'O';

    // Matrix filling function
    public static void fill_matrix() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                mat[row][col] = '-';
            }
        }
    }
    // Matrix printing function
    public static void print_matrix() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.println();
        }
    }

    //check the availability for playing
    public static boolean is_valid() {
        if(row > 2 || col > 2) return false;
        else if(row< 0 || col< 0) return false;
        else if (mat[row][col] == '-')
            return true;
        else {
            return false;
        }
    }
    // check the winner
    public static boolean check_Winner(){
        if(mat[0][0]==mat[0][1]&& mat[0][0]==mat[0][2] && mat[0][0]!= '-') //first row
          return true;
        else if(mat[1][0]== mat[1][1] && mat[1][0]==mat[1][2] && mat[1][0] != '-') // second row
            return true;
        else if(mat[2][0]== mat[2][1] && mat[2][0]==mat[2][2] && mat[2][0]!= '-') // third row
            return true;
        else if(mat[0][0]== mat[1][1] && mat[0][0]==mat[2][2] && mat[0][0]!='-') // diagonal
            return true;
        else if(mat[0][2]== mat[1][1] && mat[0][2]==mat[2][0] && mat[0][2] != '-') // diagonal
            return true;
        else if(mat[0][0]== mat[1][0] && mat[0][0]==mat[2][0] && mat[0][0] !='-') // first column
            return true;
        else if(mat[0][1]== mat[1][1] && mat[0][1]==mat[2][1] && mat[0][1]!= '-') // second column
            return true;
        else if(mat[0][2]== mat[1][2] && mat[0][2]==mat[2][2] && mat[0][2] !='-') // third column
            return true;
        else return false;
    }
    //Playing function
    public static void play(char turn) {
        for (int i = 0; i < 9; i++) {
            System.out.println("Your turn " + turn);
            System.out.println("Please play Your row");
            row = sc.nextInt() - 1;
            System.out.println("Please play Your column");
            col = sc.nextInt() - 1;

                if (is_valid())
                   mat[row][col] = turn;
                else {
                  System.out.println("Please play valid place");
                  --i;      //To stay in the same turn
                  continue;

           }
            print_matrix();

            if (check_Winner()){
                System.out.println(turn + " is winner");
                break;
            }
            {
                if (turn == 'O') turn = 'X';
                else turn = 'O';
            }


        }
    }

    public static void main(String[] args) {
        fill_matrix();
        play(turn);



    }
}
