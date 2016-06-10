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

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.SwingUtilities;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortList;

/**
 *
 * @author scream3r
 */
public class Form extends javax.swing.JPanel {

    private String portName;
    private int baudRate = SerialPort.BAUDRATE_9600;
    private int dataBits = SerialPort.DATABITS_8;
    private int stopBits = SerialPort.STOPBITS_1;
    private int parity = SerialPort.PARITY_NONE;
    private SerialPort serialPort;

    /** Creates new form Form */
    public Form() {
        initComponents();
        enableControls(false);
        String[] ports = SerialPortList.getPortNames();
        if(ports.length > 0){
            portName = ports[0];
        }
        updatePortInfo();
        jPanel1.setBorder(NimbusGui.INFO_PANEL_BORDER);
    }

    public void updatePortSettings(String portName, int baudRate, int dataBits, int stopBits, int parity) {
        this.portName = portName;
        this.baudRate = baudRate;
        this.dataBits = dataBits;
        this.stopBits = stopBits;
        this.parity = parity;
        updatePortInfo();
    }

    private boolean updatePortInfo() {
        boolean returnValue = false;
        String info = "";
        if(!portName.equals("")){
            info += (portName + " @ ");
            info += (baudRate + "-");
            info += (dataBits + "-");
            switch (parity) {
                case SerialPort.PARITY_NONE:
                    info += ("N-");
                    break;
                case SerialPort.PARITY_EVEN:
                    info += ("E-");
                    break;
                case SerialPort.PARITY_ODD:
                    info += ("O-");
                    break;
                case SerialPort.PARITY_SPACE:
                    info += ("S-");
                    break;
                case SerialPort.PARITY_MARK:
                    info += ("M-");
                    break;
            }
            switch (stopBits) {
                case SerialPort.STOPBITS_1:
                    info += ("1");
                    break;
                case SerialPort.STOPBITS_1_5:
                    info += ("1.5");
                    break;
                case SerialPort.STOPBITS_2:
                    info += ("2");
                    break;
            }
            jLabelPortInfo.setText(info);
            jButtonOpenPort.setEnabled(true);
            returnValue = true;
        }
        else {
            jLabelPortInfo.setText("");
            jButtonOpenPort.setEnabled(false);
        }
        return returnValue;
    }

    private void enableControls(boolean value) {
        jButtonSettings.setEnabled(!value);
        jComboBoxIn.setEnabled(value);
        jButtonClear.setEnabled(value);
        jLabelCTS.setEnabled(value);
        jLabelDSR.setEnabled(value);
        jLabelRLSD.setEnabled(value);
        jLabelCTS.setOpaque(value);
        jLabelDSR.setOpaque(value);
        jLabelRLSD.setOpaque(value);
        jTextAreaIn.setEnabled(value);
        jTextFieldOut.setEnabled(value);
        jButtonSend.setEnabled(value);
        jButtonSendHEX.setEnabled(value);
        jToggleButtonRTS.setEnabled(value);
        jToggleButtonDTR.setEnabled(value);
    }

    public void setControlsFocusable(boolean value) {
        jButtonOpenPort.setFocusable(value);
        jButtonSettings.setFocusable(value);
        jComboBoxIn.setFocusable(value);
        jButtonClear.setFocusable(value);
        jTextAreaIn.setFocusable(value);
        jTextFieldOut.setFocusable(value);
        jButtonSend.setFocusable(value);
        jButtonSendHEX.setFocusable(value);
        jToggleButtonRTS.setFocusable(value);
        jToggleButtonDTR.setFocusable(value);
    }

    private void clearFields() {
        jComboBoxIn.setSelectedIndex(0);
        jTextAreaIn.setText("");
        jTextFieldOut.setText("");
        jToggleButtonRTS.setSelected(false);
        jToggleButtonDTR.setSelected(false);
    }

