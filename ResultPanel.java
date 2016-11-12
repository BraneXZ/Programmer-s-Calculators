import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;

public class ResultPanel extends JPanel {
    
    private JLabel result; 
    private String defaultString = "0";
    int nums[] = new int[2];
    boolean operation[] = new boolean [4];
    boolean operationPerformed; 
    boolean equal;
    boolean error = false;
    
    public ResultPanel()
    {
        result = new JLabel(defaultString);
        result.setPreferredSize(new Dimension(450, 50));
        result.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        result.setOpaque(true);
        result.setFont(new Font("Times new Roman", Font.BOLD, 43));
        add(result);
    }
    
    public void add()
    {
        for(int i = 1; i < operation.length; i++)
        {
            if(operation[i])
            {
                setText("operation");
                operation[0] = true;
                operation[1] = false;
                operation[2] = false;
                operation[3] = false;  
                operationPerformed = true;
                return;
            }
        }
        operation[0] = true;
        operation[1] = false;
        operation[2] = false;
        operation[3] = false;  
        operationPerformed = true;
        setText("operation");
    }
    
    public void sub()
    {
        if(operation[0] == true || operation[2] == true || operation[3] == true)
        {
            setText("operation");
            operation[0] = false;
            operation[1] = true;
            operation[2] = false;
            operation[3] = false;    
            operationPerformed = true;
            return;
        }
        operation[0] = false;
        operation[1] = true;
        operation[2] = false;
        operation[3] = false;    
        operationPerformed = true;
        setText("operation");
    }
    
    public void mult()
    {
        if(operation[0] == true || operation[1] == true || operation[3] == true)
        {
            setText("operation");
            operation[0] = false;
            operation[1] = false;
            operation[2] = true;
            operation[3] = false;    
            operationPerformed = true;
            return;
        }
        operation[0] = false;
        operation[1] = false;
        operation[2] = true;
        operation[3] = false;
        operationPerformed = true;
        setText("operation");
    }
    
    public void div()
    {
        if(operation[0] == true || operation[1] == true || operation[2] == true)
        {
            setText("operation");
            operation[0] = false;
            operation[1] = false;
            operation[2] = false;
            operation[3] = true;    
            operationPerformed = true;
            return;
        }
        operation[0] = false;
        operation[1] = false;
        operation[2] = false;
        operation[3] = true; 
        operationPerformed = true;
        setText("operation");
    }
    
    public void equals()
    {
        equal = true;
        operationPerformed = true;
        setText("operation");
    }
    
    public void setText(String s)
    {
        if(error)
        {
            result.setText("0");
            error = false;
            return;
        }
        
        int resultLength = result.getText().length();
        String resultText = result.getText();
        int currentText = Integer.parseInt(resultText); 
        
        if(s.equals("back"))
        {
            if(resultLength == 1)
            {
                result.setText("0");
                return;
            }
            if(resultText.equals("0"))
            {
                return;
            }
            result.setText(resultText.substring(0, resultLength-1));
            return;
        }
        if(s.equals("clearEntry"))
        {
            result.setText("0");
                       
            return;
        }
        
        if(s.equals("negative"))
        {
           
            currentText *= -1;
            result.setText(Integer.toString(currentText));
            return;
        }
        
        if(s.equals("clear"))
        {
            result.setText("0");
            nums[0] = 0;
            nums[1] = 0;
            for(boolean i:operation)
            {
                i = false;
            }
            return;
        }
        
        
        if(s.equals("operation"))
        {
            if(nums[0] == 0)
            {
                nums[0] = currentText; 
                return;
            }
            else if(equal)
            {
                if(nums[1] == 0)
                {
                    nums[1] = currentText;
                }
                else if(nums[1] != currentText)
                {
                    nums[1] = currentText;
                    
                }
                equal = false;
            }
            else
            {
                nums[1] = currentText;
            }
            
            //add
            if(operation[0])
            {
                result.setText(Integer.toString(nums[0] + nums[1]));
                nums[0] += nums[1]; 
                return;
            }
            
            //sub
            else if(operation[1])
            {
                result.setText(Integer.toString(nums[0] - nums[1]));
                nums[0] -= nums[1];
                return;
            }
            
            //mult
            else if(operation[2])
            {
                result.setText(Integer.toString(nums[0] * nums[1]));
                nums[0] *= nums[1];
                return;
            }
            
            //div
            else if(operation[3])
            {
                if(nums[1] == 0)
                {
                    result.setText("Cannot divide by 0");
                    operation[3] = false;
                    error = true;
                    nums[0] = 0;
                    nums[1] = 0;
                    return;
                }
                result.setText(Integer.toString(nums[0] / nums[1]));
                nums[0] /= nums[1];
                return;
            }
            
            
            return;
        }
        
        if(resultText.equals("0"))
        {
            result.setText(s);
        }
        else
        {
            for(boolean i:operation)
            {
                if(i && operationPerformed)
                {
                    result.setText(s);
                    operationPerformed = false;
                    return;
                }
            }
                result.setText(result.getText()+s);
                   
                
                
            }
            
            
        }
        
        
    }

