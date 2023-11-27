package UI;

public class KGULogo  extends ImageLabel {

    KGULogo(String path, int x, int y) {
        super(path, x, y);
        setFontAndText(UIMng.getInstance().mainFont, "예약 : K-AGORA");
    }
}
