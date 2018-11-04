public class Automat {
    private boolean[] acceptState;
    private char[] alphabeth;
    private int[][] nextState;

    public Automat(boolean[] acceptState, char[] alphabeth, int[][] nextState) {
        this.acceptState = acceptState;
        this.alphabeth = alphabeth;
        this.nextState = nextState;
    }

    public boolean sjekkInput(char[] input){
        int pointer = 0;
        boolean ret = false;
        for (char c : input){
            for(int i=0;i<alphabeth.length;i++){
                if (c == alphabeth[i]){
                    pointer = nextState[pointer][i];
                    ret = true;
                }
            }
            if(!ret) return false;
        }
        return acceptState[pointer];
    }

    public static void main(String[] args){

        boolean[] zeroOneAccept = new boolean[]{false, false, true, false};
        int[][] zeroOneNextState = new int[][]{
                {1,3},
                {1,2},
                {2,3},
                {3,3}
        };

        boolean[] abAccept = new boolean[]{false, false, false, true, false};
        int[][] abNextState = new int[][]{
                {1,2},
                {4,3},
                {3,4},
                {3,3},
                {4,4}
        };

        Automat zeroOne = new Automat(
                zeroOneAccept,
                "01".toCharArray(),
                zeroOneNextState
        );

        Automat ab = new Automat(
                abAccept,
                "ab".toCharArray(),
                abNextState
        );

        System.out.println(zeroOne.sjekkInput("".toCharArray()));
        System.out.println(ab.sjekkInput("".toCharArray()));
    }

}

