package bsu.rfe.java.group9.lab2.Nebyshinets.varC;


import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    private String needle1 = null;
    private String needle2 = null;

    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    public GornerTableCellRenderer(){
        formatter.setMaximumFractionDigits(5);
        formatter.setGroupingUsed(false);

        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        label.setText(formatter.format(value));
        if(col!=0 && needle1!=null && needle2==null && needle1.equals(formatter.format(value))) {
            panel.setBackground(Color.RED);
            label.setForeground(Color.BLACK);
        }else if((needle1 != null) && (needle2 != null) &&
                ((Double)value>=Double.parseDouble(needle1)) &&
                ((Double)value<=Double.parseDouble(needle2)) ){
            panel.setBackground(Color.RED);
            label.setForeground(Color.BLACK);
        } else if( col%2 == row%2 ){
            panel.setBackground(Color.WHITE);
            label.setForeground(Color.BLACK);
        } else {
            panel.setBackground(Color.BLACK);
            label.setForeground(Color.WHITE);
        }
        return panel;
    }

    public void setNeedle(String needle) {
        this.needle1 = needle;
    }
    public void setNeedle(String needle1, String needle2) {
        this.needle1 = needle1;
        this.needle2 = needle2;
    }
}
