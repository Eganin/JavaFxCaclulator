package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_field;

    @FXML
    private Button seven_button;

    @FXML
    private Button pm_button;

    @FXML
    private Button module_button;

    @FXML
    private Button divide_button;

    @FXML
    private Button eigth_button;

    @FXML
    private Button clear_button;

    @FXML
    private Button nine_button;

    @FXML
    private Button mult_button;

    @FXML
    private Button four_button;

    @FXML
    private Button five_button;

    @FXML
    private Button six_button;

    @FXML
    private Button minus_button;

    @FXML
    private Button one_button;

    @FXML
    private Button null_button;

    @FXML
    private Button two_button;

    @FXML
    private Button three_button;

    @FXML
    private Button plus_button;

    @FXML
    private Button double_button;

    @FXML
    private Button equals_button;

    private String str_num = "";
    private float first_num = 0;
    private char operation;
    private ArrayList<Button> listNumberButton = new ArrayList<Button>();

    @FXML
    void initialize() {
        Button[] listButtons = new Button[]{null_button,one_button,two_button,three_button};
        addValueListNumberButton();
        null_button.setOnAction(actionEvent -> {// обработка нажатия на кнопку
            addNumberFromLabel(0);
        });

        one_button.setOnAction(actionEvent -> {
            addNumberFromLabel(1);
        });

        two_button.setOnAction(actionEvent -> {
            addNumberFromLabel(2);
        });

        three_button.setOnAction(actionEvent -> {
            addNumberFromLabel(3);
        });

        four_button.setOnAction(actionEvent -> {
            addNumberFromLabel(4);
        });

        five_button.setOnAction(actionEvent -> {
            addNumberFromLabel(5);
        });

        six_button.setOnAction(actionEvent -> {
            addNumberFromLabel(6);
        });

        seven_button.setOnAction(actionEvent -> {
            addNumberFromLabel(7);
        });

        eigth_button.setOnAction(actionEvent -> {
            addNumberFromLabel(8);
        });

        nine_button.setOnAction(actionEvent -> {
            addNumberFromLabel(9);
        });

        plus_button.setOnAction(actionEvent -> {
            mathAction('+');
        });

        minus_button.setOnAction(actionEvent -> {
            mathAction('-');
        });

        divide_button.setOnAction(actionEvent -> {
            mathAction('/');
        });

        mult_button.setOnAction(actionEvent -> {
            mathAction('*');
        });

        equals_button.setOnAction(actionEvent -> {
            if(this.operation == '+' || this.operation == '-'
                    || this.operation == '/' || this.operation == '*'){
                equalsMethod();
            }
        });


        double_button.setOnAction(actionEvent -> {
            this.str_num += ".";
            if(this.str_num.contains(".")){
                label_field.setText(str_num);

            }
        });

        module_button.setOnAction(actionEvent -> {
            if(this.str_num != ""){
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        pm_button.setOnAction(actionEvent -> {
            if(this.str_num != ""){
                float num = Float.parseFloat(this.str_num) * -1;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });

        clear_button.setOnAction(actionEvent -> {
            label_field.setText("0");
            this.str_num = "";
            this.first_num = 0 ;
            this.operation = 'A';
        });

    }

    private void mathAction(char operation) {
        if(this.operation != '+' && this.operation != '-'
        && this.operation != '/' && this.operation != '*') {
            this.first_num = Float.parseFloat(this.str_num);
            label_field.setText(String.valueOf(operation));// выводим знак операции
            this.str_num ="";
            this.operation =operation;
        }

    }

    private void addNumberFromLabel(int Number) {
        this.str_num += Integer.toString(Number);
        label_field.setText(str_num);// setText - установка текста на поле
    }

    private void equalsMethod(){
        float res = 0;
        switch (this.operation){
            case '+':
                res = this.first_num + Float.parseFloat(this.str_num);
                break;

            case '-':
                res = this.first_num - Float.parseFloat(this.str_num);
                break;

            case '*':
                res = this.first_num * Float.parseFloat(this.str_num);
                break;

            case '/':
                if(Integer.parseInt(this.str_num) != 0){
                    res = this.first_num / Float.parseFloat(this.str_num);
                    break;
                }else{
                    res = 0;
                }

        }

        label_field.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.first_num =0 ;
    }

    public ArrayList<Button> getListNumberButton() {
        return listNumberButton;
    }

    public void setListNumberButton(ArrayList<Button> listNumberButton) {
        this.listNumberButton = listNumberButton;
    }

    public void addValueListNumberButton(Button[] button){
        listNumberButton.addAll(Arrays.asList(button));
    }
}
