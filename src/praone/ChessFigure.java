/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package praone;

import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author Денис
 */
abstract class ChessFigure {
    protected int column;
    protected int row;
    protected String marker;
    protected final int frow;
    
    protected JTable table;
    protected JTable score;
    
    public ChessFigure(int row, int column, JTable t, JTable score)
    {
        this.table = t;
        this.score = score;
        this.column = column;
        this.row = row;
        if (row == 0)
            frow = 2;
        else
            frow = 0;
    }
    
    public void MoveTo(int row, int column)
    {
        DefaultTableModel ym;
        if (movePos(row,column) == true)
        {
            table.setValueAt("", this.row, this.column);
            table.setValueAt(marker, row, column);

            DefaultTableModel model = (DefaultTableModel) this.score.getModel();
            String a = "", a1 = "";
            switch(this.column)
            {
                case 1:
                    a = "A"; break;
                case 2:
                    a = "B"; break;
                case 3:
                    a = "C"; break;
            }
            switch(column)
            {
                case 1:
                    a1 = "A"; break;
                case 2:
                    a1 = "B"; break;
                case 3:
                    a1 = "C"; break;
            }
            model.addRow(new Object[]{marker, a + this.row, a1 + row});
            this.row = row;
            this.column = column;
        }
    }
    
    public boolean inPlace()
    {
        return row == frow;
    }
    
    public boolean datU(int row, int column)
    {
        return row == this.row && column == this.column;
    }
    
    protected abstract boolean movePos(int row, int column);
}
