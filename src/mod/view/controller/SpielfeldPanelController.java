package mod.view.controller;

import java.util.ArrayList;
import java.util.List;

import mod.interfaces.DrawableElement;
import mod.interfaces.KeyMapper;
import mod.view.ui.SpielfeldPanel;

public class SpielfeldPanelController {

    private final SpielfeldPanel panel;
    private final List<DrawableElement> elements;

    public SpielfeldPanelController() {
        this.panel = new SpielfeldPanel();
        this.elements = new ArrayList<>();
    }

    public SpielfeldPanel getPanel() { return panel; }

    public void setKeyMapper(KeyMapper keyMapper) { panel.setKeyMapper(keyMapper); }

    public void addDrawableElement(DrawableElement element) {
        elements.add(element);
        updateView();
    }

    public void setDrawableElements(List<DrawableElement> elements) {
        this.elements.clear();
        this.elements.addAll(elements);
        updateView();
    }

    public void wipeDrawableElements() {
        elements.clear();
        updateView();
    }

    private void updateView() {
        panel.setElementsToDraw(new ArrayList<>(elements));
    }
}

