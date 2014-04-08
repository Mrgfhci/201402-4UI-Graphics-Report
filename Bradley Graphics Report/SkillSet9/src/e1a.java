
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class e1a {

    public static void e1a(String[] args) throws IOException {
        Guy guy = new Guy();
        String sFirst, sLast;
        double dWage;
        int nHours;
        Scanner sin = new Scanner(new FileReader("1dIN.txt"));
        for (int i = 0; i < 4; i++) {
            sFirst = sin.next();
            sLast = sin.next();
            dWage = sin.nextDouble();
            nHours = sin.nextInt();
            guy.setVars(sFirst, sLast, dWage, nHours);
            guy.out();
        }
    }
}

class Guy {

    private String sFirst, sLast;
    private double dWage;
    private int nHours;

    void setVars(String _sFirst, String _sLast, double _dWage, int _nHours) {
        sFirst = _sFirst;
        sLast = _sLast;
        dWage = _dWage;
        nHours = _nHours;
    }

    void out() {
        System.out.println(sFirst + " " + sLast + " " + dWage + "    " + nHours);
    }
}