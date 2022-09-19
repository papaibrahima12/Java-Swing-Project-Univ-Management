package autre;

import java.awt.Color;
import java.awt.Component;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
public class ButtonDelete extends JButton implements TableCellRenderer{
    public ButtonDelete()
    {
      setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      setForeground(Color.black);
      setBackground(Color.red);
      setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/img/ico-delete.png"))));
      setText((value == null) ? "" : value.toString());
      return this;
    }
}
