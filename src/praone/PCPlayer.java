/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praone;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Денис
 */
public class PCPlayer extends Player{
    
    private final boolean isEasy;
    
    PCPlayer(String symbol, JTable table, boolean level)
    {
        super(symbol, table);
        isEasy = level;
    }
    
    @Override
    void Move()
    {
            if (gameEnd())
            {
                JOptionPane.showMessageDialog(null, "Конец игры", "Конец игры", 2);
                return;
            }
        if (isEasy)
        {
            RandomMove();
        }
        else
        {
            if ("X".equals(symbol))
            {
                // алгоритм крестиков
                if (this.isMovePossible(1, 1))
                {
                    this.moveTo(1, 1);
                    return;
                }
                try
                {
                attackMode("X");
                defenseMode("O");
                
                RandomMove();
                }
                catch(Exception e)
                {
                }
            } else
            {
                // алгоритм ноликов
                if (this.isMovePossible(1, 1))
                {
                    this.moveTo(1, 1);
                    return;
                }
                try {
                 attackMode("O");
                defenseMode("X");
                
                RandomMove();
                }
                catch (Exception e)
                {
                }
            }
        }
        if (gameEnd())
            {
                JOptionPane.showMessageDialog(null, "Конец игры", "Конец игры", 2);
                return;
            }
    }
    
    private void RandomMove()
    {
        int row, column;
        do
        {
            column = ThreadLocalRandom.current().nextInt(0, 3);
            row = ThreadLocalRandom.current().nextInt(0, 3);
        } while (!this.isMovePossible(row, column));
        this.moveTo(row, column);
    }
    
    @SuppressWarnings("empty-statement")
    private void defenseMode(String attacker) throws Exception
    {
        int counter = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (table.getValueAt(i, j) == attacker)
                    counter++;
            }
            if (counter == 2)
            {
                for (int k = 0; k < 3; k++)
                {
                    if (isMovePossible(i,k))
                    {
                        this.moveTo(i, k);
                        throw new Exception();
                    }
                }
            }
            counter = 0;
        }
        counter = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (table.getValueAt(j, i) == attacker)
                    counter++;
            }
            if (counter == 2)
            {
                for (int k = 0; k < 3; k++)
                {
                    if (isMovePossible(k,i))
                    {
                       this.moveTo(k, i);
                        throw new Exception();
                    }
                }
            }
            counter = 0;
        }
        counter = 0;
        for (int i = 0; i < 3; i++)
        {
            if (table.getValueAt(i,i) == attacker)
                counter++;
            if (counter == 2)
            {
                for (int k = 0; k < 3; k++)
                {
                    if (isMovePossible(k,k))
                    {
                        this.moveTo(k, k);
                        throw new Exception();
                    }
                }
            }
        }
        int l = 2;
        for(int i = 0; i < 3; i++, l--)
        {
            if (table.getValueAt(i,l) == attacker)
                counter++;
            if (counter == 2)
            {
                int p = 2;
                for (int k = 0; k < 3; k++, p--)
                {
                    if (isMovePossible(k,p))
                    {
                        this.moveTo(k, p);
                        throw new Exception();
                    }
                }
            }
        }
    }
    
    private void attackMode(String attacker) throws Exception
    {
        defenseMode(attacker);
    }
}
