
package views;

import stockage.BD;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 * @author BLENDER
 */
public class Table {
    String[] entete;
    int cols_tb, cols_bd;
    String req;
    TableColumnModel columnModel;
    JTable tab;
    Dimension dimension;
    JScrollPane pane;

    public Table(String[] entete, int cols_tb, int cols_bd, String req) {
        this.cols_bd = cols_bd;
        this.cols_tb = cols_tb;
        this.req = req;
        this.entete = entete;

        try {
            Connection conn = BD.GetConnection();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = stm.executeQuery(req);
            rs2.last();
            int rows = rs2.getRow();
            Object[][] data = new Object[rows][cols_tb];
            int j = 1;
            rs2.beforeFirst();
            while (rs2.next()) {
                for (int i = 1; i <= cols_bd; i++) {
                    data[j - 1][i - 1] = rs2.getObject(i);
                }
                j++;
            }
            rs2.close();
            tab = new JTable(data, entete) {
                public Component prepareRenderer(TableCellRenderer renderer,
                        int row, int column) {
                    Component c = super.prepareRenderer(renderer, row, column);
                    Color color1 = new Color(190, 228, 252);
                    Color color2 = Color.WHITE;
                    if (!c.getBackground().equals(getSelectionBackground())) {
                        Color color = (row % 2 == 0 ? color1 : color2);
                        c.setBackground(color);
                    }
                    return c;
                }

                @Override
                public boolean isCellEditable(int row, int col) {
                    return col == 0 ? false : true;
                }
            };
            tab.getTableHeader().setBackground(new java.awt.Color(0, 0, 102));
            tab.getTableHeader().setForeground(Color.WHITE);
            Font font = new Font("Arial", Font.BOLD, 18);
            Font font1 = new Font("Arial", Font.BOLD, 16);
            tab.setFont(font1);
            tab.setBackground(new Color(142, 197, 206));
            tab.setRowHeight(35);
            tab.getTableHeader().setFont(font);
            columnModel = tab.getColumnModel();
            dimension = tab.getPreferredSize();

            pane = new JScrollPane(tab);
            // int rowsVisible = tab.getModel().getRowCount();
            // tab.setPreferredScrollableViewportSize(new
            // Dimension(tab.getPreferredSize().width,tab.getRowHeight() * rowsVisible));
            // pane.setMinimumSize(new
            // Dimension(dimension.width,tab.getRowHeight()*rowsVisible));
        } catch (SQLException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public JTable getTable() {
        return this.tab;
    }

    public JScrollPane getPane(int hauteur) {
        pane.setPreferredSize(new Dimension(tab.getPreferredSize().width, hauteur));
        return this.pane;
    }

}
