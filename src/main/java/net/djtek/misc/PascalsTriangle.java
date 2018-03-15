package net.djtek.misc;

public class PascalsTriangle {
    int[][] triangle;

    public PascalsTriangle (int depth){
        triangle = new int[depth][];

        // top of triangle initialized to 1
        triangle[0] = new int[]{1};

        for (int j = 1; j < depth; ++j){
            int width = j + 1;

            // create new row
            int[] row =  new int[width];

            // populate row
            for (int i = 0; i < width; ++i){
                if (i == 0 || i == (width - 1)){
                    row[i] = 1; //triangle 'border' is always 1
                } else {
                    row[i] = triangle[j - 1][i - 1] + triangle[j - 1][i];
                }
            }

            triangle[j] = row;
        }
    }

    public void print(){
        int depth = triangle.length;
        for (int j = 0; j < depth; ++j){
            int width = j + 1;
            for (int i = 0; i < width; ++i){
                if (i > 0){
                    System.out.print(" ");
                }
                System.out.print(triangle[j][i]);
            }
            System.out.println();
        }
    }
}
