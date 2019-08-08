package com.ygznsl.chess.ui;

import java.util.ArrayList;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ChessBoardUserInterfaceBuilder
{

    private static final double SIZE = 64d;
    private final Pane[][] panes = new Pane[9][9];

    @Getter
    private GridPane root = new GridPane();

    public Scene build()
    {
        final ArrayList<Character> chars = new ArrayList<>();
        chars.add('\0');

        for (char c = 'A'; c <= 'H'; c++)
            chars.add(c);

        for (int x = 0; x < 9; x++)
        {
            for (int y = 0; y < 9; y++)
            {
                Node node = null;

                if (x == 0 && y < 8)
                {
                    final Label label = new Label(String.valueOf(8 - y));
                    label.setPrefSize(SIZE, SIZE);

                    node = label;
                }
                else if (y == 8)
                {
                    final Label label = new Label(String.valueOf(chars.get(x)));
                    label.setPrefSize(SIZE, SIZE);

                    node = label;
                }
                else
                {
                    final Pane pane = new Pane();
                    pane.setPrefSize(SIZE, SIZE);

                    final ImageView imageView = new ImageView(new Image("img/piece/white/knight.png"));
                    imageView.setCursor(Cursor.HAND);
                    imageView.setFitHeight(SIZE);
                    imageView.setFitWidth(SIZE);

                    pane
                            .getChildren()
                            .add(imageView);

                    panes[x][y] = pane;
                    node = pane;
                }

                root.add(node, x, y);
            }
        }

        final double size = SIZE * 9d;
        return new Scene(root, size, size);
    }

}
