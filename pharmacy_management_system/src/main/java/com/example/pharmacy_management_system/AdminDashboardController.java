package com.example.pharmacy_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class AdminDashboardController {
    private AdminController parentController;

    public void setParentController(AdminController parentController) {
        this.parentController = parentController;
    }

    @FXML
    void onButtonClick(ActionEvent event) throws IOException {
        Parent newContent = FXMLLoader.load(getClass().getResource("admin-view.fxml"));
        parentController.changeContentPane(newContent);
    }

}
