package org.example.model.factory;

import lombok.Getter;
import lombok.Setter;
import org.example.controller.ActionDraw;

import java.awt.*;

@Getter
@Setter
public class MenuState {
    private boolean fill;
    private Color color;
    private ShapeType shapeType;
    private ActionDraw action;
    public MenuState(){
        shapeType= ShapeType.RECTANGULAR;
        color = Color.BLUE;
    }
}
