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
public abstract class Player {
    protected String symbol;
    protected JTable table;
    
    Player(String symbol, JTable table)
    {
        this.symbol = symbol;
        this.table = table;
    }
    
    protected void moveTo(int row, int column)
    {
        if (isMovePossible(row, column))
            table.getModel().setValueAt(symbol, row, column);
    }
    
    protected boolean isMovePossible(int row, int column)
    {
        return "".equals(table.getModel().getValueAt(row, column).toString());
    }
    
    String getV(int row, int column)
    {
        return table.getValueAt(row, column).toString();
    }
    
    protected boolean gameEnd()
    {
        if (getV(0,0).equals(getV(0,1)) && getV(0,0).equals(getV(0,2)) && !"".equals(getV(0,0)))
            return true;
        if (getV(1,0).equals(getV(1,1)) && getV(1,0).equals(getV(1,2)) && !"".equals(getV(1,0)))
            return true;
        if (getV(2,0).equals(getV(2,1)) && getV(2,0).equals(getV(2,2)) && !"".equals(getV(2,0)))
            return true;
        if (getV(0,0).equals(getV(1,0)) && getV(0,0).equals(getV(2,0)) && !"".equals(getV(0,0)))
            return true;
        if (getV(0,1).equals(getV(1,1)) && getV(0,1).equals(getV(2,1)) && !"".equals(getV(0,1)))
            return true;
        if (getV(0,2).equals(getV(1,2)) && getV(0,2).equals(getV(2,2)) && !"".equals(getV(0,2)))
            return true;
        if (getV(0,0).equals(getV(1,1)) && getV(0,0).equals(getV(2,2)) && !"".equals(getV(0,0)))
            return true;
        if (getV(0,2).equals(getV(1,1)) && getV(0,2).equals(getV(2,0)) && !"".equals(getV(0,2)))
            return true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if ("".equals(getV(i,j)))
                    return false;
        return true;
    }
    abstract void Move();
}
