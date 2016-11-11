import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Dimension;

public class ResultPanel extends JPanel {
    
    private JLabel result; 
    private String defaultString = "0";
    int firstNum = 0;
    int secNum = 0;
    int counter = 0;
    
    public ResultPanel()
    {
        result = new JLabel(defaultString);
        result.setPreferredSize(new Dimension(450, 50));
        result.setHorizontalTextPosition(JLabel.RIGHT);
        result.setOpaque(true);
        add(result);
    }
    
    public void add()
    {
        if(counter == 0)
        {
        firstNum = Integer.parseInt(result.getText());
        setText("add");
        }
        else
        {
            setText("actually add");
            counter = 0; 
        }
        
    }
    
    public void setText(String s)
    {
        int resultLength = result.getText().length();
        String resultText = result.getText();
        if(s.equals("back"))
        {
            if(resultLength == 0)
            {
                return;
            }
            if(resultText.equals("0"))
            {
                return;
            }
            result.setText(resultText.substring(0, resultLength-1));
            return;
        }
        if(s.equals("clear"))
        {
            result.setText("0");
            return;
        }
        if(s.equals("negative"))
        {
            if(resultText.substring(0,1).equals("-"))
            {
                result.setText(resultText.substring(1,resultLength));
                return;
            }
            else
            {                
                result.setText("-" + resultText);
                return;
            }
        }
        
        if(resultText.equals("0"))
        {
            result.setText(s);
        }
        else
        {
            result.setText(result.getText()+s);
        }
        
        if(s.equals("add"))
        {
            
        }
    }
}
