package FIDemo;

public class sqroomImp {
    SquareRootInterface sq = new SquareRootInterface() {
        public double findSqRoot(int n) {
            return Math.sqrt(n);
        }
    };
}
