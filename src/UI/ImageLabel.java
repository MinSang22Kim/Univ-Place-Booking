package UI;

import javax.swing.*;

public class ImageLabel extends JLabel {
    ImageLabel(String path, int x, int y)
    {
        ImageIcon imageIcon = new ImageIcon(path);
        setIcon(imageIcon);
        setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        setHorizontalAlignment(JLabel.CENTER);
    }
}
