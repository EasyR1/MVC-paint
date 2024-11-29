package org.example.view.menu;

import org.example.controller.actions.AppAction;
import org.example.controller.factory.MenuState;

public class SwitchAction implements AppCommand
{
    private AppAction action;
    private MenuState menuState;

    public SwitchAction(AppAction action, MenuState menuState) {
        this.action = action;
        this.menuState = menuState;
    }

    @Override
    public void execute() {
        menuState.setAction(action);
    }
}
