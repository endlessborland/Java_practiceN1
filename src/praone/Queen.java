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
public class Queen extends ChessFigure{
    
    Queen(int row, int column, JTable t, JTable score)
    {
        super(row, column, t, score);
        marker = this.table.getValueAt(row, column).toString();
    }
    
    @Override
    protected boolean movePos(int row, int column)
    {
        if (this.table.getValueAt(row, column) == "")
        {
            if (row == this.row || column == this.column)
                return true;
            if (Math.abs(row - this.row) == Math.abs(column - this.column))
                return true;
        }
        return false;
    }
    
}
