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
import view.childStatusPane.AddChildToGroupPane;
import view.childStatusPane.RemoveChildFromGroupPane;
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
    private final MenuItem addChildToGroupMenuItem;
    private final MenuItem removeChildFromGroupMenuItem;

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
        addChildToGroupMenuItem = new MenuItem("Add to group");
        removeChildFromGroupMenuItem = new MenuItem("Remove from the group");
        replaceChildMenuItem = new MenuItem("Replace");

        sectionMenu = new Menu("Section");
        addSectionMenuItem = new MenuItem("Add new");
        removeSectionMenuItem = new MenuItem("Remove");
        changeSectionMenuItem = new MenuItem("Change");

        groupMenu = new Menu("Group");
        addGroupMenuItem = new MenuItem("Add new");
        removeGroupMenuItem = new MenuItem("Remove");

        teacherMenu.getItems().addAll(addTeacherMenuItem, removeTeacherMenuItem, changeTeacherMenuItem);
        childMenu.getItems().addAll(addChildMenuItem, removeChildMenuItem, changeChildMenuItem, addChildToGroupMenuItem, removeChildFromGroupMenuItem, replaceChildMenuItem);
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
            assert removeTeacherPane != null;
            appScene.getPane().setCenter(removeTeacherPane.getRemovePane());
        });

        changeTeacherMenuItem.setOnAction(event -> {
            ChangeTeacherPane changeTeacherPane = null;
            try {
                changeTeacherPane = new ChangeTeacherPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert changeTeacherPane != null;
            appScene.getPane().setCenter(changeTeacherPane.getChangePane());
        });

        addChildMenuItem.setOnAction(event -> {
            AddChildPane addChildPane = new AddChildPane();
            appScene.getPane().setCenter(addChildPane.getAddPane());
        });

        removeChildMenuItem.setOnAction(event -> {
            RemoveChildPane removeChildPane = null;
            try {
                removeChildPane = new RemoveChildPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert removeChildPane != null;
            appScene.getPane().setCenter(removeChildPane.getRemovePane());
        });

        changeChildMenuItem.setOnAction(event -> {
            ChangeChildPane changeChildPane = null;
            try {
                changeChildPane = new ChangeChildPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert changeChildPane != null;
            appScene.getPane().setCenter(changeChildPane.getChangePane());
        });

        replaceChildMenuItem.setOnAction(event -> {
            ReplaceChildFromGroupPane replaceChildFromGroupPane = null;
            try {
                replaceChildFromGroupPane = new ReplaceChildFromGroupPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert replaceChildFromGroupPane != null;
            appScene.getPane().setCenter(replaceChildFromGroupPane.getReplacePane());
        });

        addSectionMenuItem.setOnAction(event -> {
            AddSectionPane addSectionPane = null;
            try {
                addSectionPane = new AddSectionPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert addSectionPane != null;
            appScene.getPane().setCenter(addSectionPane.getAddPane());
        });

        removeSectionMenuItem.setOnAction(event -> {
            RemoveSectionPane removeSectionPane = null;
            try {
                removeSectionPane = new RemoveSectionPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert removeSectionPane != null;
            appScene.getPane().setCenter(removeSectionPane.getRemovePane());
        });

        changeSectionMenuItem.setOnAction(event -> {
            ChangeSectionPane changeSectionPane = null;
            try {
                changeSectionPane = new ChangeSectionPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert changeSectionPane != null;
            appScene.getPane().setCenter(changeSectionPane.getChangePane());
        });

        addGroupMenuItem.setOnAction(event -> {
            AddGroupPane addGroupPane = null;
            try {
                addGroupPane = new AddGroupPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert addGroupPane != null;
            appScene.getPane().setCenter(addGroupPane.getAddPane());
        });

        removeGroupMenuItem.setOnAction(event -> {
            RemoveGroupPane removeGroupPane = null;
            try {
                removeGroupPane = new RemoveGroupPane();
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
            assert removeGroupPane != null;
            appScene.getPane().setCenter(removeGroupPane.getRemovePane());
        });

        addChildToGroupMenuItem.setOnAction(event -> {
            AddChildToGroupPane addChildToGroupPane = null;
            try {
                addChildToGroupPane = new AddChildToGroupPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert addChildToGroupPane != null;
            appScene.getPane().setCenter(addChildToGroupPane.getAddToGroupPane());
        });

        removeChildFromGroupMenuItem.setOnAction(event -> {
            RemoveChildFromGroupPane removeChildFromGroupPane = null;
            try {
                removeChildFromGroupPane = new RemoveChildFromGroupPane();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            assert removeChildFromGroupPane != null;
            appScene.getPane().setCenter(removeChildFromGroupPane.getRemoveFromGroupPane());
        });
    }
}
