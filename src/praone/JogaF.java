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
public class JogaF {
    
    private int row;
    private int column;
    private JTable table;
    
    JogaF(int row, int column, JTable table)
    {
        this.row = row;
        this.column = column;
        this.table = table;
    }
    
    void Move(int row, int column)
    {
        if (table.getValueAt(this.row, this.column) != "O")
            return;
        if (table.getValueAt(row, column) == "" && movePossible(row, column, 1))
        {
            table.setValueAt("O", row, column);
            table.setValueAt("", this.row, this.column);
        }
        if (table.getValueAt(row, column) == "" && movePossible(row, column, 2)
                && table.getValueAt((this.row + row) / 2, (this.column + column) / 2) == "O")
        {
            table.setValueAt("O", row, column);
            table.setValueAt("", this.row, this.column);
            table.setValueAt("", (this.row + row) / 2, (this.column + column) / 2);
        }
    }
    
    boolean movePossible(int row, int column, int n)
    {
        if (Math.abs(this.row - row) == n && Math.abs(this.column - column) == 0)
            return true;
        if (Math.abs(this.row - row) == 0 && Math.abs(this.column - column) == n)
            return true;
        return false;
    }
}
