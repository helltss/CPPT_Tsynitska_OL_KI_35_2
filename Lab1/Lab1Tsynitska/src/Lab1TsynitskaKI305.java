
import java.io.*;
import java.util.*;


public class  Lab1TsynitskaKI305{
    /**
     * The static main method is the entry point into the program
     *
     * @param args
     * @throws FileNotFoundException
     *
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");
        char[][] arr = new char[in.nextInt()][];
        in.nextLine();

        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();


        if(filler.length() > 1)
        {
            System.out.print("\nВи ввели більше ніж один символ!\nЗавершення програми.");
            fout.print("\nВи ввели більше ніж один символ!\nЗавершення програми.");
            closeProgram(fout);
        }
        if(filler.isEmpty())
        {
            System.out.print("\nВи не ввели символ-заповнювач!\nЗавершення програми.");
            fout.print("\nВи не ввели символ-заповнювач!\nЗавершення програми.");
            closeProgram(fout);
        }

        System.out.print("\n");
        fout.print("\n");

        int num;
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = new char[((i + 1)*2 < arr.length) ? ((i + 1)*2) :
                    ((i + 1)*2 > arr.length + 2) ? ((arr.length - i)*2) : arr.length];
        }
        System.out.print("\n");

        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length; j++)
            {
                num = 0;
                if( (arr[i].length/ 2 > j) || (arr.length / 2 == i) ||
                        ((arr[i].length/ 2 + j >= arr.length)))
                {
                    if (j < arr[i].length / 2) {
                        arr[i][j] = (char) filler.codePointAt(0);
                    }
                    System.out.print(arr[i][num] + " ");
                    fout.print(arr[i][num] + " ");
                    num++;
                }
                else
                {
                    System.out.print("  ");
                    fout.print("  ");
                }
            }
            System.out.print("\n");
            fout.print("\n");
        }
        fout.flush();
        fout.close();
    }

    private static void closeProgram(PrintWriter fout) {
        fout.flush();
        fout.close();
        System.exit(0);
    }
}