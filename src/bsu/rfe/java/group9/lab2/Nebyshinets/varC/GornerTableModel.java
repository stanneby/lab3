package bsu.rfe.java.group9.lab2.Nebyshinets.varC;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    @Override
    public int getRowCount() {
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int row, int col) {
        double x = from + step*row;
        if( col== 0){
            return x;
        } else if(col == 1) {
            int arr_len = coefficients.length;
            Double result = coefficients[arr_len-1];
            for(int i = arr_len-2; i > -1; i--) {
                result *= x;
                result += coefficients[i];
            }
            return result;
        } else if(col == 2) {
            int arr_len = coefficients.length;
            Double result = coefficients[0];
            for(int i = 1; i < arr_len; i++) {
                result *= x;
                result += coefficients[i];
            }
            return result;
        } else {
            int arr_len = coefficients.length;
            Double result_forward = coefficients[arr_len-1];
            for(int i = arr_len-2; i > -1; i--) {
                result_forward *= x;
                result_forward += coefficients[i];
            }
            Double result_backward = coefficients[0];
            for(int i = 1; i < arr_len; i++) {
                result_backward *= x;
                result_backward += coefficients[i];
            }
            return result_forward - result_backward;
        }
    }

    public Class<?> getColumnClass(int arg0){
        return Double.class;
    }

    public String getColumnName(int col){
        switch(col) {
            case 0:
                return "Значение Х";
            case 1:
                return "Значение многочлена";
            case 2:
                return "Значение обратного многочлена";
            case 3:
                return "Разница значений";
            default:
                return "kek";
        }
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }
}
