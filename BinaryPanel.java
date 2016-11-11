import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Dimension;

public class BinaryPanel extends JPanel{
    private JTextField binary;
    
    public BinaryPanel()
    {
        binary = new JTextField();
        binary.setPreferredSize(new Dimension(450, 60));
        binary.setEditable(false);
        add(binary);
    }
}