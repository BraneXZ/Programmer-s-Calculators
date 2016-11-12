import javax.swing.*;

public class TestProgrammerSCalculator {
    public static void main(String args[] )
    {
        
        //instantiates a new programmer's calculator object and set its size, and visibility
        ProgrammerSCalculator myCalc = new ProgrammerSCalculator();
        myCalc.setSize(600,400);
        myCalc.setResizable(false);
        myCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myCalc.setTitle("Programmer's Calculator");
        myCalc.setVisible(true);
    }
}
