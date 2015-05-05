package tcyert2740ex3h;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;

import java.awt.SystemColor;

import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel totalLabel;
	private JLabel averageLabel;
	private JLabel highestLabel;
	private JLabel lowestLabel;
	private JTextField inputMonthTextField;
	private JButton updateButton;
	private String [] strRainfall = {
			"1.2", "2.7", "2.2", "3.1", "2.9", "5.1",
			"3.2", "2.7", "3.6", "1.8", "2.2", "1.7"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RainfallForm() {
		setTitle("TcyertEx2H");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly rainfall:");
		lblMonthlyRainfall.setBounds(33, 11, 95, 14);
		contentPane.add(lblMonthlyRainfall);
		
		JList list = new JList();
		list.setBackground(UIManager.getColor("Label.background"));
		list.setEnabled(false);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 -Jan.", "02 - Feb.", "03 - Mar.", "04 - Apr.", "05 - May", "06 - Jun.", "07 - July", "08 - Aug.", "09 - Sep.", "10 - Oct.", "11 - Nov.", "12 - Dec."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(33, 36, 67, 221);
		contentPane.add(list);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBackground(UIManager.getColor("List.background"));
		rainfallList.setBounds(110, 36, 47, 221);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(167, 36, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel lblNewLabel = new JLabel("Average:");
		lblNewLabel.setBounds(167, 61, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHighest = new JLabel("Highest");
		lblHighest.setBounds(167, 86, 46, 14);
		contentPane.add(lblHighest);
		
		JLabel lblLowest = new JLabel("Lowest:");
		lblLowest.setBounds(167, 111, 46, 14);
		contentPane.add(lblLowest);
		
		totalLabel = new JLabel("0.0");
		lblTotal.setLabelFor(totalLabel);
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setBounds(223, 36, 46, 14);
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		lblNewLabel.setLabelFor(averageLabel);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBounds(223, 61, 46, 14);
		contentPane.add(averageLabel);
		
		highestLabel = new JLabel("0.0");
		lblHighest.setLabelFor(highestLabel);
		highestLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		highestLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		highestLabel.setBounds(223, 86, 46, 14);
		contentPane.add(highestLabel);
		
		lowestLabel = new JLabel("0.0");
		lblLowest.setLabelFor(lowestLabel);
		lowestLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lowestLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lowestLabel.setBounds(223, 111, 46, 14);
		contentPane.add(lowestLabel);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.setText("0.0");
		inputMonthTextField.setBounds(110, 268, 47, 20);
		contentPane.add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_calculateButton_actionPerformed(arg0);
			}
		});
		calculateButton.setBounds(177, 139, 89, 23);
		contentPane.add(calculateButton);
		
		updateButton = new JButton("Update");
		updateButton.setEnabled(false);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_actionPerformed(e);
			}
		});
		updateButton.setBounds(167, 267, 76, 23);
		contentPane.add(updateButton);
	}
	protected void do_calculateButton_actionPerformed(ActionEvent arg0) {
		Rainfall rainfallData = new Rainfall(strRainfall);
		
		DecimalFormat fmt = new DecimalFormat("0.0");
		totalLabel.setText(fmt.format(rainfallData.getTotal()));
		averageLabel.setText(fmt.format(rainfallData.getAverage()));
		lowestLabel.setText(fmt.format(rainfallData.getLowest()));
		highestLabel.setText(fmt.format(rainfallData.getHighest()));
	}
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		updateButton.setEnabled(true);
		inputMonthTextField.setText((String) rainfallList.getSelectedValue());
		inputMonthTextField.requestFocus();
		inputMonthTextField.selectAll();
	}
	protected void do_updateButton_actionPerformed(ActionEvent e) {
		int selectedIndex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(inputMonthTextField.getText());
		strRainfall[selectedIndex] = Double.toString(r);
		rainfallList.repaint();
		
		inputMonthTextField.setText("0.0");
		updateButton.setEnabled(false);
		totalLabel.setText("");
		averageLabel.setText("");
		highestLabel.setText("");
		lowestLabel.setText("");
	}
}
