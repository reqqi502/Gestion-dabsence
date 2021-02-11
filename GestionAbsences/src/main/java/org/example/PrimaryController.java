
package org.example;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.example.DAO.UserDaoImp;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.DAO.FormateurDaoImp;
import org.example.Model.Absence;
import org.example.Model.Users;

/**
 * FXML Controller class
 *
 * @author kamal
 */
public class PrimaryController implements Initializable {

    FormateurDaoImp test = new FormateurDaoImp();
    @FXML
    private RadioButton rbJournee;
    @FXML
    private RadioButton rbDemiJournee;
    @FXML
    private TextField tfID;

    @FXML
    private DatePicker dateNow;
    @FXML
    private TextField tfJustification;
    @FXML
    private ComboBox<String> tfAppr;
    @FXML
    private TableView<Absence> tvAbsence;
    @FXML
    private TableColumn<Absence, Integer> colId;
    @FXML
    private TableColumn<Absence, String> colAbsences;
    @FXML
    private TableColumn<Absence, String> colDate;
    @FXML
    private TableColumn<Absence, String> colJustification;
    @FXML
    private TableColumn<Absence, String> colIdAppr;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    public Button btnBack;

    List<Users> listAppr;
    UserDaoImp user = new UserDaoImp();
    /**
     * Initializes the controller class.
     */


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateNow.setValue(LocalDate.parse(rtnTodayDate()));
        listAppr = null;
        try {
            listAppr = getAllAppr();

            for(int i=0;i<listAppr.size();i++){
                System.out.println("list " +listAppr.get(i).toString());
                tfAppr.getItems().add(listAppr.get(i).getNom());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//

        // TODO
        try {
            showAbsences();
            dateSysNow();
            //getSelected();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        if(event.getSource() == btnInsert) {
            insertAb();
        } else if(event.getSource() == btnUpdate){
            updateAb();
        }
    }
    public String journeeSelected() {
        String text = "";
        if(rbJournee.isSelected()){
            text += rbJournee.getText();
        } else if (rbDemiJournee.isSelected()) {
            text += rbDemiJournee.getText();
        }
        return text;
    }
    public String rtnTodayDate(){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        return date;
    }

    public void dateSysNow(){
        String dateText = rtnTodayDate();
        dateNow.setValue(LocalDate.parse(dateText));
    }


    public ObservableList<Absence> getAbsenceList() throws SQLException, ClassNotFoundException {

        ObservableList<Absence> absenceList = (ObservableList<Absence>) test.getAllAbsence();
        return absenceList;
    }

    public void showAbsences() throws SQLException, ClassNotFoundException{
        ObservableList<Absence> list = getAbsenceList();

        colId.setCellValueFactory(new PropertyValueFactory<Absence, Integer>("id_absence"));
        colAbsences.setCellValueFactory(new PropertyValueFactory<Absence, String>("absence"));
        colDate.setCellValueFactory(new PropertyValueFactory<Absence, String>("date"));
        colJustification.setCellValueFactory(new PropertyValueFactory<Absence, String>("justification"));
        colIdAppr.setCellValueFactory(new PropertyValueFactory<Absence, String>("id_appr"));

        tvAbsence.setItems(list);
    }
    /* public void showUser() {

         ObservableList<Users> list = user.getUsersList();
         tvNom.setCellValueFactory(new PropertyValueFactory<Users, String>("nom"));
         tvPrenom.setCellValueFactory(new PropertyValueFactory<Users, String>("prenom"));
         tvEmail.setCellValueFactory(new PropertyValueFactory<Users, String>("email"));
         tvTelephone.setCellValueFactory(new PropertyValueFactory<Users, String>("tele"));
         tvDateNaissence.setCellValueFactory(new PropertyValueFactory<Users, String>("dateNaissance"));
         tvRole.setCellValueFactory(new PropertyValueFactory<Users, String>("role"));
         tvAdmin.setItems(list);
     }*/
    public List<Users> getAllAppr() throws SQLException, ClassNotFoundException {

        List<Users> UserList = (List<Users>) user.getUsersList();
        return UserList;


    }
    private void insertAb() throws Exception {
        test.insertAbsence(new Absence(journeeSelected(), java.sql.Date.valueOf(dateNow.getValue()).toString(), tfJustification.getText(), tfAppr.getValue()));
        System.out.println("Insert successful");
        showAbsences();
    }

    private void updateAb() throws SQLException, ClassNotFoundException {
        test.updateAbsence(journeeSelected(), java.sql.Date.valueOf(dateNow.getValue()).toString(), tfJustification.getText(), tfID.getText());
        System.out.println("Update successful");
        showAbsences();
    }


    public void btnBack(ActionEvent event) throws IOException {
        if(event.getSource() == btnBack){
            App.setRoot("secondary");
        }

    }


    public void handelButtonAction(ActionEvent actionEvent) {
    }
}
