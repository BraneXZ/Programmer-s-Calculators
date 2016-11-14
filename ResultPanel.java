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
    boolean bases[] = {false, true, false, false};
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
    
    public String getText()
    {
        return result.getText();
    }
    
    public void setBases(int i)
    {
        if(i == 0)
        {
            bases[0] = true;
            bases[1] = false;
            bases[2] = false;
            bases[3] = false;
        }
        else if(i == 1)
        {
            bases[0] = false;
            bases[1] = true;
            bases[2] = false;
            bases[3] = false;
        }
        else if(i == 2)
        {
            bases[0] = false;
            bases[1] = false;
            bases[2] = true;
            bases[3] = false;
        }
        else if(i == 3)
        {
            bases[0] = false;
            bases[1] = false;
            bases[2] = false;
            bases[3] = true;
        }
    }
    
    public void setBinary(String s)
    {
        if(error)
        {
            return;
        }
        int convert = Integer.parseInt(convertToDec(s));
        setBases(3);
        result.setText(convertFromDec(Integer.toString(convert)));
    }
    
    public void setDecimal(String s)
    {
        result.setText(convertToDec(s));
    }
    
    public void setHex(String s)
    {
        if(error)
        {
            return;
        }
        int convert = Integer.parseInt(convertToDec(s));
        setBases(0);
        result.setText(convertFromDec(Integer.toString(convert)).toUpperCase());
    }
    
    public void setOct(String s)
    {
        if(error)
        {
            return;
        }
        int convert = Integer.parseInt(convertToDec(s));
        setBases(2);
        result.setText(convertFromDec(Integer.toString(convert)));
    }
    
    public String convertFromDec(String s)
    {
        if(bases[0])
        {
            return Integer.toHexString(Integer.parseInt(s));
        }
        else if(bases[1])
        {
            return s;
        }
        else if(bases[2])
        {
            return Integer.toOctalString(Integer.parseInt(s));
        }
        else
        {
            return Integer.toBinaryString(Integer.parseInt(s));
        }
    }
    public String convertToDec(String s)
    {
        if(bases[0])
        {
            if(error)
            {
                return s;
            }
            return Integer.toString(Integer.valueOf(s, 16));
        }
        else if(bases[1])
        {
            return s;
        }
        else if(bases[2])
        {
            if(error)
            {
                return s;
            }
            return Integer.toString(Integer.valueOf(s, 8));
        }
        else 
        {
            if(error)
            {
                return s;
            }
            return Integer.toString(Integer.valueOf(s, 2));
        }
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
        int currentText = 0;
        
        if(bases[0])
        {
            currentText = Integer.parseInt(convertToDec(result.getText()));
        }
        if(bases[1])
        {
            currentText = Integer.parseInt(resultText); 
        }
        if(bases[2])
        {
            currentText = Integer.parseInt(convertToDec(result.getText()));
        }
        if(bases[3])
        {
            currentText = Integer.parseInt(convertToDec(result.getText()));
        }
        
       
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
                if(bases[0])
                {
                    result.setText(Integer.toHexString(nums[0] + nums[1]).toUpperCase());
                    nums[0] += nums[1];
                    return;
                }
                if(bases[2])
                {
                    result.setText(Integer.toOctalString(nums[0] + nums[1]));
                    nums[0] += nums[1];
                    return;
                }
                if(bases[3])
                {
                    result.setText(Integer.toBinaryString(nums[0] + nums[1]));
                    nums[0] += nums[1];
                    return;
                }
                result.setText(Integer.toString(nums[0] + nums[1]));
                nums[0] += nums[1]; 
                return;
            }
            
            //sub
            else if(operation[1])
            {
                if(bases[0])
                {
                    result.setText(Integer.toHexString(nums[0] - nums[1]).toUpperCase());
                    nums[0] -= nums[1];
                    return;
                }
                if(bases[2])
                {
                    result.setText(Integer.toOctalString(nums[0] - nums[1]));
                    nums[0] -= nums[1];
                    return;
                }
                if(bases[3])
                {
                    result.setText(Integer.toBinaryString(nums[0] - nums[1]));
                    nums[0] -= nums[1];
                    return;
                }
                result.setText(Integer.toString(nums[0] - nums[1]));
                nums[0] -= nums[1];
                return;
            }
            
            //mult
            else if(operation[2])
            {
                if(bases[0])
                {
                    result.setText(Integer.toHexString(nums[0] * nums[1]).toUpperCase());
                    nums[0] *= nums[1];
                    return;
                }
                if(bases[2])
                {
                    result.setText(Integer.toOctalString(nums[0] * nums[1]));
                    nums[0] *= nums[1];
                    return;
                }
                if(bases[3])
                {
                    result.setText(Integer.toBinaryString(nums[0] * nums[1]));
                    nums[0] *= nums[1];
                    return;
                }
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
                if(bases[0])
                {
                    result.setText(Integer.toHexString(nums[0] / nums[1]).toUpperCase());
                    nums[0] /= nums[1];
                    return;
                }
                if(bases[2])
                {
                    result.setText(Integer.toOctalString(nums[0] / nums[1]));
                    nums[0] /= nums[1];
                    return;
                }
                if(bases[3])
                {
                    result.setText(Integer.toBinaryString(nums[0] / nums[1]));
                    nums[0] /= nums[1];
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

