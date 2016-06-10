/* jSSC-Terminal - serial port terminal.
 * © Alexey Sokolov (scream3r), 2011.
 *
 * This file is part of jSSC-Terminal.
 *
 * jSSC-Terminal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jSSC-Terminal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 *
 * e-mail: scream3r.org@gmail.com
 * web-site: www.scream3r.org
 */
//package applet;

import java.awt.Desktop;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.net.URI;

/**
 *
 * @author scream3r
 */
public class DialogAbout extends javax.swing.JPanel {

    private Form parent;

    /** Creates new form DialogMessage */
    public DialogAbout(Form parent) {
        this.parent = parent;
        initComponents();
        setSize(500, 236);

        parent.setControlsFocusable(false);
        GlassPane glassPane = new GlassPane();
        glassPane.add(this);
        int x = (parent.getWidth()/2) - getWidth()/2;
        int y = (parent.getHeight()/2) - getHeight()/2;
        setBounds(x, y, getWidth(), getHeight());
        Main.getApplet().setGlassPane(glassPane);
        glassPane.setVisible(true);
    }

    private void closeDialog() {
        Main.getApplet().getGlassPane().setVisible(false);
        parent.setControlsFocusable(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jHeaderPanel = new javax.swing.JPanel(){

            protected void paintComponent(Graphics g){
                GradientPaint paint = new GradientPaint(0, 0, NimbusGui.INFO_PANEL_TOP_COLOR, 0, getHeight(), NimbusGui.INFO_PANEL_BOTTOM_COLOR);
                Graphics2D graphics2D = (Graphics2D)g.create();
                graphics2D.setPaint(paint);
                graphics2D.fillRect(0, 0, getWidth(), getHeight());
            }
        }
        ;
        jHeaderLabel = new javax.swing.JLabel();
        jDataPanel = new javax.swing.JPanel();
        jLabelMessage = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jHeaderPanel.setBorder(NimbusGui.DIALOG_PANEL_BORDER);
        jHeaderPanel.setPreferredSize(new java.awt.Dimension(286, 30));

        jHeaderLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jHeaderLabel.setForeground(NimbusGui.SECTION_LABEL_FONT_COLOR);
        jHeaderLabel.setText("About jSSC-Terminal");

        javax.swing.GroupLayout jHeaderPanelLayout = new javax.swing.GroupLayout(jHeaderPanel);
        jHeaderPanel.setLayout(jHeaderPanelLayout);
        jHeaderPanelLayout.setHorizontalGroup(
            jHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jHeaderLabel)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jHeaderPanelLayout.setVerticalGroup(
            jHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jDataPanel.setBackground(new java.awt.Color(231, 233, 237));
        jDataPanel.setBorder(NimbusGui.DIALOG_PANEL_BORDER);
        jDataPanel.setPreferredSize(new java.awt.Dimension(276, 75));

        jLabelMessage.setFont(NimbusGui.DEFAULT_FONT);
        jLabelMessage.setText("<html>\n&nbsp;&nbsp;This is a free and open source (GPL3 license) application that demonstrate some functions of jSSC (Java Simple Serial Connector) library. You can use this terminal for your work and make changes in source code (under terms of GPL3 license).<br><br>\n\n<center><strong>Based on jSSC-0.8-tb2</strong><br><br></center>\n\n<center>Author: Sokolov Alexey (scream3r)</center>\n</html>");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 2));

        jButtonClose.setFont(NimbusGui.DEFAULT_FONT);
        jButtonClose.setText("Close");
        jButtonClose.setPreferredSize(new java.awt.Dimension(90, 28));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        jButtonClose.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonCloseKeyPressed(evt);
            }
        });

        jLabel1.setFont(NimbusGui.DEFAULT_FONT);
        jLabel1.setText("<html><a href=\"http://scream3r.org\">http://scream3r.org</a></html>");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jDataPanelLayout = new javax.swing.GroupLayout(jDataPanel);
        jDataPanel.setLayout(jDataPanelLayout);
        jDataPanelLayout.setHorizontalGroup(
            jDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(jDataPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jDataPanelLayout.setVerticalGroup(
            jDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDataPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jHeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(jDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jHeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        closeDialog();
}//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonCloseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCloseKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            closeDialog();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButtonClose.doClick();
        }
}//GEN-LAST:event_jButtonCloseKeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI("http://scream3r.org"));
            }
            catch (Exception ex) {
                //Do nothing
            }
        }
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JPanel jDataPanel;
    static javax.swing.JLabel jHeaderLabel;
    private javax.swing.JPanel jHeaderPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
