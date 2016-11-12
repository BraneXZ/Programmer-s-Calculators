import javax.swing.GroupLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class ProgrammerSCalculator extends JFrame implements ActionListener{
        ResultPanel result = new ResultPanel();
        BinaryPanel binary = new BinaryPanel();
        JPanel buttons = new JPanel();
        JButton zero, zero2, one, two, three, four, five, six, seven, eight, 
                nine, decimal, add, sub, mult, div, negative, clear, clearEntry,
                back, equals, oneOverX, percent, sqrt, A, B, C, D, E, F, mod, 
                quot, box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, 
                box11, box12, box13, box14, box15; 
        JRadioButton hex, dec, oct, bin;
        JPanel masters = new JPanel(); 
        JPanel base = new JPanel();
        JPanel base2 = new JPanel();
        
        public ProgrammerSCalculator()
        {
            JMenu view = new JMenu("View");
            view.setMnemonic(KeyEvent.VK_F);
            
            JMenuItem hide_show = new JMenuItem("Hide or Show");
            view.add(hide_show);
            
            JMenu edit = new JMenu("Edit");
            
            JMenuItem copy = new JMenuItem("Copy");
            edit.add(copy);
            
            JMenu help = new JMenu("Help");
            
            JMenuItem viewHelp = new JMenuItem("View Help");
            help.add(viewHelp);
            
            JMenuBar mb = new JMenuBar();
            mb.add(view);
            mb.add(edit);
            mb.add(help);
            setJMenuBar(mb);
            
            
            //assign all the buttons with the correct value
            zero = new JButton("0");
            zero2 = new JButton("0");
            one = new JButton("1");
            two = new JButton("2");
            three = new JButton("3");
            four = new JButton("4");
            five = new JButton("5");
            six = new JButton("6");
            seven = new JButton("7");
            eight = new JButton("8");
            nine = new JButton("9");
            decimal = new JButton(".");
            add = new JButton("+");
            sub = new JButton("-");
            mult = new JButton("*");
            div = new JButton("/");
            negative = new JButton("-");
            clear = new JButton("C");
            clearEntry = new JButton("CE");
            back = new JButton("Back");
            equals = new JButton("=");
            oneOverX = new JButton("1/x");
            percent = new JButton("%");
            sqrt = new JButton("√");
            A = new JButton("A");
            B = new JButton("B");
            C = new JButton("C");
            D = new JButton("D");
            E = new JButton("E");
            F = new JButton("F");
            mod = new JButton("Mod");
            quot = new JButton("Quot");
            box1 = new JButton(" ");
            box2 = new JButton(" ");
            box3 = new JButton(" ");
            box4 = new JButton(" ");
            box5 = new JButton(" ");
            box6 = new JButton(" ");
            box7 = new JButton(" ");
            box8 = new JButton(" ");
            box9 = new JButton(" ");
            box10 = new JButton(" ");
            box11 = new JButton(" ");
            box12 = new JButton(" ");
            box13 = new JButton(" ");
            box14 = new JButton(" ");
            box15 = new JButton(" ");
                       
            getContentPane().add(result, BorderLayout.NORTH);
            getContentPane().add(binary);
            
                        
            buttons.setLayout(new GridLayout(6, 8 , 4, 4));
            buttons.add(quot);
            buttons.add(mod);
            buttons.add(A);
            buttons.add(box1);
            buttons.add(box2);
            buttons.add(box3);
            buttons.add(box4);
            buttons.add(box5);
            buttons.add(box6);
            buttons.add(box7);
            buttons.add(B);
            buttons.add(back);
            buttons.add(clearEntry);
            buttons.add(clear);
            buttons.add(negative);
            buttons.add(sqrt);
            buttons.add(box8);
            buttons.add(box9);
            buttons.add(C);
            buttons.add(seven);
            buttons.add(eight);
            buttons.add(nine);
            buttons.add(div);
            buttons.add(percent);
            buttons.add(box10);
            buttons.add(box11);
            buttons.add(D);
            buttons.add(four);
            buttons.add(five);
            buttons.add(six);
            buttons.add(mult);
            buttons.add(oneOverX);
            buttons.add(box12);
            buttons.add(box13);
            buttons.add(E);
            buttons.add(one);
            buttons.add(two);
            buttons.add(three);
            buttons.add(sub);
            buttons.add(equals);
            buttons.add(box14);
            buttons.add(box15);
            buttons.add(F);
            buttons.add(zero);
            buttons.add(zero2);
            buttons.add(decimal);
            buttons.add(add);
            
            hex = new JRadioButton("Hex");
            hex.setMnemonic(KeyEvent.VK_B);
            hex.setActionCommand("Hex");
            hex.setSelected(false);
            
            dec = new JRadioButton("Dec");
            dec.setMnemonic(KeyEvent.VK_B);
            dec.setActionCommand("Dec");
            dec.setSelected(true);
            
            oct = new JRadioButton("Oct");
            oct.setMnemonic(KeyEvent.VK_B);
            oct.setActionCommand("Oct");
            oct.setSelected(false);
            
            bin = new JRadioButton("Bin");
            bin.setMnemonic(KeyEvent.VK_B);
            bin.setActionCommand("Bin");
            bin.setSelected(false);
            
            ButtonGroup baseGroup = new ButtonGroup();
            baseGroup.add(hex);
            baseGroup.add(dec);
            baseGroup.add(oct);
            baseGroup.add(bin);
            
            base.setLayout(new GridLayout(4, 1));
            base.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            base.add(hex);
            base.add(dec);
            base.add(oct);
            base.add(bin);
            
            JRadioButton qword = new JRadioButton("Qword");
            qword.setMnemonic(KeyEvent.VK_B);
            qword.setActionCommand("Qword");
            qword.setSelected(true);
            
            JRadioButton dword = new JRadioButton("Dword");
            dword.setMnemonic(KeyEvent.VK_B);
            dword.setActionCommand("Dword");
            dword.setSelected(true);
            
            JRadioButton word = new JRadioButton("Word");
            word.setMnemonic(KeyEvent.VK_B);
            word.setActionCommand("Word");
            word.setSelected(true);
            
            JRadioButton bytee = new JRadioButton("Byte");
            bytee.setMnemonic(KeyEvent.VK_B);
            bytee.setActionCommand("Byte");
            bytee.setSelected(true);
            
            ButtonGroup wordGroup = new ButtonGroup();
            wordGroup.add(qword);
            wordGroup.add(dword);
            wordGroup.add(word);
            wordGroup.add(bytee);
            
            base2.setLayout(new GridLayout(4,1));
            base2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            base2.add(qword);
            base2.add(dword);
            base2.add(word);
            base2.add(bytee);
            
            JPanel bases = new JPanel(new GridLayout(2, 1));
            bases.add(base);
            bases.add(base2);
            
            masters.setLayout(new BorderLayout());
            masters.add(buttons, BorderLayout.CENTER);
            masters.add(bases, BorderLayout.WEST);
            
            getContentPane().add(masters, BorderLayout.SOUTH);
            
            quot.addActionListener(this);
            mod.addActionListener(this);
            back.addActionListener(this);
            clearEntry.addActionListener(this);
            clear.addActionListener(this);
            negative.addActionListener(this);
            sqrt.addActionListener(this);
            zero.addActionListener(this);
            zero2.addActionListener(this);
            one.addActionListener(this);
            two.addActionListener(this);
            three.addActionListener(this);
            four.addActionListener(this);
            five.addActionListener(this);
            six.addActionListener(this);
            seven.addActionListener(this);
            eight.addActionListener(this);
            nine.addActionListener(this);
            div.addActionListener(this);
            percent.addActionListener(this);
            mult.addActionListener(this);
            oneOverX.addActionListener(this);
            sub.addActionListener(this);
            decimal.addActionListener(this);
            add.addActionListener(this);
            equals.addActionListener(this);
            hex.addActionListener(this);
            dec.addActionListener(this);
            oct.addActionListener(this);
            bin.addActionListener(this);
            
        }
        
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == one)
            {
                result.setText("1");
            }
            if(e.getSource() == two)
            {
                result.setText("2");
            }
            if(e.getSource() == three)
            {
                result.setText("3");
            }
            if(e.getSource() == four)
            {
                result.setText("4");
            }
            if(e.getSource() == five)
            {
                result.setText("5");
            }
            if(e.getSource() == six)
            {
                result.setText("6");
            }
            if(e.getSource() == seven)
            {
                result.setText("7");
            }
            if(e.getSource() == eight)
            {
                result.setText("8");
            }
            if(e.getSource() == nine)
            {
                result.setText("9");
            }
            if(e.getSource() == zero || (e.getSource() == zero2) )
            {
                result.setText("0");
            }
            if(e.getSource() == back)
            {
                result.setText("back");
            }
            if(e.getSource() == clear)
            {
                result.setText("clear");
            }
            if(e.getSource() == clearEntry)
            {
                result.setText("clearEntry");
            }
            if(e.getSource() == negative)
            {
                result.setText("negative");
            }
            if(e.getSource() == add)
            {
                result.add();
            }
            if(e.getSource() == equals)
            {
                result.equals();
            }
            if(e.getSource() == sub)
            {
                result.sub();
            }
            if(e.getSource() == mult)
            {
                result.mult();
            }
            if(e.getSource() == div)
            {
                result.div();
            }
            
        }
    
}
