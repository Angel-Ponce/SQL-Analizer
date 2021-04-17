/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author angel_p11
 */
public class CustomCell extends DefaultTableCellRenderer {

    String type = "text";
    JCheckBox check = new JCheckBox();

    public CustomCell(String type) {
        this.type = type;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setHorizontalAlignment(CENTER);
        this.setText(String.valueOf(value));
  
        if (this.type.equals("number")) {
            this.setForeground(Color.GREEN);
        }
        if (value instanceof Boolean) {
            check.setSelected((Boolean) value);
            check.setHorizontalAlignment(CENTER);
            return check;
        }
        return this;
    }

}
