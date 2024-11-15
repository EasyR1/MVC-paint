package org.example.model.factory;

import lombok.Getter;
import lombok.Setter;
import org.example.controller.ActionDraw;
import org.example.controller.MenuController;

import java.awt.*;


public class MenuState {
    private boolean fill;
    private Color color;
    private ShapeType shapeType;
    private ActionDraw actionDraw;
    public MenuState(){
        shapeType= ShapeType.RECTANGULAR;
        color = Color.BLUE;
        fill = false;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
    
    public ActionDraw getActionDraw() {
        return actionDraw;
    }

    public void setActionDraw(ActionDraw actionDraw) {
        this.actionDraw = actionDraw;
    }


}
