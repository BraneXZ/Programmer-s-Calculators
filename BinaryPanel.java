import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;

public class BinaryPanel extends JPanel{
    private JTextArea binary;
    
    public BinaryPanel()
    {       
        binary = new JTextArea("0000 0000 0000 0000 0000 0000 0000 0000 \n0000 0000 0000 0000 0000 0000 0000 0000");
        binary.setPreferredSize(new Dimension(460, 60));
        binary.setFont(new Font("Times new Roman", Font.CENTER_BASELINE, 25));
        binary.setOpaque(true);
        binary.setEditable(false);
        add(binary);
    }
    
    public void setText(String s)
    {
        char[] binaryArray = binary.getText().replace(" ", "").toCharArray();
        char[] exampleArray = s.toCharArray();
        for(int i = 1; i < exampleArray.length + 1; i++)
        {
            if(binaryArray[binaryArray.length - i] == '0' && exampleArray[exampleArray.length - i] == '1')
            {
                binaryArray[binaryArray.length - i] = '1';
            }
            else if(binaryArray[binaryArray.length - i] == '1' && exampleArray[exampleArray.length - i] == '0')
            {
                binaryArray[binaryArray.length - i] = '0';
            }
        }
        String newBinary = "";
        int counter = 0;
        
        for(int i = 0; i < binaryArray.length /2; i++)
        {
            newBinary+= binaryArray[i];
            if(counter == 3)
            {
                newBinary += " ";
                counter = 0;
                
            }
            else
            {
                counter++; 
            }
            
        }
        counter = -1; 
        for(int i = binaryArray.length/2; i < binaryArray.length; i++)
        {
            newBinary+= binaryArray[i];
            if(counter == 3)
            {
                newBinary += " ";
                counter = 0;
                
            }
            else
            {
                counter++; 
            }
        }
        
        binary.setText(newBinary);

    }
    
    public void clear()
    {
        binary.setText("0000 0000 0000 0000 0000 0000 0000 0000 \n0000 0000 0000 0000 0000 0000 0000 0000");

    }
    
}