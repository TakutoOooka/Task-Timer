package com.src.helper;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ImageButton extends JButton implements MouseListener {
  private ImageIcon image; // 画像ファイルを扱うためのクラスの宣言
  int w, h; // 画像の横幅、縦幅を格納する変数
  // 通常、押された状態、覆いかぶさった状態、無効状態のボタンの画像のパス。
  private ImageIcon normal, pressed;
  Boolean enable = true;

  public ImageButton(String[] imagePath) {
		super();
    // それぞれのPathを格納
    try {
      normal = new ImageIcon( ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath[0])) );
      pressed = new ImageIcon( ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath[1])) );
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.image = normal; // 表示画像を通常状態に設定
    setOpaque(false); // JButton panelの背景を透明にする。
    this.setBorderPainted(false); // 枠線をなしにする。
    this.w = image.getIconWidth(); // 画像の横幅を格納。
    this.h = image.getIconHeight(); // 画像の縦幅を格納。
    setPreferredSize(new Dimension(w, h) ); // ボタンのPanelのサイズを決定(JButtonはJPanelを継承しているため)
    this.addMouseListener(this); // MouseListenerに追加
  }

// ボタンの描画
  // Override
  public void paintComponent(Graphics g) {
    g.drawImage(image.getImage(), 0, 0, w, h, null);
  }

// ボタンの画像変化処理の記述
  public void mouseClicked(MouseEvent e) { }
  public void mousePressed(MouseEvent e) {
    if(enable) {
      image = pressed;// ボタンの画像を押された状態に設定する
      repaint(); // JPanel(JButton)の再描画
    }
  }
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {
    if(enable) {
      image = normal; // ボタンの画像を通常状態に設定する
      repaint(); // JPanel(JButton)の再描画
    }
  }
}