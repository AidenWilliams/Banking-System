public class Quad {
    private int[] NW,SE;
    private Quad[] quads;

    Quad(int[] NW,int[] SE){
        this.NW = NW;
        this.SE = SE;
    }

    Quad(Quad[] quads){
        this.quads = quads;
        buildQuad();
    }
    //ok qed navveg ua ajjejt
    Quad buildQuad(int[] NW, int[] SE){
        if(SE[0] - NW[0] == 1){
            return new Quad(NW,SE);
        } else {
            Quad
        }
    }
}
