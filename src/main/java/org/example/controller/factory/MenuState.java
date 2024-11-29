package org.example.controller.factory;

import lombok.Getter;
import lombok.Setter;
import org.example.controller.actions.ActionDraw;
import org.example.controller.actions.AppAction;

import java.awt.*;
@Getter
@Setter
public class MenuState {
    private boolean fill;
    private Color color;
    private ShapeType shapeType;
    private AppAction action;
    public MenuState(){
        shapeType = ShapeType.RECTANGULAR;
        color = Color.BLUE;
        fill = false;
    }

}