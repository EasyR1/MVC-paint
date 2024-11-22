package org.example.view.menu;

import org.example.controller.actions.ActionDraw;
import org.example.model.factory.MenuState;
import org.example.model.factory.ShapeType;

import javax.swing.*;

public class MenuCreator {
    private static MenuCreator instance;
    private JMenuBar menuBar;
    private ActionDraw actionDraw;
    private MenuCreator(){
        menuBar = createMenuBar();
    }
    public static MenuCreator getInstance(){
        if (instance == null){
            instance = new MenuCreator();
        }
        return instance;
    }
    public JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu shapeMenu = createShapeMenu();
        menuBar.add(shapeMenu);

        return menuBar;
    }

   // public enum ShapeType {
  //      RECTANGULAR, ELLIPSE;
  //  }
    private MenuState state;

    private JMenu createShapeMenu() {

        JMenu shapeMenu = new JMenu("Фигура");
        ButtonGroup group = new ButtonGroup();
        //поменять на фабрику
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        square.addActionListener(e -> state.setShapeType(ShapeType.RECTANGULAR));
        shapeMenu.add(square);
        group.add(square);
        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Эллипс");
        ellipse.addActionListener(e -> state.setShapeType(ShapeType.ELLIPSE));
        shapeMenu.add(ellipse);
        group.add(ellipse);
        return shapeMenu;
    }

    public void setActionDraw(ActionDraw actionDraw) {
        this.actionDraw = actionDraw;
    }
}