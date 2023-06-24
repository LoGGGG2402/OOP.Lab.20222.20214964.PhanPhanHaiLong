package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.screen;


import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Media;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {

    public MediaStore(Media media) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }


}