    private void sendString() {
        String str = jTextFieldOut.getText();
        if(str.length() > 0){
            try {
                serialPort.writeBytes(jTextFieldOut.getText().getBytes());
                jTextFieldOut.setText("");
            }
            catch (Exception ex) {
                DialogMessage dialogMessage = new DialogMessage(this, DialogMessage.TYPE_ERROR, "Writing data", "Error occurred while writing data.");
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){

            protected void paintComponent(Graphics g){
                GradientPaint paint = new GradientPaint(0, 0, NimbusGui.INFO_PANEL_TOP_COLOR, 0, getHeight(), NimbusGui.INFO_PANEL_BOTTOM_COLOR);
                Graphics2D graphics2D = (Graphics2D)g.create();
                graphics2D.setPaint(paint);
                graphics2D.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jAppName = new javax.swing.JLabel();
        jLabelPortInfo = new javax.swing.JLabel();
        jButtonOpenPort = new javax.swing.JButton();
        jButtonSettings = new javax.swing.JButton();
        jHeaderPanelInput = new javax.swing.JPanel(){

            protected void paintComponent(Graphics g){
                GradientPaint paint = new GradientPaint(0, 0, NimbusGui.INFO_PANEL_TOP_COLOR, 0, getHeight(), NimbusGui.INFO_PANEL_BOTTOM_COLOR);
                Graphics2D graphics2D = (Graphics2D)g.create();
                graphics2D.setPaint(paint);
                graphics2D.fillRect(0, 0, getWidth(), getHeight());
            }
        }
        ;
        jHeaderLabelInput = new javax.swing.JLabel();
        jInputDataPanel = new javax.swing.JPanel();
        jLabelView = new javax.swing.JLabel();
        jComboBoxIn = new javax.swing.JComboBox();
        jButtonClear = new javax.swing.JButton();
        jLabelCTS = new javax.swing.JLabel();
        jLabelDSR = new javax.swing.JLabel();
        jLabelRLSD = new javax.swing.JLabel();
        jScrollPaneIn = new javax.swing.JScrollPane();
        jTextAreaIn = new javax.swing.JTextArea();
        jHeaderPanelOutput = new javax.swing.JPanel(){

            protected void paintComponent(Graphics g){
                GradientPaint paint = new GradientPaint(0, 0, NimbusGui.INFO_PANEL_TOP_COLOR, 0, getHeight(), NimbusGui.INFO_PANEL_BOTTOM_COLOR);
                Graphics2D graphics2D = (Graphics2D)g.create();
                graphics2D.setPaint(paint);
                graphics2D.fillRect(0, 0, getWidth(), getHeight());
            }
        }
        ;
        jHeaderLabelOutput = new javax.swing.JLabel();
        jOutputDataPanel = new javax.swing.JPanel();
        jTextFieldOut = new javax.swing.JTextField();
        jButtonSend = new javax.swing.JButton();
        jButtonSendHEX = new javax.swing.JButton();
        jSeparatorOut = new javax.swing.JSeparator();
        jToggleButtonRTS = new javax.swing.JToggleButton();
        jToggleButtonDTR = new javax.swing.JToggleButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(141, 156, 166)));
        setMaximumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel1.setBackground(new Color(156, 183, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(747, 40));

        jAppName.setFont(NimbusGui.INFO_PANEL_FONT);
        jAppName.setForeground(NimbusGui.INFO_PANEL_FONT_COLOR);
        jAppName.setText("jSSC-Terminal");
        jAppName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jAppName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAppNameMouseClicked(evt);
            }
        });

