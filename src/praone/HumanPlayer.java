/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praone;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Денис
 */
public class HumanPlayer extends Player {
    
    HumanPlayer(String symbol, JTable table)
    {
        super(symbol, table);
    }
    
    public void Move()
    {
        if (gameEnd())
            {
                JOptionPane.showMessageDialog(null, "Конец игры", "Конец игры", 2);
                return;
            }
        int row, column;
        row = table.getSelectedRow();
        column = table.getSelectedColumn();
        this.moveTo(row, column);
    }
    
}
