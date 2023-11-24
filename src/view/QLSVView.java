package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Container;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.event.ActionEvent;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaThiSinhTimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_QueQuan;
	public JRadioButton rdbtn_Nam;
	public JRadioButton rdbtn_Nu;
	public JComboBox comboBox_QueQuan_TimKiem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 628);
		
		
		Action action = new QLSVController(this);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setForeground(new Color(0, 0, 0));
		menuFile.setHorizontalAlignment(SwingConstants.CENTER);
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setForeground(new Color(0, 0, 0));
		menuOpen.setHorizontalAlignment(SwingConstants.CENTER);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setForeground(new Color(0, 0, 0));
		menuSave.setHorizontalAlignment(SwingConstants.CENTER);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setForeground(new Color(0, 0, 0));
		menuExit.setHorizontalAlignment(SwingConstants.CENTER);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setForeground(new Color(0, 0, 0));
		menuAbout.setHorizontalAlignment(SwingConstants.CENTER);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setForeground(new Color(0, 0, 0));
		menuAboutMe.setHorizontalAlignment(SwingConstants.CENTER);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_QueQuan = new JLabel("Quê Quán");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_QueQuan.setForeground(new Color(0, 0, 0));
		label_QueQuan.setBounds(10, 11, 90, 38);
		contentPane.add(label_QueQuan);
		
		JLabel label_maThiSinh = new JLabel("Mã Thí Sinh");
		label_maThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_maThiSinh.setBounds(296, 11, 101, 38);
		contentPane.add(label_maThiSinh);
		
		textField_MaThiSinhTimKiem = new JTextField();
		textField_MaThiSinhTimKiem.setColumns(10);
		textField_MaThiSinhTimKiem.setBounds(386, 11, 172, 38);
		contentPane.add(textField_MaThiSinhTimKiem);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(action);
		btnTim.setBounds(579, 13, 64, 38);
		contentPane.add(btnTim);
		
		comboBox_QueQuan_TimKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_QueQuan_TimKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan_TimKiem.addItem(tinh.getTenTinh());
		}

		comboBox_QueQuan_TimKiem.setBounds(93, 11, 180, 38);
		contentPane.add(comboBox_QueQuan_TimKiem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 73, 708, 2);
		contentPane.add(separator_1);
		
		JLabel label_MaThiSinh = new JLabel("Danh Sách Thí Sinh");
		label_MaThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_MaThiSinh.setForeground(Color.BLACK);
		label_MaThiSinh.setBounds(10, 78, 180, 38);
		contentPane.add(label_MaThiSinh);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Th\u00ED Sinh", "H\u1ECD T\u00EAn", "Qu\u00EA Qu\u00E1n", "Ngày Sinh", "Gi\u1EDBi T\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
			}
		));
		
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 110, 708, 204);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 335, 708, 2);
		contentPane.add(separator_1_1);
		
		JLabel label_QueQuan_1 = new JLabel("Thông tin thí sinh");
		label_QueQuan_1.setForeground(Color.BLACK);
		label_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_QueQuan_1.setBounds(10, 335, 140, 38);
		contentPane.add(label_QueQuan_1);
		
		JLabel label_ID = new JLabel("Mã Thí Sinh");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_ID.setBounds(10, 368, 101, 38);
		contentPane.add(label_ID);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(100, 379, 148, 20);
		contentPane.add(textField_ID);
		
		JLabel label_HoVaTen = new JLabel("Họ và Tên");
		label_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_HoVaTen.setBounds(10, 397, 101, 38);
		contentPane.add(label_HoVaTen);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(100, 408, 148, 20);
		contentPane.add(textField_HoVaTen);
		
		JLabel label_QueQuan_2 = new JLabel("Quê Quán");
		label_QueQuan_2.setForeground(Color.BLACK);
		label_QueQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_QueQuan_2.setBounds(10, 431, 90, 38);
		contentPane.add(label_QueQuan_2);
		
		comboBox_QueQuan = new JComboBox();
		comboBox_QueQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}
		
		comboBox_QueQuan.setBounds(100, 441, 148, 22);
		contentPane.add(comboBox_QueQuan);
		
		JLabel label_NgaySinh = new JLabel("Ngày Sinh");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_NgaySinh.setBounds(10, 463, 101, 38);
		contentPane.add(label_NgaySinh);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(100, 474, 148, 20);
		contentPane.add(textField_NgaySinh);
		
		JLabel label_ID_1 = new JLabel("Giới Tính");
		label_ID_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_ID_1.setBounds(329, 368, 101, 38);
		contentPane.add(label_ID_1);
		
		rdbtn_Nam = new JRadioButton("Nam");
		rdbtn_Nam.setBounds(405, 378, 58, 23);
		contentPane.add(rdbtn_Nam);
		
		rdbtn_Nu = new JRadioButton("Nữ");
		rdbtn_Nu.setBounds(465, 378, 58, 23);
		contentPane.add(rdbtn_Nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(rdbtn_Nam);
		btn_gioiTinh.add(rdbtn_Nu);
		
		JLabel label_Mon1 = new JLabel("Điểm môn 1");
		label_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_Mon1.setBounds(329, 397, 101, 38);
		contentPane.add(label_Mon1);
		
		textField_Mon1 = new JTextField();
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(419, 408, 108, 20);
		contentPane.add(textField_Mon1);
		
		JLabel label_Mon2 = new JLabel("Điểm môn 2");
		label_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_Mon2.setBounds(329, 431, 101, 38);
		contentPane.add(label_Mon2);
		
		textField_Mon2 = new JTextField();
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(419, 442, 108, 20);
		contentPane.add(textField_Mon2);
		
		JLabel label_Mon3 = new JLabel("Điểm môn 3");
		label_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_Mon3.setBounds(329, 463, 101, 38);
		contentPane.add(label_Mon3);
		
		textField_Mon3 = new JTextField();
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(419, 474, 108, 20);
		contentPane.add(textField_Mon3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThem.setBounds(45, 513, 89, 38);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBounds(169, 513, 89, 38);
		contentPane.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCapNhat.setBounds(296, 512, 89, 38);
		contentPane.add(btnCapNhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLuu.setBounds(430, 512, 89, 38);
		contentPane.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Hủy Bỏ");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHuyBo.setBounds(567, 513, 89, 38);
		contentPane.add(btnHuyBo);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 505, 708, 2);
		contentPane.add(separator_1_2);
		
		JButton btnHuyTim = new JButton("Hủy");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setBounds(653, 13, 64, 38);
		contentPane.add(btnHuyTim);
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaThiSinhTimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_QueQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}
	
	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		model_table.addRow(new Object[]{
				ts.getMaThiSinh()+"", 
				ts.getTenThiSinh(), 
				ts.getQueQuan().getTenTinh(), 
				f.format(ts.getNgaySinh()),
				(ts.isGioiTinh()?"Nam":"Nữ"),
				ts.getDiemMon1()+"",
				ts.getDiemMon2()+"",
				ts.getDiemMon3()+"",
		});
	}


	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		}else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(ts.getMaThiSinh()+"")) {
					SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
					model_table.setValueAt(ts.getMaThiSinh()+"", i, 0);
					model_table.setValueAt(ts.getTenThiSinh()+"", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh()+"", i, 2);
					model_table.setValueAt(f.format(ts.getNgaySinh()), i, 3);
					model_table.setValueAt(ts.isGioiTinh()?"Nam":"Nữ", i, 4);
					model_table.setValueAt(ts.getDiemMon1()+"", i, 5);
					model_table.setValueAt(ts.getDiemMon2()+"", i, 6);
					model_table.setValueAt(ts.getDiemMon3()+"", i, 7);
				}
			}
		}
		
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		
		Date ngaySinh = new Date(model_table.getValueAt(i_row, 3) + "");
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + ""),
			  diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + ""), 
			  diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinh() {
		
		ThiSinh ts = getThiSinhDangChon();
		
		this.textField_ID.setText(ts.getMaThiSinh()+"");
		this.textField_HoVaTen.setText(ts.getTenThiSinh()+"");
		this.comboBox_QueQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		this.textField_NgaySinh.setText(f.format(ts.getNgaySinh())+"");
		if(ts.isGioiTinh()) {
			rdbtn_Nam.setSelected(true);
		}else {
			rdbtn_Nu.setSelected(true);
		}
		
		this.textField_Mon1.setText(ts.getDiemMon1()+"");
		this.textField_Mon2.setText(ts.getDiemMon2()+"");
		this.textField_Mon3.setText(ts.getDiemMon3()+"");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn với lựa chọn");
		if(luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemThiSinh() {
		// get du lieu
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_QueQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;
		if(this.rdbtn_Nam.isSelected()) {
			gioiTinh = true;
		}else gioiTinh = false;
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText()),
			  diemMon2 = Float.valueOf(this.textField_Mon2.getText()), 
			  diemMon3 = Float.valueOf(this.textField_Mon3.getText());
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		
		this.themHoacCapNhatThiSinh(ts);
	}

	public void thucHienTim() {
		// Gọi hàm hủy tìm kiếm 
		this.thucHienTaiLaiDuLieu();
		//Thực hiện tìm kiếm
		
		
		int queQuan = this.comboBox_QueQuan_TimKiem.getSelectedIndex() - 1;
		String maTS = this.textField_MaThiSinhTimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			System.out.println(tinhDaChon.toString());
			for(int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2)+"";
				String id = model_table.getValueAt(i, 0)+"";
				if(!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if(maTS.length() > 0) {
			for(int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(!id.equals(maTS)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
					
				}
			}
		}
		
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
//			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0)+"";
				if(idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	
	public void thucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong == 0) break;
			else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		}
		
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void thucHienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh:");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
										this, 
										"Bạn có chắc chắn thoát khỏi chương trình",
										"Exit",
										JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	
	private void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			System.out.println(returnVal);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}
	
	private void openFile(String path) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(path);
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject()) != null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);

		
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file.getAbsolutePath());
			thucHienTaiLaiDuLieu();
		}
	}

	
}
