package org.example.view.menu;

import lombok.Getter;
import lombok.Setter;
import org.example.controller.actions.ActionDraw;
import org.example.controller.actions.ActionMove;
import org.example.controller.actions.AppAction;
import org.example.controller.factory.MenuState;
import org.example.controller.factory.ShapeType;
import org.example.controller.state.UndoMachine;
import org.example.model.Model;
import org.example.model.MyShape;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

@Getter
@Setter
public class MenuCreator {
    private static MenuCreator instance;
    private JMenuBar menuBar;
    private AppAction action;
    private MenuState menuState;
    private Model model;
    private MyShape shape;
    private UndoMachine undoMachine;

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

        JMenu colorMenu = createColorMenu();
        menuBar.add(colorMenu);

        JMenu actionMenu = createActionMenu();
        menuBar.add(actionMenu);

        return menuBar;
    }

    public JToolBar createToolBar(){
        ArrayList<Action> subMenuItems = createToolBarItems();
        JToolBar jToolBar = new JToolBar(JToolBar.VERTICAL);
        subMenuItems.forEach(jToolBar::add);
        return jToolBar;
    }

    private ArrayList<Action> createToolBarItems() {
        ArrayList<Action> menuItems = new ArrayList<>();

        URL colorUrl = getClass().getClassLoader().getResource("color_16x16.png");
        ImageIcon colorIco = colorUrl == null ? null : new ImageIcon(colorUrl);
        AppCommand colorCommand = new SwitchColor(menuState, false, null);
        menuItems.add(new CommandActionListener("Цвет", colorIco, colorCommand));

        URL drawUrl = getClass().getClassLoader().getResource("draw_16x16.png");
        ImageIcon drawIco = drawUrl == null ? null : new ImageIcon(drawUrl);
        AppCommand drawAction = new SwitchAction(new ActionDraw(model, shape), menuState);
        menuItems.add(new CommandActionListener("draw", drawIco, drawAction));

        URL moveUrl = getClass().getClassLoader().getResource("move_16x16.png");
        ImageIcon moveIco = moveUrl == null ? null : new ImageIcon(moveUrl);
        AppCommand moveAction = new SwitchAction(new ActionMove(model),menuState);
        menuItems.add(new CommandActionListener("Двигать", moveIco, moveAction));

        URL ellipseUrl = getClass().getClassLoader().getResource("ellipse_16x16.png");
        ImageIcon ellipseIco = ellipseUrl == null ? null : new ImageIcon(ellipseUrl);
        AppCommand ellipseAction = new SwitchShape(ShapeType.ELLIPSE,menuState);
        menuItems.add(new CommandActionListener("Элипс", ellipseIco, ellipseAction));

        URL rectangularUrl = getClass().getClassLoader().getResource("rectangular_16x16.png");
        ImageIcon rectangularIco = rectangularUrl == null ? null : new ImageIcon(rectangularUrl);
        AppCommand rectangularAction = new SwitchShape(ShapeType.RECTANGULAR,menuState);
        menuItems.add(new CommandActionListener("четырехугольник", rectangularIco, rectangularAction));

        URL fillUrl = getClass().getClassLoader().getResource("fill_16x16.png");
        ImageIcon fillIco = fillUrl == null ? null : new ImageIcon(fillUrl);
        AppCommand fillAction = new SwitchFill(menuState, true);
        menuItems.add(new CommandActionListener("fill", fillIco, fillAction));

        URL no_fillUrl = getClass().getClassLoader().getResource("no_fill_16x16.png");
        ImageIcon no_fillIco = no_fillUrl == null ? null : new ImageIcon(no_fillUrl);
        AppCommand no_fillAction = new SwitchFill(menuState, false);
        menuItems.add(new CommandActionListener("no_fill", no_fillIco, no_fillAction));

        URL redoUrl = getClass().getClassLoader().getResource("redo_16x16.png");
        ImageIcon redoIco = redoUrl == null ? null : new ImageIcon(redoUrl);
        AppCommand redoCommand = new SwitchRedo(undoMachine) ;                                                                      //!!!!!!!
        menuItems.add(new CommandActionListener("redo", redoIco, redoCommand));

        URL undoUrl = getClass().getClassLoader().getResource("undo_16x16.png");
        ImageIcon undoIco = undoUrl == null ? null : new ImageIcon(undoUrl);
        AppCommand undoCommand = new SwitchUndo(undoMachine) ;                                                                      //!!!!!!!
        menuItems.add(new CommandActionListener("undo", undoIco, undoCommand));

        return menuItems;
    }

    private JMenu createActionMenu() {
        JMenu shapeMenu = new JMenu("Действие");
        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Рисовать");
        square.addActionListener(e -> menuState.setAction(new ActionDraw(model, shape)));
        shapeMenu.add(square);
        group.add(square);

        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Двигать");
        ellipse.addActionListener(e -> menuState.setAction(new ActionMove(model)));
        shapeMenu.add(ellipse);
        group.add(ellipse);
        return shapeMenu;
    }


    private JMenu createShapeMenu() {

        JMenu shapeMenu = new JMenu("Фигура");
        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        square.addActionListener(e -> menuState.setShapeType(ShapeType.RECTANGULAR));
        shapeMenu.add(square);
        group.add(square);

        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Эллипс");
        ellipse.addActionListener(e -> menuState.setShapeType(ShapeType.ELLIPSE));
        shapeMenu.add(ellipse);
        group.add(ellipse);
        return shapeMenu;
    }

    private JMenu createColorMenu() {
        JMenu colorMenu = new JMenu("Цвет");

        JMenuItem redItem = new JMenuItem("Красный");
        redItem.addActionListener(e -> menuState.setColor(Color.RED));
        colorMenu.add(redItem);

        JMenuItem greenItem = new JMenuItem("Зеленый");
        greenItem.addActionListener(e -> menuState.setColor(Color.GREEN));
        colorMenu.add(greenItem);

        JMenuItem blueItem = new JMenuItem("Синий");
        blueItem.addActionListener(e -> menuState.setColor(Color.BLUE));
        colorMenu.add(blueItem);

        JMenuItem rgbItem = new JMenuItem("RGB");
        rgbItem.addActionListener(new CommandActionListener(new SwitchColor(menuState, false, null)));
        colorMenu.add(rgbItem);

        return colorMenu;
    }
}