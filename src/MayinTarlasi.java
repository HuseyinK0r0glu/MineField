import java.util.*;
public class MayinTarlasi {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int [][] map;
    int [][] board;
    int rowNumber,colNumber,size;
    boolean game = true;

    MayinTarlasi(int rowNumber, int colNumber){
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = this.rowNumber * this.colNumber;
    }
    public void run(){
        int success = 0;
        prepareGame();
        System.out.println("oyun başladı!");
        while(game){
            print(board);
            System.out.println("satır giriniz:");
            int row = scan.nextInt();
            System.out.println("sütun giriniz:");
            int col = scan.nextInt();

            if((row<0) || (row>=rowNumber)){
                System.out.println("yanlış koordinat girdiniz ");
                continue;
            }
            if((col<0) || (col>=colNumber)){
                System.out.println("yanlış koordinat girdiniz ");
                continue;
            }

            if(map[row][col] != -1){
                check(row,col);
                success++;
                if(success == size - (size/4)){
                    System.out.println("tebrikler kazandınız");
                    break;
                }
            }else{
                game = false;
                System.out.println("Mayına Geldiniz Kaybettiniz");
            }

        }


    }

    public void prepareGame() {
        int randRow, randCol, count = 0;
        while (count < (size / 4)) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }

    }


        public void print( int[][]arr) {
            for(int i = 0 ;i<arr.length;i++){
                for(int j = 0 ;j<arr[0].length;j++){
                    if(arr[i][j] >= 0) {
                        System.out.print(" ");
                    }
                    System.out.print(arr[i][j] + "");
                }
                System.out.println();
            }
        }
        public void check(int r, int c){
            if (map[r][c]==0){
                if((c<colNumber-1) && (map[r][c+1]==-1)){
                    board[r][c]++;
                }
                if((r<rowNumber-1) && (map[r+1][c]==-1)){
                    board[r][c]++;
                }
                if((r>0) && (map[r-1][c]==0)){
                    board[r][c]++;
                }
                if((c>0) && (map[r][c-1]==0)){
                    board[r][c]++;
                }
                if(board[r][c]==0){
                    board[r][c]=-2;
                }
            }

        }
    }