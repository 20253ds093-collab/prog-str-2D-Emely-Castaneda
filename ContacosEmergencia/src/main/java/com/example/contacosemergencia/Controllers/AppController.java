package com.example.contacosemergencia.Controllers;

import com.example.contacosemergencia.Models.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController {
    @FXML private TextField txtNombre, txtTelefono;
    @FXML private ComboBox <String> cbParentesco;
    @FXML private ListView<Contacto> lvContactos;
    private String[] OpcionesParentesco = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};
    private ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        cbParentesco.getItems().addAll(OpcionesParentesco);
        lvContactos.setItems(listaContactos);
    }
    @FXML
    void onAgregar() {
        String nombre = txtNombre.getText();
        String tel = txtTelefono.getText();
        String paren = cbParentesco.getValue();
        if (nombre.isEmpty() || tel.isEmpty() || paren == null) {
            System.out.println("Error, agrega los datos");
            return;
        }
        if (tel.length() != 10) {
            System.out.println("Error: El teléfono debe tener 10 dígitos");
            return;
        }
        Contacto nuevo = new Contacto(nombre, tel, paren);
        listaContactos.add(nuevo);
        onLimpiar();
    }
    @FXML
    void onBuscar() {
        String busqueda = txtNombre.getText();
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(busqueda)) {
                txtTelefono.setText(c.getTelefono());
                cbParentesco.setValue(c.getParentesco());
                return;
            }
        }
        System.out.println("No encontrado");
    }
    @FXML
    void onLimpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }
    @FXML
    void onActualizar(){
        Contacto seleccionado = lvContactos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            System.out.println("Selecciona qué contacto quieres actualizar");
            return;
        }
        seleccionado.setNombre(txtNombre.getText());
        seleccionado.setTelefono(txtTelefono.getText());
        seleccionado.setParentesco(cbParentesco.getValue());
        lvContactos.refresh();
        onLimpiar();
        System.out.println("Contacto actualizado");

    }
    @FXML
    void onEliminar(){
        Contacto seleccionado = lvContactos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            System.out.println("Selecciona un contacto de la lista para eliminar");
            return;
        }
        listaContactos.remove(seleccionado);
        onLimpiar();
        System.out.println("Contacto eliminado correctamente");
    }

    }