        jLabelPortInfo.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelPortInfo.setForeground(NimbusGui.SECTION_LABEL_FONT_COLOR);
        jLabelPortInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jButtonOpenPort.setFont(NimbusGui.DEFAULT_FONT);
        jButtonOpenPort.setText("Open port");
        jButtonOpenPort.setPreferredSize(new java.awt.Dimension(100, 28));
        jButtonOpenPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenPortActionPerformed(evt);
            }
        });

        jButtonSettings.setFont(NimbusGui.DEFAULT_FONT);
        jButtonSettings.setText("Settings");
        jButtonSettings.setPreferredSize(new java.awt.Dimension(75, 28));
        jButtonSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSettingsMouseExited(evt);
            }
        });
        jButtonSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSettingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAppName)
                .addGap(6, 6, 6)
                .addComponent(jLabelPortInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jButtonOpenPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButtonSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonOpenPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPortInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jAppName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jHeaderPanelInput.setBorder(NimbusGui.WORK_AND_DATA_PANEL_BORDER);
        jHeaderPanelInput.setPreferredSize(new java.awt.Dimension(286, 30));

        jHeaderLabelInput.setFont(new java.awt.Font("Tahoma", 1, 12));
        jHeaderLabelInput.setForeground(NimbusGui.SECTION_LABEL_FONT_COLOR);
        jHeaderLabelInput.setText("Input");

        javax.swing.GroupLayout jHeaderPanelInputLayout = new javax.swing.GroupLayout(jHeaderPanelInput);
        jHeaderPanelInput.setLayout(jHeaderPanelInputLayout);
        jHeaderPanelInputLayout.setHorizontalGroup(
            jHeaderPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jHeaderPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jHeaderLabelInput)
                .addContainerGap(569, Short.MAX_VALUE))
        );
        jHeaderPanelInputLayout.setVerticalGroup(
            jHeaderPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jHeaderLabelInput, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jInputDataPanel.setBackground(new java.awt.Color(231, 233, 237));
        jInputDataPanel.setBorder(NimbusGui.WORK_AND_DATA_PANEL_BORDER);
        jInputDataPanel.setPreferredSize(new java.awt.Dimension(276, 75));

        jLabelView.setFont(NimbusGui.DEFAULT_FONT);
        jLabelView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelView.setText("View as:");
        jLabelView.setPreferredSize(new java.awt.Dimension(40, 28));

        jComboBoxIn.setFont(NimbusGui.DEFAULT_FONT);
        jComboBoxIn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chars", "Digits", "HEX" }));
        jComboBoxIn.setPreferredSize(new java.awt.Dimension(100, 28));

        jButtonClear.setFont(NimbusGui.DEFAULT_FONT);
        jButtonClear.setText("Clear");
        jButtonClear.setPreferredSize(new java.awt.Dimension(90, 28));
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jLabelCTS.setFont(NimbusGui.DEFAULT_FONT);
        jLabelCTS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCTS.setText("CTS");
        jLabelCTS.setPreferredSize(new java.awt.Dimension(34, 28));

        jLabelDSR.setFont(NimbusGui.DEFAULT_FONT);
        jLabelDSR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDSR.setText("DSR");
        jLabelDSR.setPreferredSize(new java.awt.Dimension(34, 28));

        jLabelRLSD.setFont(NimbusGui.DEFAULT_FONT);
        jLabelRLSD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRLSD.setText("RLSD");
        jLabelRLSD.setPreferredSize(new java.awt.Dimension(34, 28));

        jTextAreaIn.setColumns(20);
        jTextAreaIn.setEditable(false);
        jTextAreaIn.setFont(NimbusGui.DEFAULT_FONT);
        jTextAreaIn.setLineWrap(true);
        jTextAreaIn.setRows(5);
        jTextAreaIn.setWrapStyleWord(true);
        jScrollPaneIn.setViewportView(jTextAreaIn);

        javax.swing.GroupLayout jInputDataPanelLayout = new javax.swing.GroupLayout(jInputDataPanel);
        jInputDataPanel.setLayout(jInputDataPanelLayout);
        jInputDataPanelLayout.setHorizontalGroup(
            jInputDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInputDataPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jInputDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInputDataPanelLayout.createSequentialGroup()
                        .addComponent(jLabelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBoxIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                        .addComponent(jLabelCTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelDSR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelRLSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneIn, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jInputDataPanelLayout.setVerticalGroup(
            jInputDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInputDataPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jInputDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRLSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDSR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPaneIn, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jHeaderPanelOutput.setBorder(NimbusGui.WORK_AND_DATA_PANEL_BORDER);
        jHeaderPanelOutput.setPreferredSize(new java.awt.Dimension(286, 30));

        jHeaderLabelOutput.setFont(new java.awt.Font("Tahoma", 1, 12));
        jHeaderLabelOutput.setForeground(NimbusGui.SECTION_LABEL_FONT_COLOR);
        jHeaderLabelOutput.setText("Output");

        javax.swing.GroupLayout jHeaderPanelOutputLayout = new javax.swing.GroupLayout(jHeaderPanelOutput);
        jHeaderPanelOutput.setLayout(jHeaderPanelOutputLayout);
        jHeaderPanelOutputLayout.setHorizontalGroup(
            jHeaderPanelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jHeaderPanelOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jHeaderLabelOutput)
                .addContainerGap(559, Short.MAX_VALUE))
        );
        jHeaderPanelOutputLayout.setVerticalGroup(
            jHeaderPanelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jHeaderLabelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jOutputDataPanel.setBackground(new java.awt.Color(231, 233, 237));
        jOutputDataPanel.setBorder(NimbusGui.WORK_AND_DATA_PANEL_BORDER);
        jOutputDataPanel.setPreferredSize(new java.awt.Dimension(276, 75));

        jTextFieldOut.setFont(NimbusGui.DEFAULT_FONT);
        jTextFieldOut.setPreferredSize(new java.awt.Dimension(59, 28));
        jTextFieldOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOutActionPerformed(evt);
            }
        });

        jButtonSend.setFont(NimbusGui.DEFAULT_FONT);
        jButtonSend.setText("Send");
        jButtonSend.setPreferredSize(new java.awt.Dimension(90, 28));
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jButtonSendHEX.setFont(NimbusGui.DEFAULT_FONT);
        jButtonSendHEX.setText("Send HEX");
        jButtonSendHEX.setPreferredSize(new java.awt.Dimension(90, 28));
        jButtonSendHEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendHEXActionPerformed(evt);
            }
        });

        jSeparatorOut.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparatorOut.setPreferredSize(new java.awt.Dimension(2, 28));

        jToggleButtonRTS.setFont(NimbusGui.DEFAULT_FONT);
        jToggleButtonRTS.setText("Set RTS");
        jToggleButtonRTS.setPreferredSize(new java.awt.Dimension(75, 28));
        jToggleButtonRTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRTSActionPerformed(evt);
            }
        });

        jToggleButtonDTR.setFont(NimbusGui.DEFAULT_FONT);
        jToggleButtonDTR.setText("Set DTR");
        jToggleButtonDTR.setPreferredSize(new java.awt.Dimension(75, 28));
        jToggleButtonDTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonDTRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jOutputDataPanelLayout = new javax.swing.GroupLayout(jOutputDataPanel);
        jOutputDataPanel.setLayout(jOutputDataPanelLayout);
        jOutputDataPanelLayout.setHorizontalGroup(
            jOutputDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jOutputDataPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTextFieldOut, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButtonSendHEX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparatorOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jToggleButtonRTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jToggleButtonDTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jOutputDataPanelLayout.setVerticalGroup(
            jOutputDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jOutputDataPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jOutputDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButtonDTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButtonRTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparatorOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSendHEX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jHeaderPanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jOutputDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jHeaderPanelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jInputDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jHeaderPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jInputDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jHeaderPanelOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jOutputDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpenPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenPortActionPerformed
        if(jButtonOpenPort.getText().equals("Open port")){
            serialPort = new SerialPort(portName);
            try {
                if(serialPort.openPort()){
                    if(serialPort.setParams(baudRate, dataBits, stopBits, parity)){
                        jButtonOpenPort.setText("Close port");
                        serialPort.addEventListener(new Reader(), SerialPort.MASK_RXCHAR |
                                                                  SerialPort.MASK_RXFLAG |
                                                                  SerialPort.MASK_CTS |
                                                                  SerialPort.MASK_DSR |
                                                                  SerialPort.MASK_RLSD);
                        enableControls(true);
                        if(serialPort.isCTS()){
                            jLabelCTS.setBorder(NimbusGui.borderStatusOn);
                            jLabelCTS.setBackground(NimbusGui.colorStatusOnBG);
                        }
                        else {
                            jLabelCTS.setBorder(NimbusGui.borderStatusOff);
                            jLabelCTS.setBackground(NimbusGui.colorStatusOffBG);
                        }
                        if(serialPort.isDSR()){
                            jLabelDSR.setBorder(NimbusGui.borderStatusOn);
                            jLabelDSR.setBackground(NimbusGui.colorStatusOnBG);
                        }
                        else {
                            jLabelDSR.setBorder(NimbusGui.borderStatusOff);
                            jLabelDSR.setBackground(NimbusGui.colorStatusOffBG);
                        }
                        if(serialPort.isRLSD()){
                            jLabelRLSD.setBorder(NimbusGui.borderStatusOn);
                            jLabelRLSD.setBackground(NimbusGui.colorStatusOnBG);
                        }
                        else {
                            jLabelRLSD.setBorder(NimbusGui.borderStatusOff);
                            jLabelRLSD.setBackground(NimbusGui.colorStatusOffBG);
                        }
                        if(serialPort.setRTS(true)){
                            jToggleButtonRTS.setSelected(true);
                        }
                        if(serialPort.setDTR(true)){
                            jToggleButtonDTR.setSelected(true);
                        }
                    }
                    else {
                        DialogMessage dialogMessage = new DialogMessage(this, DialogMessage.TYPE_ERROR, "Setting parameters", "Can't set selected parameters.");
                        serialPort.closePort();
                    }
                }
                else {
                    DialogMessage dialogMessage = new DialogMessage(this, DialogMessage.TYPE_ERROR, "Port opening", "Can't open port. Maybe port in use.");
                }
            }
            catch (Exception ex) {
                //Do nothing
            }
        }
        else {
            try {
                if(serialPort.closePort()){
                    jButtonOpenPort.setText("Open port");
                    jLabelCTS.setBorder(null);
                    jLabelDSR.setBorder(null);
                    jLabelRLSD.setBorder(null);
                    enableControls(false);
                    clearFields();
                }
                else {
                    DialogMessage dialogMessage = new DialogMessage(this, DialogMessage.TYPE_ERROR, "Port closing", "Can't close port.");
                }
            }
            catch (Exception ex) {
                //Do nothing
            }
        }
}//GEN-LAST:event_jButtonOpenPortActionPerformed

    private void jToggleButtonRTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRTSActionPerformed
        try {
            serialPort.setRTS(jToggleButtonRTS.isSelected());
        }
        catch (Exception ex) {
            DialogMessage dialogMessage = new DialogMessage(this, DialogMessage.TYPE_ERROR, "Changing RTS state", "Error occurred while changing RTS state.");
        }
    }//GEN-LAST:event_jToggleButtonRTSActionPerformed

    private void jToggleButtonDTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonDTRActionPerformed
        try {
            serialPort.setDTR(jToggleButtonDTR.isSelected());
        }
        catch (Exception ex) {
            DialogMessage dialogMessage = new DialogMessage(this, DialogMessage.TYPE_ERROR, "Changing DTR state", "Error occurred while changing DTR state.");
        }
    }//GEN-LAST:event_jToggleButtonDTRActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        sendString();
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jButtonSendHEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendHEXActionPerformed
        setControlsFocusable(false);
        GlassPane glassPane = new GlassPane();
        DialogHEX dialog = new DialogHEX(this, serialPort);
        glassPane.add(dialog);
        int x = (getWidth()/2) - dialog.getWidth()/2;
        int y = (getHeight()/2) - dialog.getHeight()/2;
        dialog.setBounds(x, y, dialog.getWidth(), dialog.getHeight());
        Main.getApplet().setGlassPane(glassPane);
        glassPane.setVisible(true);
    }//GEN-LAST:event_jButtonSendHEXActionPerformed

    private void jButtonSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSettingsActionPerformed
        DialogSettings dialogSettings = new DialogSettings(this, portName, baudRate, dataBits, stopBits, parity);
    }//GEN-LAST:event_jButtonSettingsActionPerformed

    private void jButtonSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSettingsMouseExited
        validate();
        repaint();
    }//GEN-LAST:event_jButtonSettingsMouseExited

    private void jTextFieldOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOutActionPerformed
        sendString();
    }//GEN-LAST:event_jTextFieldOutActionPerformed

    private void jAppNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAppNameMouseClicked
        DialogAbout dialogAbout = new DialogAbout(this);
    }//GEN-LAST:event_jAppNameMouseClicked

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTextAreaIn.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed

    private class Reader implements SerialPortEventListener {

        private String str = "";

        public void serialEvent(SerialPortEvent spe) {
            if(spe.isRXCHAR() || spe.isRXFLAG()){
                if(spe.getEventValue() > 0){
                    try {
                        str = "";
                        byte[] buffer = serialPort.readBytes(spe.getEventValue());
                        if(jComboBoxIn.getSelectedIndex() == 0){//Chars
                            str = new String(buffer);
                        }
                        else if(jComboBoxIn.getSelectedIndex() == 1 || jComboBoxIn.getSelectedIndex() == 2){//Digits and HEX
                            int[] intBuffer = new int[buffer.length];
                            for(int i = 0; i < buffer.length; i++){
                                if(buffer[i] < 0){
                                    intBuffer[i] = 256 + buffer[i];
                                }
                                else {
                                    intBuffer[i] = buffer[i];
                                }
                            }
                            for(int i : intBuffer){
                                if(jComboBoxIn.getSelectedIndex() == 2){
                                    String value = Integer.toHexString(i).toUpperCase();
                                    if(value.length() == 1) {
                                        value = "0" + value;
                                    }
                                    str += (value + " ");
                                }
                                else {
                                    str += (i + " ");
                                }
                            }
                        }

                        SwingUtilities.invokeAndWait(
                            new Runnable() {
                                public void run() {
                                    jTextAreaIn.append(str);
                                    int scrollValue = jScrollPaneIn.getVerticalScrollBar().getValue();
                                    int scrollBottom = jScrollPaneIn.getVerticalScrollBar().getMaximum() - jScrollPaneIn.getVerticalScrollBar().getVisibleAmount();
                                    if((scrollValue == scrollBottom) && (scrollValue > 0)){
                                        jTextAreaIn.setCaretPosition(jTextAreaIn.getText().length());
                                    }
                                }
                            }
                        );
                    }
                    catch (Exception ex) {
                        //Do nothing
                    }
                }
            }
            else if(spe.isCTS()){
                if(spe.getEventValue() == 1){
                    jLabelCTS.setBorder(NimbusGui.borderStatusOn);
                    jLabelCTS.setBackground(NimbusGui.colorStatusOnBG);
                }
                else {
                    jLabelCTS.setBorder(NimbusGui.borderStatusOff);
                    jLabelCTS.setBackground(NimbusGui.colorStatusOffBG);
                }
            }
            else if(spe.isDSR()){
                if(spe.getEventValue() == 1){
                    jLabelDSR.setBorder(NimbusGui.borderStatusOn);
                    jLabelDSR.setBackground(NimbusGui.colorStatusOnBG);
                }
                else {
                    jLabelDSR.setBorder(NimbusGui.borderStatusOff);
                    jLabelDSR.setBackground(NimbusGui.colorStatusOffBG);
                }
            }
            else if(spe.isRLSD()){
                if(spe.getEventValue() == 1){
                    jLabelRLSD.setBorder(NimbusGui.borderStatusOn);
                    jLabelRLSD.setBackground(NimbusGui.colorStatusOnBG);
                }
                else {
                    jLabelRLSD.setBorder(NimbusGui.borderStatusOff);
                    jLabelRLSD.setBackground(NimbusGui.colorStatusOffBG);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAppName;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonOpenPort;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JButton jButtonSendHEX;
    private javax.swing.JButton jButtonSettings;
    private javax.swing.JComboBox jComboBoxIn;
    static javax.swing.JLabel jHeaderLabelInput;
    static javax.swing.JLabel jHeaderLabelOutput;
    private javax.swing.JPanel jHeaderPanelInput;
    private javax.swing.JPanel jHeaderPanelOutput;
    private javax.swing.JPanel jInputDataPanel;
    private javax.swing.JLabel jLabelCTS;
    private javax.swing.JLabel jLabelDSR;
    private javax.swing.JLabel jLabelPortInfo;
    private javax.swing.JLabel jLabelRLSD;
    private javax.swing.JLabel jLabelView;
    private javax.swing.JPanel jOutputDataPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneIn;
    private javax.swing.JSeparator jSeparatorOut;
    private javax.swing.JTextArea jTextAreaIn;
    private javax.swing.JTextField jTextFieldOut;
    private javax.swing.JToggleButton jToggleButtonDTR;
    private javax.swing.JToggleButton jToggleButtonRTS;
    // End of variables declaration//GEN-END:variables

}
