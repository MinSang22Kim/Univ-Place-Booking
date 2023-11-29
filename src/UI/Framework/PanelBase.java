package UI.Framework;

import UI.UIMng;
import javax.swing.*;

public abstract class PanelBase extends JPanel {
    protected PanelBase()
    {
        add(UIMng.getInstance().kguIcon);
    }
}
