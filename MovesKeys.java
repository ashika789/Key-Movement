import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//@author: Ashika Ganesh
public class MovesKeys extends JFrame {

	private KeyboardPanel key = new KeyboardPanel();
	private JButton jbtUp = new JButton("UP");
	private JButton jbtDown = new JButton("DOWN");
	private JButton jbtLeft = new JButton("LEFT");
	private JButton jbtRight = new JButton("RIGHT");
	public MovesKeys() {

		JPanel panel = new JPanel();

		add(panel);

		panel.add(jbtUp);
		panel.add(jbtDown);
		panel.add(jbtLeft);
		panel.add(jbtRight);


		this.add(panel, BorderLayout.SOUTH);


		add(key);


		key.setFocusable(true);


		jbtUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key.up();
			}
		});


		jbtDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key.down();
			}
		});


		jbtLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key.left();
			}
		});


		jbtRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key.right();
			}
		});
	}

	public static void main(String[] args) {
		MovesKeys frame = new MovesKeys();

		frame.setTitle("Exercise15_3");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	static class KeyboardPanel extends JPanel {
		private int x = 10;
		private int y = 10;
		private int radius = 10;

		private char keyChar = 'Z';

		public void up() {

			x += 10;
			repaint();
		}

		public void down() {
			
			x -= 10;
			repaint();
		}

		public void left() {

			y += 10;
			repaint();
		}

		public void right() {
			y -= 10;
			repaint();
		}

		public KeyboardPanel() {
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent k) {
					switch (k.getKeyCode()) {
						case KeyEvent.VK_DOWN:
							down();
							break;

						case KeyEvent.VK_UP:
							up();
							break;

						case KeyEvent.VK_LEFT:
							left();
							break;

						case KeyEvent.VK_RIGHT:
							right();
							break;

						default:
							keyChar = k.getKeyChar();
					}


					repaint();
				}
			});
		}


		protected void paintComponent(Graphics b) {
			super.paintComponent(b);

			b.setColor(Color.blue);

			b.fillOval(getWidth() / 2 - y, getHeight() / 2 - x, 2 * radius, 2 * radius);
		}
	}
}