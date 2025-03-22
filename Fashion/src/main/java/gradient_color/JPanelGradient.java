package gradient_color;
import javax.swing.*;
import java.awt.*;

public class JPanelGradient extends JPanel {

    private Color color1;
    private Color color2;
    private double angle;

    // Constructor với các tham số màu và góc
    public JPanelGradient(Color color1, Color color2, double angle) {
        this.color1 = color1;
        this.color2 = color2;
        this.angle = angle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Tính toán tọa độ cho gradient dựa trên góc được truyền vào
        double radians = Math.toRadians(angle);
        float x1 = (float) (width / 2 + Math.cos(radians) * width / 2);
        float y1 = (float) (height / 2 - Math.sin(radians) * height / 2);
        float x2 = (float) (width / 2 - Math.cos(radians) * width / 2);
        float y2 = (float) (height / 2 + Math.sin(radians) * height / 2);

        // Tạo đối tượng GradientPaint với tọa độ và màu sắc đã tính toán
        GradientPaint gp = new GradientPaint(x1, y1, color1, x2, y2, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }

    // Phương thức để cập nhật màu sắc và góc độ
    public void setGradient(Color color1, Color color2, double angle) {
        this.color1 = color1;
        this.color2 = color2;
        this.angle = angle;
        repaint();  // Yêu cầu vẽ lại JPanel với thông tin mới
    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Gradient JPanel");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 400);
//
//        // Tạo JPanel với gradient và truyền màu sắc và góc độ
//        JPanelGradient gradientPanel = new JPanelGradient(new Color(0x1b8bf3), new Color(0xc110ef), 274);
//        frame.add(gradientPanel);
//
//        frame.setVisible(true);
//    }
}