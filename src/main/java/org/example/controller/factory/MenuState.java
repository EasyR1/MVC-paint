package org.example.controller.factory;

import lombok.Getter;
import lombok.Setter;
import org.example.controller.actions.ActionDraw;
import org.example.controller.actions.ActionMove;
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

    public void setColor(Color color) {
        this.color = color;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public void setAction(ActionMove action) {
        this.action = action;
    }

    public void setAction(ActionDraw actionDraw) {

    }

    public AppAction getAction() {
        return action;
    }

    public Color getColor() {
        return color;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public ShapeCreation getShapeType() {
        return null;
    }
}