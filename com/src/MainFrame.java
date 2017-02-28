package com.src;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.IOException;

import com.src.view.MainView;
import com.src.controller.MainController;
import com.src.model.MainModel;

public class MainFrame extends JFrame {
	ImageIcon icon;
	MainView mainView;
	MainController mainCont;
	MainModel mainModel;

	public MainFrame() {
		super();
		this.setTitle("Task & Timer!");
		this.setResizable(false);
		this.setSize(200,340);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true); // 常に前面に出す

		mainView = new MainView();
		this.add(mainView);
		mainModel = new MainModel();
		mainCont = new MainController(mainView, mainModel);

		// settting for Icon
		    // MainGameの背景画像を取得 例外が発生したらコンソールにエラー内容を表示する。
    try {
      icon = new ImageIcon( ImageIO.read(
        getClass().getClassLoader().getResourceAsStream(
          "com/assets/icon/icon.png"
        )
      ) );
    } catch (IOException e) {
      e.printStackTrace();
      icon = null;
    }
		this.setIconImage(icon.getImage());

		this.setVisible(true);
		repaint();
	}
}