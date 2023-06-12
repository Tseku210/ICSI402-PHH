package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManagerViewUsersController {

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> addressCol1;

    @FXML
    private TableColumn<?, ?> addressCol11;

    @FXML
    private TableView<User> cashier_table;

    @FXML
    private TableColumn<?, ?> firstnameCol;

    @FXML
    private TableColumn<?, ?> firstnameCol1;

    @FXML
    private TableColumn<?, ?> firstnameCol11;

    @FXML
    private TableColumn<?, ?> lastnameCol;

    @FXML
    private TableColumn<?, ?> lastnameCol1;

    @FXML
    private TableColumn<?, ?> lastnameCol11;

    @FXML
    private TableView<User> manager_table;

    @FXML
    private TableView<User> pharmacist_table;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TableColumn<?, ?> phoneCol1;

    @FXML
    private TableColumn<?, ?> phoneCol11;

    @FXML
    private TableColumn<?, ?> staffIdCol;

    @FXML
    private TableColumn<?, ?> staffIdCol1;

    @FXML
    private TableColumn<?, ?> staffIdCol11;

    @FXML
    private TableColumn<?, ?> userIdCol;

    @FXML
    private TableColumn<?, ?> userIdCol1;

    @FXML
    private TableColumn<?, ?> userIdCol11;

    @FXML
    private TableColumn<?, ?> usernameCol;

    @FXML
    private TableColumn<?, ?> usernameCol1;

    @FXML
    private TableColumn<?, ?> usernameCol11;

    ObservableList<User> pharmacists = FXCollections.observableArrayList(
            new User(1, "Pharm001", "John", "Doe", "pharmacist1", "123 Main St", "555-1234", role),
            new User(2, "Pharm002", "Jane", "Doe", "pharmacist2", "456 Oak Ave", "555-5678", role)
    );

    ObservableList<User> managers = FXCollections.observableArrayList(
            new User(3, "Mngr001", "Bob", "Smith", "manager1", "789 Maple St", "555-4321", role),
            new User(4, "Mngr002", "Alice", "Smith", "manager2", "321 Elm St", "555-8765", role)
    );

    ObservableList<User> cashiers = FXCollections.observableArrayList(
            new User(5, "Cash001", "Mike", "Johnson", "cashier1", "555 Pine St", "555-2468", role),
            new User(6, "Cash002", "Sara", "Johnson", "cashier2", "888 Cedar St", "555-1357", role)
    );

    public void initialize() {
        pharmacist_table.setItems(pharmacists);
        manager_table.setItems(managers);
        cashier_table.setItems(cashiers);

        userIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        userIdCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffIdCol1.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        firstnameCol1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol1.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        usernameCol1.setCellValueFactory(new PropertyValueFactory<>("username"));
        addressCol1.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol1.setCellValueFactory(new PropertyValueFactory<>("phone"));

        userIdCol11.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffIdCol11.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        firstnameCol11.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol11.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        usernameCol11.setCellValueFactory(new PropertyValueFactory<>("username"));
        addressCol11.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol11.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

}
