package UI.Framework;

import UI.UIMng;

public class KGULogo  extends ImageLabel {

    public KGULogo(String path, int x, int y) {
        super(path, x, y);
        setFontAndText(UIMng.getIns().mainFont, "예약");
        setSize(1000, imageIcon.getIconHeight());
        setLayout(null);
    }
}
