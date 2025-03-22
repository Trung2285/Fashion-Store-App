package gradient_color;

import javax.swing.*;
import java.awt.*;

public class JButtonGradient extends JButton {
    private Color color1;
    private Color color2;
    private double angle;

    // Constructor với các tham số màu và góc
    public JButtonGradient(String text, Color color1, Color color2, double angle) {
        super(text);
        this.color1 = color1;
        this.color2 = color2;
        this.angle = angle;
        setContentAreaFilled(false); // Loại bỏ màu nền mặc định của JButton
        setFocusPainted(false); // Ẩn đường viền khi nhấn vào
        setBorderPainted(false); // Ẩn viền nút
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Tính toán tọa độ gradient dựa vào góc
        double radians = Math.toRadians(angle);
        float x1 = (float) (width / 2 + Math.cos(radians) * width / 2);
        float y1 = (float) (height / 2 - Math.sin(radians) * height / 2);
        float x2 = (float) (width / 2 - Math.cos(radians) * width / 2);
        float y2 = (float) (height / 2 + Math.sin(radians) * height / 2);

        // Tạo GradientPaint và vẽ background
        GradientPaint gp = new GradientPaint(x1, y1, color1, x2, y2, color2);
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, width, height, 20, 20); // Nút bo góc

        super.paintComponent(g); // Vẽ nội dung của JButton
    }

    // Phương thức cập nhật màu gradient
    public void setGradient(Color color1, Color color2, double angle) {
        this.color1 = color1;
        this.color2 = color2;
        this.angle = angle;
        repaint();
    }
}
