package UI.Framework;

import javax.swing.*;
import java.awt.*;

public class ImageLabel extends JLabel {
    ImageIcon imageIcon;
    int x;
    int y;
    ImageLabel(String path, int x, int y)
    {
        System.out.println("AA");
        imageIcon = new ImageIcon(path);
        setIcon(imageIcon);
        setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        setHorizontalAlignment(JLabel.CENTER);

        this.x = x;
        this.y = y;
    }

    public ImageIcon getImageIcon()
    {
        return imageIcon;
    }

    public void setFontAndText(Font font, String text)
    {
        setFont(font);
        setText(text);

        FontMetrics metrics = getFontMetrics(font);
        String labelText = getText();
        int textWidth = metrics.stringWidth(labelText) + 5;
        int textHeight = metrics.getHeight();

        setBounds(x, y, imageIcon.getIconWidth() + textWidth, imageIcon.getIconHeight());
    }
}
