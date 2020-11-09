package Quadtree;

import java.io.FileReader;
import java.io.IOException;

public class Quad {
    public boolean[] colour;

    public Quad big_quad(String fileDir, int dimension){
        String[][] linesInQuad = new String[4][dimension/2];
        String currentDirectory = System.getProperty("user.dir");
        int character, i = 0, charsInLine = dimension/4;

        try {
            FileReader reader = new FileReader(currentDirectory + fileDir);
            character = 0;
            linesInQuad[0][i] = "";
            while ((character = reader.read()) != -1) {
                if (character == '\n') {
                    linesInQuad[0][i] = "";
                    ++i;
                } else {
                    linesInQuad[0][i] += (char)character;
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Quad();
    }
}
    ////    private int[] NW,SE;
////    private Quadtree.Quad[] quads;
////
////    Quadtree.Quad(int[] NW,int[] SE){
////        this.NW = NW;
////        this.SE = SE;
////    }
////
////    Quadtree.Quad(Quadtree.Quad[] quads){
////        this.quads = quads;
////        buildQuad();
////    }
////    //ok qed navveg ua ajjejt
////    Quadtree.Quad buildQuad(int[] NW, int[] SE){
////        if(SE[0] - NW[0] == 1){
////            return new Quadtree.Quad(NW,SE);
////        } else {
////            Quadtree.Quad
////        }
////    }
//    // 0 -> 3 => {NE, NW, SW, SE}
//    public boolean[] boxes;
//    private Quadtree.Quad[] quads;
//    public boolean colour;
//
//    Quadtree.Quad(boolean[] boxes){
//        this.boxes = boxes;
//    }
//
//    Quadtree.Quad buildQuad(int[][] coordinates, boolean[] boxes){
//        // Case of one pixel quad
//        if(coordinates[3][0] - coordinates[0][0] == 1){
//            return new Quadtree.Quad(boxes);
//        }else{
//            quads
//        }
//    }
//}
