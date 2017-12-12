/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praone;

import javax.swing.JTable;

/**
 *
 * @author Денис
 */
public class FPart {
    private int row;
    private int column;
    private Integer value;
    private final JTable table;
    
    public int getRow() {return row;}
    public int getColumn() {return column;}
    
    
    FPart(int row, int column, Integer value, JTable table)
    {
        this.row = row;
        this.column = column;
        this.value = value;
        this.table = table;
    }
    
    FPart Move(FPart blank)
    {
        if ((Math.abs(blank.getRow() - this.row) == 1 &&
                Math.abs(blank.getColumn() - this.column) == 0) ||
            (Math.abs(blank.getRow() - this.row) == 0 &&
                Math.abs(blank.getColumn() - this.column) == 1))
        {
            table.getModel().setValueAt(value.intValue(), blank.getRow(), blank.getColumn());
            table.getModel().setValueAt(null, this.row, this.column);
            return this;
        }                
        return blank;
    }
    
}
