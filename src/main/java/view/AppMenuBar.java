package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import lombok.Getter;
import view.childPane.AddChildPane;
import view.childPane.ChangeChildPane;
import view.childPane.RemoveChildPane;
import view.childStatusPane.ReplaceChildFromGroupPane;
import view.groupPane.AddGroupPane;
import view.groupPane.RemoveGroupPane;
import view.sectionPane.AddSectionPane;
import view.sectionPane.ChangeSectionPane;
import view.sectionPane.RemoveSectionPane;
import view.teacherPane.AddTeacherPane;
import view.teacherPane.ChangeTeacherPane;
import view.teacherPane.RemoveTeacherPane;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class AppMenuBar {
    private final MenuBar mainMenuBar;
    private final Menu teacherMenu;
    private final Menu childMenu;
    private final Menu sectionMenu;
    private final Menu groupMenu;
    private final MenuItem addTeacherMenuItem;
    private final MenuItem removeTeacherMenuItem;
    private final MenuItem changeTeacherMenuItem;
    private final MenuItem addChildMenuItem;
    private final MenuItem removeChildMenuItem;
    private final MenuItem changeChildMenuItem;
    private final MenuItem addSectionMenuItem;
    private final MenuItem removeSectionMenuItem;
    private final MenuItem changeSectionMenuItem;
    private final MenuItem addGroupMenuItem;
    private final MenuItem removeGroupMenuItem;
    private final MenuItem replaceChildMenuItem;

    public AppMenuBar(AppScene appScene) {
        mainMenuBar = new MenuBar();

        teacherMenu = new Menu("Teacher");
        addTeacherMenuItem = new MenuItem("Add new");
        removeTeacherMenuItem = new MenuItem("Remove");
        changeTeacherMenuItem = new MenuItem("Change");

        childMenu = new Menu("Child");
        addChildMenuItem = new MenuItem("Add new");
        removeChildMenuItem = new MenuItem("Remove");
        changeChildMenuItem = new MenuItem("Change");
        replaceChildMenuItem = new MenuItem("Replace");

        sectionMenu = new Menu("Section");
        addSectionMenuItem = new MenuItem("Add new");
        removeSectionMenuItem = new MenuItem("Remove");
        changeSectionMenuItem = new MenuItem("Change");

        groupMenu = new Menu("Group");
        addGroupMenuItem = new MenuItem("Add new");
        removeGroupMenuItem = new MenuItem("Remove");

        teacherMenu.getItems().addAll(addTeacherMenuItem, removeTeacherMenuItem, changeTeacherMenuItem);
        childMenu.getItems().addAll(addChildMenuItem, removeChildMenuItem, changeChildMenuItem, replaceChildMenuItem);
        sectionMenu.getItems().addAll(addSectionMenuItem, removeSectionMenuItem, changeSectionMenuItem);
        groupMenu.getItems().addAll(addGroupMenuItem, removeGroupMenuItem);

        action(appScene);

        mainMenuBar.getMenus().addAll(teacherMenu, childMenu, sectionMenu, groupMenu);

    }

    private void action(AppScene appScene) {
        addTeacherMenuItem.setOnAction(event -> {
            AddTeacherPane addTeacherPane = new AddTeacherPane();
            appScene.getPane().setCenter(addTeacherPane.getAddPane());
        });

        removeTeacherMenuItem.setOnAction(event -> {
            RemoveTeacherPane removeTeacherPane = null;
            try {
                removeTeacherPane = new RemoveTeacherPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            appScene.getPane().setCenter(removeTeacherPane.getRemovePane());
        });

        changeTeacherMenuItem.setOnAction(event -> {
            ChangeTeacherPane changeTeacherPane = null;
            try {
                changeTeacherPane = new ChangeTeacherPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            appScene.getPane().setCenter(changeTeacherPane.getChangePane());
        });

        addChildMenuItem.setOnAction(event -> {
            AddChildPane addChildPane = new AddChildPane();
            appScene.getPane().setCenter(addChildPane.getAddPane());
        });

        removeChildMenuItem.setOnAction(event -> {
            RemoveChildPane removeChildPane = new RemoveChildPane();
            appScene.getPane().setCenter(removeChildPane.getRemovePane());
        });

        changeChildMenuItem.setOnAction(event -> {
            ChangeChildPane changeChildPane = new ChangeChildPane();
            appScene.getPane().setCenter(changeChildPane.getChangePane());
        });

        replaceChildMenuItem.setOnAction(event -> {
            ReplaceChildFromGroupPane replaceChildFromGroupPane = new ReplaceChildFromGroupPane();
            appScene.getPane().setCenter(replaceChildFromGroupPane.getReplacePane());
        });

        addSectionMenuItem.setOnAction(event -> {
            AddSectionPane addSectionPane = new AddSectionPane();
            appScene.getPane().setCenter(addSectionPane.getAddPane());
        });

        removeSectionMenuItem.setOnAction(event -> {
            RemoveSectionPane removeSectionPane = new RemoveSectionPane();
            appScene.getPane().setCenter(removeSectionPane.getRemovePane());
        });

        changeSectionMenuItem.setOnAction(event -> {
            ChangeSectionPane changeSectionPane = new ChangeSectionPane();
            appScene.getPane().setCenter(changeSectionPane.getChangePane());
        });

        addGroupMenuItem.setOnAction(event -> {
            AddGroupPane addGroupPane = new AddGroupPane();
            appScene.getPane().setCenter(addGroupPane.getAddPane());
        });

        removeGroupMenuItem.setOnAction(event -> {
            RemoveGroupPane removeGroupPane = new RemoveGroupPane();
            appScene.getPane().setCenter(removeGroupPane.getRemovePane());
        });
    }
}
